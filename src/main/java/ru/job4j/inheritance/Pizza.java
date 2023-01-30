package ru.job4j.inheritance;

public class Pizza {
    public String name() {
        return "Just tasty pizza";
    }
}

class PizzaExtraCheese extends Pizza {
    @Override
    public String name() {
        return super.name() + " extra cheese";
    }
}

class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    @Override
    public String name() {
        return super.name() + " extra tomato";
    }
}

class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese();
        PizzaExtraCheeseExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato();
        System.out.println(pizza.name());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
    }
}
