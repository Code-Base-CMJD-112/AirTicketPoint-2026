package lk.ijse.cmjd112.AirTicketPoint;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AirTicketPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirTicketPointApplication.class, args);
	}
	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}

}
