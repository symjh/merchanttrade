package ins.platform.aggpay.zipkin;

import zipkin.server.EnableZipkinServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lengleng
 * @date 2018-01-24
 * zipkin mysql 存储实现
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinDbApplication.class, args);
    }
}
