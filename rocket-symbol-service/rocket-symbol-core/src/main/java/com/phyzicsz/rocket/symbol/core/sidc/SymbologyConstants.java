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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Defines constants used by the 2525 symbology classes.
 *
 * @author phyzicsz <phyzics.z@gmail.com>
 */
public interface SymbologyConstants {

    /**
     * The MIL-STD-2525 Additional Information modifier field ID. 
     */
    final String ADDITIONAL_INFORMATION = "H";

    /**
     * The MIL-STD-2525 Altitude/Depth modifier field ID.
     */
    final String ALTITUDE_DEPTH = "X";

    /**
     * The MIL-STD-2525 Auxiliary Equipment Indicator modifier field ID.
     * 
     * <ul> 
     * <li>AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_SHORT</li>
     * <li>AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_LONG</li>
     * </ul>
     */
    final String AUXILIARY_EQUIPMENT = "AG";
    /**
     * The MIL-STD-2525 Towed Sonar Array (Long) auxiliary equipment code.
     */
    final String AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_LONG = "NL";
    /**
     * The MIL-STD-2525 Towed Sonar Array (Short) auxiliary equipment code.
     */
    final String AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_SHORT = "NS";
    /**
     * List containing all recognized MIL-STD-2525 auxiliary equipment codes.
     */
    final List<String> AUXILIARY_EQUIPMENT_ALL = Collections.unmodifiableList(
            Arrays.asList(
            AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_SHORT,
            AUXILIARY_EQUIPMENT_TOWED_SONAR_ARRAY_LONG
    ));

    /**
     * The MIL-STD-2525 Azimuth modifier field ID.
     */
    final String AZIMUTH = "AN";

    
    /**
     * The MIL-STD-2525 Air battle dimension code.
     */
    final String BATTLE_DIMENSION_AIR = "A";
    /**
     * The MIL-STD-2525 Ground battle dimension code.
     */
    final String BATTLE_DIMENSION_GROUND = "G";
    /**
     * The MIL-STD-2525 Other battle dimension code.
     */
    final String BATTLE_DIMENSION_OTHER = "X";
    /**
     * The MIL-STD-2525 Sea Subsurface battle dimension code.
     */
    final String BATTLE_DIMENSION_SEA_SUBSURFACE = "U";
    /**
     * The MIL-STD-2525 Sea Surface battle dimension code.
     */
    final String BATTLE_DIMENSION_SEA_SURFACE = "S";
    /**
     * The MIL-STD-2525 Special Operations Forces (SOF) battle dimension code.
     */
    final String BATTLE_DIMENSION_SOF = "F";
    /**
     * The MIL-STD-2525 Space battle dimension code.
     */
    final String BATTLE_DIMENSION_SPACE = "P";
    /**
     * The MIL-STD-2525 Unknown battle dimension code.
     */
    final String BATTLE_DIMENSION_UNKNOWN = "Z";
    /**
     * List containing all recognized MIL-STD-2525 battle dimension codes.
     */
    final List<String> BATTLE_DIMENSION_ALL = Collections.unmodifiableList(Arrays.asList(
            BATTLE_DIMENSION_UNKNOWN,
            BATTLE_DIMENSION_SPACE,
            BATTLE_DIMENSION_AIR,
            BATTLE_DIMENSION_GROUND,
            BATTLE_DIMENSION_SEA_SURFACE,
            BATTLE_DIMENSION_SEA_SUBSURFACE,
            BATTLE_DIMENSION_SOF,
            BATTLE_DIMENSION_OTHER
    ));
    /**
     * List containing all recognized MIL-STD-2525 battle dimension codes for
     * the Signals Intelligence scheme.
     */
    final List<String> BATTLE_DIMENSION_ALL_INTELLIGENCE = Collections.unmodifiableList(Arrays.asList(
            BATTLE_DIMENSION_UNKNOWN,
            BATTLE_DIMENSION_SPACE,
            BATTLE_DIMENSION_AIR,
            BATTLE_DIMENSION_GROUND,
            BATTLE_DIMENSION_SEA_SURFACE,
            BATTLE_DIMENSION_SEA_SUBSURFACE,
            BATTLE_DIMENSION_OTHER
    ));

    
    /**
     * The MIL-STD-2525 Command and Control General Maneuver category code, used
     * by symbols belonging to the Tactical Graphics scheme.
     */
    final String CATEGORY_COMMAND_CONTROL_GENERAL_MANEUVER = "G";
    /**
     * The MIL-STD-2525 Combat Service Support category code, used by symbols
     * belonging to the Tactical Graphics scheme.
     */
    final String CATEGORY_COMBAT_SERVICE_SUPPORT = "S";
    /**
     * The MIL-STD-2525 Fire Support category code, used by symbols belonging to
     * the Tactical Graphics scheme.
     */
    final String CATEGORY_FIRE_SUPPORT = "F";
    /**
     * The MIL-STD-2525 Incident category code, used by symbols belonging to the
     * Emergency Management scheme.
     */
    final String CATEGORY_INCIDENT = "I";
    /**
     * The MIL-STD-2525 Individual category code, used by symbols belonging to
     * the Stability Operations scheme.
     */
    final String CATEGORY_INDIVIDUAL = "P";
    /**
     * The MIL-STD-2525 Infrastructure category code, used by symbols belonging
     * to the Emergency Management scheme.
     */
    final String CATEGORY_INFRASTRUCTURE = "F";
    /**
     * The MIL-STD-2525 Items category code, used by symbols belonging to the
     * Stability Operations scheme.
     */
    final String CATEGORY_ITEMS = "I";
    /**
     * The MIL-STD-2525 Locations category code, used by symbols belonging to
     * the Stability Operations scheme.
     */
    final String CATEGORY_LOCATIONS = "L";
    /**
     * The MIL-STD-2525 Mobility/Survivability category code, used by symbols
     * belonging to the Tactical Graphics scheme.
     */
    final String CATEGORY_MOBILITY_SURVIVABILITY = "M";
    /**
     * The MIL-STD-2525 Natural Events category code, used by symbols belonging
     * to the Emergency Management scheme.
     */
    final String CATEGORY_NATURAL_EVENTS = "N";
    /**
     * The MIL-STD-2525 Non-Military Group or Organization category code, used
     * by symbols belonging to the Stability Operations scheme.
     */
    final String CATEGORY_NONMILITARY_GROUP_ORGANIZATION = "G";
    /**
     * The MIL-STD-2525 Operations category code, used by symbols belonging to
     * the Stability Operations and Emergency Management schemes.
     */
    final String CATEGORY_OPERATIONS = "O";
    /**
     * The MIL-STD-2525 Other category code, used by symbols belonging to the
     * Tactical Graphics scheme.
     */
    final String CATEGORY_OTHER = "O";
    /**
     * The MIL-STD-2525 Rape category code, used by symbols belonging to the
     * Stability Operations scheme.
     */
    final String CATEGORY_RAPE = "R";
    /**
     * The MIL-STD-2525 Tasks category code, used by symbols belonging to the
     * Tactical Graphics scheme.
     */
    final String CATEGORY_TASKS = "T";
    /**
     * The MIL-STD-2525 Violent Activities category code, used by symbols
     * belonging to the Stability Operations scheme.
     */
    final String CATEGORY_VIOLENT_ACTIVITIES = "V";

    /**
     * The MIL-STD-2525 Atmospheric category code, used by symbols belonging to
     * the METOC scheme.
     */
    final String CATEGORY_ATMOSPHERIC = "A";
    /**
     * The MIL-STD-2525 Oceanic category code, used by symbols belonging to the
     * METOC scheme.
     */
    final String CATEGORY_OCEANIC = "O";
    /**
     * The MIL-STD-2525 Space category code, used by symbols belonging to the
     * METOC scheme.
     */
    final String CATEGORY_SPACE = "S";

    /**
     * List containing all recognized MIL-STD-2525 category codes.
     */
    final List<String> CATEGORY_ALL = Collections.unmodifiableList(Arrays.asList(
            // Tactical Graphics category codes.
            CATEGORY_TASKS,
            CATEGORY_COMMAND_CONTROL_GENERAL_MANEUVER,
            CATEGORY_MOBILITY_SURVIVABILITY,
            CATEGORY_FIRE_SUPPORT,
            CATEGORY_COMBAT_SERVICE_SUPPORT,
            CATEGORY_OTHER,
            // Stability Operations category codes.
            CATEGORY_VIOLENT_ACTIVITIES,
            CATEGORY_LOCATIONS,
            CATEGORY_OPERATIONS,
            CATEGORY_ITEMS,
            CATEGORY_INDIVIDUAL,
            CATEGORY_NONMILITARY_GROUP_ORGANIZATION,
            CATEGORY_RAPE,
            // Emergency Management category codes (CATEGORY_OPERATIONS already included from Tactical Graphics).
            CATEGORY_INCIDENT,
            CATEGORY_NATURAL_EVENTS,
            CATEGORY_INFRASTRUCTURE,
            // METOC category codes
            CATEGORY_ATMOSPHERIC,
            CATEGORY_OCEANIC,
            CATEGORY_SPACE
    ));
    /**
     * List containing all recognized MIL-STD-2525 category codes for the
     * Tactical Graphics scheme.
     */
    final List<String> CATEGORY_ALL_TACTICAL_GRAPHICS = Collections.unmodifiableList(Arrays.asList(
            CATEGORY_TASKS,
            CATEGORY_COMMAND_CONTROL_GENERAL_MANEUVER,
            CATEGORY_MOBILITY_SURVIVABILITY,
            CATEGORY_FIRE_SUPPORT,
            CATEGORY_COMBAT_SERVICE_SUPPORT,
            CATEGORY_OTHER
    ));
    /**
     * List containing all recognized MIL-STD-2525 category codes for the
     * Stability Operations scheme.
     */
    final List<String> CATEGORY_ALL_STABILITY_OPERATIONS = Collections.unmodifiableList(Arrays.asList(
            CATEGORY_VIOLENT_ACTIVITIES,
            CATEGORY_LOCATIONS,
            CATEGORY_OPERATIONS,
            CATEGORY_ITEMS,
            CATEGORY_INDIVIDUAL,
            CATEGORY_NONMILITARY_GROUP_ORGANIZATION,
            CATEGORY_RAPE
    ));
    /**
     * List containing all recognized MIL-STD-2525 category codes for the
     * Emergency Management scheme.
     */
    final List<String> CATEGORY_ALL_EMERGENCY_MANAGEMENT = Collections.unmodifiableList(Arrays.asList(
            CATEGORY_INCIDENT,
            CATEGORY_NATURAL_EVENTS,
            CATEGORY_OPERATIONS,
            CATEGORY_INFRASTRUCTURE
    ));
    /**
     * List containing all recognized MIL-STD-2525 category codes for the
     * Meteorological and Oceanographic scheme.
     */
    final List<String> CATEGORY_ALL_METOC = Collections.unmodifiableList(Arrays.asList(
            CATEGORY_ATMOSPHERIC,
            CATEGORY_OCEANIC,
            CATEGORY_SPACE
    ));

    /**
     * The MIL-STD-2525 Combat Effectiveness modifier field ID.
     */
    final String COMBAT_EFFECTIVENESS = "K";

    

    /**
     * The MIL-STD-2525 Date Time Group (DTG) modifier field ID. Displays a time
     * in the DTG format "DDHHMMSSZMONYYYY" or "O/O" for on order.
     */
    final String DATE_TIME_GROUP = "W";
    /**
     * The MIL-STD-2525 Direction of Movement Indicator modifier field ID.
     * Indicates the direction of movement or intended movement of an object.
     */
    final String DIRECTION_OF_MOVEMENT = "Q";

    /**
     * The MIL-STD-2525 Distance modifier field ID. Indicates a distance in
     * meters (radius, length, width, etc).
     */
    final String DISTANCE = "AM";

    /**
     * The MIL-STD-2525 Echelon modifier field ID. Indicates the echelon code
     * associated with a MIL-STD-2525 symbol (SIDC position 12).
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
     */
    final String ECHELON = "B";
    /**
     * The MIL-STD-2525 Army echelon code. 
     */
    final String ECHELON_ARMY = "K";
    /**
     * The MIL-STD-2525 Army Group/Front echelon code. 
     */
    final String ECHELON_ARMY_GROUP_FRONT = "L";
    /**
     * The MIL-STD-2525 Battalion/Squadron echelon code.
     */
    final String ECHELON_BATTALION_SQUADRON = "F";
    /**
     * The MIL-STD-2525 Brigade echelon code.
     */
    final String ECHELON_BRIGADE = "H";
    /**
     * The MIL-STD-2525 Command echelon code.
     */
    final String ECHELON_COMMAND = "N";
    /**
     * The MIL-STD-2525 Company/Battery/Troop echelon code.
     */
    final String ECHELON_COMPANY_BATTERY_TROOP = "E";
    /**
     * The MIL-STD-2525 Corps echelon code.
     */
    final String ECHELON_CORPS = "J";
    /**
     * The MIL-STD-2525 Division echelon code.
     */
    final String ECHELON_DIVISION = "I";
    /**
     * The MIL-STD-2525 Platoon/Detachment echelon code.
     */
    final String ECHELON_PLATOON_DETACHMENT = "D";
    /**
     * The MIL-STD-2525 Section echelon code.
     */
    final String ECHELON_SECTION = "C";
    /**
     * The MIL-STD-2525 Squad echelon code.
     */
    final String ECHELON_SQUAD = "B";
    /**
     * The MIL-STD-2525 Team/Crew echelon code.
     */
    final String ECHELON_TEAM_CREW = "A";
    /**
     * The MIL-STD-2525 Regiment/Group echelon code.
     */
    final String ECHELON_REGIMENT_GROUP = "G";
    /**
     * The MIL-STD-2525 Region echelon code.
     */
    final String ECHELON_REGION = "M";
    /**
     * List containing all recognized MIL-STD-2525 echelon codes.
     */
    final List<String> ECHELON_ALL = Collections.unmodifiableList(Arrays.asList(
            ECHELON_TEAM_CREW,
            ECHELON_SQUAD,
            ECHELON_SECTION,
            ECHELON_PLATOON_DETACHMENT,
            ECHELON_COMPANY_BATTERY_TROOP,
            ECHELON_BATTALION_SQUADRON,
            ECHELON_REGIMENT_GROUP,
            ECHELON_BRIGADE,
            ECHELON_DIVISION,
            ECHELON_CORPS,
            ECHELON_ARMY,
            ECHELON_ARMY_GROUP_FRONT,
            ECHELON_REGION,
            ECHELON_COMMAND
    ));

    /**
     * The MIL-STD-2525 Evaluation Rating modifier field ID. Indicates the
     * reliability and credibility of a unit, equipment, or installation. When
     * used as a key, the corresponding value must be a string containing two
     * characters.
     * <p>
     * The first character indicates the reliability rating, and must be one of
     * the following: 
     * <ul> 
     * <li>"A" - completely reliable</li> 
     * <li>"B" - usually reliable</li> 
     * <li>"C" - fairly reliable</li> 
     * <li>"D" - not usually reliable</li>
     * <li>"E" - unreliable</li> 
     * <li>"F" - reliability cannot be judged</li>
     * </ul>
     * <p>
     * The second character indicates the credibility rating, and must be one of
     * the following: 
     * <ul> 
     * <li>"1" - confirmed by other sources</li> 
     * <li>"2" - probably true</li> 
     * <li>"3" - possibly true</li> 
     * <li>"4" - doubtfully true</li>
     * <li>"5" - improbable</li> 
     * <li>"6" - truth cannot be judged</li> 
     * </ul>
     */
    final String EVALUATION_RATING = "J";

    /**
     * The MIL-STD-2525 Feint/Dummy Indicator modifier field ID. Indicates
     * whether a MIL-STD-2525 symbol's represented object is a feint/dummy.
     * <p>
     * The following symbology schemes support the feint/dummy modifier:
     * <ul> 
     * <li>Warfighting</li> 
     * <li>Stability Operations</li> 
     * </ul>
     */
    final String FEINT_DUMMY = "AB";

    /**
     * The MIL-STD-2525 Frame Shape modifier field ID. Indicates standard
     * identity, battle dimension, or exercise amplifying descriptors of an
     * object.
     */
    final String FRAME_SHAPE = "E";

    final String FRAME_SHAPE_EXERCISE = "X";

    final String FRAME_SHAPE_JOKER = "J";

    final String FRAME_SHAPE_FAKER = "K";

    

    
    /**
     * The MIL-STD-2525 Point type, used by symbols belonging to the METOC
     * scheme.
     */
    final String GRAPHIC_TYPE_POINT = "P--";
    /**
     * The MIL-STD-2525 Line type, used by symbols belonging to the METOC
     * scheme.
     */
    final String GRAPHIC_TYPE_LINE = "-L-";
    /**
     * The MIL-STD-2525 Area type, used by symbols belonging to the METOC
     * scheme.
     */
    final String GRAPHIC_TYPE_AREA = "--A";
    final List<String> GRAPHIC_TYPE_ALL = Collections.unmodifiableList(Arrays.asList(
            GRAPHIC_TYPE_POINT,
            GRAPHIC_TYPE_LINE,
            GRAPHIC_TYPE_AREA
    ));

    /**
     * The MIL-STD-2525 Headquarters modifier field ID. Indicates whether a
     * MIL-STD-2525 symbol's represented object is a headquarters. A
     * headquarters symbol indicates the headquarters associated with a unit,
     * equipment, or installation. When a marked as an headquarters, a symbol's
     * graphic is changed to include a line extending downward from the left
     * side of its frame. 
     * <p>
     * The following symbology schemes support the headquarters modifier:
     * <ul> 
     * <li>Warfighting</li> 
     * <li>Stability Operations</li> 
     * </ul>
     */
    final String HEADQUARTERS = "S";

    /**
     * The MIL-STD-2525 Higher Formation modifier field ID. Indicates the number
     * or title of higher echelon command. 
     */
    final String HIGHER_FORMATION = "M";

    /**
     * String (ENY) that is displayed as part of MIL-STD-2525 graphics that
     * depict hostile entities.
     */
    final String HOSTILE_ENEMY = "ENY";

    /**
     * The MIL-STD-2525 IFF/SIF modifier field ID. Indicates an IFF/SIF
     * identification mode or code.
     */
    final String IFF_SIF = "P";

    /**
     * The MIL-STD-2525 Installation modifier field ID. Indicates the
     * installation code associated with a MIL-STD-2525 symbol (SIDC positions
     * 11-12). When a marked as an installation, a symbol's represented object
     * is a military camp or base. 
     * When used as a key, the corresponding value must be one of the following:
     * <ul> 
     * <li>INSTALLATION_NORMAL</li> 
     * <li>INSTALLATION_FEINT_DUMMY</li>  
     * </ul>
     */
    final String INSTALLATION = "AC";
    /**
     * The MIL-STD-2525 Normal (as opposed to Feint/Dummy) installation code.
     */
    final String INSTALLATION_NORMAL = "H-";
    /**
     * The MIL-STD-2525 Feint/Dummy installation code. 
     */
    final String INSTALLATION_FEINT_DUMMY = "HB";
    /**
     * List containing all recognized MIL-STD-2525 installation codes.
     */
    final List<String> INSTALLATION_ALL = Collections.unmodifiableList(Arrays.asList(
            INSTALLATION_NORMAL,
            INSTALLATION_FEINT_DUMMY
    ));

    /**
     * The MIL-STD-2525 Location modifier field ID. Indicates a symbol's
     * location in any desired display format. 
     */
    final String LOCATION = "Y";

    /**
     * The MIL-STD-2525 Mobility Indicator modifier field ID. Indicates the
     * equipment mobility code associated with a MIL-STD-2525 symbol (SIDC
     * positions 11-12). 
     * <ul> 
     * <li>MOBILITY_WHEELED</li> 
     * <li>MOBILITY_CROSS_COUNTRY</li>
     * <li>MOBILITY_TRACKED</li>
     * <li>MOBILITY_WHEELED_TRACKED_COMBINATION</li> 
     * <li>MOBILITY_TOWED</li>
     * <li>MOBILITY_RAIL</li>
     * <li>MOBILITY_OVER_THE_SNOW</li> 
     * <li>MOBILITY_SLED</li>
     * <li>MOBILITY_PACK_ANIMALS</li> 
     * <li>MOBILITY_BARGE</li>
     * <li>MOBILITY_AMPHIBIOUS</li> 
     * </ul>
     * 
     */
    final String MOBILITY = "R";
    /**
     * The MIL-STD-2525 Amphibious Mobility mobility code. 
     */
    final String MOBILITY_AMPHIBIOUS = "MY";
    /**
     * The MIL-STD-2525 Barge mobility code. 
     */
    final String MOBILITY_BARGE = "MX";
    /**
     * The MIL-STD-2525 Cross Country mobility code. 
     */
    final String MOBILITY_CROSS_COUNTRY = "MP";
    /**
     * The MIL-STD-2525 Over The Snow mobility code. 
     */
    final String MOBILITY_OVER_THE_SNOW = "MU";
    /**
     * The MIL-STD-2525 Pack Animals mobility code. 
     */
    final String MOBILITY_PACK_ANIMALS = "MW";
    /**
     * The MIL-STD-2525 Rail mobility code. 
     */
    final String MOBILITY_RAIL = "MT";
    /**
     * The MIL-STD-2525 Sled mobility code. 
     */
    final String MOBILITY_SLED = "MV";
    /**
     * The MIL-STD-2525 Towed mobility code. 
     */
    final String MOBILITY_TOWED = "MS";
    /**
     * The MIL-STD-2525 Tracked mobility code. 
     */
    final String MOBILITY_TRACKED = "MQ";
    /**
     * The MIL-STD-2525 Wheeled/Limited Cross Country mobility code. 
     */
    final String MOBILITY_WHEELED = "MO";
    /**
     * The MIL-STD-2525 Wheeled And Tracked Combination mobility code. 
     */
    final String MOBILITY_WHEELED_TRACKED_COMBINATION = "MR";
    /**
     * List containing all recognized MIL-STD-2525 mobility codes.
     */
    final List<String> MOBILITY_ALL = Collections.unmodifiableList(Arrays.asList(
            MOBILITY_WHEELED,
            MOBILITY_CROSS_COUNTRY,
            MOBILITY_TRACKED,
            MOBILITY_WHEELED_TRACKED_COMBINATION,
            MOBILITY_TOWED,
            MOBILITY_RAIL,
            MOBILITY_OVER_THE_SNOW,
            MOBILITY_SLED,
            MOBILITY_PACK_ANIMALS,
            MOBILITY_BARGE,
            MOBILITY_AMPHIBIOUS
    ));

    /**
     * The MIL-STD-2525 feint/dummy units and equipment symbol modifier code.
     * Indicates a symbol that is a feint/dummy. Appears in SIDC position 11.
     */
    final String MODIFIER_CODE_FEINT_DUMMY = "F";
    /**
     * The MIL-STD-2525 feint/dummy headquarters units and equipment symbol
     * modifier code. Indicates a symbol that is a feint/dummy and a
     * headquarters. Appears in SIDC position 11. 
     */
    final String MODIFIER_CODE_FEINT_DUMMY_HEADQUARTERS = "C";
    /**
     * The MIL-STD-2525 feint/dummy task force units and equipment symbol
     * modifier code. Indicates a symbol that is a feint/dummy and a task force.
     * Appears in SIDC position 11. 
     */
    final String MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE = "G";
    /**
     * The MIL-STD-2525 feint/dummy task force headquarters units and equipment
     * symbol modifier code. Indicates a symbol that is a feint/dummy, a task
     * force, and a headquarters. Appears in SIDC position 11. 
     */
    final String MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE_HEADQUARTERS = "D";
    /**
     * The MIL-STD-2525 headquarters units and equipment symbol modifier code.
     * Indicates a symbol that is a headquarters. Appears in SIDC position 11.
     */
    final String MODIFIER_CODE_HEADQUARTERS = "A";
    /**
     * The MIL-STD-2525 task force units and equipment symbol modifier code.
     * Indicates a symbol that is a task force. Appears in SIDC position 11. 
     */
    final String MODIFIER_CODE_TASK_FORCE = "E";
    /**
     * The MIL-STD-2525 task force headquarters units and equipment symbol
     * modifier code. Indicates a symbol that is a task force and a
     * headquarters. Appears in SIDC position 11. 
     */
    final String MODIFIER_CODE_TASK_FORCE_HEADQUARTERS = "B";
    /**
     * List containing all recognized MIL-STD-2525 units and equipment symbol
     * modifier codes.
     */
    final List<String> MODIFIER_CODE_ALL_UEI = Collections.unmodifiableList(Arrays.asList(
            MODIFIER_CODE_HEADQUARTERS,
            MODIFIER_CODE_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_TASK_FORCE,
            MODIFIER_CODE_FEINT_DUMMY,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE
    ));
    /**
     * List containing all recognized MIL-STD-2525 units and equipment symbol
     * modifier codes that indicate a feint/dummy.
     */
    final List<String> MODIFIER_CODE_ALL_FEINT_DUMMY = Collections.unmodifiableList(Arrays.asList(
            MODIFIER_CODE_FEINT_DUMMY_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE
    ));
    /**
     * List containing all recognized MIL-STD-2525 units and equipment symbol
     * modifier codes that indicate a headquarters.
     */
    final List<String> MODIFIER_CODE_ALL_HEADQUARTERS = Collections.unmodifiableList(Arrays.asList(
            MODIFIER_CODE_HEADQUARTERS,
            MODIFIER_CODE_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE_HEADQUARTERS
    ));
    /**
     * List containing all recognized MIL-STD-2525 units and equipment symbol
     * modifier codes that indicate a task force.
     */
    final List<String> MODIFIER_CODE_ALL_TASK_FORCE = Collections.unmodifiableList(Arrays.asList(
            MODIFIER_CODE_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE_HEADQUARTERS,
            MODIFIER_CODE_TASK_FORCE,
            MODIFIER_CODE_FEINT_DUMMY_TASK_FORCE
    ));

    
    final String OPERATIONAL_CONDITION_DAMAGED = "OD";
    final String OPERATIONAL_CONDITION_DESTROYED = "OX";
    final List<String> OPERATIONAL_CONDITION_ALL = Collections.unmodifiableList(Arrays.asList(
            OPERATIONAL_CONDITION_DAMAGED,
            OPERATIONAL_CONDITION_DESTROYED
    ));

   
    final String OPERATIONAL_CONDITION_ALTERNATE_FULLY_CAPABLE = "PC";
    final String OPERATIONAL_CONDITION_ALTERNATE_DAMAGED = "PD";
    final String OPERATIONAL_CONDITION_ALTERNATE_DESTROYED = "PX";
    final String OPERATIONAL_CONDITION_ALTERNATE_FULL_TO_CAPACITY = "PF";
    final List<String> OPERATIONAL_CONDITION_ALTERNATE_ALL = Collections.unmodifiableList(Arrays.asList(
            OPERATIONAL_CONDITION_ALTERNATE_FULLY_CAPABLE,
            OPERATIONAL_CONDITION_ALTERNATE_DAMAGED,
            OPERATIONAL_CONDITION_ALTERNATE_DESTROYED,
            OPERATIONAL_CONDITION_ALTERNATE_FULL_TO_CAPACITY
    ));

    
    /**
     * The MIL-STD-2525 Air order of battle code.
     */
    final String ORDER_OF_BATTLE_AIR = "A";
    /**
     * The MIL-STD-2525 Civilian order of battle code.
     */
    final String ORDER_OF_BATTLE_CIVILIAN = "C";
    /**
     * The MIL-STD-2525 Control Markings order of battle code.
     */
    final String ORDER_OF_BATTLE_CONTROL_MARKINGS = "X";
    /**
     * The MIL-STD-2525 Electronic order of battle code.
     */
    final String ORDER_OF_BATTLE_ELECTRONIC = "E";
    /**
     * The MIL-STD-2525 Ground order of battle code.
     */
    final String ORDER_OF_BATTLE_GROUND = "G";
    /**
     * The MIL-STD-2525 Maritime order of battle code.
     */
    final String ORDER_OF_BATTLE_MARITIME = "N";
    /**
     * The MIL-STD-2525 Strategic Force Related order of battle code.
     */
    final String ORDER_OF_BATTLE_STRATEGIC_FORCE_RELATED = "S";
    /**
     * List containing all recognized MIL-STD-2525 order of battle codes.
     */
    final List<String> ORDER_OF_BATTLE_ALL = Collections.unmodifiableList(Arrays.asList(
            ORDER_OF_BATTLE_AIR,
            ORDER_OF_BATTLE_CIVILIAN,
            ORDER_OF_BATTLE_CONTROL_MARKINGS,
            ORDER_OF_BATTLE_ELECTRONIC,
            ORDER_OF_BATTLE_GROUND,
            ORDER_OF_BATTLE_MARITIME,
            ORDER_OF_BATTLE_STRATEGIC_FORCE_RELATED
    ));
    /**
     * List containing all recognized MIL-STD-2525 order of battle codes for the
     * Warfighting (UEI), Signals Intelligence (SIGINT), Stability Operations
     * (SO), and Emergency Management (EM) schemes.
     */
    final List<String> ORDER_OF_BATTLE_ALL_UEI_SIGINT_SO_EM = Collections.unmodifiableList(Arrays.asList(
            ORDER_OF_BATTLE_AIR,
            ORDER_OF_BATTLE_ELECTRONIC,
            ORDER_OF_BATTLE_CIVILIAN,
            ORDER_OF_BATTLE_GROUND,
            ORDER_OF_BATTLE_MARITIME,
            ORDER_OF_BATTLE_STRATEGIC_FORCE_RELATED
    ));
    /**
     * List containing all recognized MIL-STD-2525 order of battle codes for the
     * Tactical Graphics scheme.
     */
    final List<String> ORDER_OF_BATTLE_ALL_TACTICAL_GRAPHICS = Collections.unmodifiableList(Arrays.asList(
            ORDER_OF_BATTLE_CONTROL_MARKINGS
    ));

    /**
     * The MIL-STD-2525 Quantity modifier field ID. Indicates the number of
     * items associated with a MIL-STD-2525 symbol.
     */
    final String QUANTITY = "C";

    /**
     * The MIL-STD-2525 Reinforced or Reduced modifier field ID. Indicates
     * whether a unit is reinforced or reduced, or both. When used as a key, the
     * corresponding value must be one of the following values:
     * <ul> 
     * <li>REINFORCED to indicate that the unit is reinforced</li>
     * <li>REDUCED to indicate that the unit is reduced</li>
     * <li>REINFORCED_AND_REDUCED to indicate that the unit is reinforced and
     * reduced</li> 
     * </ul>
     */
    final String REINFORCED_REDUCED = "F";

    final String REINFORCED = "R";

    final String REDUCED = "D";

    final String REINFORCED_AND_REDUCED = "RD";

    /**
     * Indicates the scheme code associated with a MIL-STD-2525 symbol (SIDC
     * position 1). A symbol's scheme defines the specific MIL-STD-2525
     * symbology set that it belongs to. The scheme codes are defined in each
     * appendix of the MIL-STD-2525 specification. When used as a key, the
     * corresponding value must be one of the following:
     * <ul> 
     * <li>SCHEME_WARFIGHTING</li> 
     * <li>SCHEME_TACTICAL_GRAPHICS</li>
     * <li>SCHEME_METOC</li>
     * <li>SCHEME_INTELLIGENCE</li> 
     * <li>SCHEME_STABILITY_OPERATIONS</li>
     * <li>SCHEME_EMERGENCY_MANAGEMENT</li> 
     * </ul>
     */
    final String SCHEME = "SymbolServiceProperties.Scheme";
    /**
     * The MIL-STD-2525 Emergency Management (EM) scheme code.
     */
    final String SCHEME_EMERGENCY_MANAGEMENT = "E";
    /**
     * The MIL-STD-2525 Signals Intelligence (SIGINT) scheme code.
     */
    final String SCHEME_INTELLIGENCE = "I";
    /**
     * The MIL-STD-2525 Meteorological and Oceanographic (METOC) scheme code.
     */
    final String SCHEME_METOC = "W";
    /**
     * The MIL-STD-2525 Stability Operations (SO) scheme code. 
     */
    final String SCHEME_STABILITY_OPERATIONS = "O";
    /**
     * The MIL-STD-2525 Tactical Graphics scheme code. See MIL-STD-2525C table
     * B-I (page 305).
     */
    final String SCHEME_TACTICAL_GRAPHICS = "G";
    /**
     * The MIL-STD-2525 Warfighting scheme code. This scheme is also referred to
     * as Units, Equipment, and Installations (UEI). 
     */
    final String SCHEME_WARFIGHTING = "S";
    /**
     * List containing all recognized MIL-STD-2525 scheme codes.
     */
    final List<String> SCHEME_ALL = Collections.unmodifiableList(Arrays.asList(
            SCHEME_WARFIGHTING,
            SCHEME_TACTICAL_GRAPHICS,
            SCHEME_METOC,
            SCHEME_INTELLIGENCE,
            SCHEME_STABILITY_OPERATIONS,
            SCHEME_EMERGENCY_MANAGEMENT
    ));

    
    /**
     * The MIL-STD-2525 Signature Equipment modifier field ID. Indicates
     * detectable electronic signatures from hostile equipment.
     */
    final String SIGNATURE_EQUIPMENT = "L";

    /**
     * The MIL-STD-2525 Special C2 Headquarters modifier field ID. Indicates a
     * the name of a special Command and Control Headquarters. The name is
     * displayed inside the symbol's frame.
     */
    final String SPECIAL_C2_HEADQUARTERS = "AA";

    /**
     * The MIL-STD-2525 Speed modifier field ID. Indicates a symbol's velocity
     * as defined in MIL-STD-6040.
     */
    final String SPEED = "Z";

    /**
     * The MIL-STD-2525 Speed Leader modifier field ID. Indicates the speed and
     * direction of movement or intended movement of an object.
     */
    final String SPEED_LEADER_SCALE = "AJ";

    /**
     * The MIL-STD-2525 Staff Comments modifier field ID. The meaning of this
     * field is implementation specific.
     */
    final String STAFF_COMMENTS = "G";

   
    /**
     * The MIL-STD-2525 Assumed Friend standard identity code. Indicates a
     * symbol assumed to be a friend because of its characteristics or origin.
     */
    final String STANDARD_IDENTITY_ASSUMED_FRIEND = "A";
    /**
     * The MIL-STD-2525 Exercise Assumed Friend standard identity code.
     * Indicates a symbol acting as an assumed friend for exercise purposes.
     */
    final String STANDARD_IDENTITY_EXERCISE_ASSUMED_FRIEND = "M";
    /**
     * The MIL-STD-2525 Exercise Friend standard identity code. Indicates a
     * symbol acting as a friend for exercise purposes.
     */
    final String STANDARD_IDENTITY_EXERCISE_FRIEND = "D";
    /**
     * The MIL-STD-2525 Exercise Neutral standard identity code. Indicates a
     * symbol acting as neutral for exercise purposes.
     */
    final String STANDARD_IDENTITY_EXERCISE_NEUTRAL = "L";
    /**
     * The MIL-STD-2525 Exercise Pending standard identity code. Indicates a
     * symbol which has not been subject to the identification process for
     * exercise purposes.
     */
    final String STANDARD_IDENTITY_EXERCISE_PENDING = "G";
    /**
     * The MIL-STD-2525 Exercise Unknown standard identity code. Indicates a
     * symbol that as been evaluated but not identified for exercise purposes.
     */
    final String STANDARD_IDENTITY_EXERCISE_UNKNOWN = "W";
    /**
     * The MIL-STD-2525 Faker standard identity code. Indicates a friendly
     * symbol acting as hostile for exercise purposes.
     */
    final String STANDARD_IDENTITY_FAKER = "K";
    /**
     * The MIL-STD-2525 Friend standard identity code. Indicates a symbol
     * belonging to a declared friendly nation.
     */
    final String STANDARD_IDENTITY_FRIEND = "F";
    /**
     * The MIL-STD-2525 Hostile standard identity code. Indicates a symbol
     * belonging to any opposing nation or entity.
     */
    final String STANDARD_IDENTITY_HOSTILE = "H";
    /**
     * The MIL-STD-2525 Joker standard identity code. Indicates a friendly
     * symbol acting as suspect for exercise purposes.
     */
    final String STANDARD_IDENTITY_JOKER = "J";
    /**
     * The MIL-STD-2525 Neutral standard identity code. Indicates a symbol who's
     * characteristics or nationality indicates that it is neither supporting
     * nor opposing friendly forces. 
     */
    final String STANDARD_IDENTITY_NEUTRAL = "N";
    /**
     * The MIL-STD-2525 Pending standard identity code. Indicates a symbol which
     * has not been subject to the identification process.
     */
    final String STANDARD_IDENTITY_PENDING = "P";
    /**
     * The MIL-STD-2525 Suspect standard identity code. Indicates a symbol which
     * is potentially hostile because of its characteristics or nationality.
     */
    final String STANDARD_IDENTITY_SUSPECT = "S";
    /**
     * The MIL-STD-2525 Unknown standard identity code. Indicates a symbol that
     * as been evaluated but not identified.
     */
    final String STANDARD_IDENTITY_UNKNOWN = "U";
    /**
     * List containing all recognized MIL-STD-2525 standard identity codes.
     */
    final List<String> STANDARD_IDENTITY_ALL = Collections.unmodifiableList(Arrays.asList(
            STANDARD_IDENTITY_PENDING,
            STANDARD_IDENTITY_UNKNOWN,
            STANDARD_IDENTITY_FRIEND,
            STANDARD_IDENTITY_NEUTRAL,
            STANDARD_IDENTITY_HOSTILE,
            STANDARD_IDENTITY_ASSUMED_FRIEND,
            STANDARD_IDENTITY_SUSPECT,
            STANDARD_IDENTITY_EXERCISE_PENDING,
            STANDARD_IDENTITY_EXERCISE_UNKNOWN,
            STANDARD_IDENTITY_EXERCISE_FRIEND,
            STANDARD_IDENTITY_EXERCISE_NEUTRAL,
            STANDARD_IDENTITY_EXERCISE_ASSUMED_FRIEND,
            STANDARD_IDENTITY_JOKER,
            STANDARD_IDENTITY_FAKER
    ));

   
    /**
     * The MIL-STD-2525 Static, used by symbols belonging to the METOC scheme.
     */
    final String STATIC = "S-";
    /**
     * The MIL-STD-2525 Dynamic, used by symbols belonging to the METOC scheme.
     */
    final String DYNAMIC = "-D";
    final List<String> STATIC_DYNAMIC_ALL = Collections.unmodifiableList(Arrays.asList(
            STATIC,
            DYNAMIC
    ));

    /**
     * The MIL-STD-2525 Status / Operational Condition modifier field ID.
     * Indicates the status code associated with a MIL-STD-2525 symbol (SIDC
     * position 4). A symbol's status defines whether the represented object
     * exists at the time the symbol was generated, or is anticipated to exist
     * in the future. Additionally, a symbol's status can define its operational
     * condition. 
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
     */
    final String STATUS = "AL";
    /**
     * The MIL-STD-2525 Anticipated/Planned status code. Indicates a symbol
     * who's represented object is anticipated to exist at the symbol's
     * location.
     */
    final String STATUS_ANTICIPATED = "A";
    /**
     * The MIL-STD-2525 Known status code. 
     */
    final String STATUS_KNOWN = "K";
    /**
     * The MIL-STD-2525 Present/Fully Capable status code. Indicates a symbol
     * who's represented object currently exists at the symbol's location. 
     */
    final String STATUS_PRESENT = "P";
    /**
     * The MIL-STD-2525 Present/Damaged status code. Indicates a symbol who's
     * represented object is damaged, and currently exists at the symbol's
     * location.
     */
    final String STATUS_DAMAGED = "D";
    /**
     * The MIL-STD-2525 Present/Destroyed status code. Indicates a symbol who's
     * represented object is destroyed, and currently exists at the symbol's
     * location.
     */
    final String STATUS_DESTROYED = "X";
    /**
     * The MIL-STD-2525 Present/Full To Capacity status code. Indicates a symbol
     * who's represented object's capacity is full, and currently exists at the
     * symbol's location.
     */
    final String STATUS_FULL_TO_CAPACITY = "F";
    /**
     * The MIL-STD-2525 Present/Fully Capable status code. Indicates a symbol
     * who's represented object is fully capable, and currently exists at the
     * symbol's location.
     */
    final String STATUS_FULLY_CAPABLE = "C";
    /**
     * The MIL-STD-2525 Suspected status code. Indicates a symbol who's
     * represented object is suspected to exist at the symbol's location.
     */
    final String STATUS_SUSPECTED = "S";
    /**
     * List containing all recognized MIL-STD-2525 status codes.
     */
    final List<String> STATUS_ALL = Collections.unmodifiableList(Arrays.asList(
            // UEI, SIGINT, SO, and EM status codes.
            STATUS_ANTICIPATED,
            STATUS_PRESENT,
            STATUS_FULLY_CAPABLE,
            STATUS_DAMAGED,
            STATUS_DESTROYED,
            STATUS_FULL_TO_CAPACITY,
            // Tactical Graphics and METOC status codes (ANTICIPATED and PRESENT already included).
            STATUS_SUSPECTED,
            STATUS_KNOWN
    ));
    /**
     * List containing all recognized MIL-STD-2525 status codes for the
     * Warfighting (UEI), Signals Intelligence (SIGINT), Stability Operations
     * (SO), and Emergency Management schemes. TODO: EM scheme contradicts
     * itself.
     */
    final List<String> STATUS_ALL_UEI_SIGINT_SO_EM = Collections.unmodifiableList(Arrays.asList(
            STATUS_ANTICIPATED,
            STATUS_PRESENT,
            STATUS_FULLY_CAPABLE,
            STATUS_DAMAGED,
            STATUS_DESTROYED,
            STATUS_FULL_TO_CAPACITY
    ));
    /**
     * List containing all recognized MIL-STD-2525 status codes for the Tactical
     * Graphics and Meteorological and Oceanographic (METOC) scheme.
     */
    final List<String> STATUS_ALL_TACTICAL_GRAPHICS_METOC = Collections.unmodifiableList(Arrays.asList(
            STATUS_ANTICIPATED,
            STATUS_SUSPECTED,
            STATUS_PRESENT,
            STATUS_KNOWN
    ));

    

    /**
     * The MIL-STD-2525 Symbol Indicator modifier field ID. Indicates a symbol
     * to included in a TacticalGraphic.
     */
    final String SYMBOL_INDICATOR = "A";

    /**
     * The MIL-STD-2525 Task Force Indicator modifier field ID. Indicates
     * whether a MIL-STD-2525 symbol's represented object is a task force. When
     * a marked as a task force, a symbol's graphic is changed to include a
     * bracket above its echelon.
     * <p>
     * The following symbology schemes support the task force modifier:
     * <ul> 
     * <li>Warfighting</li> 
     * <li>Stability Operations</li> 
     * </ul>
     */
    final String TASK_FORCE = "D";

    /**
     * The MIL-STD-2525 Type modifier field ID. Indicates types of equipment.
     */
    final String TYPE = "V";

    /**
     * The MIL-STD-2525 Unique Designation modifier field ID. Uniquely
     * identifies a particular symbol or track number. Identifies acquisitions
     * number when used with SIGINT symbology.
     */
    final String UNIQUE_DESIGNATION = "T";
}
