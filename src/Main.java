import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o nome do arquivo: ");
        String fileName = reader.readLine();
        Compiler.readfromFile(fileName);
        Interpret.readFromFile(fileName.substring(0, fileName.indexOf(".")) + ".hex", "com6");
    }
}
