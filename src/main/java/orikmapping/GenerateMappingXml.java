package orikmapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.springframework.util.StringUtils;

public class GenerateMappingXml {
	private static final Integer CONFIG_ROW_INDX = 0;
	private static final Integer CLASS_A_INDX  = 1;
	private static final Integer CLASS_B_INDX  = 2;
	
	private static final Integer FIELD_A_INDX = 1;
	private static final Integer FIELD_B_INDX = 2;
	
	public static void main(String[] args) {
		String fileName= "C:\\roni\\workspaces\\springboot\\orikatest\\src\\input.csv";
        File file= new File(fileName);
        Scanner inputStream;
        List<List<String>> lines = new ArrayList<>();
        System.out.println("Start generate xml config base on " + fileName);
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                if(StringUtils.isEmpty(line)) {
                	continue;
                }
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean isFirstTime = true;
        try { 
        	Path path = Paths.get("mapping1.xml");
	        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				writer.write("<mappings>\n");
				for(List<String> classConfig : lines) {
					writeMappingCofig(writer, classConfig, isFirstTime);
					isFirstTime = false;
				}
				
				writer.write("</classMapping>\n");
				writer.write("</mappings>\n");
	        }
        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
       
        System.out.println("Complete generate xml config base on " + fileName);
        
      }

	private static void writeMappingCofig(BufferedWriter writer, List<String> classConfig, boolean isFirstTime) throws IOException {
		if(classConfig.get(CONFIG_ROW_INDX).equals("class") ) {
			writeClassConfig(writer, classConfig, isFirstTime);
		}
		
		if(classConfig.get(CONFIG_ROW_INDX).equals("field") ) {
			writeFieldConfig(writer, classConfig, isFirstTime);
		}
		
		
		
	}

	private static void writeFieldConfig(BufferedWriter writer, List<String> classConfig, boolean isFirstTime) throws IOException {
		StringBuffer buff = new StringBuffer();
		buff.append("<fieldMapping>\n");
		buff.append("\t<fieldA name=\"").append(classConfig.get(FIELD_A_INDX)).append("\"/>\n");
		buff.append("\t<fieldB name=\"").append(classConfig.get(FIELD_B_INDX)).append("\"/>\n");
		buff.append("</fieldMapping>\n");
		writer.write(buff.toString());
	}

	private static void writeClassConfig(BufferedWriter writer, List<String> classConfig, boolean isFirstTime) throws IOException {
		if(!isFirstTime) {		
			writer.write("</classMapping>\n");
		}
		StringBuffer buff = new StringBuffer();
		buff.append("<classMapping classA=\"").append(classConfig.get(CLASS_A_INDX)).append("\"  classB=\"").append(classConfig.get(CLASS_B_INDX)).append("\">\n");
		writer.write(buff.toString());
		
	}

}
