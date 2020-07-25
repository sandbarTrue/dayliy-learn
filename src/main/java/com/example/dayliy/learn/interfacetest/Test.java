package com.example.dayliy.learn.interfacetest;

 class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

 class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    @Override
    public String show(A obj){
        return ("B and A");
    }
}

 class C extends B{

}

 class D extends B{

}

public class Test {
    public static void main(String[] args) {
        //接口 一种约定  一种协议  一种扩展  有一个定义方 TypeC run/link  要实现这个协议这一方必须遵守协议
        Andriod andriod =new Andriod();
        run(andriod);
        Typec typec =new Andriod();
        run(typec);

        Andriod huawei=new Huawei();
        huawei.run("huawei");
        huawei.UsbRun("usb run");
        LoginService loginService=new YJPZLoginService();
        loginService.login("zhoujun","1w234");
        //继承
//        A a1 = new A();
//        A a2 = new B();
//        B b = new B();
//        C c = new C();
//        D d = new D();
//
//        System.out.println("1--" + a1.show(b));
//        System.out.println("2--" + a1.show(c));
//        System.out.println("3--" + a1.show(d));
//        System.out.println("4--" + a2.show(b));
//        System.out.println("5--" + a2.show(c));
//        System.out.println("6--" + a2.show(d));
//        System.out.println("7--" + b.show(b));
//        System.out.println("8--" + b.show(c));
//        System.out.println("9--" + b.show(d));
    }

    public static  void run(Typec typec){
        typec.run("kkk");
    }

}