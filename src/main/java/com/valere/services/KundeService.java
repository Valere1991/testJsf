package com.valere.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valere.entities.Kunde;
import com.valere.repositories.KundeRepository;

@Service
@Transactional
public class KundeService {
 
    @Autowired
    private KundeRepository repo;
     
    public List<Kunde> listAll() {
        return repo.findAll();
    }
     
    public void save(Kunde kunde) {
        repo.save(kunde);
    }
     
    
}