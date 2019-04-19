import com.ucmed.hnust.service.Greeting;
import com.ucmed.hnust.service.GreetingAroundAdvice;
import com.ucmed.hnust.service.GreetingImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZY-LJ-1446 on 2018/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class GreetingTest {
    private Logger logger = Logger.getLogger(this.getClass());
    @Test
    public void sayHi(){

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHi("LiuJiang");
    }
}
