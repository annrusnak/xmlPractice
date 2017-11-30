package com.epam.lab.JAXPParsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bCity = false;
    boolean bAge = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            String rollNo = attributes.getValue("id");
            System.out.println("Person ID : " + rollNo);
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
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
            bCity = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge= false;
        }
    }
}
