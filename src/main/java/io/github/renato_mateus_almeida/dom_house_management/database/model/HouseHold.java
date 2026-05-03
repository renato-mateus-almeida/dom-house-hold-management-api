package io.github.renato_mateus_almeida.dom_house_management.database.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOUSE_HOLD")
public class HouseHold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private String observation;

    private Double regionalKwhPrice;

    @OneToMany(mappedBy = "houseHold", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms;

    public HouseHold(String description, String observation, Double regionalKwhPrice) {
        this.description = description;
        this.observation = observation;
        this.regionalKwhPrice = regionalKwhPrice;
    }

    public HouseHold() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addRoom(Room newRoom) {
        if (Objects.isNull(newRoom)) {
            return false;
        }

        newRoom.setHouseHold(this);
        return this.getRooms().add(newRoom);
    }

    public Set<Room> getRooms() {
        if (Objects.isNull(this.rooms)) {
            setRooms(new HashSet<>());
        }

        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Double getRegionalKwhPrice() {
        return regionalKwhPrice;
    }

    public void setRegionalKwhPrice(Double regionalKwhPrice) {
        this.regionalKwhPrice = regionalKwhPrice;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
