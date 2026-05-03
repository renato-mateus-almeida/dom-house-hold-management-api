package io.github.renato_mateus_almeida.dom_house_management.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.renato_mateus_almeida.dom_house_management.exception.HouseHoldNotFoundException;
import io.github.renato_mateus_almeida.dom_house_management.infra.dto.HouseHoldDTO;
import io.github.renato_mateus_almeida.dom_house_management.service.HouseHoldService;

@RestController
@RequestMapping("/v1/house-hold")
public class HouseHoldController {

    private final HouseHoldService houseHoldService;

    public HouseHoldController(HouseHoldService houseHoldService) {
        this.houseHoldService = houseHoldService;
    }

    @GetMapping
    public ResponseEntity<List<HouseHoldDTO>> findAll(@RequestParam(value = "q", required = false) String searchTerm) {
        return ResponseEntity.ok(houseHoldService.findByDescription(searchTerm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseHoldDTO> findById(@PathVariable Long id) throws HouseHoldNotFoundException {
        return ResponseEntity.ok(houseHoldService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HouseHoldDTO> create(@RequestBody HouseHoldDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(houseHoldService.create(dto));
    }
}
