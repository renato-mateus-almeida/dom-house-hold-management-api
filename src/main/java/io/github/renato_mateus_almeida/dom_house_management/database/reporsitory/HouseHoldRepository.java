package io.github.renato_mateus_almeida.dom_house_management.database.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.renato_mateus_almeida.dom_house_management.database.model.HouseHold;

@Repository
public interface HouseHoldRepository extends JpaRepository<HouseHold, Long>{
    
    List<HouseHold> findByDescriptionContainingIgnoreCase(String description);
    
}
