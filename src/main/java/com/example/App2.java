package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * CommandLineRunnerはコマンドラインで値を取得する場合に使う。
 * 
 * @author nagase
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App  extends SpringBootServletInitializer  {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<App> applicationClass = App.class;
}
