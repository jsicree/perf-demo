package demo.app.demoapp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import demo.app.demoapp.services.AccountService;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.impl.AccountServiceSimpleImpl;
import demo.app.demoapp.services.impl.CalculationServiceImpl;

@Configuration
@EnableAsync
public class AppConfig {

	public AppConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public AccountService accountService() {
		return new AccountServiceSimpleImpl();
	}

	@Bean
	public CalculationService calculationService() {
		return new CalculationServiceImpl();
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(25);
		executor.setThreadNamePrefix("PerfDemoThread-");
		executor.initialize();
		return executor;
	}	
	
}
