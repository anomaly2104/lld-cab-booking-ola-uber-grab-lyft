package com.uditagarwal.cabbooking.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Location {
  private Double x;
  private Double y;

  public Double distance(Location location2) {
    return sqrt( pow(this.x - location2.x, 2) + pow(this.y - location2.y, 2) );
  }
}
