package cn.limu.spring6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"cn.limu.spring6.dao", "cn.limu.spring6.service"})
public class Spring6Config {

}
