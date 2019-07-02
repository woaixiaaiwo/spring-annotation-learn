import com.boge.config.TxConfig;
import com.boge.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    public void test01(){
        UserService userSerevice = (UserService) annotationConfigApplicationContext.getBean("userService");
        userSerevice.insert();

    }

}
