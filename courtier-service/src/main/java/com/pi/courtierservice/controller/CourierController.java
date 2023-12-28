package com.pi.courtierservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pi.courtierservice.model.Courier;
import com.pi.courtierservice.model.Location;
import com.pi.courtierservice.repository.CourierRepository;
import com.pi.courtierservice.repository.LocationRepository;

@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/create")
    public ResponseEntity<Courier> createCourierWithLocation(@RequestBody Courier courier) {
        // First, save the location to generate the ID
        Location location = courier.getLocation();
        if (location.getLatitude() == null || location.getLongitude() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Latitude and Longitude cannot be null");
        }
        location = locationRepository.save(location);
        courier.setLocation(location);
        Courier savedCourier = courierRepository.save(courier);

        return ResponseEntity.ok(savedCourier);
    }

    // Update the location of a courier
    @PutMapping("/{cin}/updateLocation")
    public ResponseEntity<Location> updateCourierLocation(@PathVariable String cin, @RequestBody Location location) {
        Courier courier = courierRepository.findById(cin)
                .orElseThrow(() -> new RuntimeException("Courier not found with cin " + cin));
    
        Location currentLocation = courier.getLocation();
        if (currentLocation == null) {
            currentLocation = new Location();
            courier.setLocation(currentLocation);
        }
        currentLocation.setLongitude(location.getLongitude());
        currentLocation.setLatitude(location.getLatitude());
        courierRepository.save(courier);
    
        return ResponseEntity.ok(currentLocation);
    }
    
}