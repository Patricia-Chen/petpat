package com.example.service.impl;

import com.example.dao.PetDao;
import com.example.pojo.entity.PetEntity;
import com.example.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetDao petDao;

    @Override
    public void createPet(String name, String type, String breed, String size, String gender, String age, String source, List<String> health, List<String> requirements,
                          String price, String reason, List<String> urls, String address, String story, String attention, String date){
        petDao.save(PetEntity.builder().name(name).type(type).breed(breed).size(size).gender(gender).age(age).source(source).health(health)
                .requirements(requirements).price(price).reason(reason).urls(urls).address(address).story(story).attention(attention).date(date).build());
    }

    @Override
    public List<PetEntity> getAllPets(){
        return petDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<PetEntity> getAllStationPets(){
        return petDao.findAllStationPets("救助站", "江苏省南京市栖霞区");
    }


    @Override
    public PetEntity getOnePet(Long petId){
        return petDao.findById(petId).get();
    }

    @Override
    public List<PetEntity> getPetsByType(String type){
        return petDao.getPetEntitiesByType(type);
    }

    @Override
    public List<PetEntity> getFilterPets(String type, String address, List<String> breed, List<String> gender, List<String> age, List<String> size,
                                  List<String> source, List<String> health, List<String> price) {
        if("全国".equals(address)){
            if("none".equals(health.get(0))){
                return petDao.getPetsAllAddressAndNoHealthLimited(type, breed, gender, age, size, source, price);
            }
            return petDao.getPetsAllAddress(type, breed, gender, age, size, source, health.toArray(new String[0]), price);
        }
        if("none".equals(health.get(0))){
            return petDao.getPetsNoHealthLimited(type, address, breed, gender, age, size, source, price);
        }
        return petDao.getFilterPets(type, address, breed, gender, age, size, source, health.toArray(new String[0]), price);
    }

    @Override
    public void deletePet(Long petId){
        petDao.deleteById(petId);
    }



}
