import command.ICommand;
import command.jaxb.CommandType;
import command.jaxb.CommandsType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Hurshid
 */
public class App {

    public static void main(String[] args) {
        if (args.length > 0) {
            String shortcut = args[0];
            try {
                File file = new File(App.class.getClassLoader().getResource("commandConfig.xml").getPath());
                JAXBContext jaxbContext = JAXBContext.newInstance(CommandsType.class, CommandType.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                CommandsType commands = (CommandsType) jaxbUnmarshaller.unmarshal(file);
                for (CommandType command : commands.getCommand()) {
                    if (command.getShortcut().equals(shortcut)) {
                        String className = command.getClassName();
                        ICommand iCommand = (ICommand) Class.forName(className).newInstance();
                        iCommand.printInfo();
                        iCommand.execute(args);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Oops!");
            System.out.println("Try this: 1st argument is command name('elementCount'), 2nd one is absolute path to xml, 3rd one is tag name");
        }
    }
}
