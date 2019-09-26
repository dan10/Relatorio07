import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Compiler {

    public static void readfromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        // ArrayList to store the commands of the file
        ArrayList<String> commands = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found. Try again!");
        }

        if (bufferedReader != null)
            commands = separateCommands(bufferedReader);
    }

    private void toHexFile(){

    }

    private static ArrayList<String> separateCommands(BufferedReader bufferedReader) throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null && !line.contains("fim")) {
            line = line.trim();
            String[] com = line.split(";");
            commands.addAll(Arrays.asList(com));
        }

        System.out.println(commands.toString());
        return commands;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o nome do arquivo: ");
        String fileName = reader.readLine();
        readfromFile(fileName);
    }
}
