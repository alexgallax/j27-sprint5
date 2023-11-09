package edu.praktikum.sprint5.models;

import java.util.Comparator;

public interface SpaceShip extends Comparable<SpaceShip> {

    int getCrewCount();

    boolean isCargo();
}
