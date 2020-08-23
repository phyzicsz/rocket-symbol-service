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

import com.google.common.net.MediaType;
import com.phyzicsz.rocket.symbol.core.exception.UnsupportedMimeType;
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
    private static final Map<MediaType, String> extensionMapping = new HashMap<>();

    static {
        extensionMapping.put(MediaType.JPEG, "jpg");
        extensionMapping.put(MediaType.PNG, "png");
        extensionMapping.put(MediaType.BMP, "bmp");
    }

    /**
     * Returns the file suffix string corresponding to the specified mime type
     * string.The returned suffix starts with the period character '.' followed
     * by the mime type's subtype, as in: ".[subtype]".
     *
     * @param mimeType the mime type who's suffix is returned.
     *
     * @return the file suffix for the specified mime type, with a leading ".".
     * @throws com.phyzicsz.rocket.symbol.core.exception.UnsupportedMimeType
     */
    public static String fileExtensionForMimeType(MediaType mimeType) throws UnsupportedMimeType, IllegalStateException {
        if (mimeType == null) {
            logger.error("mime type is null");
            throw new IllegalStateException("mime type is null");
        }

        if (!mimeType.is(MediaType.PNG)
                && !mimeType.is(MediaType.JPEG)
                && !mimeType.is(MediaType.BMP)) {
            throw new UnsupportedMimeType("Unsupported Mime Type: " + mimeType.toString());
        }

        return "." + extensionMapping.get(mimeType);
    }

}
