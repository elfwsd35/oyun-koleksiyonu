package com.oyun.oyun_koleksiyonu.service;

import com.oyun.oyun_koleksiyonu.model.Oyun;
import com.oyun.oyun_koleksiyonu.repository.OyunRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OyunService {

    private final OyunRepository oyunRepository;

    public OyunService(OyunRepository oyunRepository) {
        this.oyunRepository = oyunRepository;
    }

    public List<Oyun> tumOyunlariGetir() {
        return oyunRepository.findAll();
    }

    public List<Oyun> bitirilenOyunlariGetir() {
        return oyunRepository.findByBitirildi(true);
    }

    public Oyun oyunEkle(Oyun oyun) {
        if (oyun.getAd() == null || oyun.getAd().isBlank()) {
            throw new IllegalArgumentException("Oyun adi bos olamaz!");
        }
        if (oyun.getPuan() < 1 || oyun.getPuan() > 10) {
            throw new IllegalArgumentException("Puan 1 ile 10 arasinda olmali!");
        }
        return oyunRepository.save(oyun);
    }

    public void oyunSil(Long id) {
        oyunRepository.deleteById(id);
    }
}