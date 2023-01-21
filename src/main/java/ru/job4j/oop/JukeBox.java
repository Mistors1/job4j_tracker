package ru.job4j.oop;

public class JukeBox {
    public static void main(String[] args) {
        JukeBox song = new JukeBox();
        song.music(1);
        song.music(2);
        song.music(3);
    }

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }

    }
}
