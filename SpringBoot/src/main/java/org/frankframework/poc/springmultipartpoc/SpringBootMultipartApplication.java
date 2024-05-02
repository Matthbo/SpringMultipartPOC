package org.frankframework.poc.springmultipartpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {
        DispatcherServletAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
//        WebMvcAutoConfiguration.class
})
public class SpringBootMultipartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultipartApplication.class, args);
    }

}
