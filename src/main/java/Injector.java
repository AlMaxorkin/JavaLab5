import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector {
    public static void inject(Object object) throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

        Field[] fields = object.getClass().getDeclaredFields();

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        Properties properties = new Properties();

        properties.load(fileInputStream);

        for (Field field : fields) {
            if (field.getAnnotation(AutoInjectable.class) != null) {

                var cls = Class.forName(properties.getProperty(field.getAnnotatedType().toString()));
                Object implInstance = null;
                try {
                    implInstance = cls.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                field.setAccessible(true);
                
                System.out.println("this is impl" + implInstance);

                System.out.println(cls.getCanonicalName());
                field.set(object, implInstance);
            }
        }
    }
}