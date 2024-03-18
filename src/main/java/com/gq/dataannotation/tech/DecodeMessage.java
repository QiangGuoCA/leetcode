package com.gq.dataannotation.tech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodeMessage {

    public static String decode(String filePath) {
        Map<Integer, String> messageMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (scanner.hasNext()) {
                        String word = scanner.next();
                        messageMap.put(num, word);
                    }
                } else {
                    scanner.next();
                }
            }
            scanner.close();

            int height = 0;

            StringBuilder decodedMessage = new StringBuilder();
            for (int i = 1; i <= messageMap.size(); i = i + height + 1) {
                    if (messageMap.containsKey(i)) {
                        decodedMessage.append(messageMap.get(i)).append(" ");
                    }
                height ++;

            }
            return decodedMessage.toString().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found.";
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/gq/dataannotation/tech/input/coding_qual_input.txt";
        String message = decode(filePath);
        if(message != null) {
            System.out.println(message);
        } else {
            System.out.println("Error decoding the message.");
        }
    }
}
