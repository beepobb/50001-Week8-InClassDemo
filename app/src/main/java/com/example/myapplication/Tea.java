package com.example.myapplication;

public class Tea {
    private boolean sugar;
    private boolean milk;
    private Tea(TeaBuilder teaBuilder){
        this.sugar = teaBuilder.sugar;
        this.milk = teaBuilder.milk;
    }
    static class TeaBuilder {
        private boolean sugar;
        private boolean milk;
        TeaBuilder(){}
        public TeaBuilder setSugar ( boolean sugar){
            this.sugar = sugar;
            return this; }
        public TeaBuilder setMilk ( boolean milk){
            this .milk = milk;
            return this; }
        public Tea build (){
            return new Tea( this ); }
    }
}