package command;

/**
 * @author Hurshid
 */
public interface ICommand {

    public void execute(String[] args) throws Exception;

    public void printInfo();
}
