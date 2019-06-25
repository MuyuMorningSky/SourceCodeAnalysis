import com.mayikt.config.MySpringConfig;
import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestSpring {

    @Test
    public void testAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MySpringConfig.class);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>初始化容器");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            /**
             * 测试默认加载模式
             */
            Object bean = applicationContext.getBean(beanName);
            System.out.println(beanName+"<===============>"+bean);
        }
        /**
         * 测试单例，并且getBean调用无参构造器
         */
        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService == userService2);
    }
}
