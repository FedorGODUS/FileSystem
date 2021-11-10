package Commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
public class CreateFileCommand implements Command {
    private String name;
    @Override
    public void execute() throws IOException {
        File absFile = new File(name);
        if (absFile.createNewFile()){
            System.out.println("File is created");
        }else System.out.println("There is a file already");
    }
}
