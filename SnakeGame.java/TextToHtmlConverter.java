import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextToHtmlConverter {

    public static void main(String[] args) {
        String inputFilePath = "SnakeGame.java";
        String outputFilePath = "index.html";

        try {
            // Read the text file
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
            reader.close();

            // Create the HTML file
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Text to HTML Conversion</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<pre>" + content + "</pre>");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();

            System.out.println("HTML file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
