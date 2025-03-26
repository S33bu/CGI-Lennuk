package com.example.lennuk.controller;
import java.time.LocalDate;
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
        return Arrays.asList(
            new Lend("New York", "London", LocalDate.of(2025, 3, 25), 420, 500, lennukohad.genereeriKohad()),
            new Lend("Paris", "Tokyo", LocalDate.of(2025, 4, 10), 720, 800, lennukohad.genereeriKohad()),
            new Lend("Sydney", "San Francisco", LocalDate.of(2025, 5, 5), 840, 900, lennukohad.genereeriKohad())
        );
    }
 
}

