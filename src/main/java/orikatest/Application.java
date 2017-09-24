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

import orikatest.beanDto.BasicPersonDto;
import orikatest.beans.*;
import orikmapping.ClassConverterService;
import orikmapping.beans.*;
import orikmapping.beans.MappingConfig;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		
		
       SpringApplication.run(Application.class, args);
    }
	
}
