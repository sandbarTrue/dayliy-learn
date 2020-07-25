package com.example.dayliy.learn.jicheng;

public class AnimalTest {

    public static void main(String[] args) {
        Animal animal1=new Animal();
        Animal animal=new Dog();
        Dog dog=(Dog) animal;
        Dog dog1=(Dog) animal1;
    }
}

class Animal{


}

class Dog extends  Animal{



   public void  work(){

    }

}