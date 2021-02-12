import PackAWay.controller;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTests {

    @Autowired
    private PackAWay.controller controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}