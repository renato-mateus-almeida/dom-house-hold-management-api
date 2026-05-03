package io.github.renato_mateus_almeida.dom_house_management.service;

import org.springframework.stereotype.Service;

import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.ItemRepository;
import io.github.renato_mateus_almeida.dom_house_management.database.reporsitory.RoomRepository;
import io.github.renato_mateus_almeida.dom_house_management.exception.RoomNotFoundException;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ItemRepository itemRepository;

    public RoomService(ItemRepository itemRepository, RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
    }

    public Double calculateTotalWattageCosumerByRoomId(Long roomId) throws RoomNotFoundException {
        Long checkedId = roomRepository.findIdById(roomId).orElseThrow(() -> new RoomNotFoundException("[GET]", roomId));
        return itemRepository.findTotalWattageByRoomIdEquals(checkedId);
    }
    
    
}
