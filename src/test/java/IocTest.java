import com.boge.bean.Person;
import com.boge.config.ConfigClass2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.boge.config.ConfigClass;

import java.util.Arrays;

public class IocTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigClass2.class);

    @Test
     public void test01(){
         String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
         for(String name : names){
             System.out.println(name);
         }

     }

    @Test
    public void test02(){
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

    }

}
