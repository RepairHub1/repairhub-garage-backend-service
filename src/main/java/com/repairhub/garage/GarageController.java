
package com.repairhub.garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    @Autowired
    private GarageRepository garageRepository;

    @GetMapping
    public List<Garage> getAll() {
        return garageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return garageRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return garageRepository.save(garage);
    }

    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        garage.setId(id);
        return garageRepository.save(garage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        garageRepository.deleteById(id);
    }
}
