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

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SymbolCode provides a utility for parsing and representing the individual
 * fields of a MIL-STD-2525 symbol identification code (SIDC).
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public final class SymbolCode extends SymbolServiceProperties {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SymbolCode.class);

    private final String SCHEME_STRING = "scheme";
    private final String STANDARD_IDENTITY_STRING = "standard identity";
    private final String CATEGORY_STRING=  "category";
    private final String STATUS_STRING = "status";
    private final String SYMBOL_MODIFIER_STRING = "symbolModifier";
    private final String ORDER_OF_BATTLE_STRING = "order of battle";
    private final String BATTLE_DIMENSION_STRING = "battle dimension";
    private final String ECHELON_STRING = "echelon";
    
    /**
     * Indicates the character for an unused position in a MIL-STD-2525 symbol
     * identification code
     */
    protected static final String UNUSED_POSITION_CODE = "-";
    

    /**
     * Creates a new symbol code, with all fields initialized to null.
     */
    public SymbolCode() {
        
    }

    /**
     * Creates a new SymbolCode by parsing the fields of the specified
     * MIL-STD-2525 15-character alphanumeric symbol identification code
     * (SIDC).
     *
     * @param symCode the symbol identification code to parse.
     * @throws java.io.IOException
     * @throws IllegalArgumentException if the symCode is null or has a length other than 15.
     */
    public SymbolCode(String symCode) throws IOException {
        if (symCode == null) {
            logger.error("symbol code is null");
            throw new IllegalArgumentException("symbol code is null");
        }

        if (symCode.length() != 15) {
            logger.error("symbol code is invalid length: {}", symCode.length());
            throw new IllegalArgumentException("symbol code is invalid len");
        }

        String s = this.parseSymCode(symCode);
        if (s != null) {
            // A non-null return value indicates the symCode is unrecognized, and contains a message indicating the
            // problematic fields.
            logger.error("unknown sym code: {}", s);
            throw new IOException(s);
        }
    }

    /**
     * Indicates this symbol code's Coding Scheme field.
     *
     * @return the value of the Coding Scheme field. May be <code>null</code>.
     *
     * @see #setScheme(String)
     */
    public String getScheme() {
        return this.getStringValue(SymbologyConstants.SCHEME);
    }

    /**
     * Specifies this symbol code's Coding Scheme field. The value must be <code>null</code> 
     * or one of the following:
     * <ul> 
     * <li>SCHEME_WARFIGHTING</li> 
     * <li>SCHEME_TACTICAL_GRAPHICS</li>
     * <li>SCHEME_METOC</li>
     * <li>SCHEME_INTELLIGENCE</li> 
     * <li>SCHEME_STABILITY_OPERATIONS</li>
     * <li>SCHEME_EMERGENCY_MANAGEMENT</li> 
     * </ul>
     *
     * @param value the new value for the Coding Scheme field. May be
     * <code>null</code>.
     */
    public void setScheme(String value) {
        this.put(SymbologyConstants.SCHEME, value);
    }

    /**
     * Indicates this symbol code's Standard Identity field.
     *
     * @return the value of the Standard Identity field. May be
     * <code>null</code>.
     *
     * @see #setStandardIdentity(String)
     */
    public String getStandardIdentity() {
        return this.getStringValue(SymbolServiceProperties.STANDARD_IDENTITY);
    }

    /**
     * Specifies this symbol code's Standard Identity field. 
     * <ul> 
     * <li>STANDARD_IDENTITY_PENDING</li>
     * <li>STANDARD_IDENTITY_UNKNOWN</li>
     * <li>STANDARD_IDENTITY_ASSUMED_FRIEND</li>
     * <li>STANDARD_IDENTITY_FRIEND</li> 
     * <li>STANDARD_IDENTITY_NEUTRAL</li>
     * <li>STANDARD_IDENTITY_SUSPECT</li>
     * <li>STANDARD_IDENTITY_HOSTILE</li>
     * <li>STANDARD_IDENTITY_EXERCISE_PENDING</li>
     * <li>STANDARD_IDENTITY_EXERCISE_UNKNOWN</li>
     * <li>STANDARD_IDENTITY_EXERCISE_ASSUMED_FRIEND</li>
     * <li>STANDARD_IDENTITY_EXERCISE_FRIEND</li>
     * <li>STANDARD_IDENTITY_EXERCISE_NEUTRAL</li>
     * <li>STANDARD_IDENTITY_JOKER</li> 
     * <li>STANDARD_IDENTITY_FAKER</li> 
     * </ul>
     *
     * @param value the new value for the Standard Identity field. May be
     * <code>null</code>.
     */
    public void setStandardIdentity(String value) {
        this.put(SymbolServiceProperties.STANDARD_IDENTITY, value);
    }

    /**
     * Indicates this symbol code's Battle Dimension field.
     *
     * @return the value of the Battle Dimension field. May be
     * <code>null</code>.
     *
     * @see #setBattleDimension(String)
     */
    public String getBattleDimension() {
        return this.getStringValue(SymbolServiceProperties.BATTLE_DIMENSION);
    }

    /**
     * Specifies this symbol code's Battle Dimension field. 
     * <ul> 
     * <li>BATTLE_DIMENSION_SPACE</li> 
     * <li>BATTLE_DIMENSION_AIR</li>
     * <li>BATTLE_DIMENSION_GROUND</li>
     * <li>BATTLE_DIMENSION_SEA_SURFACE</li>
     * <li>BATTLE_DIMENSION_SEA_SUBSURFACE</li> 
     * <li>BATTLE_DIMENSION_SOF</li>
     * <li>BATTLE_DIMENSION_OTHER</li> 
     * </ul>
     *
     * @param value the new value for the Battle Dimension field. May be
     * <code>null</code>.
     */
    public void setBattleDimension(String value) {
        this.put(SymbolServiceProperties.BATTLE_DIMENSION, value);
    }

    /**
     * Indicates this symbol code's Category field.
     *
     * @return the value of the Category field. May be <code>null</code>.
     *
     * @see #setCategory(String)
     */
    public String getCategory() {
        return this.getStringValue(SymbolServiceProperties.CATEGORY);
    }

    /**
     * Specifies this symbol code's Category field. 
     * <p>
     * <strong>Tactical Graphics</strong>
     * <ul> 
     * <li>CATEGORY_TASKS</li>
     * <li>CATEGORY_COMMAND_CONTROL_GENERAL_MANEUVER</li>
     * <li>CATEGORY_MOBILITY_SURVIVABILITY</li> 
     * <li>CATEGORY_FIRE_SUPPORT</li>
     * <li>CATEGORY_COMBAT_SERVICE_SUPPORT</li>
     * <li>CATEGORY_OTHER</li> 
     * </ul>
     * <p>
     * <strong>Stability Operations</strong>
     * <ul> <li>CATEGORY_VIOLENT_ACTIVITIES</li> 
     * <li>CATEGORY_LOCATIONS</li>
     * <li>CATEGORY_OPERATIONS</li>
     * <li>CATEGORY_ITEMS</li> 
     * <li>CATEGORY_INDIVIDUAL</li>
     * <li>CATEGORY_NONMILITARY_GROUP_ORGANIZATION</li>
     * <li>CATEGORY_RAPE</li> 
     * </ul>
     * <p>
     * <strong>Emergency Management</strong>
     * <ul> <li>CATEGORY_INCIDENT</li> 
     * <li>CATEGORY_NATURAL_EVENTS</li>
     * <li>CATEGORY_OPERATIONS</li>
     * <li>CATEGORY_INFRASTRUCTURE</li> 
     * </ul>
     *
     * @param value the new value for the Category field. May be
     * <code>null</code>.
     */
    public void setCategory(String value) {
        this.put(SymbolServiceProperties.CATEGORY, value);
    }

    /**
     * Indicates this symbol code's Status/Operational Condition field.
     *
     * @return the value of the Status/Operational Condition field. May be
     * <code>null</code>.
     *
     * @see #setStatus(String)
     */
    public String getStatus() {
        return this.getStringValue(SymbologyConstants.STATUS);
    }

    /**
     * Specifies this symbol code's Status/Operational Condition field. 
     * <p>
     * <strong>Warfighting, Signals Intelligence, Stability Operations</strong>
     * <ul> 
     * <li>STATUS_ANTICIPATED</li> 
     * <li>STATUS_PRESENT</li>
     * <li>STATUS_PRESENT_FULLY_CAPABLE</li>
     * <li>STATUS_PRESENT_DAMAGED</li> 
     * <li>STATUS_PRESENT_DESTROYED</li>
     * <li>STATUS_PRESENT_FULL_TO_CAPACITY</li> 
     * </ul>
     * <p>
     * <strong>Tactical Graphics</strong>
     * <ul> <li>STATUS_ANTICIPATED</li> 
     * <li>STATUS_SUSPECTED</li>
     * <li>STATUS_PRESENT</li> 
     * <li>STATUS_KNOWN</li> </ul>
     * <p>
     * <strong>Emergency Management</strong>
     * <ul> 
     * <li>STATUS_ANTICIPATED</li> 
     * <li>STATUS_PRESENT</li> 
     * </ul>
     *
     * @param value the new value for the Status/Operational Condition field.
     * May be <code>null</code>.
     */
    public void setStatus(String value) {
        this.put(SymbologyConstants.STATUS, value);
    }

    /**
     * Indicates this symbol code's Function ID field.
     *
     * @return the value of the Function ID field. May be <code>null</code>.
     *
     * @see #setFunctionId(String)
     */
    public String getFunctionId() {
        return this.getStringValue(SymbolServiceProperties.FUNCTION_ID);
    }

    /**
     * Specifies this symbol code's Function ID field.
     *
     * @param value the new value for the Function ID field. May be
     * <code>null</code>.
     */
    public void setFunctionId(String value) {
        this.put(SymbolServiceProperties.FUNCTION_ID, value);
    }

    /**
     * Indicates this symbol code's Symbol Modifier field.
     *
     * @return the value of the Symbol Modifier field. May be <code>null</code>.
     *
     * @see #setSymbolModifier(String)
     */
    public String getSymbolModifier() {
        return this.getStringValue(SymbolServiceProperties.SYMBOL_MODIFIER);
    }

    /**
     * Specifies this symbol code's Symbol Modifier field. 
     *
     * @param value the new value for the Symbol Modifier field. May be
     * <code>null</code>.
     */
    public void setSymbolModifier(String value) {
        this.put(SymbolServiceProperties.SYMBOL_MODIFIER, value);
    }

    /**
     * Indicates this symbol code's Echelon field.
     *
     * @return the value of the Echelon field. May be <code>null</code>.
     *
     * @see #setEchelon(String)
     */
    public String getEchelon() {
        return this.getStringValue(SymbologyConstants.ECHELON);
    }

    /**
     * Specifies this symbol code's Echelon field. 
     * <ul> 
     * <li>ECHELON_TEAM_CREW</li> 
     * <li>ECHELON_SQUAD</li>
     * <li>ECHELON_SECTION</li>
     * <li>ECHELON_PLATOON_DETACHMENT</li>
     * <li>ECHELON_COMPANY_BATTERY_TROOP</li>
     * <li>ECHELON_BATTALION_SQUADRON</li>
     * <li>ECHELON_REGIMENT_GROUP</li> 
     * <li>ECHELON_BRIGADE</li>
     * <li>ECHELON_DIVISION</li> 
     * <li>ECHELON_CORPS</li>
     * <li>ECHELON_ARMY</li> 
     * <li>ECHELON_ARMY_GROUP_FRONT</li>
     * <li>ECHELON_REGION</li> 
     * <li>ECHELON_COMMAND</li> 
     * </ul>
     * <p>
     *
     * @param value the new value for the Echelon field. May be
     * <code>null</code>.
     */
    public void setEchelon(String value) {
        this.put(SymbologyConstants.ECHELON, value);
    }

    /**
     * Indicates this symbol code's Country Code field.
     *
     * @return the value of the Country Code field. May be <code>null</code>.
     *
     * @see #setCountryCode(String)
     */
    public String getCountryCode() {
        return this.getStringValue(SymbolServiceProperties.COUNTRY_CODE);
    }

    /**
     * Specifies this symbol code's Country Code field. 
     * 
     * @param value the new value for the Country Code field. May be
     * <code>null</code>.
     */
    public void setCountryCode(String value) {
        this.put(SymbolServiceProperties.COUNTRY_CODE, value);
    }

    /**
     * Indicates this symbol code's Order of Battle field.
     *
     * @return the value of the Order of Battle field. May be <code>null</code>.
     *
     * @see #setOrderOfBattle(String)
     */
    public String getOrderOfBattle() {
        return this.getStringValue(SymbolServiceProperties.ORDER_OF_BATTLE);
    }

    /**
     * Specifies this symbol code's Order of Battle field. 
     * <p>
     * <strong>Warfighting, Signals Intelligence, Stability Operations,
     * Emergency Management</strong>
     * <ul> 
     * <li>ORDER_OF_BATTLE_AIR</li> 
     * <li>ORDER_OF_BATTLE_ELECTRONIC</li>
     * <li>ORDER_OF_BATTLE_CIVILIAN</li>
     * <li>ORDER_OF_BATTLE_GROUND</li> 
     * <li>ORDER_OF_BATTLE_MARITIME</li>
     * <li>ORDER_OF_BATTLE_STRATEGIC_FORCE_RELATED</li>
     * </ul>
     * <p>
     * <strong>Tactical Graphics</strong>
     * <ul> 
     * <li>ORDER_OF_BATTLE_CONTROL_MARKINGS</li> 
     * </ul>
     *
     * @param value the new value for the Order of Battle field. May be
     * <code>null</code>.
     */
    public void setOrderOfBattle(String value) {
        this.put(SymbolServiceProperties.ORDER_OF_BATTLE, value);
    }

    /**
     * Indicates this symbol code's Static/Dynamic field.
     *
     * @return the value of the Static/Dynamic Condition field. May be
     * <code>null</code>.
     *
     * @see #setStaticDynamic(String)
     */
    public String getStaticDynamic() {
        return this.getStringValue(SymbolServiceProperties.STATIC_DYNAMIC);
    }

    /**
     * Specifies this symbol code's Static/Dynamic field. 
     *
     * @param value the new value for the Static/Dynamic field. May be
     * <code>null</code>.
     */
    public void setStaticDynamic(String value) {
        this.put(SymbolServiceProperties.STATIC_DYNAMIC, value);
    }

    /**
     * Indicates this symbol code's Graphic Type field.
     *
     * @return the value of the Graphic Type field. May be <code>null</code>.
     *
     * @see #setStaticDynamic(String)
     */
    public String getGraphicType() {
        return this.getStringValue(SymbolServiceProperties.GRAPHIC_TYPE);
    }

    /**
     * Specifies this symbol code's Graphic Type field. 
     *
     * @param value the new value for the Graphic Type field. May be
     * <code>null</code>.
     */
    public void setGraphicType(String value) {
        this.put(SymbolServiceProperties.GRAPHIC_TYPE, value);
    }

    /**
     * Returns the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode's current field values. 
     * 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode
     */
    @Override
    public String toString() {
        return this.composeSymCode();
    }

    /**
     * Indicates a string representation of the symbol code with positions that
     * do not uniquely identify a particular symbol or graphic replaced with
     * hyphens. This method masks out the Standard Identity, Status, Echelon,
     * Symbol Modifier, Country Code, and Order Of Battle fields. For example,
     * the masked version of "GFGPGPAD---AUSX" is "G-F-GPAD-------".
     *
     * @return String representation of the symbol code with some fields
     * replaced with hyphens.
     */
    public String toMaskedString() {
        SymbolCode masked = new SymbolCode();
        masked.setValues(this);

        masked.setStandardIdentity(null);
        masked.setStatus(null);
        masked.setEchelon(null);
        masked.setSymbolModifier(null);
        masked.setCountryCode(null);
        masked.setOrderOfBattle(null);

        return masked.toString();
    }

  
    /**
     * Parses a symbol code encoded into its individual fields, populating this
     * SymbolCode's fields with the value of each field. Fields that are either
     * not part of the specified symbol code or are unspecified are left
     * unchanged.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol code fields.
     */
    protected String parseSymCode(String symCode) {
        // Coding Scheme (position 1).
        String scheme = symCode.substring(0, 1);

        if (SymbologyConstants.SCHEME_WARFIGHTING.equalsIgnoreCase(scheme)) {
            return this.parseWarfightingSymCode(symCode);
        } else if (SymbologyConstants.SCHEME_TACTICAL_GRAPHICS.equalsIgnoreCase(scheme)) {
            return this.parseTacticalGraphicsSymCode(symCode);
        } else if (SymbologyConstants.SCHEME_METOC.equalsIgnoreCase(scheme)) {
            return this.parseMetocSymCode(symCode);
        } else if (SymbologyConstants.SCHEME_INTELLIGENCE.equalsIgnoreCase(scheme)) {
            return this.parseIntelligenceSymCode(symCode);
        } else if (SymbologyConstants.SCHEME_STABILITY_OPERATIONS.equalsIgnoreCase(scheme)) {
            return this.parseStabilityOperationsSymCode(symCode);
        } else if (SymbologyConstants.SCHEME_EMERGENCY_MANAGEMENT.equalsIgnoreCase(scheme)) {
            return this.parseEmergencyManagementSymCode(symCode);
        } else {
            return this.parseUnrecognizedSymCode(symCode);
        }
    }

    /**
     * Returns a error string indicating that the symbol code's scheme is not
     * recognized.
     *
     * @param symCode the unknown symbol code.
     *
     * @return an error string.
     */
    protected String parseUnrecognizedSymCode(String symCode) {
        // Return a message indicating that the symCode's scheme is not recognized.
        String scheme = symCode.substring(0, 1);
        return "The scheme " + scheme + " is not recognized for symbol code" + symCode;
    }

    /**
     * Parses a symbol code encoded in the Warfighting coding scheme.
     * 
     *
     * @param symCode the symbol code to parse. 
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol code fields.
     */
    protected String parseWarfightingSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (s != null && s.equalsIgnoreCase(SymbologyConstants.SCHEME_WARFIGHTING)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Standard Identity/Exercise Amplifying Descriptor (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.STANDARD_IDENTITY_ALL.contains(s.toUpperCase())) {
            this.setStandardIdentity(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STANDARD_IDENTITY_STRING);
        }

        // Battle Dimension (position 3).
        s = symCode.substring(2, 3);
        if (SymbologyConstants.BATTLE_DIMENSION_ALL.contains(s.toUpperCase())) {
            this.setBattleDimension(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(BATTLE_DIMENSION_STRING);
        }

        // Status/Operational Condition (position 4).
        s = symCode.substring(3, 4);
        if (SymbologyConstants.STATUS_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setStatus(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10).
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Symbol Modifier (positions 11-12).
        s = symCode.substring(10, 12);
        if (this.isUnitsAndEquipmentSymbolModifier(s)
                || SymbologyConstants.INSTALLATION_ALL.contains(s.toUpperCase())
                || SymbologyConstants.MOBILITY_ALL.contains(s.toUpperCase())
                || SymbologyConstants.AUXILIARY_EQUIPMENT_ALL.contains(s.toUpperCase())) {
            this.setSymbolModifier(s);
        } else if (!"--".equals(s)) // "--" is accepted and indicates a null symbol modifier.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(SYMBOL_MODIFIER_STRING);
        }

        // Country Code (positions 13-14).
        s = symCode.substring(12, 14);
        if (!"--".equals(s)) // "--" is accepted and indicates a null country code.
        {
            this.setCountryCode(s);
        }

        // Order Of Battle (position 15).
        s = symCode.substring(14, 15);
        if (SymbologyConstants.ORDER_OF_BATTLE_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setOrderOfBattle(s);
        } else if (!"-".equals(s)) // "-" is accepted and indicates a null order of battle.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ORDER_OF_BATTLE_STRING);
        }

        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;
    }

    /**
     * Parses a symbol code encoded in the Tactical Graphics coding scheme.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol elements.
     */
    protected String parseTacticalGraphicsSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (s != null && s.equalsIgnoreCase(SymbologyConstants.SCHEME_TACTICAL_GRAPHICS)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Standard Identity/Exercise Amplifying Descriptor (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.STANDARD_IDENTITY_ALL.contains(s.toUpperCase())) {
            this.setStandardIdentity(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STANDARD_IDENTITY_STRING);
        }

        // Category (position 3).
        s = symCode.substring(2, 3);
        if (SymbologyConstants.CATEGORY_ALL_TACTICAL_GRAPHICS.contains(s.toUpperCase())) {
            this.setCategory(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(CATEGORY_STRING);
        }

        // Status/Operational Condition (position 4).
        s = symCode.substring(3, 4);
        if (SymbologyConstants.STATUS_ALL_TACTICAL_GRAPHICS_METOC.contains(s.toUpperCase())) {
            this.setStatus(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10).
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Echelon (position 12, position 11 is unused).
        s = symCode.substring(11, 12);
        if (SymbologyConstants.ECHELON_ALL.contains(s.toUpperCase())) {
            this.setEchelon(s);
        } else if (!UNUSED_POSITION_CODE.equals(s)) // "-" is accepted and indicates a null echelon.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ECHELON_STRING);
        }

        // Country Code (positions 13-14).
        s = symCode.substring(12, 14);
        if (!"--".equals(s)) // "--" is accepted and indicates a null country code. We don't validate country codes.
        {
            this.setCountryCode(s);
        }

        // Order Of Battle (position 15).
        s = symCode.substring(14, 15);
        if (SymbologyConstants.ORDER_OF_BATTLE_ALL_TACTICAL_GRAPHICS.contains(s.toUpperCase())) {
            this.setOrderOfBattle(s);
        } else if (!"-".equals(s)) // "-" is accepted and indicates a null order of battle.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ORDER_OF_BATTLE_STRING);
        }

        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;
    }

    /**
     * Parses a symbol code encoded in the Meteorological and Oceanographic
     * coding scheme.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return an error string.
     */
    protected String parseMetocSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (SymbologyConstants.SCHEME_METOC.equalsIgnoreCase(s)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Category (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.CATEGORY_ALL_METOC.contains(s.toUpperCase())) {
            this.setCategory(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(CATEGORY_STRING);
        }

        // Static/Dynamic (position 3,4).
        s = symCode.substring(2, 4);
        if (SymbologyConstants.STATIC_DYNAMIC_ALL.contains(s.toUpperCase())) {
            this.setStaticDynamic(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10).
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Graphic Type (position 11-13).
        s = symCode.substring(10, 13);
        if (SymbologyConstants.GRAPHIC_TYPE_ALL.contains(s.toUpperCase())) {
            this.setGraphicType(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(ECHELON_STRING);
        }

        // Positions 14 and 15 unused
        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;
    }

    /**
     * Parses symbol codes encoded for the Signals Intelligence coding scheme.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol elements.
     */
    protected String parseIntelligenceSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (s != null && s.equalsIgnoreCase(SymbologyConstants.SCHEME_INTELLIGENCE)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Standard Identity/Exercise Amplifying Descriptor (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.STANDARD_IDENTITY_ALL.contains(s.toUpperCase())) {
            this.setStandardIdentity(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STANDARD_IDENTITY_STRING);
        }

        // Battle Dimension (position 3).
        s = symCode.substring(2, 3);
        if (SymbologyConstants.BATTLE_DIMENSION_ALL_INTELLIGENCE.contains(s.toUpperCase())) {
            this.setBattleDimension(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(BATTLE_DIMENSION_STRING);
        }

        // Status/Operational Condition (position 4)
        s = symCode.substring(3, 4);
        if (SymbologyConstants.STATUS_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setStatus(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10)
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Not Used (positions 11-12).
        s = symCode.substring(10, 12);
        if (!"--".equals(s)) // "--" is the only accepted string in positions 11-12.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(SYMBOL_MODIFIER_STRING);
        }

        // Country Code (positions 13-14).
        s = symCode.substring(12, 14);
        if (!"--".equals(s)) // "--" is accepted and indicates a null country code.
        {
            this.setCountryCode(s);
        }

        // Order of Battle (position 15).
        s = symCode.substring(14, 15);
        if (SymbologyConstants.ORDER_OF_BATTLE_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setOrderOfBattle(s);
        } else if (!"-".equals(s)) // "-" is accepted and indicates a null order of battle.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ORDER_OF_BATTLE_STRING);
        }

        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;

    }

    /**
     * Parses a symbol code encoded in the Stability Operations coding scheme.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol elements.
     */
    protected String parseStabilityOperationsSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (s != null && s.equalsIgnoreCase(SymbologyConstants.SCHEME_STABILITY_OPERATIONS)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Standard Identity/Exercise Amplifying Descriptor (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.STANDARD_IDENTITY_ALL.contains(s.toUpperCase())) {
            this.setStandardIdentity(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STANDARD_IDENTITY_STRING);
        }

        // Category (position 3).
        s = symCode.substring(2, 3);
        if (SymbologyConstants.CATEGORY_ALL_STABILITY_OPERATIONS.contains(s.toUpperCase())) {
            this.setCategory(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(CATEGORY_STRING);
        }

        // Status/Operational Condition (position 4).
        s = symCode.substring(3, 4);
        if (SymbologyConstants.STATUS_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setStatus(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10).
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Symbol Modifier (positions 11-12).
        s = symCode.substring(10, 12);
        if (this.isUnitsAndEquipmentSymbolModifier(s) || SymbologyConstants.INSTALLATION_ALL.contains(s.toUpperCase())) {
            this.setSymbolModifier(s);
        } else if (!"--".equals(s)) // "--" is accepted and indicates a null symbol modifier.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(SYMBOL_MODIFIER_STRING);
        }

        // Country Code (positions 13-14).
        s = symCode.substring(12, 14);
        if (!"--".equals(s)) // "--" is accepted and indicates a null country code.
        {
            this.setCountryCode(s);
        }

        // Order Of Battle (position 15).
        s = symCode.substring(14, 15);
        if (SymbologyConstants.ORDER_OF_BATTLE_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setOrderOfBattle(s);
        } else if (!"-".equals(s)) // "-" is accepted and indicates a null order of battle.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ORDER_OF_BATTLE_STRING);
        }

        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;
    }

    /**
     * Parses a symbol code encoded in the Emergency Management coding scheme.
     *
     * @param symCode the symbol code to parse. Must be non-<code>null</code>
     * and have length of 15 or greater. Any characters after the 15th character
     * are ignored.
     *
     * @return <code>null</code> if the symbol code is recognized, otherwise a
     * non-<code>null</code> string listing the unrecognized symbol elements.
     */
    protected String parseEmergencyManagementSymCode(String symCode) {
        StringBuilder sb = new StringBuilder();

        // Coding Scheme (position 1).
        String s = symCode.substring(0, 1);
        if (s != null && s.equalsIgnoreCase(SymbologyConstants.SCHEME_EMERGENCY_MANAGEMENT)) {
            this.setScheme(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(SCHEME_STRING);
        }

        // Standard Identity/Exercise Amplifying Descriptor (position 2).
        s = symCode.substring(1, 2);
        if (SymbologyConstants.STANDARD_IDENTITY_ALL.contains(s.toUpperCase())) {
            this.setStandardIdentity(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STANDARD_IDENTITY_STRING);
        }

        // Category (position 3).
        s = symCode.substring(2, 3);
        if (SymbologyConstants.CATEGORY_ALL_EMERGENCY_MANAGEMENT.contains(s.toUpperCase())) {
            this.setCategory(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(CATEGORY_STRING);
        }

        // Status/Operational Condition (position 4).
        s = symCode.substring(3, 4);
        if (SymbologyConstants.STATUS_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setStatus(s);
        } else {
            sb.append(sb.length() > 0 ? ", " : "").append(STATUS_STRING);
        }

        // Function ID (positions 5-10).
        s = symCode.substring(4, 10);
        if (!"------".equals(s)) // "------" is accepted and indicates a null function ID.
        {
            this.setFunctionId(s);
        }

        // Symbol Modifier (positions 11-12).
        s = symCode.substring(10, 12);
        if (SymbologyConstants.INSTALLATION_ALL.contains(s.toUpperCase())
                || SymbologyConstants.MOBILITY_ALL.contains(s.toUpperCase())) {
            this.setSymbolModifier(s);
        } else if (!"--".equals(s)) // "--" is accepted and indicates a null symbol modifier.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(SYMBOL_MODIFIER_STRING);
        }

        // Country Code (positions 13-14).
        s = symCode.substring(12, 14);
        if (!"--".equals(s)) // "--" is accepted and indicates a null country code.
        {
            this.setCountryCode(s);
        }

        // Order Of Battle (position 15).
        s = symCode.substring(14, 15);
        if (SymbologyConstants.ORDER_OF_BATTLE_ALL_UEI_SIGINT_SO_EM.contains(s.toUpperCase())) {
            this.setOrderOfBattle(s);
        } else if (!"-".equals(s)) // "-" is accepted and indicates a null order of battle.
        {
            sb.append(sb.length() > 0 ? ", " : "").append(ORDER_OF_BATTLE_STRING);
        }

        return sb.length() > 0
                ? ("The fields " + sb.toString() + " are not recognized for symbol code " + symCode) : null;
    }

    /**
     * Indicates whether the specified 2-character Symbol Modifier code
     * represents a units and equipment symbol modifier code.
     *
     * @param value the modifier code to test. Must be non-<code>null</code> and
     * have length of 2 or greater. Any characters after the 2nd character are
     * ignored.
     *
     * @return <code>true</code> if the specified code represents a units and
     * equipment modifier code, and <code>false</code> otherwise.
     */
    protected boolean isUnitsAndEquipmentSymbolModifier(String value) {
        String firstChar = value.substring(0, 1).toUpperCase();
        String secondChar = value.substring(1, 2).toUpperCase();

        return (UNUSED_POSITION_CODE.equals(firstChar) && SymbologyConstants.ECHELON_ALL.contains(secondChar))
                || (SymbologyConstants.MODIFIER_CODE_ALL_UEI.contains(firstChar) && UNUSED_POSITION_CODE.equals(secondChar))
                || (SymbologyConstants.MODIFIER_CODE_ALL_UEI.contains(firstChar)
                && SymbologyConstants.ECHELON_ALL.contains(secondChar));
    }

    /**
     * Composes and returns a MIL-STD-2525 15-character symbol identification
     * code (SIDC) from this SymbolCode's current field values.
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, or <code>null</code> if the Coding
     * Scheme is unrecognized.
     */
    protected String composeSymCode() {
        String scheme = this.getScheme();

        if (SymbologyConstants.SCHEME_WARFIGHTING.equalsIgnoreCase(scheme)) {
            return this.composeWarfightingSymCode();
        } else if (SymbologyConstants.SCHEME_TACTICAL_GRAPHICS.equalsIgnoreCase(scheme)) {
            return this.composeTacticalGraphicsSymCode();
        } else if (SymbologyConstants.SCHEME_METOC.equalsIgnoreCase(scheme)) {
            return this.composeMetocSymCode();
        } else if (SymbologyConstants.SCHEME_INTELLIGENCE.equalsIgnoreCase(scheme)) {
            return this.composeIntelligenceSymCode();
        } else if (SymbologyConstants.SCHEME_STABILITY_OPERATIONS.equalsIgnoreCase(scheme)) {
            return this.composeStabilityOperationsSymCode();
        } else if (SymbologyConstants.SCHEME_EMERGENCY_MANAGEMENT.equalsIgnoreCase(scheme)) {
            return this.composeEmergencyManagementSymCode();
        } else {
            return this.composeUnrecognizedSymCode();
        }
    }

    /**
     * Returns <code>null</code> indicating that this SymbolCode's Coding Scheme
     * is not recognized.
     *
     * @return <code>null</code>.
     */
    protected String composeUnrecognizedSymCode() {
        return null;
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the
     * Warfighting coding scheme. 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the Warfighting coding
     * scheme.
     */
    protected String composeWarfightingSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getStandardIdentity(), 1); // Position 2.
        appendFieldValue(sb, this.getBattleDimension(), 1); // Position 3.
        appendFieldValue(sb, this.getStatus(), 1); // Position 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        appendFieldValue(sb, this.getSymbolModifier(), 2); // Positions 11-12.
        appendFieldValue(sb, this.getCountryCode(), 2);  // Positions 13-14.
        appendFieldValue(sb, this.getOrderOfBattle(), 1);// Position 15.

        return sb.toString();
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the
     * Tactical Graphics coding scheme. 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the Tactical Graphics
     * coding scheme.
     */
    protected String composeTacticalGraphicsSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getStandardIdentity(), 1); // Position 2.
        appendFieldValue(sb, this.getCategory(), 1); // Position 3.
        appendFieldValue(sb, this.getStatus(), 1); // Position 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        sb.append(UNUSED_POSITION_CODE); // Position 11. Unused because the echelon code uses only position 12.
        appendFieldValue(sb, this.getEchelon(), 1); // Position 12.
        appendFieldValue(sb, this.getCountryCode(), 2);  // Positions 13-14.
        appendFieldValue(sb, this.getOrderOfBattle(), 1);// Position 15.

        return sb.toString();
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the
     * Meteorological and Oceanographic coding scheme. 
     * 
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the METOC coding scheme.
     */
    protected String composeMetocSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getCategory(), 1); // Position 2.
        appendFieldValue(sb, this.getStaticDynamic(), 2); // Position 3, 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        appendFieldValue(sb, this.getGraphicType(), 3); // Position 11-13
        sb.append(UNUSED_POSITION_CODE); // Position 14 unused
        sb.append(UNUSED_POSITION_CODE); // Position 15 unused

        return sb.toString();
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the Signals
     * Intelligence coding scheme. 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the Signals Intelligence
     * coding scheme.
     */
    protected String composeIntelligenceSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getStandardIdentity(), 1); // Position 2.
        appendFieldValue(sb, this.getBattleDimension(), 1); // Position 3.
        appendFieldValue(sb, this.getStatus(), 1); // Position 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        sb.append(UNUSED_POSITION_CODE).append(UNUSED_POSITION_CODE); // Positions 11-12 are not used.
        appendFieldValue(sb, this.getCountryCode(), 2);  // Positions 13-14.
        appendFieldValue(sb, this.getOrderOfBattle(), 1);// Position 15.

        return sb.toString();
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the
     * Stability Operations coding scheme. 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the Stability Operations
     * coding scheme.
     */
    protected String composeStabilityOperationsSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getStandardIdentity(), 1); // Position 2.
        appendFieldValue(sb, this.getCategory(), 1); // Position 3.
        appendFieldValue(sb, this.getStatus(), 1); // Position 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        appendFieldValue(sb, this.getSymbolModifier(), 2); // Positions 11-12.
        appendFieldValue(sb, this.getCountryCode(), 2);  // Positions 13-14.
        appendFieldValue(sb, this.getOrderOfBattle(), 1);// Position 15.

        return sb.toString();
    }

    /**
     * Composes a 15-character symbol identification code (SIDC) for the
     * Emergency Management coding scheme. 
     *
     * @return the MIL-STD-2525 15-character symbol identification code (SIDC)
     * corresponding to this SymbolCode, according to the Emergency Management
     * coding scheme.
     */
    protected String composeEmergencyManagementSymCode() {
        StringBuilder sb = new StringBuilder();

        appendFieldValue(sb, this.getScheme(), 1); // Position 1.
        appendFieldValue(sb, this.getStandardIdentity(), 1); // Position 2.
        appendFieldValue(sb, this.getCategory(), 1); // Position 3.
        appendFieldValue(sb, this.getStatus(), 1); // Position 4.
        appendFieldValue(sb, this.getFunctionId(), 6); // Positions 5-10.
        appendFieldValue(sb, this.getSymbolModifier(), 2); // Positions 11-12.
        appendFieldValue(sb, this.getCountryCode(), 2);  // Positions 13-14.
        appendFieldValue(sb, this.getOrderOfBattle(), 1);// Position 15.

        return sb.toString();
    }

    /**
     * Appends the specified field value to the specified StringBuilder, padding
     * or trimming the value to fit its length in the symbol code as necessary.
     *
     * @param sb the StringBuilder representing a MIL-STD-2525 symbol
     * identification code (SIDC).
     * @param value the field value to append.
     * @param length the number of positions used by the field in the SIDC.
     */
    public static void appendFieldValue(StringBuilder sb, String value, int length) {
        if (sb == null) {
            logger.error("string builder is null");
            throw new IllegalArgumentException("string builder is null");
        }

        if (length < 0) {
            logger.error("string builder length is invalid: {}", length);
            throw new IllegalArgumentException("string builder length is invalid");
        }

        // Append the code's characters, starting at character 0 and stopping after the number of character positions
        // assigned to the code have been reached or the code's characters are exhausted, whichever comes first. This
        // does nothing if the code is null or empty. If the code contains fewer characters then its assigned length,
        // then only those characters are appended.
        if (value != null && value.length() > 0) {
            sb.append(value, 0, value.length() < length ? value.length() : length);
        }

        // Append the "unused" character for each unused character position assigned to the code. We encounter unused
        // positions when the code is null or its length is less than the number of assigned character positions.
        for (int i = (value != null ? value.length() : 0); i < length; i++) {
            sb.append(UNUSED_POSITION_CODE);
        }
    }

    /**
     * Indicates whether the specified field value is empty.
     *
     * @param value the value to test. May be <code>null</code>.
     *
     * @return <code>true</code> if the value is empty, and <code>false</code>
     * otherwise.
     */
    public static boolean isFieldEmpty(String value) {
        return value == null || value.isEmpty() || value.replaceAll(UNUSED_POSITION_CODE, "").trim().isEmpty();
    }
}
