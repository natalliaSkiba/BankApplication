package com.telran.bankapplication.repository;

import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client,UUID> {
    List<Client> findAll();
}