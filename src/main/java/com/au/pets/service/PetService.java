package com.au.pets.service;

import com.au.pets.model.Pet;

import java.util.List;

public interface PetService {
    Pet getPetById(String id);

    List<Pet> getAllPets();

    Pet savePet(Pet pet);

    void deletePet(String id);
}
