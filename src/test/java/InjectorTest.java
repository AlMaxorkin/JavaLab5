import MainPackage.Interface2;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {


    @Test
    void inject() {
        Example example = new Example();
        try {
            Injector.inject(example);
            assertEquals(example.publicField1.InterfaceMethod(), "Implementation1 ");
            assertEquals(example.publicField2.InterfaceMethod(), "Implementation2 ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}