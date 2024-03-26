package nam.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Temp {
    @Autowired
    Temp2 temp2;
    @Test
    void proxyCheck() {
        //BasicService$$EnhancerBySpringCGLIB...
        assertThat(AopUtils.isAopProxy(temp2)).isTrue();
    }

    @TestConfiguration
    static class Config {
        @Bean
        Temp2 temp2() {
            return new Temp2();
        }
    }
    @Transactional
    static class Temp2 {

    }
}

