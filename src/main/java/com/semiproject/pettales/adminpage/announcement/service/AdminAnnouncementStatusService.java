/*
서비스(Service) 클래스
비즈니스 로직을 수행하며, 필요한 경우
레포지토리를 호출하여 데이터를 가져오거나 저장합니다.
 */

package com.semiproject.pettales.adminpage.announcement.service;

import com.semiproject.pettales.adminpage.announcement.entity.AdminAnnouncementStatus;
import com.semiproject.pettales.adminpage.announcement.repository.AdminAnnouncementStatusRepository;
import com.semiproject.pettales.adminpage.model.dto.AnnouncementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminAnnouncementStatusService {
    private final AdminAnnouncementStatusRepository adminAnnouncementStatusRepository;

    @Autowired
    public AdminAnnouncementStatusService(AdminAnnouncementStatusRepository adminAnnouncementStatusRepository) {
        this.adminAnnouncementStatusRepository = adminAnnouncementStatusRepository;
    }

    public AnnouncementDTO updateAnnouncement(int annoCode, AnnouncementDTO announcementDTO) {
        AdminAnnouncementStatus adminAnnouncementStatus = adminAnnouncementStatusRepository.findById(annoCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 공지사항 코드:" + annoCode));

        // DTO의 데이터로 엔터티를 업데이트합니다
        updateEntityFromDto(adminAnnouncementStatus, announcementDTO);
        adminAnnouncementStatus.setUpdateDate(new Date());

        AdminAnnouncementStatus updatedAdminAnnouncementStatus = adminAnnouncementStatusRepository.save(adminAnnouncementStatus);
        return convertToDto(updatedAdminAnnouncementStatus);
    }

    // DTO의 데이터로 엔터티를 업데이트하는 메소드
    private void updateEntityFromDto(AdminAnnouncementStatus adminAnnouncementStatus, AnnouncementDTO announcementDTO) {
        adminAnnouncementStatus.setAnnoTitle(announcementDTO.getAnnoTitle());
        adminAnnouncementStatus.setAnnoContents(announcementDTO.getAnnoContents());
        adminAnnouncementStatus.setAnnoPin(announcementDTO.getAnnoPin());
        adminAnnouncementStatus.setAnnoStatus(announcementDTO.getAnnoStatus());
    }

    // 엔터티를 DTO로 변환하는 메소드
    private AnnouncementDTO convertToDto(AdminAnnouncementStatus adminAnnouncementStatus) {
        // 엔터티의 데이터로 새로운 DTO를 생성합니다
        AnnouncementDTO dto = new AnnouncementDTO();
        dto.setAnnoCode(adminAnnouncementStatus.getAnnoCode());
        dto.setAnnoTitle(adminAnnouncementStatus.getAnnoTitle());
        dto.setAnnoContents(adminAnnouncementStatus.getAnnoContents());
        dto.setAnnoPin(adminAnnouncementStatus.getAnnoPin());
        dto.setAnnoStatus(adminAnnouncementStatus.getAnnoStatus());
        dto.setRegistDate(adminAnnouncementStatus.getRegistDate());
        dto.setUpdateDate(adminAnnouncementStatus.getUpdateDate());
        return dto;
    }


    // 공지사항을 삭제하는 메소드
    public void deleteAnnouncement(int annoCode) {
        AdminAnnouncementStatus announcement = adminAnnouncementStatusRepository.findById(annoCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 공지사항 코드:" + annoCode));
        adminAnnouncementStatusRepository.deleteById(annoCode);
    }

    // 전체 공지사항 수를 반환하는 메소드
    public int getAnnouncementCount() {
        return (int) adminAnnouncementStatusRepository.count();
    }

    // 페이지별로 공지사항 목록을 반환하는 메소드
    public List<AnnouncementDTO> getAnnouncementsPerPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size); // 페이지는 0부터 시작하므로 page - 1을 해줍니다.
        Page<AdminAnnouncementStatus> pageResult = adminAnnouncementStatusRepository.findAll(pageRequest);
        return pageResult.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 키워드로 공지사항을 검색하는 메소드
    public List<AnnouncementDTO> searchAnnouncements(String keyword) {
        List<AdminAnnouncementStatus> entities = adminAnnouncementStatusRepository.findByannoTitleContaining(keyword);
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 공지사항 정보를 가져오는 메소드
    public AnnouncementDTO getAnnouncementInfo(int annoCode) {
        AdminAnnouncementStatus adminAnnouncementStatus = adminAnnouncementStatusRepository.findById(annoCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 공지사항 코드:" + annoCode));
        return convertToDto(adminAnnouncementStatus);
    }

    // 공지사항 정보를 업데이트하는 메소드
    public AnnouncementDTO updateAnnouncementInfo(AnnouncementDTO announDTO) {
        AdminAnnouncementStatus adminAnnouncementStatus = adminAnnouncementStatusRepository.findById(announDTO.getAnnoCode())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 공지사항 코드:" + announDTO.getAnnoCode()));

        // DTO의 데이터로 엔터티를 업데이트합니다
        adminAnnouncementStatus.setAnnoTitle(announDTO.getAnnoTitle());
        adminAnnouncementStatus.setAnnoContents(announDTO.getAnnoContents());
        adminAnnouncementStatus.setAnnoPin(announDTO.getAnnoPin());
        adminAnnouncementStatus.setAnnoStatus(announDTO.getAnnoStatus());
        adminAnnouncementStatus.setUpdateDate(new Date());

        AdminAnnouncementStatus updatedAdminAnnouncementStatus = adminAnnouncementStatusRepository.save(adminAnnouncementStatus);
        return convertToDto(updatedAdminAnnouncementStatus);
    }

    // 새로운 공지사항을 등록하는 메소드
    public AnnouncementDTO addAnnouncement(AnnouncementDTO announDTO) {
        AdminAnnouncementStatus adminAnnouncementStatus = new AdminAnnouncementStatus();

        // DTO의 데이터로 엔터티를 설정합니다
        adminAnnouncementStatus.setAnnoTitle(announDTO.getAnnoTitle());
        adminAnnouncementStatus.setAnnoContents(announDTO.getAnnoContents());
        adminAnnouncementStatus.setAnnoPin(announDTO.getAnnoPin());
        adminAnnouncementStatus.setAnnoStatus(announDTO.getAnnoStatus());
        adminAnnouncementStatus.setRegistDate(new Date());

        AdminAnnouncementStatus newAdminAnnouncementStatus = adminAnnouncementStatusRepository.save(adminAnnouncementStatus);
        return convertToDto(newAdminAnnouncementStatus);
    }

    public AnnouncementDTO updateAnnouncementInfo(int annoCode, AnnouncementDTO announDTO) {
        AdminAnnouncementStatus adminAnnouncementStatus = adminAnnouncementStatusRepository.findById(annoCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 공지사항 코드:" + annoCode));

        // 찾은 Announcement를 announDTO의 정보로 업데이트 합니다.
        adminAnnouncementStatus.setAnnoTitle(announDTO.getAnnoTitle());
        adminAnnouncementStatus.setAnnoContents(announDTO.getAnnoContents());
        adminAnnouncementStatus.setAnnoPin(announDTO.getAnnoPin());
        adminAnnouncementStatus.setAnnoStatus(announDTO.getAnnoStatus());
        adminAnnouncementStatus.setUpdateDate(new Date());

        AdminAnnouncementStatus updatedAdminAnnouncementStatus = adminAnnouncementStatusRepository.save(adminAnnouncementStatus);
        return convertToDto(updatedAdminAnnouncementStatus);
    }
}