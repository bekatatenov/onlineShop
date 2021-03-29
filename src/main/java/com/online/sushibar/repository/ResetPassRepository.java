package com.online.sushibar.repository;

import com.online.sushibar.entity.ResetPass;
import com.online.sushibar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPassRepository extends JpaRepository<ResetPass, Long> {

    boolean existsByUser(User user);

    ResetPass findByUser(User user);

    boolean existsByTokenAndUser(String token, User user);

}
