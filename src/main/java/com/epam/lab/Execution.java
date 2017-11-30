package com.epam.lab;

import com.epam.lab.JAXBParsers.ObjectToXML;
import com.epam.lab.JAXBParsers.XMLToObject;
import com.epam.lab.JAXPParsers.DOMParser;
import com.epam.lab.JAXPParsers.MySAXParser;
import com.epam.lab.JAXPParsers.MySTAXParser;

import static com.epam.lab.JAXPParsers.XMLValidation.validateXMLSchema;

public class Execution {
    public static void main(String[] args) {

        System.out.println( "practicet.xml validates against practice.xsd? " + validateXMLSchema( "practice.xsd", "practice.xml" ) );

        DOMParser domParser = new DOMParser();
        MySAXParser mySAXParser = new MySAXParser();
        MySTAXParser mySTAXParser = new MySTAXParser();
        System.out.println("-----------------------------------------------------");
        System.out.println("DOM parser");
        System.out.println("-----------------------------------------------------");
        domParser.parse();
        System.out.println("-----------------------------------------------------");
        System.out.println("SAX parser");
        System.out.println("-----------------------------------------------------");
        mySAXParser.parseSAX();
        System.out.println("-----------------------------------------------------");
        System.out.println("STAX parser");
        System.out.println("-----------------------------------------------------");
        mySTAXParser.parseSTAX();


        System.out.println("-----------------------------------------------------");
        System.out.println("JAXB parser: from Object to XML");
        System.out.println("-----------------------------------------------------");
        ObjectToXML objectToXML=new ObjectToXML();
        objectToXML.parseToXML();

        System.out.println("-----------------------------------------------------");
        System.out.println("JAXB parser: from XML to Object");
        System.out.println("-----------------------------------------------------");
        XMLToObject xmlToObject=new XMLToObject();
        xmlToObject.parseToObject();
    }
}
