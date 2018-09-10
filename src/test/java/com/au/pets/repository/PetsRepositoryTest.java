package com.au.pets.repository;

import com.au.pets.model.Pet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@DataMongoTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PetsRepositoryTest {

    @Autowired
    private PetsRepository petsRepository;

    @Test
    public void testGetPetById() {
        Pet pet = petsRepository.save(new Pet(null, "Budgie", null, null));

        Pet savedBudgie = petsRepository.findById(pet.geId()).get();
        Assert.assertNotNull(savedBudgie);
        Assert.assertEquals(savedBudgie.getName(), pet.getName());
    }

    @Test
    public void testGetPetByName() {
        Pet pet = petsRepository.save(new Pet(null, "Budgie", null, null));

        List<Pet> savedBudgie = petsRepository.findByName(pet.getName());
        Assert.assertNotNull(savedBudgie);
        Assert.assertTrue(savedBudgie.size() == 1);
        Assert.assertEquals(savedBudgie.get(0).getName(), pet.getName());
    }
}
