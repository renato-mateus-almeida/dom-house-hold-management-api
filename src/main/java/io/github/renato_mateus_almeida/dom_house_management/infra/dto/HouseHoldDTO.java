package io.github.renato_mateus_almeida.dom_house_management.infra.dto;

import io.github.renato_mateus_almeida.dom_house_management.utils.DoubleUtils;
import io.github.renato_mateus_almeida.dom_house_management.utils.StringUtils;

public record HouseHoldDTO(String description, String observation, Double regionalKwhPrice) {
    
    public HouseHoldDTO {

        if( StringUtils.isEmpty(description) || DoubleUtils.isEmpty(regionalKwhPrice)) {
            throw new IllegalArgumentException();
        }
    
    }
}
