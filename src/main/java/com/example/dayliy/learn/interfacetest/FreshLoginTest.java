package com.example.dayliy.learn.interfacetest;
//7fresh 登陆入口
public class FreshLoginTest {

    public static void main(String[] args) {
        LoginService loginService=new FreshLoginService();
        loginService.login("jj","ss");
    }

    public void login(Integer type,String userName,String password){
        switch(type){
            case 1:
                break;
            default:
        }
    }
}
