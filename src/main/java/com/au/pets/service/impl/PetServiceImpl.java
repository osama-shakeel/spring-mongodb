package com.au.pets.service.impl;

import com.au.pets.model.Pet;
import com.au.pets.repository.PetsRepository;
import com.au.pets.service.PetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetsRepository petsRepository;

    @Override
    public List<Pet> getAllPets() {
        return petsRepository.findAll();
    }

    @Override
    public Pet getPetById(String id) {
        return petsRepository.findById(new ObjectId(id));
    }

    @Override
    public void deletePet(String id) {
        Pet pet = petsRepository.findById(new ObjectId(id));
        if (pet != null) {
            petsRepository.delete(pet);
        }
    }

    @Override
    public Pet savePet(Pet pet) {
        pet.setId(ObjectId.get());
        return petsRepository.save(pet);
    }
}
