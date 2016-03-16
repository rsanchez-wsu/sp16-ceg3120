/*
 * Copyright (C) 2016
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

//This code was sourced from the following website http://www.petefreitag.com/item/445.cfm 

package edu.wright.cs.sp16.ceg3120;

//import org.w3c.dom.Document;
import org.xml.sax.SAXException;
//

import java.io.IOException;
//import java.io.StringWriter;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;


/**
 * Class that parses xml and should store it in a document.
 *
 *
 */
public class XmlWrite {
	/**
	 * Unfinished method that will parse xml and save user preferences into Profile.xml
	 * @throws TransformerException exception handling for creating Transformer
	 * @throws ParserConfigurationException exception handling for creating newDocumentBuilder
	 * @throws SAXException exception handling for using docBuilder.parse
	 * @throws IOException exception handling for using docBuilder.parse
	 */
	public static void writeXml(UserSettings settings) throws TransformerException, 
	ParserConfigurationException, SAXException, IOException {		
		//DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		//I added a string passed to this method as the file
		//Document doc = docBuilder.parse(settings);
		//enter input source inside the brackets
		//this is where we can add attributes and tags
		//write xml document to a string
		//Transformer transformer = TransformerFactory.newInstance().newTransformer();
		//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		//StreamResult result = new StreamResult(new StringWriter());
		//DOMSource source = new DOMSource(doc);
		//transformer.transform(source,result);
				
		//String xmlString = result.getWriter().toString();
		//System.out.println(xmlString);
	}
}
