package MainPackage;


class Implementation1 implements Interface1{
    public void InterfaceMethod() {
        System.out.println("A");
    }
}

class Implementation2 implements Interface1{
    public void InterfaceMethod() {
        System.out.println("B");
    }
}

class Implementation3 implements Interface2{
    public void InterfaceMethod() {
        System.out.println("C");
    }
}
