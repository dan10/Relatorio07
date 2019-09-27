import java.io.*;

class Interpret {

    static void readFromFile(String fileName, String port) throws IOException, InterruptedException {
        BufferedReader bufferedReader = null;
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fileName);
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found. Try again!");
        }

        if (bufferedReader != null) {
            while (true) {
                if (((char) br.read()) == '\n') {
                    if ((line = bufferedReader.readLine()) != null) {
                        sendToArduino(line, port);
                        System.out.println(line);
                    } else {
                        System.out.println("Progama Terminou");
                        break;
                    }
                }
            }
        }
    }

    private static void sendToArduino(String s, String port) throws IOException, InterruptedException {
        System.out.println(s);
        ProcessBuilder pb = new ProcessBuilder("envia.exe", port, s); // Colocar a "com" respectiva ao arduino // conectado
        Process p = pb.start();
        p.waitFor();
    }
}
