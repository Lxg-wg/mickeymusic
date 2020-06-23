package indi.wwq.mickey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
*33233443
 * @author wg
 */

@SpringBootApplication
@MapperScan(basePackages = "indi.wwq.mickey.mapper")
@ServletComponentScan(basePackages ="indi.wwq.mickey.filters" )
public class MickeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MickeyApplication.class, args);
    }

}
