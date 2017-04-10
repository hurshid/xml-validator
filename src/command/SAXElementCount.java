package command;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Hurshid
 */
public class SAXElementCount extends DefaultHandler {
    int tagCount = 0;
    private String elem;

    public SAXElementCount(String element) {
        this.elem = element;
    }

    public void startElement(String uri, String name, String element,
                             Attributes atri) throws SAXException {
        if (element.equals(elem)) {
            tagCount++;
        }
    }

    public void endDocument() {
        if (tagCount < 1)
            System.out.format("There isn't %s element in xml file\n", elem);
        System.out.format("Total elements: %s\n", tagCount);
    }

}