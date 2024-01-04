package com.semiproject.pettales.AAmypage.passwordchange.repository;

import com.semiproject.pettales.AAmypage.userupdate.entity.UserUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordChangeRepository extends JpaRepository<UserUpdate, Integer> {
}
