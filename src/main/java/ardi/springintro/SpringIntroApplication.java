package ardi.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ConfigurationPropertiesScan("ardi.springintro.model")
public class SpringIntroApplication {

	public static void main(String[] args) {

		// Class spring yang bertugas sebagai container yang me-managed semua bean yang ada
		ApplicationContext context = SpringApplication.run(SpringIntroApplication.class, args);

//		TheaterApp theaterApp = context.getBean(TheaterApp.class);
//		theaterApp.playTheater();

	}

}
