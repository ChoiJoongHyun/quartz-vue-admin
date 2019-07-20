/**
 * Created by joonghyun on 2019-07-19
 */
package com.quartz.admin.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Slf4j
public final class BlobConverter {

    private BlobConverter() {
        throw new AssertionError();
    }

    public static String toString(Blob blob) {
        try {
            return IOUtils.toString(blob.getBinaryStream(), "UTF-8");
        } catch (IOException | SQLException e) {
            log.error("Blob to String convert error", e);
            throw new BlobConverterException("Blob to String convert error");
        }
    }

    public static class BlobConverterException extends RuntimeException {

        public BlobConverterException(String message) {
            super(message);
        }
    }
}
