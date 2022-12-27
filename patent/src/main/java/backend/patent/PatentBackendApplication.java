package backend.patent;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.jaxb.CreateTestData;
import backend.patent.repository.ZahtevZaPriznanjePatentaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.Arrays;

@SpringBootApplication
public class PatentBackendApplication {

	public static void main(String[] args) {
		//System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
		SpringApplication.run(PatentBackendApplication.class, args);
		/**
		CreateTestData testData = new CreateTestData();
		ZahtevZaPriznanjePatentaRepository repository = new ZahtevZaPriznanjePatentaRepository();

		try {
			testData.writeToFile();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		*/

	}

}
