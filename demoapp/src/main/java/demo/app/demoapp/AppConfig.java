package demo.app.demoapp;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import demo.app.demoapp.services.AccountService;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.impl.AccountServiceSimpleImpl;
import demo.app.demoapp.services.impl.CalculationServiceImpl;
import demo.app.demoapp.services.impl.MemoryServiceImpl;

@Configuration
@EnableAsync
@PropertySource({ "classpath:demoapp_config.properties" })
public class AppConfig {

	private static final String PROPERTY_NAME_COMPUTE_COMPOUND_INTEREST_DELAY_MS = "compoundInterest.delay.ms";
	private static final String PROPERTY_NAME_TASK_EXECUTOR_CORE_POOL_SIZE = "taskExecutor.core.pool.size";
	private static final String PROPERTY_NAME_TASK_EXECUTOR_MAX_POOL_SIZE = "taskExecutor.max.pool.size";
	private static final String PROPERTY_NAME_TASK_EXECUTOR_QUEUE_CAPACITY = "taskExecutor.queue.capacity";
	private static final String PROPERTY_NAME_TASK_EXECUTOR_THREAD_NAME_PREFIX = "taskExecutor.thread.name.prefix";

	@Resource
	private Environment environment;
	
	public AppConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public AccountService accountService() {
		return new AccountServiceSimpleImpl();
	}

	@Bean
	public CalculationService calculationService() {
		return new CalculationServiceImpl(Integer.parseInt(environment.getRequiredProperty(PROPERTY_NAME_COMPUTE_COMPOUND_INTEREST_DELAY_MS)));
	}

	@Bean
	public MemoryService memoryService() {
		return new MemoryServiceImpl();
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Integer.parseInt(environment.getRequiredProperty(PROPERTY_NAME_TASK_EXECUTOR_CORE_POOL_SIZE)));
		executor.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty(PROPERTY_NAME_TASK_EXECUTOR_MAX_POOL_SIZE)));
		executor.setQueueCapacity(Integer.parseInt(environment.getRequiredProperty(PROPERTY_NAME_TASK_EXECUTOR_QUEUE_CAPACITY)));
		executor.setThreadNamePrefix(environment.getRequiredProperty(PROPERTY_NAME_TASK_EXECUTOR_THREAD_NAME_PREFIX));
		executor.initialize();
		return executor;
	}	
	
}
