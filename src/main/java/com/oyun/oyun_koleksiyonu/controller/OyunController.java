package com.oyun.oyun_koleksiyonu.controller;

import com.oyun.oyun_koleksiyonu.model.Oyun;
import com.oyun.oyun_koleksiyonu.service.OyunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oyunlar")
public class OyunController {

    private final OyunService oyunService;

    public OyunController(OyunService oyunService) {
        this.oyunService = oyunService;
    }

    @GetMapping
    public List<Oyun> tumOyunlar() {
        return oyunService.tumOyunlariGetir();
    }

    @GetMapping("/bitirilenler")
    public List<Oyun> bitirilenler() {
        return oyunService.bitirilenOyunlariGetir();
    }

    @PostMapping
    public Oyun oyunEkle(@RequestBody Oyun oyun) {
        return oyunService.oyunEkle(oyun);
    }

    @DeleteMapping("/{id}")
    public void oyunSil(@PathVariable Long id) {
        oyunService.oyunSil(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> hataYakala(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}