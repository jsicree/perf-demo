package demo.app.demoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

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
	
}
