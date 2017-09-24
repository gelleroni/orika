package orikatest;

import java.util.Date;

import orikatest.beanDto.BasicPersonDto;
import orikatest.beanDto.WorkPlaceDto;
import orikatest.beans.BasicPerson;
import orikatest.beans.WorkPlace;
import orikmapping.ClassConverterService;

public class OrikaTest {

	public static void main(String[] args) {
		ClassConverterService service = null;
		BasicPerson person = new BasicPerson();
		person.setName("roni geller");
		person.setAge(43);
		person.setBirthDate(new Date());
		person.setUNSTANDARD("successs");
		WorkPlace workPlace = new WorkPlace();
		workPlace.setDepName("Develops");
		BasicPerson[] workerArr = new BasicPerson[2];
		workerArr[0] = person;
		workPlace.setWorkerArr(workerArr);
		
		
		try {
			System.out.println("Start Application");
			
			
			service = ClassConverterService.instance();
			
			WorkPlaceDto dto = service.getMapperFacade().map(workPlace, WorkPlaceDto.class);
			System.out.println(dto);
			System.out.println(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
