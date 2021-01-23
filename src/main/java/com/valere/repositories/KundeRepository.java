package com.valere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valere.entities.Kunde;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
	 
}