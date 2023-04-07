package ru.academits.nadein.csv;

import java.io.*;
import java.util.ArrayList;

public class MainVersion2 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("CSV/src/ZadachaCSV2.csv"));
             PrintWriter writer = new PrintWriter("FileInHtml.html")) {

            writer.println("<!DOCTYPE HTML>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Моя страница HTML из CSV</title>");
            writer.println("<meta charset=\"utf-8\">");
            writer.println("</head>");
            writer.println("<table border=\"1\" width=\"10\" height=\"10\">");

            String currentLine = bufferedReader.readLine();
            String subString;

            while (currentLine != null) {
                currentLine = bufferedReader.readLine();
                writer.println("<tr>");

                while (currentLine.length() > 0) {
                    while (currentLine.indexOf(',') > 0) {
                        if (!currentLine.startsWith("\"")) {
                            subString = currentLine.substring(0, currentLine.indexOf(',') - 1);
                            subString = subString.replaceAll("&", "&amp");
                            subString = subString.replaceAll("<", "&lt");
                            subString = subString.replaceAll(">", "&gt");

                            writer.println("<td>");
                            writer.println(subString);
                            writer.println("</td>");

                            currentLine = currentLine.substring(currentLine.indexOf(',') + 1);
                        }

                        if (currentLine.startsWith("\"")) {
                            subString = currentLine.substring(currentLine.indexOf('"') + 1);

                            if (currentLine.contains(",\",")) {
                                subString = currentLine.substring(currentLine.indexOf('"') + 1, currentLine.indexOf(",\","));
                                subString = subString.concat(",");

                                subString = subString.replaceAll("&", "&amp");
                                subString = subString.replaceAll("<", "&lt");
                                subString = subString.replaceAll(">", "&gt");
                                subString = subString.replaceAll("\"\"", "\"");

                                writer.println("<td>");
                                writer.println(subString);
                                writer.println("</td>");

                                currentLine = currentLine.substring(currentLine.indexOf(",\",") + 1);
                            }

                            if (currentLine.contains("\",") && !currentLine.contains(",\",")) {
                                subString = currentLine.substring(currentLine.indexOf('"') + 1, currentLine.indexOf("\","));

                                subString = subString.replaceAll("&", "&amp");
                                subString = subString.replaceAll("<", "&lt");
                                subString = subString.replaceAll(">", "&gt");
                                subString = subString.replaceAll("\"\"", "\"");

                                writer.println("<td>");
                                writer.println(subString);
                                writer.println("</td>");

                                currentLine = currentLine.substring(currentLine.indexOf("\",") + 1);
                            }
                        }
                    }

                    if (currentLine.startsWith("\"")) {
                        subString = currentLine.substring(currentLine.indexOf('"') + 1);

                        subString = currentLine.replaceAll("&", "&amp");
                        subString = currentLine.replaceAll("<", "&lt");
                        subString = currentLine.replaceAll(">", "&gt");
                        subString = subString.replaceAll("\"\"", "\"");

                        subString = subString.concat("<br>");
                        writer.println("<td>");
                        writer.println(subString);
                        writer.println("</td>");
                    }


                }

                writer.println("<td>");
                writer.println("");
                writer.println("</td>");
                writer.println("</tr>");



            }
        }
    }


} catch(FileNotFoundException e){
        System.out.println("Файл не найден");
        }catch(IOException e){
        System.out.println("Что то пошло не так, проверьте файл.");
        }
        }
        }