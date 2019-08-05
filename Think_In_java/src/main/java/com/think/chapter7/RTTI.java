package com.think.chapter7;

class Useful{
    public void f(){}
    public void g(){}
}

class MoreUseful extends Useful{
    @Override
    public void f(){}

    @Override
    public void g(){}

    public void u(){}

    public void v(){}

    public void w(){}

}
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };

        x[0].f();
        x[1].g();

        ((MoreUseful)x[1]).u();
        ((MoreUseful)x[0]).u();
    }
}
