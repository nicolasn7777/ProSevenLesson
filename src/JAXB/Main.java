package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.add(new Human("Kyiv", "Korolova", "1"));
        catalog.add(new Human("Dnipro", "Levka", "99"));

        try {
            File file = new File("D:\\programs\\IDE\\projects IDE\\JAXBCity\\src\\JAXB\\output.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(catalog, file);
            marshaller.marshal(catalog, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(file);
            System.out.println(catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}