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
package com.phyzicsz.rocket.symbol.code;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class SymbolCodeTest {

    public SymbolCodeTest() {
    }

    @Test
    public void basicComposeTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        symbol.setScheme(SymbologyConstants.SCHEME_WARFIGHTING);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("SH-------------");
    }

    @Test
    public void nullTest() {
        String sidc = null;
        assertThatThrownBy(() -> { 
            new SymbolCode(sidc);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void invalidLengthTest() {
        String sidc = "SH";
        assertThatThrownBy(() -> {
            new SymbolCode(sidc);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void composeUnknownTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        symbol.setScheme("Z");
        String sidc = symbol.toString();
        assertThat(sidc).isNull();
    }

    @Test
    public void composeWarfightingTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        symbol.setScheme(SymbologyConstants.SCHEME_WARFIGHTING);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("SH-------------");
    }

    @Test
    public void composeStabilityOperationsTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        symbol.setScheme(SymbologyConstants.SCHEME_STABILITY_OPERATIONS);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("OH-------------");
    }

    @Test
    public void composeIntelligeceTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setScheme(SymbologyConstants.SCHEME_INTELLIGENCE);
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("IH-------------");
    }

    @Test
    public void composeEmergencyManagementTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setScheme(SymbologyConstants.SCHEME_EMERGENCY_MANAGEMENT);
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("EH-------------");
    }

    @Test
    public void composeMetocTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setScheme(SymbologyConstants.SCHEME_METOC);
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("W--------------");
    }

    @Test
    public void composeTacticalGraphicsTest() {
        SymbolCode symbol = new SymbolCode();
        symbol.setScheme(SymbologyConstants.SCHEME_TACTICAL_GRAPHICS);
        symbol.setStandardIdentity(SymbologyConstants.STANDARD_IDENTITY_HOSTILE);
        String sidc = symbol.toString();
        assertThat(sidc).isEqualTo("GH-------------");
    }

    @Test
    public void basicSymbolCodeParseTest() {
        String sidc = "SFUPSK---------";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_WARFIGHTING);
        assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
        assertThat(battleDimension).isEqualTo(SymbologyConstants.BATTLE_DIMENSION_SEA_SUBSURFACE);
        assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
        assertThat(category).isNull();
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void parseUnknownTest() {
        String sidc = "ZH-------------";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNotNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isNull();
        assertThat(identity).isNull();
        assertThat(battleDimension).isNull();
        assertThat(status).isNull();
        assertThat(category).isNull();
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void emergencyMangementParseTest() {
        String sidc = "EFOPDG---------";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_EMERGENCY_MANAGEMENT);
        assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
        assertThat(battleDimension).isNull();
        assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
        assertThat(category).isEqualTo(SymbologyConstants.CATEGORY_OPERATIONS);
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void stabilityOperationsParseTest() {
        String sidc = "OFVPD----------";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_STABILITY_OPERATIONS);
        assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
        assertThat(battleDimension).isNull();
        assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
        assertThat(category).isEqualTo(SymbologyConstants.CATEGORY_VIOLENT_ACTIVITIES);
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void tacticalGraphicsParseTest() {
        String sidc = "GFGPGLB-------X";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_TACTICAL_GRAPHICS);
        assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
        assertThat(battleDimension).isNull();
        assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
        assertThat(category).isEqualTo(SymbologyConstants.CATEGORY_COMMAND_CONTROL_GENERAL_MANEUVER);
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void intelligenceParseTest() {
        String sidc = "IFPPSCD--------";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_INTELLIGENCE);
        assertThat(identity).isEqualTo(SymbologyConstants.STANDARD_IDENTITY_FRIEND);
        assertThat(battleDimension).isEqualTo(SymbologyConstants.BATTLE_DIMENSION_SPACE);
        assertThat(status).isEqualTo(SymbologyConstants.STATUS_PRESENT);
        assertThat(category).isNull();
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isNull();
        assertThat(graphicType).isNull();
    }

    @Test
    public void metocParseTest() {
        String sidc = "WOS-HPBA--P----";
        SymbolCode symbol = new SymbolCode();
        String unknownSymbols = symbol.parseSymCode(sidc);
        assertThat(unknownSymbols).isNull();

        String scheme = symbol.getScheme();
        String identity = symbol.getStandardIdentity();
        String battleDimension = symbol.getBattleDimension();
        String status = symbol.getStatus();
        String category = symbol.getCategory();
        String echelon = symbol.getEchelon();
        String staticDynamic = symbol.getStaticDynamic();
        String graphicType = symbol.getGraphicType();

        assertThat(scheme).isEqualTo(SymbologyConstants.SCHEME_METOC);
        assertThat(identity).isNull();
        assertThat(battleDimension).isNull();
        assertThat(status).isNull();
        assertThat(category).isEqualTo(SymbologyConstants.CATEGORY_OPERATIONS);
        assertThat(echelon).isNull();
        assertThat(staticDynamic).isEqualTo("S-");
        assertThat(graphicType).isEqualTo("P--");
    }
}
