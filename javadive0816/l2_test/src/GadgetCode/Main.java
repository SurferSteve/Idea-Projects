package GadgetCode;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.lang.model.element.Element;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

/**
 * Created by Steve on 27.02.2016.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        WeatherSite msn = new WeatherSite();
        msn.name = "http://weather.service.msn.com/find.aspx?outputview=search&src=vista&weasearchstr=";

        City city = new City();

        System.out.println("Введите название Вашего города на русском:");
        Scanner scanner = new Scanner(System.in);
        city.ruName = scanner.next();
        city.enName = city.setEnName(city.ruName);

        msn.name = msn.name + city.enName;

        System.out.println(city.enName);
        System.out.println(msn.name);

//        xmlDoc
//        Element element = new Element();
//        Element element = ...; // каким-то образом получили element
//        NodeList nodeList = Element.getElementsByTagName("weather");
//        int length = nodeList.getLength();
//        for (int i=0;i<length;++i) {
//            Element el = (Element) nodeList.item(i);
//            System.out.println(el.getTagName() +":" + el.getTextContent());
//        }
        // упрощенный пример
        File f = new File(msn.name);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(f);
        org.w3c.dom.Element root = document.getDocumentElement();
        // для простоты сразу берем weather
        Element weather = (Element) root.getElementsByTagName("weather").item(0);
//        String textContent = weather.getTextContent(); // тоже для упрощения
        String textContent = weather.toString(); // тоже для упрощения
        System.out.println(textContent);
    }
}
