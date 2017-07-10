package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution
{
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws Exception
    {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(obj, stringWriter);
        stringWriter.close();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(stringWriter.toString())));
        document.setXmlStandalone(false);

        changeTextNodesToCdataNodes(document, document);
        NodeList list = document.getElementsByTagName(tagName);

        for (int i = 0; i < list.getLength(); i++)
            list.item(i).getParentNode().insertBefore(document.createComment(comment), list.item(i));

        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        stringWriter = new StringWriter();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(stringWriter);

        transformer.transform(source, result);
        stringWriter.close();
        return stringWriter.toString();
    }

    private static void changeTextNodesToCdataNodes(Node firstNode, Document ownerDocument)
    {

        if (firstNode.hasChildNodes())
        {
            NodeList children = firstNode.getChildNodes();

            for (int i = 0; i < children.getLength(); i++)
            {
                Node node = children.item(i);
                if (node.getNodeType() == Node.TEXT_NODE)
                {
                    if (node.getTextContent().matches(".*[<>&].*"))
                        node.getParentNode().replaceChild(ownerDocument.createCDATASection(node.getTextContent()), node);
                } else
                {
                    changeTextNodesToCdataNodes(node, ownerDocument);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><first><second>some string</second><second>some string</second><second><![CDATA[need CDATA because of < and >]]></second><second/></first>";

        String comment = "it's a comment";
        String tagName = "second";

        String res = null;
        if (s.indexOf(tagName) > -1)
            res = s.replace("<" + tagName + ">", "<!--" + comment + "-->" + "<" + tagName + ">");

        System.out.println(res);
    }
}