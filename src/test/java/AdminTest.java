import com.alibaba.fastjson.JSON;
import com.ucmed.hnust.pojo.Admin;
import com.ucmed.hnust.service.AdminService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZY-LJ-1446 on 2018/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AdminTest {


    @Autowired
    private AdminService adminService;


    @Test
    public void selectByAdminInfo(){
        Admin admin = new Admin();
        admin.setAccount("liuddjiang");
        admin.setPassword("liujiang629728");
        Admin admin1 = adminService.selectByAdminInfo(admin);

    }
}
