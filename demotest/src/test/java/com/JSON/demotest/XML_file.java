/**
 * 
 */
package com.JSON.demotest;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author venkateshwara.d
 *
 */
public class XML_file {

	/**
	 * @param args
	 */
	
	
	protected static String parseTreeFromNode1(String tagname,String rootnode,File fXmlFile) throws SAXException, IOException, ParserConfigurationException
	{
		String string2=null;
		try {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList1 = doc.getElementsByTagName(rootnode);
		for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
			Node node = nList1.item(temp1);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				 string2 =eElement.getElementsByTagName(tagname).item(0).getTextContent();
				
			}
		}
	
		
		return string2;
		}
		catch(org.xml.sax.SAXParseException e)
		{
			return"remove the invalid content from xml file" ;
		}
	}
	
	
	protected static String parseTreeFromNode(String tagname,String attribute,File fXmlFile) throws SAXException, IOException, ParserConfigurationException
	{
		try {
		Set<String> test = new LinkedHashSet<String>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList1 = doc.getElementsByTagName(tagname);
		for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
			Node node = nList1.item(temp1);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// Print each language detail
				Element eElement = (Element) node;
				test.add(eElement.getAttribute(attribute));
				
			}
		}
		String string1 = String.join(",", test);
		String string2 =(string1.replaceFirst(".$","")).trim();
		return string2;
		}
		catch(java.lang.NullPointerException e)
		{
			return "the following tag or attribute is missing";
		}
	}
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		String path = System.getProperty("user.dir");
		
		File fXmlFile = new File(path + "\\XML_file\\staff_new.xml");
		
		String currencyInJSP = parseTreeFromNode1("salary","company", fXmlFile).trim().toUpperCase();
		
		System.out.println(currencyInJSP);
		
		String lanText = parseTreeFromNode("country","orignalLang",fXmlFile);
		
		System.out.println("Language text -> " + lanText); //Hindi,Bengali,Telugu,Marathi,Tamil,Gujarati,Malayala
	}

}
