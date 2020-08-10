package me.meloni.FileReading;

import java.io.IOException;
/**
 * Used to validate if a file indeed is a file provided in weekly backups.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.5
 */
public class Validate {
    /**
     * Validation if a file indeed is a file provided in weekly backups.
     *
     * @since 0.0.5
     */
    public static boolean validate(String path) throws IOException {
        return Reader.alllines(path).get(1).startsWith("8;4");
    }
}
