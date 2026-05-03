package io.github.renato_mateus_almeida.dom_house_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.renato_mateus_almeida.dom_house_management.service.HouseHoldService;
import io.github.renato_mateus_almeida.dom_house_management.service.RoomService;

@SpringBootApplication
public class DomHouseManagementApplication implements CommandLineRunner {

	@Autowired
	private RoomService roomService;

	@Autowired
	private HouseHoldService holdService;

	public static void main(String[] args) {
		SpringApplication.run(DomHouseManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumer1 = roomService.calculateTotalWattageCosumerByRoomId(1L);
		var consumer2 = roomService.calculateTotalWattageCosumerByRoomId(2L);
		
		System.out.println("Consumo: " + consumer1);
		System.out.println("Consumo: " + consumer2);

	}
}
