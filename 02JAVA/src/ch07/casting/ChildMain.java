package ch07.casting;

public class ChildMain {
    public static void main(String[] args) {
        //Upcasting
        Parent parent = new Child();
        parent.parentField = "가능";
        System.out.println(parent.parentField);
        parent.method1(); //Parent Method 1
        parent.method2(); //Child Method2
        //parent.childField = "불가능"
        //parent.method3(); 불가능

        //Downcasting
        Child child = (Child) parent;
        child.childField = "가능";
        System.out.println(child.childField);
        child.method3(); //Child Method 3
        child.method2(); //Child Method2
        child.method1(); //Parent Method 1
        child.parentField = "가능?";
        System.out.println(child.parentField);

    }
}
