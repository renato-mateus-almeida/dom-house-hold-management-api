package io.github.renato_mateus_almeida.dom_house_management.infra.mappers;

public interface Mapper<Entity, DTO> {
    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);
    Entity parse(Long id, DTO dto);
}
