package com.uditagarwal.cabbooking.strategies;

import com.uditagarwal.cabbooking.model.Cab;
import com.uditagarwal.cabbooking.model.Location;
import com.uditagarwal.cabbooking.model.Rider;
import java.util.List;
import lombok.NonNull;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

  @Override
  public Cab matchCabToRider(
      @NonNull final Rider rider,
      @NonNull final List<Cab> candidateCabs,
      @NonNull final Location fromPoint,
      @NonNull final Location toPoint) {
    if (candidateCabs.isEmpty()) {
      return null;
    }
    return candidateCabs.get(0);
  }
}
