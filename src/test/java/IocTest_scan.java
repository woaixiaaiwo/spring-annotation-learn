import com.boge.config.ConfigClass;
import com.boge.config.ConfigClass2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest_scan {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);

    @Test
     public void test01(){
         String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
         for(String name : names){
             System.out.println(name);
         }

     }

}
