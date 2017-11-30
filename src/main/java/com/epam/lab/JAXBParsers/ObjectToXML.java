package com.epam.lab.JAXBParsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ObjectToXML {
    public void parseToXML() {

        Person person=new Person();
        person.setId( 5 );
        person.setFirstName( "Anna" );
        person.setLastName( "Rusnak" );
        person.setCity( "lviv" );
        person.setAge( 33 );

        try {

            File file = new File("newFile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
