package Commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Data
@AllArgsConstructor
public class WriteCommand implements Command {
    private String text;
    private String directory;

    @Override
    public void execute() throws IOException {
        File file = new File(directory);
        FileOutputStream fos = new FileOutputStream(file);
        if (file.isFile() && file.canWrite()) {
            fos.write(text.getBytes(StandardCharsets.UTF_8), 0, text.getBytes(StandardCharsets.UTF_8).length);
            fos.close();
            System.out.println("Text is written");
        }
    }
}
