package ru.job4j.oop;

public class Cat {
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    private String food;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        System.out.println("There are gav's nick");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        System.out.println("There are black's nick");
        black.giveNick("Black");
        black.show();
    }
}
