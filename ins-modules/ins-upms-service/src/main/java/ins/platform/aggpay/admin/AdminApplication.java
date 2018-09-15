package ins.platform.aggpay.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lengleng
 * @date 2017年10月27日13:59:05
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"ins.platform.aggpay.admin", "ins.platform.aggpay.common.bean"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}