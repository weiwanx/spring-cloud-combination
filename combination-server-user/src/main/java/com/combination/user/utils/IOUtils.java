package com.combination.user.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author weiwanxi
 */
public class IOUtils {

    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
