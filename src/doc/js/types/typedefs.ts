
type BlockFace = "north" | "east" | "west" | "south" | "up" | "down";

type Hand = "hand" | "off_hand";

type ArmorSlot = "head" | "chest" | "legs" | "feet";

type EquipmentSlot = Hand | ArmorSlot;

type BlockAction = "left_click_air" | "left_click_block" | "right_click_air" |
                   "right_click_block" | "physical";

type TeleportCause = "chorus_fruit" | "command" | "end_gateway" | "end_portal" | "ender_pearl" |
                     "nether_portal" | "plugin" | "spectate" | "unknown";

type Biome = "badlands" | "badlands_plateau" | "bamboo_jungle" | "bamboo_jungle_hills" |
             "basalt_deltas" | "beach" | "birch_forest" | "birch_forest_hills" |
             "cold_ocean" | "crimson_forest" | "dark_forest" | "dark_forest_hills" |
             "deep_cold_ocean" | "deep_frozen_ocean" | "deep_lukewarm_ocean" |
             "deep_ocean" | "deep_warm_ocean" | "desert" | "desert_hills" |
             "desert_lakes" | "end_barrens" | "end_highlands" | "end_midlands" |
             "eroded_badlands" | "flower_forest" | "forest" | "frozen_ocean" |
             "frozen_river" | "giant_spruce_taiga" | "giant_spruce_taiga_hills" |
             "giant_tree_taiga" | "giant_tree_taiga_hills" | "gravelly_mountains" |
             "ice_spikes" | "jungle" | "jungle_edge" | "jungle_hills" |
             "lukewarm_ocean" | "modified_badlands_plateau" |
             "modified_gravelly_mountains" | "modified_jungle" |
             "modified_jungle_edge" | "modified_wooded_badlands_plateau" |
             "mountain_edge" | "mountains" | "mushroom_field_shore" | "mushroom_fields" |
             "nether_wastes" | "ocean" | "plains" | "river" | "savanna" |
             "savanna_plateau" | "shattered_savanna" | "shattered_savanna_plateau" |
             "small_end_islands" | "snowy_beach" | "snowy_mountains" | "snowy_taiga" |
             "snowy_taiga_hills" | "snowy_taiga_mountains" | "snowy_tundra" |
             "soul_sand_valley" | "stone_shore" | "sunflower_plains" | "swamp" |
             "swamp_hills" | "taiga" | "taiga_hills" | "taiga_mountains" |
             "tall_birch_forest" | "tall_birch_hills" | "the_end" | "the_void" |
             "warm_ocean" | "warped_forest" | "wooded_badlands_plateau" |
             "wooded_hills" | "wooded_mountains";

type PistonReaction = "block" | "break" | "ignore" | "move" | "push_only";
