package org.ivanov.enversrnd.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class SqlFileReader {
    private static final String SCRIPTS_DIR = "db/scripts/";

    @SneakyThrows
    public String readQuery(String fileName) {
        return String.join("\n", Files.readAllLines(resourcePath(fileName), StandardCharsets.UTF_8));
    }

    @SneakyThrows
    private Path resourcePath(String fileName) {
        ClassLoader classLoader = SqlFileReader.class.getClassLoader();
        String resourceRelativePath = SCRIPTS_DIR + fileName;
        URL resourceUrl = classLoader.getResource(resourceRelativePath);
        Assert.notNull(resourceUrl, "Resource not found: '" + resourceRelativePath + "'");
        URI uri = resourceUrl.toURI();
        return Path.of(uri);
    }
}
