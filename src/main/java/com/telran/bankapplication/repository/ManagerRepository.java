package com.telran.bankapplication.repository;

import com.telran.bankapplication.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("SELECT a FROM Manager a WHERE a.lastName=?1")
    Optional<Manager> findManagerByName(String lastName);

    Optional<Manager> findManagerById(Long id);
}
