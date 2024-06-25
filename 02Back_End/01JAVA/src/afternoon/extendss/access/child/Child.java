package afternoon.extendss.access.child;

//다른 패키지라서~ 임포트
import afternoon.extendss.access.parent.Parent;

public class Child extends Parent {
    public void access() {
        //default: 패키지가 달라서 접근 x
        //protected: 패키지가 달라도 상속관계라 가능,,~
        //default: 패키지가 달라서 불가능
        //private: 같은 클래스 아니라서 불가능
        System.out.println("publicValue: " + publicValue); //어디서든 접근 가능
        System.out.println("protectedValue: " + protectedValue);

        publicMethod();
        protectedMethod();

        printParent();
    }
}
