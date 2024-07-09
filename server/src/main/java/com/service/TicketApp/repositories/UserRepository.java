package com.service.TicketApp.repositories;

import com.service.TicketApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<Users,Long> {
}
