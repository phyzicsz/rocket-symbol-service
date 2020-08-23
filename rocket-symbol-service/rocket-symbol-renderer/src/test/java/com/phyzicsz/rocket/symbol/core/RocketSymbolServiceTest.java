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
package com.phyzicsz.rocket.symbol.core;

import com.phyzicsz.rocket.symbol.core.exception.UnsupportedMimeType;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class RocketSymbolServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RocketSymbolServiceTest.class);

    public RocketSymbolServiceTest() {
    }

    /**
     * Test of createIcon method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateIcon() throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        byte[] actual = instance.asPng(symbolCode);

        Path path = Paths.get("src", "test", "resources", symbolCode + ".png");
        byte[] expected = Files.readAllBytes(path);
//        byte[] expected = getClass().getClassLoader().getResourceAsStream(symbolCode + ".png").readAllBytes();
        assertThat(expected).contains(actual);

    }

    /**
     * Test of createIcon method.
     *
     * @param tempDir
     * @throws java.lang.Exception
     */
    @Test
    public void testPngToFile(@TempDir Path tempDir) throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        byte[] actual = instance.asPng(symbolCode);

        String fileName = tempDir.toString() + symbolCode + ".file.png";
        Path filePath = Paths.get(tempDir.toString(), symbolCode + ".path.png");

        instance.pngToFile(symbolCode, fileName);
        byte[] expected1 = Files.readAllBytes(Paths.get(fileName));
        assertThat(expected1).contains(actual);

        instance.pngToFile(symbolCode, filePath);
        byte[] expected2 = Files.readAllBytes(filePath);
        assertThat(expected2).contains(actual);
    }

    /**
     * Test of toPng method.
     *
     * @param tempDir
     * @throws java.lang.Exception
     */
    @Test
    public void toPng(@TempDir Path tempDir) throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        Path filePath = Paths.get(tempDir.toString(), symbolCode + ".png");
        byte[] bytes = instance.asPng(symbolCode);
        
        try (FileOutputStream stream = new FileOutputStream(filePath.toFile())) {
            stream.write(bytes);
        }
        

        ImageInputStream iis = ImageIO.createImageInputStream(filePath.toFile());
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

        while (imageReaders.hasNext()) {
            ImageReader reader =imageReaders.next();
            assertThat(reader.getFormatName()).isEqualTo("png");

        }

    }
    
    /**
     * Test of toPng method.
     *
     * @param tempDir
     * @throws java.lang.Exception
     */
    @Test
    public void toJpg(@TempDir Path tempDir) throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        Path filePath = Paths.get(tempDir.toString(), symbolCode + ".jpg");
        byte[] bytes = instance.asJpg(symbolCode);
        
        try (FileOutputStream stream = new FileOutputStream(filePath.toFile())) {
            stream.write(bytes);
        }

        ImageInputStream iis = ImageIO.createImageInputStream(filePath.toFile());
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

        while (imageReaders.hasNext()) {
            ImageReader reader =imageReaders.next();
            assertThat(reader.getFormatName()).isEqualTo("jpg");

        }

    }

    /**
     * Test of testCreateIconResize method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateIconResize() throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        BufferedImage image = instance.withImageSize(64)
                .asBufferedImage(symbolCode);

        assertThat(image.getWidth()).isEqualTo(64);
        assertThat(image.getHeight()).isEqualTo(64);
    }
    
    /**
     * Test of testCreateIconResize method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateIconResize0() throws Exception {
        System.out.println("createIcon");
        String symbolCode = "SFUPSK---------";
        RocketSymbolService instance = new RocketSymbolService();

        BufferedImage image = instance.withImageSize(0)
                .asBufferedImage(symbolCode);

        assertThat(image.getWidth()).isEqualTo(128);
        assertThat(image.getHeight()).isEqualTo(128);
    }

    @Test
    public void testFriendSymbology() throws IOException, UnsupportedMimeType {
        List<String> friend = Arrays.asList(
                "SFPP------*****",
                "SFPPS-----*****",
                "SFPPV-----*****",
                "SFPPT-----*****",
                "SFPPL-----*****",
                "SFAP------*****",
                "SFAPM-----*****",
                "SFAPMFKB--*****",
                "SFAPMFO---*****",
                "SFAPMFQA--*****",
                "SFAPMFM---*****",
                "SFAPML----*****",
                "SFAPWMS---*****",
                "SFGPUUSO--*****");

        RocketSymbolService instance = new RocketSymbolService();

        for (String symbolCode : friend) {
            logger.info("testing symbolCode: {}", symbolCode);
            byte[] actual = instance.asPng(symbolCode);
            Path testFile = Paths.get("src", "test", "resources", "2525", "friend", symbolCode + ".png");
            byte[] expected = Files.readAllBytes(testFile);

            assertThat(expected).contains(actual);
        }
    }

    @Test
    public void testHostileSymbology() throws IOException, UnsupportedMimeType {
        List<String> hostile = Arrays.asList(
                "SHPP------*****",
                "SHPPS-----*****",
                "SHPPV-----*****",
                "SHPPT-----*****",
                "SHPPL-----*****",
                "SHAP------*****",
                "SHAPM-----*****",
                "SHAPMFKB--*****",
                "SHAPMFO---*****",
                "SHAPMFQA--*****",
                "SHAPMFM---*****",
                "SHAPML----*****",
                "SHAPWMS---*****",
                "SHGPUUSO--*****");

        RocketSymbolService instance = new RocketSymbolService();

        for (String symbolCode : hostile) {
            logger.info("testing symbolCode: {}", symbolCode);
            byte[] actual = instance.asPng(symbolCode);
            Path testFile = Paths.get("src", "test", "resources", "2525", "hostile", symbolCode + ".png");
            byte[] expected = Files.readAllBytes(testFile);

            assertThat(expected).contains(actual);
        }
    }

    @Test
    public void testNeutralSymbology() throws IOException, UnsupportedMimeType {
        List<String> neutral = Arrays.asList(
                "SNPP------*****",
                "SNPPS-----*****",
                "SNPPV-----*****",
                "SNPPT-----*****",
                "SNPPL-----*****",
                "SNAP------*****",
                "SNAPM-----*****",
                "SNAPMFKB--*****",
                "SNAPMFO---*****",
                "SNAPMFQA--*****",
                "SNAPMFM---*****",
                "SNAPML----*****",
                "SNAPWMS---*****",
                "SNGPUUSO--*****");

        RocketSymbolService instance = new RocketSymbolService();

        for (String symbolCode : neutral) {
            logger.info("testing symbolCode: {}", symbolCode);
            byte[] actual = instance.asPng(symbolCode);
            Path testFile = Paths.get("src", "test", "resources", "2525", "neutral", symbolCode + ".png");
            byte[] expected = Files.readAllBytes(testFile);

            assertThat(expected).contains(actual);
        }
    }

    @Test
    public void testUnknownSymbology() throws IOException, UnsupportedMimeType {
        List<String> unknown = Arrays.asList(
                "SUPP------*****",
                "SUPPS-----*****",
                "SUPPV-----*****",
                "SUPPT-----*****",
                "SUPPL-----*****",
                "SUAP------*****",
                "SUAPM-----*****",
                "SUAPMFKB--*****",
                "SUAPMFO---*****",
                "SUAPMFQA--*****",
                "SUAPMFM---*****",
                "SUAPML----*****",
                "SUAPWMS---*****",
                "SUGPUUSO--*****");

        RocketSymbolService instance = new RocketSymbolService();

        for (String symbolCode : unknown) {
            logger.info("testing symbolCode: {}", symbolCode);
            byte[] actual = instance.asPng(symbolCode);
            Path testFile = Paths.get("src", "test", "resources", "2525", "unknown", symbolCode + ".png");
            byte[] expected = Files.readAllBytes(testFile);

            assertThat(expected).contains(actual);
        }
    }

}
