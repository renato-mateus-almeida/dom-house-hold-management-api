package io.github.renato_mateus_almeida.dom_house_management.database.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.renato_mateus_almeida.dom_house_management.database.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
    @Query("SELECT SUM(i.wattage) FROM Item i WHERE i.room.id = :roomId")
    Double findTotalWattageByRoomIdEquals(Long roomId);
    
}
