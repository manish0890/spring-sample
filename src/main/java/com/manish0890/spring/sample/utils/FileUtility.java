package com.manish0890.spring.sample.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

public class FileUtility {

    private FileUtility() {
        // for static usage
    }

    /**
     * Locates the file from resources directory and returns the content in String format
     *
     * @param path {@link String}
     * @return {@link String}
     */
    public static String getFileContentAsString(String path) {
        String content;
        try {
            content = IOUtils.toString(Objects.requireNonNull(getInputStream(path)), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content;
    }

    /**
     * Locates the file from resources directory and returns the content in InputStream
     *
     * @param path {@link String}
     * @return {@link InputStream}
     */
    public static InputStream getInputStream(String path) {
        Assert.notNull(path, "Path cannot be null");

        ClassLoader classLoader = FileUtility.class.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }

    /**
     * Locates the file from resources directory and returns the File
     *
     * @param path {@link String}
     * @return {@link File}
     */
    public static File getFile(String path) {
        Assert.notNull(path, "Path cannot be null");

        ClassLoader classLoader = FileUtility.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        Assert.notNull(resource, "CSV file cannot be null");

        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
