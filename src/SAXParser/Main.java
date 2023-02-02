package SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String args[]) throws XMLStreamException, FileNotFoundException {
        // Name of file
        final String fileName = "D:\\programs\\IDE\\projects IDE\\ProSevenLesson\\src\\SAXParser\\city.xml";

        // Creating file be using StAX
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter (new FileOutputStream(String.valueOf(fileName)));

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("city");
        writer.writeAttribute("size", "big");
        writer.writeCharacters("Kyiv");
        writer.writeStartElement("street");
        writer.writeCharacters("Korolova");
        writer.writeStartElement("house");
        writer.writeCharacters("1");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();

        //SAX parsing
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean city = false;
                boolean street = false;
                boolean house = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("city")) {
                        city = true;
                    }
                    if (qName.equalsIgnoreCase("street")) {
                        street = true;
                    }
                    if (qName.equalsIgnoreCase("house")) {
                        house = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (city) {
                        System.out.println("City: " + new String(ch, start, length));
                        city = false;
                    }
                    if (street) {
                        System.out.println("Street: " + new String(ch, start, length));
                        street = false;
                    }
                    if (house) {
                        System.out.println("House: " + new String(ch, start, length));
                        house = false;
                    }
                }
            };
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
