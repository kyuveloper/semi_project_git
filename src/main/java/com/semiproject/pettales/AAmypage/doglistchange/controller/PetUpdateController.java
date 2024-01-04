package com.semiproject.pettales.AAmypage.doglistchange.controller;

import com.semiproject.pettales.AAmypage.doglistchange.entity.PetUpdate;
import com.semiproject.pettales.AAmypage.doglistchange.service.PetUpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/mypage/pet")
public class PetUpdateController {

    private final PetUpdateService petUpdateService;

    @Autowired
    public PetUpdateController(PetUpdateService petUpdateService) {
        this.petUpdateService = petUpdateService;
    }

    // 펫 리스트 조회
    @GetMapping
    public List<PetUpdate> getMyPets() {
        return petUpdateService.getPets();
    }

    // 펫 등록
    @PostMapping("/add")
    public PetUpdate addPet(@RequestBody PetUpdate pet) {
        return petUpdateService.createPet(pet);
    }

    // 펫 수정
    @PutMapping("/update/{petCode}")
    public PetUpdate updatePet(@PathVariable int petCode, @RequestBody PetUpdate pet) {
        return petUpdateService.updatePet(petCode, pet);
    }

    // 펫 삭제
    @DeleteMapping("/delete/{petCode}")
    public void deletePet(@PathVariable int petCode) {
        petUpdateService.deletePet(petCode);
    }
}