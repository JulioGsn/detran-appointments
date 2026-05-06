package com.example.detran.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "Detran API",
            "description", "API REST para gerenciamento de candidatos, exames, agendamentos e resultados"
        );
    }
}
