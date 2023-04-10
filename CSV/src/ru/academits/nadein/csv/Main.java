package ru.academits.nadein.csv;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\OopCourse\\ZadachaCSV.csv", StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter("FileInHtml.html", StandardCharsets.UTF_8)) {

            writer.println("<!DOCTYPE HTML>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Моя страница HTML из CSV</title>");
            writer.println("<meta charset=\"utf-8\">");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" width=\"10\">");

            String currentLine = bufferedReader.readLine();
            boolean isTableDetail = false;

            while (currentLine != null) {
                if (currentLine.isBlank()) {
                    currentLine = bufferedReader.readLine();

                    continue;
                }

                if (!isTableDetail) {
                    writer.println("<tr>");
                    writer.println("    <td>");
                }

                for (int i = 0; i < currentLine.length() - 1; i++) {
                    char symbol = currentLine.charAt(i);
                    char nextSymbol = currentLine.charAt(i + 1);

                    if (symbol == ',' && nextSymbol == '"' && !isTableDetail) {
                        isTableDetail = true;
                        writer.println();
                        writer.println("    </td>");
                        writer.println("    <td>");
                        i++;

                        continue;
                    }

                    if (symbol == '"' && nextSymbol == ',') {
                        isTableDetail = false;
                        writer.println();
                        writer.println("    </td>");
                        writer.println("    <td>");
                        i++;

                        continue;
                    }

                    if (i == currentLine.length() - 2 && symbol == '"' && nextSymbol == '"') {
                        writer.println();
                        writer.println("    </td>");

                        continue;
                    }

                    if (symbol == '"' && nextSymbol == '"') {
                        writer.print(symbol);
                        i++;

                        continue;
                    }

                    if (nextSymbol == ',' && i == currentLine.length() - 2) {
                        writer.println();
                        writer.println("    </td>");
                        writer.println("    <td>");
                        writer.println("    </td>");
                        writer.println("</tr>");
                    }

                    if (symbol == ',' && nextSymbol != '"') {
                        writer.println();
                        writer.println("    </td>");
                        writer.println("    <td>");

                        continue;
                    }

                    if (i == currentLine.length() - 2 && nextSymbol != ',' && isTableDetail) {
                        writer.print(symbol);
                        writer.print(nextSymbol);
                        writer.print("<br>");
                        writer.println();

                        continue;
                    }

                    writer.print(symbol);

                    if (i == currentLine.length() - 2 && nextSymbol != ',' && !isTableDetail) {
                        writer.print(nextSymbol);
                        writer.println();
                        writer.println("    </td>");
                    }
                }
                if (!isTableDetail) {
                    writer.println();
                    writer.println("</tr>");
                }

                currentLine = bufferedReader.readLine();
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Что то пошло не так, проверьте файл.");
        }
    }
}