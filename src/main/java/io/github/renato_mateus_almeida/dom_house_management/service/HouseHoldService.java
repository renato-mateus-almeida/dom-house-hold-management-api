package io.github.renato_mateus_almeida.dom_house_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.HouseHoldRepository;
import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.ItemRepository;
import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.RoomRepository;
import io.github.renato_mateus_almeida.dom_house_management.exception.HouseHoldNotFoundException;
import io.github.renato_mateus_almeida.dom_house_management.infra.dto.HouseHoldDTO;
import io.github.renato_mateus_almeida.dom_house_management.infra.mappers.HouseHoldMapper;

@Service
public class HouseHoldService {

    private final HouseHoldMapper mapper;

    private final HouseHoldRepository houseHoldepository;
    private final RoomRepository roomRepository;
    private final ItemRepository itemRepository;

    public HouseHoldService(RoomRepository roomRepository, ItemRepository itemRepository,
            HouseHoldRepository houseHoldepository, HouseHoldMapper mapper) {

        this.houseHoldepository = houseHoldepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;

        this.mapper = mapper;
    }

    public List<HouseHoldDTO> findAll() {
        return houseHoldepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public HouseHoldDTO findById(Long id) throws HouseHoldNotFoundException {
        return houseHoldepository
        .findById(id)
        .map(mapper::toDTO)
        .orElseThrow(() -> new HouseHoldNotFoundException("[GET]", id));
    }

    public Double calculateTotalWattageConsumeByHouseHoldId(Long houseHoldId) {
        return roomRepository
                .findTotalWattageByRoomIdEquals(houseHoldId).stream()
                .mapToDouble(id -> itemRepository.findTotalWattageByRoomIdEquals(id)).sum();
    }

}
