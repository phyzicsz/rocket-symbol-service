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
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class MimeEncodingUtilsTest {

   

    public MimeEncodingUtilsTest() {
    }

    /**
     * Test of makeSuffixForMimeType method, of class MimeEncodingUtils.
     *
     * @throws com.phyzicsz.rocket.symbol.core.exception.UnsupportedMimeType
     */
    @Test
    public void testExtensionForPng() throws UnsupportedMimeType {
        String mimeTypeSuffix = MimeEncodingUtils.fileExtensionForMimeType(MediaType.PNG);
        assertThat(mimeTypeSuffix).isEqualTo(".png");
    }
    
    @Test
    public void testExtensionForBmp() throws UnsupportedMimeType {
        String mimeTypeSuffix = MimeEncodingUtils.fileExtensionForMimeType(MediaType.BMP);
        assertThat(mimeTypeSuffix).isEqualTo(".bmp");
    }

    
    @Test
    public void testExtensionForJPG() throws UnsupportedMimeType {
        String mimeTypeSuffix = MimeEncodingUtils.fileExtensionForMimeType(MediaType.JPEG);
        assertThat(mimeTypeSuffix).isEqualTo(".jpg");
    }
    
    @Test
    public void nullTest() {
        assertThatThrownBy(() -> {
            MimeEncodingUtils.fileExtensionForMimeType(null);
        }).isInstanceOf(IllegalStateException.class);
    }
    
    @Test
    public void unsupportedTest() {
        assertThatThrownBy(() -> {
            MimeEncodingUtils.fileExtensionForMimeType(MediaType.KML);
        }).isInstanceOf(UnsupportedMimeType.class);
    }

//    @Test
//    public void parameterTest() {
//        String imageFormat = "image/png;base64";
//        String mimeTypeSuffix = MimeEncodingUtils.makeSuffixForMimeType(imageFormat);
//        assertThat(mimeTypeSuffix).isEqualTo(".png");
//
//    }
}
