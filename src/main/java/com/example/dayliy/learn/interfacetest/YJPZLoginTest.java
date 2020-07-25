package com.example.dayliy.learn.interfacetest;
//登陆的入口
public class YJPZLoginTest {

    public static void main(String[] args) {
        LoginService loginService=new YJPZLoginService();
        loginService.login("jj","ss");
    }
}
