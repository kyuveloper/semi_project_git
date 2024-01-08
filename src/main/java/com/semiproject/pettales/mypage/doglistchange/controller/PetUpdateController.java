package com.semiproject.pettales.mypage.doglistchange.controller;

import ch.qos.logback.core.model.Model;
import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import com.semiproject.pettales.mypage.doglistchange.service.PetUpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user/mypage/pet")
public class PetUpdateController {
    private final PetUpdateService petUpdateService;

    @Autowired
    public PetUpdateController(PetUpdateService petUpdateService) {
        this.petUpdateService = petUpdateService;
        this.petUpdateService.setUploadDir("src/main/resources/static/images/pet");
    }

    // 펫 리스트 조회
    @GetMapping("/mypets")
    public List<PetUpdate> getMyPets() {
        return petUpdateService.getPets();
    }

    // 이미지를 저장하는 디렉토리
    private final String uploadDir = "/path/to/your/directory";

    public String saveImage(MultipartFile image) {
        try {
            // 이미지의 원본 이름을 가져옵니다
            String originalFileName = image.getOriginalFilename();

            // 이미지를 저장할 경로를 생성합니다
            Path imagePath = Paths.get(uploadDir, originalFileName);

            // 이미지 파일을 저장합니다
            Files.write(imagePath, image.getBytes());

            // 저장된 이미지의 경로를 반환합니다
            return imagePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장에 실패하였습니다.", e);
        }
    }

    // 펫 등록
    @PostMapping("/add")
    public String addPet(@ModelAttribute PetUpdate pet, @RequestParam("petImg") MultipartFile petImg) {
        petUpdateService.createPet(pet, petImg);
        return "redirect:/user/mypage";
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
