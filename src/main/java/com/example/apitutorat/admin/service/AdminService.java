package com.example.apitutorat.admin.service;

import com.example.apitutorat.admin.Administrateur;

import java.util.List;

public interface AdminService {
    public Administrateur addAdmin(Administrateur administrateur);
    Administrateur login(String login , String password);
}
