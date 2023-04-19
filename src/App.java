import java.util.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import UserDefinedException.*;
import AnnotatedClasses.Autosar;

public class App {
    public static void main(String[] args) {

        try{

            String file_name = args[0];
            File file = new File(file_name);
            
            // check if the file is valid or not.
            if(!file_name.endsWith(".arxml")){
                throw new NotVaildAutosarFileException();
            }
            if(file.length() == 0){
                throw new EmptyAutosarFileException();
            }

            // unmarshall xml file.
            JAXBContext jaxbContext = JAXBContext.newInstance(Autosar.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Autosar autosar = (Autosar) jaxbUnmarshaller.unmarshal(file);

            // get unmarshalled objects and sort them based on short-name field.
            ArrayList<Autosar.Container> containers = autosar.getContainers();
            Collections.sort(containers);
    
            // create a new file with modified original file name.
            int index = file_name.lastIndexOf(".");
            String new_name = file_name.substring(0, index) + "_mod" + file_name.substring(index);
            File new_file = new File(new_name);
            
            // marshall the list of object to the new file, this file should be sorted now.
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Autosar autosar2 = new Autosar(containers);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(autosar2, new_file);

        }
        catch (JAXBException jbe) {
            jbe.printStackTrace();
        }
        catch(NotVaildAutosarFileException nvafe){
            System.out.println(nvafe.getMessage());
        }
        catch(EmptyAutosarFileException eafe){
            System.out.println(eafe.getMessage());
        }
        finally{
            System.out.println("Done");
        }
    }
}
