package ru.job4j.polymorph;

public class Plane implements Transport {
    @Override
    public void move() {
        System.out.println("Самолет летит");
    }
}
