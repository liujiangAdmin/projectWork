package com.ucmed.hnust.xml.dom;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
/**
 * Created by ZY-LJ-1446 on 2018/2/6.
 */
public class DomUtil {

    /**
     * 使用dom方式生成xml文档
     * 1.创建DOM树
     * 1.1创建DocumentBuilderFactory对象
     * 1.2通过DocumentBuilderFactory对象获得DocumentBuilder对象
     * 1.3通过DocumentBuilder对象的newDocument()创建Document对象，该对象代表一个xml文档
     * 1.4通过Document的createElement()创建根节点
     * 1.5通过Document的createElement()方法创建多个子节点，并将这些节点添加的父节点上
     * 1.6将根节点添加到Document上
     * 2.将DOM树转换成xml文件
     * 2.1创建TransformerFactory类的对象
     * 2.2通过TransformerFactory创建Transformer对象
     * 2.3通过Transformer对象的Transform()将Dom树转换为xml文档（该方法有两个参数，第一个参数为数据源，
     * 需要创建DOMSource对象并将Document加载其中，第二个参数为xml文档要输出的文件，需要创建StreamResult对象并指定目的文件）
     * */

    /**
     * 获取Document对象
     * */
    public static Document getDocument() throws ParserConfigurationException {
        // 创建DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // 创建DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //创建Document
        Document document = builder.newDocument();

        // 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
        // document.setXmlStandalone(true);
        return document;
    }
    /**
     * 将节点加到Document上
     * */
    public static Document getJDDocument(Document document)
    {
        // 创建根节点
        Element bookstore = document.createElement("employees");
        // 创建子节点，并设置属性
        Element book = document.createElement("employee");
        book.setAttribute("id", "1");
        // 为book添加子节点
        Element name = document.createElement("name");
        name.setTextContent("安徒生qqqqqxxxxqq童话");
        book.appendChild(name);
        Element author = document.createElement("author");
        author.setTextContent("安徒生");
        book.appendChild(author);
        Element price = document.createElement("price");
        price.setTextContent("49");
        book.appendChild(price);
        // 为根节点添加子节点
        bookstore.appendChild(book);

        // 将根节点添加到Document下
        document.appendChild(bookstore);
        return document;
    }
    /**
     * 将Document转为xml文件
     * */
    public static void documentToXml(Document document,File file) throws TransformerException {
        // 创建TransformerFactory对象
        TransformerFactory tff = TransformerFactory.newInstance();
        // 创建Transformer对象
        Transformer tf = tff.newTransformer();

        // 设置输出数据时换行
        tf.setOutputProperty(OutputKeys.INDENT, "yes");

        // 使用Transformer的transform()方法将DOM树转换成XML
        tf.transform(new DOMSource(document), new StreamResult(file));
    }

}
