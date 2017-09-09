package orikatest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import orikatest.beans.*;
import orikmapping.ClassConverterService;
import orikmapping.beans.*;
import orikmapping.beans.MappingConfig;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		
		ClassConverterService service = null;
		BasicPerson person = new BasicPerson();
		person.setName("roni geller");
		person.setAge(43);
		person.setBirthDate(new Date());
		person.setUNSTANDARD("successs");
		try {
			System.out.println("Start Application");
			
			
			service = ClassConverterService.instance();
			
			BasicPersonDto dto = service.getMapperFacade().map(person, BasicPersonDto.class);
			System.out.println(dto);
			System.out.println(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // SpringApplication.run(Application.class, args);
    }
	
}
