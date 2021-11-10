package Commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
public class CreateDirectoryCommand implements Command {
    private String directory;
    @Override
    public void execute() throws IOException {
        File file = new File(directory);
        if (file.mkdir()){
            System.out.println("Directory is created");
        }else System.out.println("Directory is not created");
    }
}
