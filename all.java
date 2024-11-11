import java.util.*;
import java.lang.*;
import java.io.*;

class Animal {
    private static int animalCount = 0; // Счетчик животных
    public Animal() {
        animalCount++;
    }
    public static int getAnimalCount() {
        return animalCount;
    }
    public void run(int distance) {
        // Будет переопределено в подклассах
    }
    public void swim(int distance) {
        // Будет переопределено в подклассах
    }
}
class Dog extends Animal {
    private static int dogCount = 0; // Счетчик собак
    public Dog() {
        super();
        dogCount++;
    }
    public static int getDogCount() {
        return dogCount;
    }
    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " метров.");
        } else {
            System.out.println("Собака не может пробежать " + distance + " метров.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " метров.");
        } else {
            System.out.println("Собака не может проплыть " + distance + " метров.");
        }
    }
}
class Cat extends Animal {
    private static int catCount = 0; // Счетчик котов
    private boolean isFull; // Поле сытости
    public Cat() {
        super();
        this.isFull = false; // Кот изначально голоден
        catCount++;
    }
    public static int getCatCount() {
        return catCount;
    }
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " метров.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " метров.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }
    public void eat(FoodBowl foodBowl) {
        if (foodBowl.getFoodAmount() > 0) {
            foodBowl.decreaseFood();
            this.isFull = true;
            System.out.println("Кот покушал из миски.");
        } else {
            System.out.println("Кот не может покушать, в миске нет еды.");
        }
    }
    public boolean isFull() {
        return isFull;
    }
}
class FoodBowl {
    private int foodAmount; // Количество еды в миске
    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }
    public int getFoodAmount() {
        return foodAmount;
    }
    public void decreaseFood() {
        if (foodAmount > 0) {
            foodAmount--;
        }
    }
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Количество добавляемой еды должно быть положительным.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Создаем миску с едой
        FoodBowl foodBowl = new FoodBowl(5);
        
        // Создаем котов
        Cat[] cats = { new Cat(), new Cat(), new Cat() };
        
        // Коты пытаются покушать
        for (Cat cat : cats) {
            cat.eat(foodBowl);
        }
        
        // Проверяем сытость котов
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытость: " + (cats[i].isFull() ? "Да" : "Нет"));
        }
        
        // Добавляем еду в миску
        foodBowl.addFood(3);
        
        // Коты снова пытаются покушать
        for (Cat cat : cats) {
            cat.eat(foodBowl);
        }
        
        // Проверяем сытость котов
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытость: " + (cats[i].isFull() ? "Да" : "Нет"));
        }
        
        // Создаем собак
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        
        // Собака пробует бег и плавание
        dog1.run(300);
        dog1.swim(5);
        dog2.run(600);
        dog2.swim(15);
        
        // Выводим общее количество животных
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}

