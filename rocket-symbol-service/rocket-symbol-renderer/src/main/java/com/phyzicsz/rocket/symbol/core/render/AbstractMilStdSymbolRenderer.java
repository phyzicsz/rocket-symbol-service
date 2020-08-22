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
package com.phyzicsz.rocket.symbol.core.render;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for rendering images from a set of base images.
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public abstract class AbstractMilStdSymbolRenderer implements SymbolRenderer {

    private static final Logger logger = LoggerFactory.getLogger(AbstractMilStdSymbolRenderer.class);
    /**
     * Path in the file system or network to the symbol repository.
     */
    protected final String baseImagePath = "/symbols";

    public AbstractMilStdSymbolRenderer() {

    }

    public String getBasePath() {
        return this.baseImagePath;
    }

    protected BufferedImage readImage(String path) {
        if (path == null) {
            logger.error("retrieverPath is null");
            throw new IllegalArgumentException("retrieverPath is null");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(this.getBasePath());
        sb.append("/");
        sb.append(path);

         try (InputStream is = getClass().getResourceAsStream(sb.toString())) {
             if (null != is) {
                 return ImageIO.read(is);
             }
             return ImageIO.read(is);
        }catch (IOException ex) {
            logger.error("ExceptionWhileReading", ex);
        }
        return null;
    }

    /**
     * Draw one image into another image. The image is drawn at location (0, 0).
     *
     * @param src Image to draw.
     * @param dest Image to draw into.
     *
     * @return BufferedImage.
     */
    protected BufferedImage drawImage(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            logger.error("src is null");
            throw new IllegalArgumentException("src is null");
        }

        if (dest == null) {
            logger.error("dest is null");
            throw new IllegalArgumentException("dest is null");
        }

        Graphics2D g = null;
        try {
            g = dest.createGraphics();
            g.drawImage(src, 0, 0, null);
        } finally {
            if (g != null) {
                g.dispose();
            }
        }

        return dest;
    }

    /**
     * Multiply each pixel in an image by a color. White pixels are replaced by
     * the multiplication color, black pixels are unaffected.
     *
     * @param image Image to operate on.
     * @param color Color to multiply by.
     */
    protected void multiply(BufferedImage image, Color color) {
        if (image == null) {
            logger.error("image is null");
            throw new IllegalArgumentException("image is null");
        }

        if (color == null) {
            logger.error("color is null");
            throw new IllegalArgumentException("color is null");
        }

        int w = image.getWidth();
        int h = image.getHeight();

        if (w == 0 || h == 0) {
            return;
        }

        int[] pixels = new int[w];
        int c = color.getRGB();
        float ca = ((c >> 24) & 0xff) / 255f;
        float cr = ((c >> 16) & 0xff) / 255f;
        float cg = ((c >> 8) & 0xff) / 255f;
        float cb = (c & 0xff) / 255f;

        for (int y = 0; y < h; y++) {
            image.getRGB(0, y, w, 1, pixels, 0, w);

            for (int x = 0; x < w; x++) {
                int s = pixels[x];
                float sa = ((s >> 24) & 0xff) / 255f;
                float sr = ((s >> 16) & 0xff) / 255f;
                float sg = ((s >> 8) & 0xff) / 255f;
                float sb = (s & 0xff) / 255f;

                int fa = (int) (ca * sa * 255 + 0.5);
                int fr = (int) (cr * sr * 255 + 0.5);
                int fg = (int) (cg * sg * 255 + 0.5);
                int fb = (int) (cb * sb * 255 + 0.5);

                pixels[x] = (fa & 0xff) << 24
                        | (fr & 0xff) << 16
                        | (fg & 0xff) << 8
                        | (fb & 0xff);
            }

            image.setRGB(0, y, w, 1, pixels, 0, w);
        }
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.baseImagePath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractMilStdSymbolRenderer)) {
            return false;
        }
        final AbstractMilStdSymbolRenderer other = (AbstractMilStdSymbolRenderer) obj;
        if (!Objects.equals(this.baseImagePath, other.baseImagePath)) {
            return false;
        }
        return true;
    }

}
