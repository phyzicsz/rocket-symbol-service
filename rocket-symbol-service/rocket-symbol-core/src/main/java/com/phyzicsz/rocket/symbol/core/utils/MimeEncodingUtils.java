/*
 * Copyright 2020 phyzicsz <phyzics.z@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phyzicsz.rocket.symbol.core.utils;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class MimeEncodingUtils {

    private static final Logger logger = LoggerFactory.getLogger(MimeEncodingUtils.class);

    private static final Map<String, String> mimeTypeToSuffixMap = new HashMap<String, String>();

    static {
        mimeTypeToSuffixMap.put("application/acad", "dwg");
        mimeTypeToSuffixMap.put("application/bil", "bil");
        mimeTypeToSuffixMap.put("application/bil16", "bil");
        mimeTypeToSuffixMap.put("application/bil32", "bil");
        mimeTypeToSuffixMap.put("application/dxf", "dxf");
        mimeTypeToSuffixMap.put("application/octet-stream", "bin");
        mimeTypeToSuffixMap.put("application/pdf", "pdf");
        mimeTypeToSuffixMap.put("application/rss+xml", "xml");
        mimeTypeToSuffixMap.put("application/rtf", "rtf");
        mimeTypeToSuffixMap.put("application/sla", "slt");
        mimeTypeToSuffixMap.put("application/vnd.google-earth.kml+xml", "kml");
        mimeTypeToSuffixMap.put("application/vnd.google-earth.kmz", "kmz");
        mimeTypeToSuffixMap.put("application/vnd.ogc.gml+xml", "gml");
        mimeTypeToSuffixMap.put("application/x-gzip", "gz");
        mimeTypeToSuffixMap.put("application/xml", "xml");
        mimeTypeToSuffixMap.put("application/zip", "zip");
        mimeTypeToSuffixMap.put("multipart/zip", "zip");
        mimeTypeToSuffixMap.put("multipart/x-gzip", "gzip");
    }

    /**
     * Returns the file suffix string corresponding to the specified mime type
     * string. The returned suffix starts with the period character '.' followed
     * by the mime type's subtype, as in: ".[subtype]".
     *
     * @param mimeType the mime type who's suffix is returned.
     *
     * @return the file suffix for the specified mime type, with a leading ".".
     *
     * @throws IllegalArgumentException if the mime type is null or malformed.
     */
    public static String makeSuffixForMimeType(String mimeType) {
        if (mimeType == null) {
            logger.error("mime type is null");
            throw new IllegalStateException("mime type is null");
        }

        if (!mimeType.contains("/") || mimeType.endsWith("/")) {
            logger.error("invalid image format");
            throw new IllegalStateException("invalid image format");
        }

        // Remove any parameters appended to this mime type before using it as a key in the mimeTypeToSuffixMap. Mime
        // parameters do not change the mapping from mime type to suffix.
        int paramIndex = mimeType.indexOf(";");
        if (paramIndex != -1) {
            mimeType = mimeType.substring(0, paramIndex);
        }

        String suffix = mimeTypeToSuffixMap.get(mimeType);

        if (suffix == null) {
            suffix = mimeType.substring(mimeType.lastIndexOf("/") + 1);
        }

        suffix = suffix.replaceFirst("bil32", "bil"); // if bil32, replace with "bil" suffix.
        suffix = suffix.replaceFirst("bil16", "bil"); // if bil16, replace with "bil" suffix.

        return "." + suffix;
    }

}
