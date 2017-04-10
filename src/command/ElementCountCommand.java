package command;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Hurshid
 */
public class ElementCountCommand implements ICommand {

    @Override
    public void execute(String[] args) throws Exception {
        try {
            SAXParserFactory parserFact = SAXParserFactory.newInstance();
            SAXParser parser = parserFact.newSAXParser();
            SAXElementCount handler = new SAXElementCount(args[2]);
            parser.parse(args[1], handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void printInfo() {
        System.out.println("Counts the number of tags in the xml file");
        System.out.println("1st argument is command name('elementCount'), 2nd one is absolute path to xml, 3rd one is tag name");
    }
}
