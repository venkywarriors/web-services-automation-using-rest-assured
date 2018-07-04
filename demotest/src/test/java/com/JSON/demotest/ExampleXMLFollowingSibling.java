package com.JSON.demotest;
/*
 * @author venkateshwara.d
 *
 */
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleXMLFollowingSibling {

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;

    public static void main(String q[]) {
        ExampleXPathFollowingSibling exampleXPathFollowingSibling = new ExampleXPathFollowingSibling();
        exampleXPathFollowingSibling.execute();
    }

    public void execute() {
        try {
            builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(this.getClass().getResourceAsStream("\\XML_file\\user.xml"));
            XPath xPath =  XPathFactory.newInstance().newXPath();
            String expression = "//following-sibling::User[position()=3]";

            NodeList nl = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            System.out.println(nl.item(0).getTextContent());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
/*
generated output
72638

    Amitabh

    Bachchan


    Panama Street

    Mumbai

    India

Male
05/04/1999
amitabh.bachchan@asv.com
 */
