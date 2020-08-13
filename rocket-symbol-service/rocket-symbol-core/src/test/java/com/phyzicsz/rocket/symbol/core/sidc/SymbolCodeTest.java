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

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class SymbolCodeTest {
    
    public SymbolCodeTest() {
    }

     @Test
     public void basicBuildTest() {
         SymbolCode symbol = new SymbolCode();
         symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
         symbol.setScheme(SymbologyConstants.SCHEME_WARFIGHTING);
         String sidc = symbol.toString();
         assertThat(sidc).isEqualTo("SH-------------");
     }
     
     @Test
     public void basicSymbolCodeTest() {
         String sidc = "SFUPSK---------";
         SymbolCode symbol = new SymbolCode();
         String unknownSymbols = symbol.parseSymCode(sidc);
         assertThat(unknownSymbols).isNull();
         
         String scheme = symbol.getScheme();
         String identity = symbol.getStandardIdentity();
         String battleDimension= symbol.getBattleDimension();
         String status = symbol.getStatus();
         
         assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_WARFIGHTING);
         assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
         assertThat(battleDimension).isEqualTo(SymbologyConstants.BATTLE_DIMENSION_SEA_SUBSURFACE);
         assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
       
         
     }
}

