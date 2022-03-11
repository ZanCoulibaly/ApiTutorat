package com.example.apitutorat.users.repository;

import com.example.apitutorat.users.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuteurRepository extends JpaRepository<Tuteur, Long> {
}
