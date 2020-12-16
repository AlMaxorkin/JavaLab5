import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Example example = new Example();
        try {
            Injector.inject(example);
            System.out.println();
            example.foo();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Object a = new Object();


    }
}
