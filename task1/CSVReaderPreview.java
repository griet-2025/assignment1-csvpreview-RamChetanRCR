package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line;
        String sep = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("The file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            String[] columns = header.split(sep);
            System.out.println("Columns:");
            for (String col : columns) {
                System.out.print(col + " ");
            }
            System.out.println("\nTotal columns: " + columns.length);
            System.out.println("\nFirst 5 Records:\n");

            int count = 0;
            while ((line = br.readLine()) != null && count < 5) {
                String[] fields = line.split(sep);
                System.out.println(String.join(" ", fields));
                count++;
            }

            while (br.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            System.err.println("File read error:");
            e.printStackTrace();
        }
    }
}
