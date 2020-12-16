import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Класс с методом injector
 */
public class Injector {
    /**
     * Ищет поля помеченные аннотацией @AutoInjectible инициализирует эти поля экземлярами классов,
     * которые указаны в файле config.properties
     * @param object объект любого класса
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static void inject(Object object) throws IOException, ClassNotFoundException, IllegalAccessException {

        Field[] fields = object.getClass().getDeclaredFields();

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        Properties properties = new Properties();

        properties.load(fileInputStream);

        for (Field field : fields) {
            if (field.getAnnotation(AutoInjectable.class) != null) {

                Class cls = Class.forName(properties.getProperty(field.getAnnotatedType().toString()));
                Object implInstance = null;
                try {
                    implInstance = cls.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

                field.setAccessible(true);
                field.set(object, implInstance);
            }
        }
    }
}