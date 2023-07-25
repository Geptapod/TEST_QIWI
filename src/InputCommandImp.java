
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputCommandImp implements InputCommand {
    @Override
    public String[] getCommandArgs() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter command: ");
        String readedCommand = reader.readLine();
        return readedCommand.split(" ");
    }
}
