package com.epam.lab.JAXPParsers;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MySAXParser {
    public void parseSAX(){

        try {
            long startTime = System.currentTimeMillis();
            File inputFile = new File("practice.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(inputFile, handler);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println( "SAX time: " + totalTime );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

