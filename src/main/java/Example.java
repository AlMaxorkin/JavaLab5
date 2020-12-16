import MainPackage.Interface1;
import MainPackage.Interface2;


/**
 * Пример класса, объект которого может передаваться в inject
 */
public class Example {
    @AutoInjectable
    private Interface1 field1;

    @AutoInjectable
    private Interface2 field2;

    @AutoInjectable
    public Interface1 publicField1;

    @AutoInjectable
    public Interface2 publicField2;

    private Interface2 field3;

    private int SomeInt =1211;


    private String string = "string123";

    public String getString() {
        return string;
    }

    public int getSomeInt() {
        return SomeInt;
    }

    public void foo(){
        field1.InterfaceMethod();
        field2.InterfaceMethod();
    }

}
