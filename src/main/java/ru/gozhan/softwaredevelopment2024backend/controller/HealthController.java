package ru.gozhan.softwaredevelopment2024backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

    @GetMapping("live")
    public String isLive() {
        return "<title>Backend is alive</title>";
    }

}
