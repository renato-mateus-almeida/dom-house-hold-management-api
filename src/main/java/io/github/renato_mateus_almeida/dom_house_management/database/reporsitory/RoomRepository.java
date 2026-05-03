package io.github.renato_mateus_almeida.dom_house_management.database.reporsitory;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.renato_mateus_almeida.dom_house_management.database.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    @Query("SELECT R.ID FROM Room R WHERE R.ID = :roomId")
    Optional<Long> findIdById(Long roomId);

    @Query("SELECT R.ID FROM Room R WHERE R.houseHold.id = :houseHoldId")
    Set<Long> findTotalWattageByRoomIdEquals(Long houseHoldId);

}
