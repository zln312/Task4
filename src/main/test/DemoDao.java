import com.mapper.ExcellentMapper;
import com.mapper.JobMapper;
import com.mapper.UserMapper;



import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class DemoDao {
    @Autowired
    ExcellentMapper excellentMapper;
    @Autowired
    JobMapper jobMapper;
    @Autowired
    UserMapper userMapper;

    Logger logger = Logger.getLogger(DemoDao.class);

    @Test
    public void test() {
     if ("".equals("")){
         System.out.println("可以判断");
     }else {
         System.out.println("不可以判断");
     }

    }
}