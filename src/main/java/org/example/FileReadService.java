package org.example;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReadService {
    public static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();

        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead));
            }
        }

        return content.toString();
    }
}
