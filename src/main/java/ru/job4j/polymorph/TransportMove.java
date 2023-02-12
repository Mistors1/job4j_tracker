package ru.job4j.polymorph;

public class TransportMove {
    public static void main(String[] args) {
        Transport car = new Car();
        Transport taxi = new Car();
        Transport train = new Train();
        Transport plane = new Plane();

        Transport[] transports = new Transport[] {car, train, plane, taxi};
        for (Transport i : transports) {
            i.move();
        }
    }
}
