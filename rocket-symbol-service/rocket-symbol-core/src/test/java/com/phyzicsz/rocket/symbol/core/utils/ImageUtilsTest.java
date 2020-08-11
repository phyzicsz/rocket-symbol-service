package com.phyzicsz.rocket.symbol.core.utils;

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

import com.phyzicsz.rocket.symbol.core.utils.ImageUtils;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class ImageUtilsTest {

    public ImageUtilsTest() {
    }

    @Test
    public void imageUtilsTest() {
        int width = 100;
        int height = 100;

        // No.1 How to create buffered image 
        // that does not support transparency    
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width,height);
        g2d.dispose();
        
        assertThat(bufferedImage.getWidth()).isEqualTo(width);
        assertThat(bufferedImage.getHeight()).isEqualTo(height);
        
        bufferedImage = ImageUtils.resize(bufferedImage, 50);
        
        assertThat(bufferedImage.getWidth()).isEqualTo(50);
        assertThat(bufferedImage.getHeight()).isEqualTo(50);
        
    }
}
