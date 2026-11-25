package com.oyun.oyun_koleksiyonu.repository;

import com.oyun.oyun_koleksiyonu.model.Oyun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OyunRepository extends JpaRepository<Oyun, Long> {


    List<Oyun> findByBitirildi(boolean bitirildi);
}