package com.semiproject.pettales.AAmypage.doglistchange.service;

import com.semiproject.pettales.AAmypage.doglistchange.entity.PetUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.semiproject.pettales.AAmypage.doglistchange.repository.PetUpdateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetUpdateService {

    private final PetUpdateRepository petUpdateRepository;

    @Autowired
    public PetUpdateService(PetUpdateRepository petUpdateRepository) {
        this.petUpdateRepository = petUpdateRepository;
    }

    public PetUpdate createPet(PetUpdate pet) {
        return petUpdateRepository.save(pet);
    }

    public List<PetUpdate> getPets() {
        return petUpdateRepository.findAll();
    }

    public PetUpdate updatePet(int petCode, PetUpdate pet) {
        Optional<PetUpdate> oldPet = petUpdateRepository.findById(petCode);
        if(oldPet.isPresent()) {
            PetUpdate updatedPet = oldPet.get();
            updatedPet.setPetName(pet.getPetName());
            updatedPet.setPetStatus(pet.getPetStatus());
            updatedPet.setPetSpecies(pet.getPetSpecies());
            updatedPet.setPetWeight(pet.getPetWeight());
            updatedPet.setUpdateDate(pet.getUpdateDate());
            return petUpdateRepository.save(updatedPet);
        }
        else {
            throw new RuntimeException("Pet not found with petCode: " + petCode);
        }
    }

    public void deletePet(int petCode) {
        petUpdateRepository.deleteById(petCode);
    }
}
