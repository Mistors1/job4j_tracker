package ru.job4j.polymorph;

public class Train implements Transport {

   @Override
   public void move() {
        System.out.println("Поезд движется по рельсам");
    }
}
