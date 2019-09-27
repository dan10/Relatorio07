import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


class Compiler {

    private static char a = 0;
    private static char b = 0;

    static void readfromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        // ArrayList to store the commands of the file
        ArrayList<String> commands = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(new File(fileName.substring(0, fileName.indexOf(".")) + ".hex"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found. Try again!");
        }

        if (bufferedReader != null)
            commands = separateCommands(bufferedReader);

        for (String i : commands) {
            convertOperation(i, bufferedWriter);
        }

        if (bufferedReader != null) {
            bufferedReader.close();
        }

        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    private static void convertOperation(String line, BufferedWriter writer) throws IOException {
        if (line.contains("=")) {
            if (line.charAt(0) == 'A') {
                a = line.charAt(2);
            } else {
                b = line.charAt(2);
            }
        } else if (line.contains("An")) {
            writer.write(a + "" + b + Constants.An + "\n");
        } else if (line.contains("nAoB")) {
            writer.write(a + "" + b + Constants.nAoB + "\n");
        } else if (line.contains("AnB")) {
            writer.write(a + "" + b + "" + Constants.AnB + "\n");
        } else if (line.contains("zeroL")) {
            writer.write(a + "" + b + "" + Constants.zeroL + "\n");
        } else if (line.contains("nAeB")) {
            writer.write(a + "" + b + "" + Constants.nAeB + "\n");
        } else if (line.contains("Bn")) {
            writer.write(a + "" + b + "" + Constants.Bn + "\n");
        } else if (line.contains("AxB")) {
            writer.write(a + "" + b + "" + Constants.AxB + "\n");
        } else if (line.contains("ABn")) {
            writer.write(a + "" + b + "" + Constants.ABn + "\n");
        } else if (line.contains("AnoB")) {
            writer.write(a + "" + b + "" + Constants.AnoB + "\n");
        } else if (line.contains("nAxB")) {
            writer.write(a + "" + b + "" + Constants.nAxB + "\n");
        } else if (line.contains("B") && !line.contains("A")) {
            writer.write(a + "" + b + "" + Constants.B + "\n");
        } else if (line.contains("AB")) {
            writer.write(a + "" + b + "" + Constants.AB + "\n");
        } else if (line.contains("umL")) {
            writer.write(a + "" + b + "" + Constants.umL + "\n");
        } else if (line.contains("AoBn")) {
            writer.write(a + "" + b + "" + Constants.AoBn + "\n");
        } else if (line.contains("AoB")) {
            writer.write(a + "" + b + "" + Constants.AoB + "\n");
        } else if (line.contains("A")) {
            writer.write(a + "" + b + "" + Constants.A + "\n");
        }
    }

    private static ArrayList<String> separateCommands(BufferedReader bufferedReader) throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null && line.contains("inicio"))

            while ((line = bufferedReader.readLine()) != null && !line.contains("fim")) {
                line = line.trim();
                String[] com = line.split(";");
                commands.addAll(Arrays.asList(com));
            }

        System.out.println(commands.toString() + commands.size() + " Test:" + Constants.An);
        return commands;
    }

}
