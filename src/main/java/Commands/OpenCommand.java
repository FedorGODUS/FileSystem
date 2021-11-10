package Commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@AllArgsConstructor
@Data
public class OpenCommand implements Command {
    private String directory;

    @Override
    public void execute() throws IOException {
        File file = new File(directory);
        if (file.isFile() && file.canRead()) {
            FileInputStream fileOutputStream = new FileInputStream(file);
            int i = -1;
            while ((i = fileOutputStream.read()) != -1) {
                System.out.print((char) i);
                System.out.println();
            }
            fileOutputStream.close();
        }
    }
}
