package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {
    public static void writeToFile(String filename, String content) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            byte[] bytes = content.getBytes();
            outputStream.write(bytes);
        }
    }
}
