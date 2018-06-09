package com.lobster93.spring_boot_demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({"com.lobster93.spring_boot_demo.service", "com.lobster93.spring_boot_demo.controller"})
@EnableMongoRepositories("com.lobster93.spring_boot_demo.dao")
@SpringBootApplication
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoApplication.class);
    }

//    @Autowired
//    private CustomerService customerService;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootDemoApplication.class, args);
//	}
//
//    @Override
//    public void run(String... args) throws Exception {
//        customerService.save(new Customer());
//    }
}
