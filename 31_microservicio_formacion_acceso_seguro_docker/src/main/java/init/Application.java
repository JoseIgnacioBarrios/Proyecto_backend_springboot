package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = {"controller","service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public RestClient getRestClient() {
//		return RestClient.create();
//	}
//	
	@Bean
	@LoadBalanced
	public RestClient.Builder getBuilder(){
		return RestClient.builder();
	}
	@Bean
	public RestClient getRestClient(RestClient.Builder builder) {
		return builder.build();
	}

}
