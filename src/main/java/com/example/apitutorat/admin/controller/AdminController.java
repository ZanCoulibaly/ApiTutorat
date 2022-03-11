package com.example.apitutorat.admin.controller;

import com.example.apitutorat.admin.Administrateur;
import com.example.apitutorat.admin.repository.AdminRepository;
import com.example.apitutorat.admin.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/")
public class AdminController {
    @Autowired
    AdminServiceImp adminServiceImp;

    @PostMapping("add")
    public Administrateur addAdmin(@RequestBody Administrateur administrateur){
        return adminServiceImp.addAdmin(administrateur);
    }

    @GetMapping("loginPass/{login}/{password}")
    public Administrateur Login(@PathVariable String login, @PathVariable String password) {
        return adminServiceImp.login(login, password);
    }
}
