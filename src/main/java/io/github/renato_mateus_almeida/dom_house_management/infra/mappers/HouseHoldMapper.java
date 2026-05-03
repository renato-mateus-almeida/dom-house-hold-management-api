package io.github.renato_mateus_almeida.dom_house_management.infra.mappers;

import org.springframework.stereotype.Component;

import io.github.renato_mateus_almeida.dom_house_management.infra.dto.HouseHoldDTO;
import io.github.renato_mateus_almeida.dom_house_management.database.model.HouseHold;

@Component
public class HouseHoldMapper implements Mapper<HouseHold, HouseHoldDTO> {

    @Override
    public HouseHoldDTO toDTO(HouseHold entity) {
        return new HouseHoldDTO(entity.getDescription(), entity.getObservation(), entity.getRegionalKwhPrice());
    }

    @Override
    public HouseHold toEntity(HouseHoldDTO dto) {
        return new HouseHold(dto.description(), dto.observation(), dto.regionalKwhPrice());
    }

    @Override
    public HouseHold parse(Long id, HouseHoldDTO dto) {
        var newInstance = toEntity(dto);
        newInstance.setId(id);
        return newInstance;
    }
    
}
