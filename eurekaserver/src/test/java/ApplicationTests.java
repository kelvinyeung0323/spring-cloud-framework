import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

/**
 * Created by Kelvin Yeung on 2018/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class ApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void catalogLoads(){

        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/eureka/apps",Map.class);
        Assert.assertEquals(HttpStatus.OK,entity.getStatusCode());
    }


    @Test
    public void adminLoads(){
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/env",Map.class);
        Assert.assertEquals(HttpStatus.OK,entity.getStatusCode());
    }
}
