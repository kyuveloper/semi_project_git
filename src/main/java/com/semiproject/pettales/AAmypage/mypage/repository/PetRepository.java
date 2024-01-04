package com.semiproject.pettales.AAmypage.mypage.repository;

import com.semiproject.pettales.AAmypage.doglistchange.entity.PetUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetUpdate, Integer> {
    List<PetUpdate> findByUserUpdate_UserCode(int userId);
}

