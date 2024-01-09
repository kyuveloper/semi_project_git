package com.semiproject.pettales.mypage.mypage.repository;

import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetUpdate, Integer> {
    List<PetUpdate> findByUserUpdate_UserCode(int userId);
}

