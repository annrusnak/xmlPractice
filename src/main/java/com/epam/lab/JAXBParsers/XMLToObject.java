package com.epam.lab.JAXBParsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public void parseToObject(){
        try {

            File file = new File("newFile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) jaxbUnmarshaller.unmarshal(file);
            System.out.println(person.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    }

