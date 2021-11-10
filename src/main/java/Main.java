import Commands.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder directory = new StringBuilder(System.getProperty("user.dir"));
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                Command command;
                String[] line = scanner.nextLine().split(" ");
                switch (line[0]) {
                    case "open":
                        command = new OpenCommand(directory + "/" + line[1]);
                        command.execute();
                        break;
                    case "create":
                        command = new CreateFileCommand(line[1]);
                        command.execute();
                        break;
                    case "createDirectory":
                        command = new CreateDirectoryCommand(directory + "/" + line[1]);
                        command.execute();
                        break;
                    case "write":
                        command = new WriteCommand(line[2], directory + "/" + line[1]);
                        command.execute();
                        break;
                    case "goBack":
                        File file = new File(directory.toString());
                        directory = new StringBuilder(file.getParentFile().getAbsolutePath());
                        System.out.println(directory);
                        break;
                    case "goForward":
                        if (new File(directory + "/" + line[1]).isDirectory()) {
                            directory.append("/").append(line[1]);
                            System.out.println(directory);
                        }else System.out.println("Not directory");
                        break;
                    case "stop":
                        System.exit(0);
                    default:
                        System.out.println("No such command");
                }
            } catch (IOException e) {
                System.out.println("exception");
            }
        }

    }
}
