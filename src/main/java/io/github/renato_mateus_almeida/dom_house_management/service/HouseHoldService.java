package io.github.renato_mateus_almeida.dom_house_management.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.HouseHoldRepository;
import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.ItemRepository;
import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.RoomRepository;
import io.github.renato_mateus_almeida.dom_house_management.exception.HouseHoldNotFoundException;
import io.github.renato_mateus_almeida.dom_house_management.infra.dto.HouseHoldDTO;
import io.github.renato_mateus_almeida.dom_house_management.infra.mappers.HouseHoldMapper;
import io.github.renato_mateus_almeida.dom_house_management.utils.StringUtils;

@Service
public class HouseHoldService {

    private final HouseHoldMapper mapper;

    private final HouseHoldRepository houseHoldRepository;
    private final RoomRepository roomRepository;
    private final ItemRepository itemRepository;

    public HouseHoldService(RoomRepository roomRepository, ItemRepository itemRepository,
            HouseHoldRepository houseHoldRepository, HouseHoldMapper mapper) {

        this.houseHoldRepository = houseHoldRepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;

        this.mapper = mapper;
    }

    public List<HouseHoldDTO> findByDescription(String searchTerm) {
        return houseHoldRepository.findByDescriptionContainingIgnoreCase(StringUtils.emptyIfNull(searchTerm))
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public HouseHoldDTO findById(Long id) throws HouseHoldNotFoundException {
        return houseHoldRepository
                .findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new HouseHoldNotFoundException("[GET]", id));
    }

    public HouseHoldDTO create(HouseHoldDTO dto) {
        houseHoldRepository.save(mapper.toEntity(dto));
        return dto;
    }

    public HouseHoldDTO update(Long id, HouseHoldDTO dto) throws HouseHoldNotFoundException {
        houseHoldRepository.save(
            houseHoldRepository.findById(id)
                .map(foundedHouseHold -> mapper.parse(id, dto))
                .orElseThrow(() -> new HouseHoldNotFoundException("[PUT]", id))
        );
        return dto;
    }

    public void delete(Long id) throws HouseHoldNotFoundException {
        houseHoldRepository.delete(
            houseHoldRepository.findById(id)
                .orElseThrow(() -> new HouseHoldNotFoundException("[DELETE]", id))
        );
    }

    public Double calculateTotalWattageConsumeByHouseHoldId(Long houseHoldId) {
        return roomRepository
                .findTotalWattageByRoomIdEquals(houseHoldId).stream()
                .mapToDouble(id -> itemRepository.findTotalWattageByRoomIdEquals(id)).sum();
    }

}
