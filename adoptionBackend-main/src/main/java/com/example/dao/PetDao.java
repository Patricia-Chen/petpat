package com.example.dao;

import com.example.pojo.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetDao extends JpaRepository<PetEntity, Long> {
    @Query(value = "select * from pet_entity p where p.source=?1 and p.address=?2", nativeQuery = true)
    List<PetEntity> findAllStationPets(String source, String address);

    @Query(value = "select * from pet_entity p where p.type=?1", nativeQuery = true)
    List<PetEntity> getPetEntitiesByType(String type);

    @Query(value = "select * from pet_entity p where p.type=?1 and p.address=?2 " +
            "and p.breed in ?3 and p.gender in ?4 and p.age in ?5 " +
            "and p.size in ?6 and p.source in ?7 " +
            "and p.health @> ?8 and p.price in ?9", nativeQuery = true)
    List<PetEntity> getFilterPets(String type, String address, List<String> breed, List<String> gender, List<String> age, List<String> size,
         List<String> source, String[] health, List<String> price);

    @Query(value = "select * from pet_entity p where p.type=?1 and p.breed in ?2 " +
            "and p.gender in ?3 and p.age in ?4 " +
            "and p.size in ?5 and p.source in ?6 " +
            "and p.health @> ?7 and p.price in ?8", nativeQuery = true)
    List<PetEntity> getPetsAllAddress(String type, List<String> breed, List<String> gender, List<String> age, List<String> size,
                                  List<String> source, String[] health, List<String> price);

    @Query(value = "select * from pet_entity p where p.type=?1 and p.address=?2 " +
            "and p.breed in ?3 and p.gender in ?4 and p.age in ?5 " +
            "and p.size in ?6 and p.source in ?7 " +
            "and p.price in ?8", nativeQuery = true)
    List<PetEntity> getPetsNoHealthLimited(String type, String address, List<String> breed, List<String> gender, List<String> age, List<String> size,
                                      List<String> source, List<String> price);

    @Query(value = "select * from pet_entity p where p.type=?1 and p.breed in ?2 " +
            "and p.gender in ?3 and p.age in ?4 " +
            "and p.size in ?5 and p.source in ?6 " +
            "and p.price in ?7", nativeQuery = true)
    List<PetEntity> getPetsAllAddressAndNoHealthLimited(String type, List<String> breed, List<String> gender, List<String> age, List<String> size,
                                           List<String> source, List<String> price);
}
