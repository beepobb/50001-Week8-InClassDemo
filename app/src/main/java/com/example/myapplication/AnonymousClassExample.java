package com.example.myapplication;

public class AnonymousClassExample {
    public static void main(String[] args) {
        Sound runningSound = new RunningSound();
        System.out.println( runningSound.makeSound() );

        // Anonymous class
        System.out.println(new Sound() {
            @Override
            public String makeSound() {
                return "tap tap tap";
            }
        }.makeSound());
    }
}

class RunningSound implements Sound {
    @Override
    public String makeSound() {
        return "tap tap tap";
    }
}

interface Sound {
    String makeSound();
}