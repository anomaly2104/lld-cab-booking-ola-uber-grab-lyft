package com.uditagarwal.cabbooking.database;

import com.uditagarwal.cabbooking.exceptions.RiderAlreadyExistsException;
import com.uditagarwal.cabbooking.exceptions.RiderNotFoundException;
import com.uditagarwal.cabbooking.model.Rider;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/** In memory database for storing jobs. */
public class RidersManager {
  Map<String, Rider> riders = new HashMap<>();

  public void createRider(@NonNull final Rider newRider) {
    if (riders.containsKey(newRider.getId())) {
      throw new RiderAlreadyExistsException();
    }

    riders.put(newRider.getId(), newRider);
  }

  public Rider getRider(@NonNull final String riderId) {
    if (!riders.containsKey(riderId)) {
      throw new RiderNotFoundException();
    }
    return riders.get(riderId);
  }
}
