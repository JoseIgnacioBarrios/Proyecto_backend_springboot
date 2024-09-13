package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
@EntityScan
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	//XXXXXXXXXXXXXXXXXXX necesario para el uso del servidor Eureka XXXXXXXXXXXXXXXXXXXXXXXXX
	@Bean
	@LoadBalanced
	public RestClient.Builder getBuilder(){
		return RestClient.builder();
	}
	
//	@Bean
//	public RestClient getRestClient() {
//		return RestClient.create();
//	}
	@Bean
	public RestClient getRestClient(RestClient.Builder builder) {
		return builder.build();
	}
}
