package com.example.lennuk.controller;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lennuk.Lend;
import com.example.lennuk.lennukohad;

@RestController
@RequestMapping("/api/lennud")
public class LendController{
    @GetMapping("/lend")

    public List<Lend> getLennud(){
        //Lennud genereeritud Copiloti abil
        return Arrays.asList(
            new Lend("New York", "London", LocalDateTime.of(2025, 3, 25, 10, 30), 420, 500, lennukohad.genereeriKohad()),
            new Lend("Paris", "Tokyo", LocalDateTime.of(2025, 4, 10, 14, 45), 720, 800, lennukohad.genereeriKohad()),
            new Lend("Sydney", "San Francisco", LocalDateTime.of(2025, 5, 5, 8, 15), 840, 900, lennukohad.genereeriKohad()),
            new Lend("Berlin", "Dubai", LocalDateTime.of(2025, 6, 20, 16, 00), 360, 450, lennukohad.genereeriKohad()),
            new Lend("Rome", "New Delhi", LocalDateTime.of(2025, 7, 15, 22, 30), 600, 700, lennukohad.genereeriKohad()),
            new Lend("Madrid", "Buenos Aires", LocalDateTime.of(2025, 8, 10, 9, 45), 780, 850, lennukohad.genereeriKohad()),
            new Lend("Toronto", "Hong Kong", LocalDateTime.of(2025, 9, 5, 13, 20), 900, 950, lennukohad.genereeriKohad()),
            new Lend("Los Angeles", "Sydney", LocalDateTime.of(2025, 10, 25, 18, 00), 960, 1000, lennukohad.genereeriKohad()),
            new Lend("Chicago", "Paris", LocalDateTime.of(2025, 11, 30, 7, 15), 480, 550, lennukohad.genereeriKohad()),
            new Lend("Miami", "Cape Town", LocalDateTime.of(2025, 12, 20, 23, 45), 1020, 1100, lennukohad.genereeriKohad()),
            new Lend("New York", "Paris", LocalDateTime.of(2025, 1, 15, 11, 00), 420, 500, lennukohad.genereeriKohad()),
            new Lend("London", "Tokyo", LocalDateTime.of(2025, 2, 20, 13, 30), 720, 800, lennukohad.genereeriKohad()),
            new Lend("Sydney", "New York", LocalDateTime.of(2025, 3, 10, 9, 45), 840, 900, lennukohad.genereeriKohad()),
            new Lend("Berlin", "San Francisco", LocalDateTime.of(2025, 4, 5, 17, 15), 360, 450, lennukohad.genereeriKohad()),
            new Lend("Rome", "Dubai", LocalDateTime.of(2025, 5, 25, 21, 00), 600, 700, lennukohad.genereeriKohad()),
            new Lend("Madrid", "Tokyo", LocalDateTime.of(2025, 6, 15, 10, 30), 780, 850, lennukohad.genereeriKohad()),
            new Lend("Toronto", "Paris", LocalDateTime.of(2025, 7, 20, 14, 00), 900, 950, lennukohad.genereeriKohad()),
            new Lend("Los Angeles", "London", LocalDateTime.of(2025, 8, 10, 19, 30), 960, 1000, lennukohad.genereeriKohad()),
            new Lend("Chicago", "Dubai", LocalDateTime.of(2025, 9, 25, 8, 45), 480, 550, lennukohad.genereeriKohad()),
            new Lend("Miami", "New Delhi", LocalDateTime.of(2025, 10, 30, 22, 15), 1020, 1100, lennukohad.genereeriKohad()),
            new Lend("New York", "Sydney", LocalDateTime.of(2025, 11, 5, 12, 00), 420, 500, lennukohad.genereeriKohad()),
            new Lend("Paris", "San Francisco", LocalDateTime.of(2025, 12, 15, 15, 45), 720, 800, lennukohad.genereeriKohad()),
            new Lend("Sydney", "Berlin", LocalDateTime.of(2025, 1, 25, 7, 30), 840, 900, lennukohad.genereeriKohad()),
            new Lend("Berlin", "New York", LocalDateTime.of(2025, 2, 10, 16, 00), 360, 450, lennukohad.genereeriKohad()),
            new Lend("Rome", "Tokyo", LocalDateTime.of(2025, 3, 20, 20, 30), 600, 700, lennukohad.genereeriKohad()),
            new Lend("Madrid", "Dubai", LocalDateTime.of(2025, 4, 15, 11, 45), 780, 850, lennukohad.genereeriKohad()),
            new Lend("Toronto", "New Delhi", LocalDateTime.of(2025, 5, 5, 13, 15), 900, 950, lennukohad.genereeriKohad()),
            new Lend("Los Angeles", "Paris", LocalDateTime.of(2025, 6, 25, 18, 45), 960, 1000, lennukohad.genereeriKohad()),
            new Lend("Chicago", "Tokyo", LocalDateTime.of(2025, 7, 30, 9, 00), 480, 550, lennukohad.genereeriKohad()),
            new Lend("Miami", "London", LocalDateTime.of(2025, 8, 20, 23, 30), 1020, 1100, lennukohad.genereeriKohad())
                );
    }
 
}

