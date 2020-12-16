import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import static java.lang.Class.forName;

public class Injector {
    public static void inject(Object object) throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

        Field [] fields = object.getClass().getDeclaredFields();

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        Properties properties = new Properties();

        properties.load(fileInputStream);

        for(Field field: fields){
            if(field.getAnnotation(AutoInjectable.class) instanceof AutoInjectable){

                Class cls = Class.forName(properties.getProperty(field.getAnnotatedType().toString()));

                field.setAccessible(true);
                System.out.println(field.getName());


                System.out.println(cls.getNestHost().getName());

                System.out.println(cls.getCanonicalName());
                field.set(object, cls);

            }
        }


        }
}

