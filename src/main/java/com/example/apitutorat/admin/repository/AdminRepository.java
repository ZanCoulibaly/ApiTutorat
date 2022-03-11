package com.example.apitutorat.admin.repository;

import com.example.apitutorat.admin.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Administrateur, Long> {
    Administrateur findByLoginAndPassword(String login, String password);
}
