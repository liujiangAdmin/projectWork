package com.ucmed.hnust.xml.dom;

import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

/**
 * Created by ZY-LJ-1446 on 2018/2/7.
 */
public class DomTest {
    public static void main (String [] args)
    {
        File file = new File("");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Document document = DomUtil.getDocument();
            Document document1 =  DomUtil.getJDDocument(document);
            DomUtil.documentToXml(document1,file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
}
}
