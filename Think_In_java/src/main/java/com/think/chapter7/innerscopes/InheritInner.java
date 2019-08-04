package com.think.chapter7.innerscopes;

class WithInner{
    class Inner{

    }
}
public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner inner){
        inner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
    }
}
