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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public class SymbolServiceProperties extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = LoggerFactory.getLogger(SymbolServiceProperties.class);

    public static final String COLOR = "SymbolServiceProperties.Color";
    
    public static final String IMAGE_SIZE = "SymbolServiceProperties.Size";
    
    public static final Integer DEFAULT_IMAGE_SIZE = 128;

    /**
     * Indicates the battle dimension code associated with a MIL-STD-2525 symbol
     * (SIDC position 3). 
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
     */
    public static final String BATTLE_DIMENSION = "SymbolServiceProperties.BattleDimension";

    /**
     * Indicates the category code associated with a MIL-STD-2525 symbol (SIDC
     * position 3).
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
     * <ul> 
     * <li>CATEGORY_VIOLENT_ACTIVITIES</li> 
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
     */
    public static final String CATEGORY = "SymbolServiceProperties.Category";

    /**
     * Indicates the country code associated with a MIL-STD-2525 symbol (SIDC
     * positions 13-14).
     */
    public static final String COUNTRY_CODE = "SymbolServiceProperties.CountryCode";

    /**
     * Indicates the function ID associated with a MIL-STD-2525 symbol (SIDC
     * positions 5-10). 
     */
    public static final String FUNCTION_ID = "SymbolServiceProperties.FunctionId";

    /**
     * Indicates the type of a graphic in the Meteorological and Oceanographic
     * scheme (SIDC positions 11-13). 
     * <ul> 
     * <li>GRAPHIC_TYPE_POINT</li> 
     * <li>GRAPHIC_TYPE_LINE</li>
     * <li>GRAPHIC_TYPE_AREA</li> 
     * </ul>
     */
    public static final String GRAPHIC_TYPE = "SymbolServiceProperties.GraphicType";

    public static final String OPERATIONAL_CONDITION = "SymbolServiceProperties.OperationalCondition";

    public static final String OPERATIONAL_CONDITION_ALTERNATE = "SymbolServiceProperties.OperationalConditionAlternate";

    /**
     * Indicates the order of battle code associated with a MIL-STD-2525 symbol
     * (SIDC position 15). 
     * 
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
     */
    public static final String ORDER_OF_BATTLE = "SymbolServiceProperties.OrderOfBattle";

    /**
     * Indicates whether to display a MIL-STD-2525 tactical symbol's fill color.
     */
    public static final String SHOW_FILL = "SymbolServiceProperties.ShowFill";

    /**
     * Indicates whether to display a MIL-STD-2525 tactical symbol's frame. 
     */
    public static final String SHOW_FRAME = "SymbolServiceProperties.ShowFrame";
    /**
     * Indicates whether to display a MIL-STD-2525 tactical symbol's icon.
     */
    public static final String SHOW_ICON = "SymbolServiceProperties.ShowIcon";

    /**
     * Indicates the standard identity code associated with a MIL-STD-2525
     * symbol (SIDC position 2). 
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
     * <li>STANDARD_IDENTITY_FAKER</li> </ul>
     * 
     */
    public static final String STANDARD_IDENTITY = "SymbolServiceProperties.StandardIdentity";

    /**
     * Indicates if a graphic in the Meteorological and Oceanographic scheme is
     * static or dynamic (SIDC positions 3 and 4). 
     */
    public static final String STATIC_DYNAMIC = "SymbolServiceProperties.StaticDynamic";

    /**
     * Indicates the symbol modifier code associated with a MIL-STD-2525 symbol
     * (SIDC positions 11-12). 
     */
    public static final String SYMBOL_MODIFIER = "SymbolServiceProperties.SymbolModifier";

    public String getStringValue(String key) {
        if (key == null) {
            logger.error("key is null");
            throw new IllegalArgumentException("key is null");
        }
        try {
            Object value = this.get(key);
            return value != null ? value.toString() : null;
        } catch (ClassCastException e) {
            logger.error("key not a string: {}", key);
            throw new IllegalArgumentException("key is not a sring", e);
        }
    }

    public SymbolServiceProperties setValues(SymbolServiceProperties list) {
        if (list == null) {
            logger.error("attribute list is null");
            throw new IllegalArgumentException("attribute list is null");
        }

        Set<Map.Entry<String, Object>> entries = list.entrySet();
        entries.forEach(entry -> {
            this.put(entry.getKey(), entry.getValue());
        });

        return this;
    }
}
