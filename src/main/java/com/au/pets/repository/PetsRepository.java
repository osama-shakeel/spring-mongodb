package com.au.pets.repository;

import com.au.pets.model.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetsRepository extends MongoRepository <Pet, ObjectId> {

    List <Pet> findByName(String name);
}
