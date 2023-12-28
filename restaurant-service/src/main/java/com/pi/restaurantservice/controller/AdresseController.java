package com.pi.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.restaurantservice.model.Adresse;
import com.pi.restaurantservice.repository.AdresseRepository;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    private AdresseRepository adresseRepository;

    @GetMapping
    public ResponseEntity<List<Adresse>> getAllAdresses() {
        List<Adresse> adresses = adresseRepository.findAll();
        return ResponseEntity.ok(adresses);
    }

    @PostMapping
    public ResponseEntity<Adresse> createAdresse(Adresse adresse) {
        Adresse savedAdresse = adresseRepository.save(adresse);
        return ResponseEntity.ok(savedAdresse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adresse> updateAdresse(@PathVariable Long id, @RequestBody Adresse adresseDetails) {
        return adresseRepository.findById(id)
                .map(existingAdresse -> {
                    existingAdresse.setNom(adresseDetails.getNom());
                    existingAdresse.setNumero(adresseDetails.getNumero());
                    existingAdresse.setRue(adresseDetails.getRue());
                    existingAdresse.setCite(adresseDetails.getCite());
                    existingAdresse.setVille(adresseDetails.getVille());
                    Adresse updatedAdresse = adresseRepository.save(existingAdresse);
                    return ResponseEntity.ok(updatedAdresse);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdresse(@PathVariable Long id) {
        return adresseRepository.findById(id)
                .map(adresse -> {
                    adresseRepository.delete(adresse);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
