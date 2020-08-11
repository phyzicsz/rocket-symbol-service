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
package com.phyzicsz.rocket.symbol.core.sidc;

import com.phyzicsz.rocket.symbol.core.sidc.SymbologyConstants;
import com.phyzicsz.rocket.symbol.core.sidc.SymbolCode;
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
public class SymbolCodeTest {
    
    public SymbolCodeTest() {
    }

     @Test
     public void basicTest() {
         SymbolCode symbol = new SymbolCode();
         symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
         symbol.setScheme(SymbologyConstants.SCHEME_WARFIGHTING);
         String sidc = symbol.toString();
         assertThat(sidc).isEqualTo("SH-------------");
     }
}

