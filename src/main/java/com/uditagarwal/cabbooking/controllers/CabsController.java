package com.uditagarwal.cabbooking.controllers;

import com.uditagarwal.cabbooking.database.CabsManager;
import com.uditagarwal.cabbooking.database.TripsManager;
import com.uditagarwal.cabbooking.model.Cab;
import com.uditagarwal.cabbooking.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
  private CabsManager cabsManager;
  private TripsManager tripsManager;

  public CabsController(CabsManager cabsManager, TripsManager tripsManager) {
    this.cabsManager = cabsManager;
    this.tripsManager = tripsManager;
  }

  @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
  public ResponseEntity regiserCab(final String cabId, final String driverName) {
    cabsManager.createCab(new Cab(cabId, driverName));
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/update/cab/location", method = RequestMethod.POST)
  public ResponseEntity updateCabLocation(
      final String cabId, final Double newX, final Double newY) {

    cabsManager.updateCabLocation(cabId, new Location(newX, newY));
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/update/cab/availability", method = RequestMethod.POST)
  public ResponseEntity updateCabAvailability(final String cabId, final Boolean newAvailability) {
    cabsManager.updateCabAvailability(cabId, newAvailability);
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/update/cab/end/trip", method = RequestMethod.POST)
  public ResponseEntity endTrip(final String cabId) {
    tripsManager.endTrip(cabsManager.getCab(cabId));
    return ResponseEntity.ok("");
  }
}
