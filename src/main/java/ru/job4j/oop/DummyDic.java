package ru.job4j.oop;

public class DummyDic {

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String eng = word.engToRus("Bully");
        System.out.println("Неизвестное слово: " + eng);
    }

    public String engToRus(String eng) {
        return eng;
    }
}
