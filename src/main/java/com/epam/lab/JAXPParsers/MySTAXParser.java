package com.epam.lab.JAXPParsers;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class MySTAXParser {
    public void parseSTAX(){
        boolean bFirstName = false;
        boolean bLastName = false;
        boolean bCity = false;
        boolean bAge = false;

        try {
            long startTime = System.currentTimeMillis();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader("practice.xml"));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("person")) {
                            System.out.println("Start Element : person");
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String persId = attributes.next().getValue();
                            System.out.println("Person ID : " + persId);
                        } else if (qName.equalsIgnoreCase("firstname")) {
                            bFirstName = true;
                        } else if (qName.equalsIgnoreCase("lastname")) {
                            bLastName = true;
                        } else if (qName.equalsIgnoreCase("city")) {
                            bCity = true;
                        }
                        else if (qName.equalsIgnoreCase("age")) {
                            bAge = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bFirstName) {
                            System.out.println("First Name: " + characters.getData());
                            bFirstName = false;
                        }
                        if(bLastName) {
                            System.out.println("Last Name: " + characters.getData());
                            bLastName = false;
                        }
                        if(bCity) {
                            System.out.println("City: " + characters.getData());
                            bCity = false;
                        }
                        if(bAge) {
                            System.out.println("Marks: " + characters.getData());
                            bAge = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("person")) {
                            System.out.println("End Element : person");
                            System.out.println();
                        }
                        break;
                }
            }
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println( "STAX time: " + totalTime );
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
    }

