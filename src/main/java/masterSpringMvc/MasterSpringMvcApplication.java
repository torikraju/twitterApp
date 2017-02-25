package masterSpringMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import masterSpringMvc.config.PicturesUploadProperties;

@SpringBootApplication(exclude = {SessionAutoConfiguration.class})
@EnableConfigurationProperties({PicturesUploadProperties.class})
public class MasterSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringMvcApplication.class, args);
	}
	

	
}
