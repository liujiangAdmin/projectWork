import com.ucmed.hnust.xml.dom.DomUtil;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.Properties;

/**
 * Created by ZY-LJ-1446 on 2018/2/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class IndexTest {

    private Logger logger = Logger.getLogger(this.getClass());

    String mrmyList;
    @Before
    public void before()
    {
        Properties properties = new Properties();
        try {
            logger.info(this.getClass().getResourceAsStream("/other/mrmy.properties"));
            properties.load(this.getClass().getResourceAsStream("other/mrmy.properties"));
            mrmyList = properties.getProperty("mymy.list");
            mrmyList=new String(mrmyList.getBytes("ISO-8859-1"),"utf-8");
            logger.info(mrmyList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test()
    {
        logger.info(this.getClass().getResource("/other/dom.xml").getPath());
        File file = new File(this.getClass().getResource("/other/dom.xml").getPath());
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Document document = DomUtil.getDocument();
            Document document1 =  DomUtil.getJDDocument(document);
            DomUtil.documentToXml(document1,file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
