package ge.tbc.testautomation.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlUtils {
    public static final String path = "src/main/resources/request.xml";

    public static void setValue(Object ...params) {
        for (int i = 0; i < params.length - 1; i += 2) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(path);
                Node node = doc.getElementsByTagName(String.valueOf(params[i])).item(0);
                node.setTextContent(String.valueOf(params[i+1]));
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                DOMSource src = new DOMSource(doc);
                StreamResult res = new StreamResult(new File(path));
                transformer.transform(src, res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
