package io.github.renato_mateus_almeida.dom_house_management.database.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_hold_id", referencedColumnName = "id", nullable = false)
    private HouseHold houseHold;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items;

    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HouseHold getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {
        this.houseHold = houseHold;
    }

    public boolean addItem(Item newItem) {
        if(Objects.isNull(newItem)) {
            return false;
        }
        
        newItem.setRoom(this);
        return this.getItems().add(newItem);
    }

    public Set<Item> getItems() {
        if(Objects.isNull(this.items)) {
            setItems(new HashSet<>());
        }

        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
}
