package com.au.pets.controller;

import com.au.pets.model.Pet;
import com.au.pets.service.PetService;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetService petService;

    @GetMapping("/")
    public List<Pet> getAllPets() {
        List <Pet> pets = petService.getAllPets();
        return pets;
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable("id") String id) {
        Pet pet = null;
        if (id != null) {
            pet = petService.getPetById(id);
        }
        return pet;
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addPet(@RequestBody String jsonBody, UriComponentsBuilder uriBuilder) {
        Pet pet = new Gson().fromJson(jsonBody, Pet.class);
        Pet savedPet = petService.savePet(pet);

        UriComponents uriComponents =
                uriBuilder.path("/pets/{id}").buildAndExpand(
                        savedPet.getIdString());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") String id) {
        petService.deletePet(id);
        return  ResponseEntity.ok().build();
    }
}
