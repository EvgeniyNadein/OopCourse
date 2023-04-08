package ru.academits.nadein.csv;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("CSV/src/zadachaCSV2.csv"));
             PrintWriter writer = new PrintWriter("FileInHtml.html")) {

            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                currentLine = bufferedReader.readLine();

            }

            writer.println("<!DOCTYPE HTML>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>��� �������� HTML �� CSV</title>");
            writer.println("<meta charset=\"utf-8\">");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" width=\"10\" height=\"10\">");

            boolean isLineBreak = false;

            for (int j = 0; j < linesFromFile.length; j++) {
                if (j == 0) {
                    writer.println("<tr>");
                    writer.println("<td>");
                }

                if (j > 0 && !isLineBreak) {
                    writer.println("<tr>");
                    writer.println("<td>");
                }

                for (int k = 0; k < linesFromFile[j].length() - 2; k++) {
                    char symbol = linesFromFile[j].charAt(k);
                    char nextSymbol = linesFromFile[j].charAt(k + 1);
                    char thirdSymbol = linesFromFile[j].charAt(k + 2);

                    if (symbol == ',' && nextSymbol != '"' && thirdSymbol != ',') {
                        writer.println("</td>");
                        writer.println("<td>");
                    }

                    if (symbol == ',' && nextSymbol == '"' && thirdSymbol == ',') {
                        writer.println(symbol);
                        isLineBreak = false;
                        writer.println("</td>");
                        writer.println("<td>");
                        continue;
                    }

                    if (symbol == ',' && nextSymbol == '"') {
                        isLineBreak = true;
                        writer.println("</td>");
                        writer.println("<td>");
                        k++;
                        continue;
                    }

                    if (symbol == '"' && nextSymbol == '"') {
                        writer.print('"');
                        k++;
                        continue;
                    }

                    if (symbol == '"' && nextSymbol == ',') {
                        writer.println("</td>");
                        writer.println("<td>");
                        isLineBreak = false;
                        k++;
                        continue;
                    }

                    if (symbol == ',' && isLineBreak) {
                        writer.print(symbol);
                        k++;
                    }

                    if (k == linesFromFile[j].length() - 3 && thirdSymbol != ',' && !isLineBreak) {
                        writer.print(symbol);
                        writer.print(nextSymbol);
                        writer.println(thirdSymbol);
                        writer.println("</td>");
                        continue;
                    }

                    writer.print(symbol);
                }

                if (isLineBreak) {
                    writer.print("<br>");
                } else {
                    writer.println("</tr>");
                }
            }

            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
        } catch (IOException e) {
            System.out.println("��� �� ����� �� ���, ��������� ����.");
        }
    } // �.� ��������� �������� (��� ����)), ���� �������� ���� ����, ���� ������� ���������� � ArrayList �����
//  � ������������ ��������� ������� �������� replace() (����� ����������).
}