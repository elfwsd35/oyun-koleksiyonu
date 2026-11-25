package com.oyun.oyun_koleksiyonu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Oyun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String platform;
    private boolean bitirildi;
    private int puan;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public boolean isBitirildi() { return bitirildi; }
    public void setBitirildi(boolean bitirildi) { this.bitirildi = bitirildi; }

    public int getPuan() { return puan; }
    public void setPuan(int puan) { this.puan = puan; }
}