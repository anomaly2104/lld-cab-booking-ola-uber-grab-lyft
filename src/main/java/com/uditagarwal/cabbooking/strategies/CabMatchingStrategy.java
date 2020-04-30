package com.uditagarwal.cabbooking.strategies;

import com.uditagarwal.cabbooking.model.Cab;
import com.uditagarwal.cabbooking.model.Location;
import com.uditagarwal.cabbooking.model.Rider;
import java.util.List;

public interface CabMatchingStrategy {

  Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
