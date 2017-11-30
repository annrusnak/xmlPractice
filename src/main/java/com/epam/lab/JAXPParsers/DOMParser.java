package com.epam.lab.JAXPParsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    public void parse() {

        try {
            long startTime = System.currentTimeMillis();
            File inputFile = new File("practice.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("person");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Person ID: "
                            + eElement.getAttribute("id"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("City : "
                            + eElement
                            .getElementsByTagName("city")
                            .item(0)
                            .getTextContent());
                    System.out.println("Age : "
                            + eElement
                            .getElementsByTagName("age")
                            .item(0)
                            .getTextContent());
                }
                long totalTime = System.currentTimeMillis() - startTime;
                System.out.println( "DOM time: " + totalTime );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

