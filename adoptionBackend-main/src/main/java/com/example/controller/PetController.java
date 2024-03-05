package com.example.controller;

import com.example.pojo.entity.PetEntity;
import com.example.request.CreatePetRequest;
import com.example.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @PostMapping("pet")
    public void craetePet(@RequestBody CreatePetRequest request){
        petService.createPet(request.getName(), request.getType(), request.getBreed(), request.getSize(), request.getGender(), request.getAge(), request.getSource(), request.getHealth(),
                request.getRequirements(), request.getPrice(), request.getReason(), request.getUrls(), request.getAddress(), request.getStory(), request.getAttention(), request.getDate());
    }

    @GetMapping("pets")
    public List<PetEntity> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("stationPets")
    public List<PetEntity> getAllStationPets(){
        return petService.getAllStationPets();
    }

    @GetMapping("pet/{petId}")
    public PetEntity getOnePet(@PathVariable("petId") Long petId){
        System.out.println(petService.getOnePet(petId));
        return petService.getOnePet(petId);
    }

    @GetMapping("petsByType/{type}")
    public List<PetEntity> getPetsByType(@PathVariable("type") String type){
        return petService.getPetsByType(type);
    }

    @GetMapping("filteredPets/{type}/{address}/{breed}/{gender}/{age}/{size}/{source}/{health}/{price}")
    public List<PetEntity> getFilterPets(@PathVariable("type") String type, @PathVariable("address") String address, @PathVariable("breed") List<String> breed,
                                         @PathVariable("gender") List<String> gender, @PathVariable("age") List<String> age, @PathVariable("size") List<String> size,
                                         @PathVariable("source") List<String> source, @PathVariable("health") List<String> health, @PathVariable("price") List<String> price){
        return petService.getFilterPets(type, address, breed, gender, age, size, source, health, price);
    }

    @DeleteMapping("pet/{petId}")
    public void deleteRoute(@PathVariable("petId") Long petId) {
        petService.deletePet(petId);
    }

}
