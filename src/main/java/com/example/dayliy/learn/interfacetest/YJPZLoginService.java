package com.example.dayliy.learn.interfacetest;

public class YJPZLoginService  implements  LoginService{
    @Override
    public Boolean login(String userName, String password) {
        System.out.println(userName);
        return true;
    }
}
