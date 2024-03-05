package com.example.service;

import com.example.pojo.entity.PetEntity;

import java.util.List;

public interface PetService {
    void createPet(String name, String type, String breed, String size, String gender, String age, String source, List<String> health, List<String> requirements,
                   String price, String reason, List<String> urls, String address, String story, String attention, String date);

    List<PetEntity> getAllPets();

    List<PetEntity> getAllStationPets();

    PetEntity getOnePet(Long petId);

    void deletePet(Long petId);

    List<PetEntity> getPetsByType(String type);

    List<PetEntity> getFilterPets(String type, String address, List<String> breed, List<String> gender, List<String> age, List<String> size,
                                  List<String> source, List<String> health, List<String> price);

//    List<PetEntity> getPetsByAddress(String address);
//
//    List<PetEntity> getPetsByBreeds(List<String> breeds);
//
//    List<PetEntity> getPetsByGenders(List<String> genders);



}
