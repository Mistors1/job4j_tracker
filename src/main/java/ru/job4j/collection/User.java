package ru.job4j.collection;


public record User(String name, int age) implements Comparable<User> {
    @Override
    public int compareTo(User o) {
      int rsl = CharSequence.compare(this.name, o.name);
      if (rsl == 0) {
          rsl = Integer.compare(this.age, o.age);
      }
        return rsl;
    }
}
