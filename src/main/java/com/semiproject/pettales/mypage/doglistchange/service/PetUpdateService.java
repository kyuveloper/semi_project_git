package com.semiproject.pettales.mypage.doglistchange.service;

import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.semiproject.pettales.mypage.doglistchange.repository.PetUpdateRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class PetUpdateService {
    private String uploadDir;
    private final PetUpdateRepository petUpdateRepository;

    @Autowired
    public PetUpdateService(PetUpdateRepository petUpdateRepository) {
        this.petUpdateRepository = petUpdateRepository;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public PetUpdate createPet(PetUpdate pet, MultipartFile petImg) {
        String petImgPath = saveImage(petImg);
        pet.setPetImg(petImgPath);
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

    private String saveImage(MultipartFile image) {
        String originalFileName = image.getOriginalFilename(); // 원본 파일 이름
        String filePath = uploadDir + "/" + originalFileName; // 파일 저장 경로

        try {
            byte[] bytes = image.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes); // 이미지 파일 저장
        } catch (IOException e) {
            throw new RuntimeException("이미지를 저장하는 중 오류가 발생했습니다.", e);
        }

        return filePath; // 저장된 이미지의 경로 반환
    }

    public void deletePet(int petCode) {
        petUpdateRepository.deleteById(petCode);
    }
}
