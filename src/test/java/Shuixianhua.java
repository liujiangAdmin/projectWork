import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZY-LJ-1446 on 2018/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class Shuixianhua {
    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public  void shuixianhua()
    {
        for (int i=100;i<=999;i++)
        {
            int bai = i/100;
            int shi = i%100/10;
            int ge = i%10;
            /*if(bai*bai*bai+shi*shi*shi+ge*ge*ge==i)
            {
                logger.info("shuixinahua:"+i);
            }*/
            logger.info(bai+","+shi+","+ge);
        }
    }
}
