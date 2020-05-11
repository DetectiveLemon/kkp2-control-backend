package kkp2.controlbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("kkp2.controlbackend.Mapper")
@SpringBootApplication
public class ControlBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlBackendApplication.class, args);
    }

}
