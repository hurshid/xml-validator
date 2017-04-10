package command;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * @author Hurshid
 */
public class ScanXmlCommand implements ICommand{
    @Override
    public void execute(String[] args) throws Exception {
        try {
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            //sample.xsd
            Schema schema = factory.newSchema(new StreamSource(args[2]));
            Validator validator = schema.newValidator();
//            "test.xml"
            validator.validate(new StreamSource(args[1]));
        } catch (Exception ex) {
            System.out.println("Unmatched");
            return;
        }
        System.out.println("Matched");
    }

    @Override
    public void printInfo() {
        System.out.println("Scan xml file");
        System.out.println("1st argument is command name('scanxml'), 2nd one is absolute path to xml, 3rd one is absolute path to xsd");
    }
}
