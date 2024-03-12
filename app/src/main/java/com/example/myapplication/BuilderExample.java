package com.example.myapplication;

public class BuilderExample {
    public static void main(String[] args) {
        Tea.TeaBuilder teaBuilder = new Tea.TeaBuilder();
        Tea tea1 = teaBuilder.setSugar(true).setMilk(false).build();

    }
}
