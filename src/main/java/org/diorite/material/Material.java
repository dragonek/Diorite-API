package org.diorite.material;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.Air;
import org.diorite.material.blocks.Bedrock;
import org.diorite.material.blocks.Cobblestone;
import org.diorite.material.blocks.Dirt;
import org.diorite.material.blocks.Grass;
import org.diorite.material.blocks.Planks;
import org.diorite.material.blocks.Sapling;
import org.diorite.material.blocks.Stone;
import org.diorite.material.blocks.liquid.Lava;
import org.diorite.material.blocks.liquid.Water;
import org.diorite.utils.SimpleEnum;
import org.diorite.utils.collections.SimpleStringHashMap;
import org.diorite.utils.math.IntRange;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

public abstract class Material implements SimpleEnum<Material>
{
    protected static final float SLOW_GROW      = 0.1f;
    public static final    int   MATERIALS_SIZE = 385;

    public static final  Air                     AIR         = Air.AIR;
    public static final  Stone                   STONE       = Stone.STONE;
    public static final  Grass                   GRASS       = Grass.GRASS;
    public static final  Dirt                    DIRT        = Dirt.DIRT;
    public static final  Cobblestone             COBBLESTONE = Cobblestone.COBBLESTONE;
    public static final  Planks                  PLANKS      = Planks.PLANKS_QAK;
    public static final  Sapling                 SAPLING     = Sapling.SAPLING_OAK;
    public static final  Bedrock                 BEDROCK     = Bedrock.BEDROCK;
    public static final  Water                   WATER       = Water.WATER_SOURCE;
    public static final  Lava                    LAVA        = Lava.LAVA_SOURCE;
    //    public static final Material    SAND                       = new Material("SAND", 12);
//    public static final Material    GRAVEL                     = new Material("GRAVEL", 13);
//    public static final Material    GOLD_ORE                   = new Material("GOLD_ORE", 14);
//    public static final Material    IRON_ORE                   = new Material("IRON_ORE", 15);
//    public static final Material    COAL_ORE                   = new Material("COAL_ORE", 16);
//    public static final Material    LOG                        = new Material("LOG", 17);
//    public static final Material    LEAVES                     = new Material("LEAVES", 18);
//    public static final Material    SPONGE                     = new Material("SPONGE", 19);
//    public static final Material    GLASS                      = new Material("GLASS", 20);
//    public static final Material    LAPIS_ORE                  = new Material("LAPIS_ORE", 21);
//    public static final Material    LAPIS_BLOCK                = new Material("LAPIS_BLOCK", 22);
//    public static final Material    DISPENSER                  = new Material("DISPENSER", 23);
//    public static final Material    SANDSTONE                  = new Material("SANDSTONE", 24);
//    public static final Material    NOTE_BLOCK                 = new Material("NOTE_BLOCK", 25);
//    public static final Material    BED_BLOCK                  = new Material("BED_BLOCK", 26);
//    public static final Material    POWERED_RAIL               = new Material("POWERED_RAIL", 27);
//    public static final Material    DETECTOR_RAIL              = new Material("DETECTOR_RAIL", 28);
//    public static final Material    PISTON_STICKY_BASE         = new Material("PISTON_STICKY_BASE", 29);
//    public static final Material    WEB                        = new Material("WEB", 30);
//    public static final Material    LONG_GRASS                 = new Material("LONG_GRASS", 31);
//    public static final Material    DEAD_BUSH                  = new Material("DEAD_BUSH", 32);
//    public static final Material    PISTON_BASE                = new Material("PISTON_BASE", 33);
//    public static final Material    PISTON_EXTENSION           = new Material("PISTON_EXTENSION", 34);
//    public static final Material    WOOL                       = new Material("WOOL", 35);
//    public static final Material    PISTON_MOVING_PIECE        = new Material("PISTON_MOVING_PIECE", 36);
//    public static final Material    YELLOW_FLOWER              = new Material("YELLOW_FLOWER", 37);
//    public static final Material    RED_ROSE                   = new Material("RED_ROSE", 38);
//    public static final Material    BROWN_MUSHROOM             = new Material("BROWN_MUSHROOM", 39);
//    public static final Material    RED_MUSHROOM               = new Material("RED_MUSHROOM", 40);
//    public static final Material    GOLD_BLOCK                 = new Material("GOLD_BLOCK", 41);
//    public static final Material    IRON_BLOCK                 = new Material("IRON_BLOCK", 42);
//    public static final Material    DOUBLE_STEP                = new Material("DOUBLE_STEP", 43);
//    public static final Material    STEP                       = new Material("STEP", 44);
//    public static final Material    BRICK                      = new Material("BRICK", 45);
//    public static final Material    TNT                        = new Material("TNT", 46);
//    public static final Material    BOOKSHELF                  = new Material("BOOKSHELF", 47);
//    public static final Material    MOSSY_COBBLESTONE          = new Material("MOSSY_COBBLESTONE", 48);
//    public static final Material    OBSIDIAN                   = new Material("OBSIDIAN", 49);
//    public static final Material    TORCH                      = new Material("TORCH", 50);
//    public static final Material    FIRE                       = new Material("FIRE", 51);
//    public static final Material    MOB_SPAWNER                = new Material("MOB_SPAWNER", 52);
//    public static final Material    WOOD_STAIRS                = new Material("WOOD_STAIRS", 53);
//    public static final Material    CHEST                      = new Material("CHEST", 54);
//    public static final Material    REDSTONE_WIRE              = new Material("REDSTONE_WIRE", 55);
//    public static final Material    DIAMOND_ORE                = new Material("DIAMOND_ORE", 56);
//    public static final Material    DIAMOND_BLOCK              = new Material("DIAMOND_BLOCK", 57);
//    public static final Material    WORKBENCH                  = new Material("WORKBENCH", 58);
//    public static final Material    CROPS                      = new Material("CROPS", 59);
//    public static final Material    SOIL                       = new Material("SOIL", 60);
//    public static final Material    FURNACE                    = new Material("FURNACE", 61);
//    public static final Material    BURNING_FURNACE            = new Material("BURNING_FURNACE", 62);
//    public static final Material    SIGN_POST                  = new Material("SIGN_POST", 63, 64);
//    public static final Material    WOODEN_DOOR                = new Material("WOODEN_DOOR", 64);
//    public static final Material    LADDER                     = new Material("LADDER", 65);
//    public static final Material    RAILS                      = new Material("RAILS", 66);
//    public static final Material    COBBLESTONE_STAIRS         = new Material("COBBLESTONE_STAIRS", 67);
//    public static final Material    WALL_SIGN                  = new Material("WALL_SIGN", 68, 64);
//    public static final Material    LEVER                      = new Material("LEVER", 69);
//    public static final Material    STONE_PLATE                = new Material("STONE_PLATE", 70);
//    public static final Material    IRON_DOOR_BLOCK            = new Material("IRON_DOOR_BLOCK", 71);
//    public static final Material    WOOD_PLATE                 = new Material("WOOD_PLATE", 72);
//    public static final Material    REDSTONE_ORE               = new Material("REDSTONE_ORE", 73);
//    public static final Material    GLOWING_REDSTONE_ORE       = new Material("GLOWING_REDSTONE_ORE", 74);
//    public static final Material    REDSTONE_TORCH_OFF         = new Material("REDSTONE_TORCH_OFF", 75);
//    public static final Material    REDSTONE_TORCH_ON          = new Material("REDSTONE_TORCH_ON", 76);
//    public static final Material    STONE_BUTTON               = new Material("STONE_BUTTON", 77);
//    public static final Material    SNOW                       = new Material("SNOW", 78);
//    public static final Material    ICE                        = new Material("ICE", 79);
//    public static final Material    SNOW_BLOCK                 = new Material("SNOW_BLOCK", 80);
//    public static final Material    CACTUS                     = new Material("CACTUS", 81);
//    public static final Material    CLAY                       = new Material("CLAY", 82);
//    public static final Material    SUGAR_CANE_BLOCK           = new Material("SUGAR_CANE_BLOCK", 83);
//    public static final Material    JUKEBOX                    = new Material("JUKEBOX", 84);
//    public static final Material    FENCE                      = new Material("FENCE", 85);
//    public static final Material    PUMPKIN                    = new Material("PUMPKIN", 86);
//    public static final Material    NETHERRACK                 = new Material("NETHERRACK", 87);
//    public static final Material    SOUL_SAND                  = new Material("SOUL_SAND", 88);
//    public static final Material    GLOWSTONE                  = new Material("GLOWSTONE", 89);
//    public static final Material    PORTAL                     = new Material("PORTAL", 90);
//    public static final Material    JACK_O_LANTERN             = new Material("JACK_O_LANTERN", 91);
//    public static final Material    CAKE_BLOCK                 = new Material("CAKE_BLOCK", 92, 64);
//    public static final Material    DIODE_BLOCK_OFF            = new Material("DIODE_BLOCK_OFF", 93);
//    public static final Material    DIODE_BLOCK_ON             = new Material("DIODE_BLOCK_ON", 94);
//    public static final Material    STAINED_GLASS              = new Material("STAINED_GLASS", 95);
//    public static final Material    TRAP_DOOR                  = new Material("TRAP_DOOR", 96);
//    public static final Material    MONSTER_EGGS               = new Material("MONSTER_EGGS", 97);
//    public static final Material    SMOOTH_BRICK               = new Material("SMOOTH_BRICK", 98);
//    public static final Material    HUGE_MUSHROOM_1            = new Material("HUGE_MUSHROOM_1", 99);
//    public static final Material    HUGE_MUSHROOM_2            = new Material("HUGE_MUSHROOM_2", 100);
//    public static final Material    IRON_FENCE                 = new Material("IRON_FENCE", 101);
//    public static final Material    THIN_GLASS                 = new Material("THIN_GLASS", 102);
//    public static final Material    MELON_BLOCK                = new Material("MELON_BLOCK", 103);
//    public static final Material    PUMPKIN_STEM               = new Material("PUMPKIN_STEM", 104);
//    public static final Material    MELON_STEM                 = new Material("MELON_STEM", 105);
//    public static final Material    VINE                       = new Material("VINE", 106);
//    public static final Material    FENCE_GATE                 = new Material("FENCE_GATE", 107);
//    public static final Material    BRICK_STAIRS               = new Material("BRICK_STAIRS", 108);
//    public static final Material    SMOOTH_STAIRS              = new Material("SMOOTH_STAIRS", 109);
//    public static final Material    MYCEL                      = new Material("MYCEL", 110);
//    public static final Material    WATER_LILY                 = new Material("WATER_LILY", 111);
//    public static final Material    NETHER_BRICK               = new Material("NETHER_BRICK", 112);
//    public static final Material    NETHER_FENCE               = new Material("NETHER_FENCE", 113);
//    public static final Material    NETHER_BRICK_STAIRS        = new Material("NETHER_BRICK_STAIRS", 114);
//    public static final Material    NETHER_WARTS               = new Material("NETHER_WARTS", 115);
//    public static final Material    ENCHANTMENT_TABLE          = new Material("ENCHANTMENT_TABLE", 116);
//    public static final Material    BREWING_STAND              = new Material("BREWING_STAND", 117);
//    public static final Material    CAULDRON                   = new Material("CAULDRON", 118);
//    public static final Material    ENDER_PORTAL               = new Material("ENDER_PORTAL", 119);
//    public static final Material    ENDER_PORTAL_FRAME         = new Material("ENDER_PORTAL_FRAME", 120);
//    public static final Material    ENDER_STONE                = new Material("ENDER_STONE", 121);
//    public static final Material    DRAGON_EGG                 = new Material("DRAGON_EGG", 122);
//    public static final Material    REDSTONE_LAMP_OFF          = new Material("REDSTONE_LAMP_OFF", 123);
//    public static final Material    REDSTONE_LAMP_ON           = new Material("REDSTONE_LAMP_ON", 124);
//    public static final Material    WOOD_DOUBLE_STEP           = new Material("WOOD_DOUBLE_STEP", 125);
//    public static final Material    WOOD_STEP                  = new Material("WOOD_STEP", 126);
//    public static final Material    COCOA                      = new Material("COCOA", 127);
//    public static final Material    SANDSTONE_STAIRS           = new Material("SANDSTONE_STAIRS", 128);
//    public static final Material    EMERALD_ORE                = new Material("EMERALD_ORE", 129);
//    public static final Material    ENDER_CHEST                = new Material("ENDER_CHEST", 130);
//    public static final Material    TRIPWIRE_HOOK              = new Material("TRIPWIRE_HOOK", 131);
//    public static final Material    TRIPWIRE                   = new Material("TRIPWIRE", 132);
//    public static final Material    EMERALD_BLOCK              = new Material("EMERALD_BLOCK", 133);
//    public static final Material    SPRUCE_WOOD_STAIRS         = new Material("SPRUCE_WOOD_STAIRS", 134);
//    public static final Material    BIRCH_WOOD_STAIRS          = new Material("BIRCH_WOOD_STAIRS", 135);
//    public static final Material    JUNGLE_WOOD_STAIRS         = new Material("JUNGLE_WOOD_STAIRS", 136);
//    public static final Material    COMMAND                    = new Material("COMMAND", 137);
//    public static final Material    BEACON                     = new Material("BEACON", 138);
//    public static final Material    COBBLE_WALL                = new Material("COBBLE_WALL", 139);
//    public static final Material    FLOWER_POT                 = new Material("FLOWER_POT", 140);
//    public static final Material    CARROT                     = new Material("CARROT", 141);
//    public static final Material    POTATO                     = new Material("POTATO", 142);
//    public static final Material    WOOD_BUTTON                = new Material("WOOD_BUTTON", 143);
//    public static final Material    SKULL                      = new Material("SKULL", 144);
//    public static final Material    ANVIL                      = new Material("ANVIL", 145);
//    public static final Material    TRAPPED_CHEST              = new Material("TRAPPED_CHEST", 146);
//    public static final Material    GOLD_PLATE                 = new Material("GOLD_PLATE", 147);
//    public static final Material    IRON_PLATE                 = new Material("IRON_PLATE", 148);
//    public static final Material    REDSTONE_COMPARATOR_OFF    = new Material("REDSTONE_COMPARATOR_OFF", 149);
//    public static final Material    REDSTONE_COMPARATOR_ON     = new Material("REDSTONE_COMPARATOR_ON", 150);
//    public static final Material    DAYLIGHT_DETECTOR          = new Material("DAYLIGHT_DETECTOR", 151);
//    public static final Material    REDSTONE_BLOCK             = new Material("REDSTONE_BLOCK", 152);
//    public static final Material    QUARTZ_ORE                 = new Material("QUARTZ_ORE", 153);
//    public static final Material    HOPPER                     = new Material("HOPPER", 154);
//    public static final Material    QUARTZ_BLOCK               = new Material("QUARTZ_BLOCK", 155);
//    public static final Material    QUARTZ_STAIRS              = new Material("QUARTZ_STAIRS", 156);
//    public static final Material    ACTIVATOR_RAIL             = new Material("ACTIVATOR_RAIL", 157);
//    public static final Material    DROPPER                    = new Material("DROPPER", 158);
//    public static final Material    STAINED_CLAY               = new Material("STAINED_CLAY", 159);
//    public static final Material    STAINED_GLASS_PANE         = new Material("STAINED_GLASS_PANE", 160);
//    public static final Material    LEAVES_2                   = new Material("LEAVES_2", 161);
//    public static final Material    LOG_2                      = new Material("LOG_2", 162);
//    public static final Material    ACACIA_STAIRS              = new Material("ACACIA_STAIRS", 163);
//    public static final Material    DARK_OAK_STAIRS            = new Material("DARK_OAK_STAIRS", 164);
//    public static final Material    SLIME_BLOCK                = new Material("SLIME_BLOCK", 165);
//    public static final Material    BARRIER                    = new Material("BARRIER", 166);
//    public static final Material    IRON_TRAPDOOR              = new Material("IRON_TRAPDOOR", 167);
//    public static final Material    PRISMARINE                 = new Material("PRISMARINE", 168);
//    public static final Material    SEA_LANTERN                = new Material("SEA_LANTERN", 169);
//    public static final Material    HAY_BLOCK                  = new Material("HAY_BLOCK", 170);
//    public static final Material    CARPET                     = new Material("CARPET", 171);
//    public static final Material    HARD_CLAY                  = new Material("HARD_CLAY", 172);
//    public static final Material    COAL_BLOCK                 = new Material("COAL_BLOCK", 173);
//    public static final Material    PACKED_ICE                 = new Material("PACKED_ICE", 174);
//    public static final Material    DOUBLE_PLANT               = new Material("DOUBLE_PLANT", 175);
//    public static final Material    STANDING_BANNER            = new Material("STANDING_BANNER", 176);
//    public static final Material    WALL_BANNER                = new Material("WALL_BANNER", 177);
//    public static final Material    DAYLIGHT_DETECTOR_INVERTED = new Material("DAYLIGHT_DETECTOR_INVERTED", 178);
//    public static final Material    RED_SANDSTONE              = new Material("RED_SANDSTONE", 179);
//    public static final Material    RED_SANDSTONE_STAIRS       = new Material("RED_SANDSTONE_STAIRS", 180);
//    public static final Material    DOUBLE_STONE_SLAB2         = new Material("DOUBLE_STONE_SLAB2", 181);
//    public static final Material    STONE_SLAB2                = new Material("STONE_SLAB2", 182);
//    public static final Material    SPRUCE_FENCE_GATE          = new Material("SPRUCE_FENCE_GATE", 183);
//    public static final Material    BIRCH_FENCE_GATE           = new Material("BIRCH_FENCE_GATE", 184);
//    public static final Material    JUNGLE_FENCE_GATE          = new Material("JUNGLE_FENCE_GATE", 185);
//    public static final Material    DARK_OAK_FENCE_GATE        = new Material("DARK_OAK_FENCE_GATE", 186);
//    public static final Material    ACACIA_FENCE_GATE          = new Material("ACACIA_FENCE_GATE", 187);
//    public static final Material    SPRUCE_FENCE               = new Material("SPRUCE_FENCE", 188);
//    public static final Material    BIRCH_FENCE                = new Material("BIRCH_FENCE", 189);
//    public static final Material    JUNGLE_FENCE               = new Material("JUNGLE_FENCE", 190);
//    public static final Material    DARK_OAK_FENCE             = new Material("DARK_OAK_FENCE", 191);
//    public static final Material    ACACIA_FENCE               = new Material("ACACIA_FENCE", 192);
//    public static final Material    SPRUCE_DOOR                = new Material("SPRUCE_DOOR", 193);
//    public static final Material    BIRCH_DOOR                 = new Material("BIRCH_DOOR", 194);
//    public static final Material    JUNGLE_DOOR                = new Material("JUNGLE_DOOR", 195);
//    public static final Material    ACACIA_DOOR                = new Material("ACACIA_DOOR", 196);
//    public static final Material    DARK_OAK_DOOR              = new Material("DARK_OAK_DOOR", 197);
    // ----- Item Separator -----
    //    public static final  Material                IRON_SPADE           = new Material("IRON_SPADE", 256, 1, 250);
//    public static final  Material                IRON_PICKAXE         = new Material("IRON_PICKAXE", 257, 1, 250);
//    public static final  Material                IRON_AXE             = new Material("IRON_AXE", 258, 1, 250);
//    public static final  Material                FLINT_AND_STEEL      = new Material("FLINT_AND_STEEL", 259, 1, 64);
//    public static final  Material                APPLE                = new Material("APPLE", 260);
//    public static final  Material                BOW                  = new Material("BOW", 261, 1, 384);
//    public static final  Material                ARROW                = new Material("ARROW", 262);
//    public static final  Material                COAL                 = new Material("COAL", 263);
//    public static final  Material                DIAMOND              = new Material("DIAMOND", 264);
//    public static final  Material                IRON_INGOT           = new Material("IRON_INGOT", 265);
//    public static final  Material                GOLD_INGOT           = new Material("GOLD_INGOT", 266);
//    public static final  Material                IRON_SWORD           = new Material("IRON_SWORD", 267, 1, 250);
//    public static final  Material                WOOD_SWORD           = new Material("WOOD_SWORD", 268, 1, 59);
//    public static final  Material                WOOD_SPADE           = new Material("WOOD_SPADE", 269, 1, 59);
//    public static final  Material                WOOD_PICKAXE         = new Material("WOOD_PICKAXE", 270, 1, 59);
//    public static final  Material                WOOD_AXE             = new Material("WOOD_AXE", 271, 1, 59);
//    public static final  Material                STONE_SWORD          = new Material("STONE_SWORD", 272, 1, 131);
//    public static final  Material                STONE_SPADE          = new Material("STONE_SPADE", 273, 1, 131);
//    public static final  Material                STONE_PICKAXE        = new Material("STONE_PICKAXE", 274, 1, 131);
//    public static final  Material                STONE_AXE            = new Material("STONE_AXE", 275, 1, 131);
//    public static final  Material                DIAMOND_SWORD        = new Material("DIAMOND_SWORD", 276, 1, 1561);
//    public static final  Material                DIAMOND_SPADE        = new Material("DIAMOND_SPADE", 277, 1, 1561);
//    public static final  Material                DIAMOND_PICKAXE      = new Material("DIAMOND_PICKAXE", 278, 1, 1561);
//    public static final  Material                DIAMOND_AXE          = new Material("DIAMOND_AXE", 279, 1, 1561);
//    public static final  Material                STICK                = new Material("STICK", 280);
//    public static final  Material                BOWL                 = new Material("BOWL", 281);
//    public static final  Material                MUSHROOM_SOUP        = new Material("MUSHROOM_SOUP", 282, 1);
//    public static final  Material                GOLD_SWORD           = new Material("GOLD_SWORD", 283, 1, 32);
//    public static final  Material                GOLD_SPADE           = new Material("GOLD_SPADE", 284, 1, 32);
//    public static final  Material                GOLD_PICKAXE         = new Material("GOLD_PICKAXE", 285, 1, 32);
//    public static final  Material                GOLD_AXE             = new Material("GOLD_AXE", 286, 1, 32);
//    public static final  Material                STRING               = new Material("STRING", 287);
//    public static final  Material                FEATHER              = new Material("FEATHER", 288);
//    public static final  Material                SULPHUR              = new Material("SULPHUR", 289);
//    public static final  Material                WOOD_HOE             = new Material("WOOD_HOE", 290, 1, 59);
//    public static final  Material                STONE_HOE            = new Material("STONE_HOE", 291, 1, 131);
//    public static final  Material                IRON_HOE             = new Material("IRON_HOE", 292, 1, 250);
//    public static final  Material                DIAMOND_HOE          = new Material("DIAMOND_HOE", 293, 1, 1561);
//    public static final  Material                GOLD_HOE             = new Material("GOLD_HOE", 294, 1, 32);
//    public static final  Material                SEEDS                = new Material("SEEDS", 295);
//    public static final  Material                WHEAT                = new Material("WHEAT", 296);
//    public static final  Material                BREAD                = new Material("BREAD", 297);
//    public static final  Material                LEATHER_HELMET       = new Material("LEATHER_HELMET", 298, 1, 55);
//    public static final  Material                LEATHER_CHESTPLATE   = new Material("LEATHER_CHESTPLATE", 299, 1, 80);
//    public static final  Material                LEATHER_LEGGINGS     = new Material("LEATHER_LEGGINGS", 300, 1, 75);
//    public static final  Material                LEATHER_BOOTS        = new Material("LEATHER_BOOTS", 301, 1, 65);
//    public static final  Material                CHAINMAIL_HELMET     = new Material("CHAINMAIL_HELMET", 302, 1, 165);
//    public static final  Material                CHAINMAIL_CHESTPLATE = new Material("CHAINMAIL_CHESTPLATE", 303, 1, 240);
//    public static final  Material                CHAINMAIL_LEGGINGS   = new Material("CHAINMAIL_LEGGINGS", 304, 1, 225);
//    public static final  Material                CHAINMAIL_BOOTS      = new Material("CHAINMAIL_BOOTS", 305, 1, 195);
//    public static final  Material                IRON_HELMET          = new Material("IRON_HELMET", 306, 1, 165);
//    public static final  Material                IRON_CHESTPLATE      = new Material("IRON_CHESTPLATE", 307, 1, 240);
//    public static final  Material                IRON_LEGGINGS        = new Material("IRON_LEGGINGS", 308, 1, 225);
//    public static final  Material                IRON_BOOTS           = new Material("IRON_BOOTS", 309, 1, 195);
//    public static final  Material                DIAMOND_HELMET       = new Material("DIAMOND_HELMET", 310, 1, 363);
//    public static final  Material                DIAMOND_CHESTPLATE   = new Material("DIAMOND_CHESTPLATE", 311, 1, 528);
//    public static final  Material                DIAMOND_LEGGINGS     = new Material("DIAMOND_LEGGINGS", 312, 1, 495);
//    public static final  Material                DIAMOND_BOOTS        = new Material("DIAMOND_BOOTS", 313, 1, 429);
//    public static final  Material                GOLD_HELMET          = new Material("GOLD_HELMET", 314, 1, 77);
//    public static final  Material                GOLD_CHESTPLATE      = new Material("GOLD_CHESTPLATE", 315, 1, 112);
//    public static final  Material                GOLD_LEGGINGS        = new Material("GOLD_LEGGINGS", 316, 1, 105);
//    public static final  Material                GOLD_BOOTS           = new Material("GOLD_BOOTS", 317, 1, 91);
//    public static final  Material                FLINT                = new Material("FLINT", 318);
//    public static final  Material                PORK                 = new Material("PORK", 319);
//    public static final  Material                GRILLED_PORK         = new Material("GRILLED_PORK", 320);
//    public static final  Material                PAINTING             = new Material("PAINTING", 321);
//    public static final  Material                GOLDEN_APPLE         = new Material("GOLDEN_APPLE", 322);
//    public static final  Material                SIGN                 = new Material("SIGN", 323, 16);
//    public static final  Material                WOOD_DOOR            = new Material("WOOD_DOOR", 324, 64);
//    public static final  Material                BUCKET               = new Material("BUCKET", 325, 16);
//    public static final  Material                WATER_BUCKET         = new Material("WATER_BUCKET", 326, 1);
//    public static final  Material                LAVA_BUCKET          = new Material("LAVA_BUCKET", 327, 1);
//    public static final  Material                MINECART             = new Material("MINECART", 328, 1);
//    public static final  Material                SADDLE               = new Material("SADDLE", 329, 1);
//    public static final  Material                IRON_DOOR            = new Material("IRON_DOOR", 330, 64);
//    public static final  Material                REDSTONE             = new Material("REDSTONE", 331);
//    public static final  Material                SNOW_BALL            = new Material("SNOW_BALL", 332, 16);
//    public static final  Material                BOAT                 = new Material("BOAT", 333, 1);
//    public static final  Material                LEATHER              = new Material("LEATHER", 334);
//    public static final  Material                MILK_BUCKET          = new Material("MILK_BUCKET", 335, 1);
//    public static final  Material                CLAY_BRICK           = new Material("CLAY_BRICK", 336);
//    public static final  Material                CLAY_BALL            = new Material("CLAY_BALL", 337);
//    public static final  Material                SUGAR_CANE           = new Material("SUGAR_CANE", 338);
//    public static final  Material                PAPER                = new Material("PAPER", 339);
//    public static final  Material                BOOK                 = new Material("BOOK", 340);
//    public static final  Material                SLIME_BALL           = new Material("SLIME_BALL", 341);
//    public static final  Material                STORAGE_MINECART     = new Material("STORAGE_MINECART", 342, 1);
//    public static final  Material                POWERED_MINECART     = new Material("POWERED_MINECART", 343, 1);
//    public static final  Material                EGG                  = new Material("EGG", 344, 16);
//    public static final  Material                COMPASS              = new Material("COMPASS", 345);
//    public static final  Material                FISHING_ROD          = new Material("FISHING_ROD", 346, 1, 64);
//    public static final  Material                WATCH                = new Material("WATCH", 347);
//    public static final  Material                GLOWSTONE_DUST       = new Material("GLOWSTONE_DUST", 348);
//    public static final  Material                RAW_FISH             = new Material("RAW_FISH", 349);
//    public static final  Material                COOKED_FISH          = new Material("COOKED_FISH", 350);
//    public static final  Material                INK_SACK             = new Material("INK_SACK", 351);
//    public static final  Material                BONE                 = new Material("BONE", 352);
//    public static final  Material                SUGAR                = new Material("SUGAR", 353);
//    public static final  Material                CAKE                 = new Material("CAKE", 354, 1);
//    public static final  Material                BED                  = new Material("BED", 355, 1);
//    public static final  Material                DIODE                = new Material("DIODE", 356);
//    public static final  Material                COOKIE               = new Material("COOKIE", 357);
//    public static final  Material                MAP                  = new Material("MAP", 358);
//    public static final  Material                SHEARS               = new Material("SHEARS", 359, 1, 238);
//    public static final  Material                MELON                = new Material("MELON", 360);
//    public static final  Material                PUMPKIN_SEEDS        = new Material("PUMPKIN_SEEDS", 361);
//    public static final  Material                MELON_SEEDS          = new Material("MELON_SEEDS", 362);
//    public static final  Material                RAW_BEEF             = new Material("RAW_BEEF", 363);
//    public static final  Material                COOKED_BEEF          = new Material("COOKED_BEEF", 364);
//    public static final  Material                RAW_CHICKEN          = new Material("RAW_CHICKEN", 365);
//    public static final  Material                COOKED_CHICKEN       = new Material("COOKED_CHICKEN", 366);
//    public static final  Material                ROTTEN_FLESH         = new Material("ROTTEN_FLESH", 367);
//    public static final  Material                ENDER_PEARL          = new Material("ENDER_PEARL", 368, 16);
//    public static final  Material                BLAZE_ROD            = new Material("BLAZE_ROD", 369);
//    public static final  Material                GHAST_TEAR           = new Material("GHAST_TEAR", 370);
//    public static final  Material                GOLD_NUGGET          = new Material("GOLD_NUGGET", 371);
//    public static final  Material                NETHER_STALK         = new Material("NETHER_STALK", 372);
//    public static final  Material                POTION               = new Material("POTION", 373, 1);
//    public static final  Material                GLASS_BOTTLE         = new Material("GLASS_BOTTLE", 374);
//    public static final  Material                SPIDER_EYE           = new Material("SPIDER_EYE", 375);
//    public static final  Material                FERMENTED_SPIDER_EYE = new Material("FERMENTED_SPIDER_EYE", 376);
//    public static final  Material                BLAZE_POWDER         = new Material("BLAZE_POWDER", 377);
//    public static final  Material                MAGMA_CREAM          = new Material("MAGMA_CREAM", 378);
//    public static final  Material                BREWING_STAND_ITEM   = new Material("BREWING_STAND_ITEM", 379);
//    public static final  Material                CAULDRON_ITEM        = new Material("CAULDRON_ITEM", 380);
//    public static final  Material                EYE_OF_ENDER         = new Material("EYE_OF_ENDER", 381);
//    public static final  Material                SPECKLED_MELON       = new Material("SPECKLED_MELON", 382);
//    public static final  Material                MONSTER_EGG          = new Material("MONSTER_EGG", 383, 64);
//    public static final  Material                EXP_BOTTLE           = new Material("EXP_BOTTLE", 384, 64);
//    public static final  Material                FIREBALL             = new Material("FIREBALL", 385, 64);
//    public static final  Material                BOOK_AND_QUILL       = new Material("BOOK_AND_QUILL", 386, 1);
//    public static final  Material                WRITTEN_BOOK         = new Material("WRITTEN_BOOK", 387, 16);
//    public static final  Material                EMERALD              = new Material("EMERALD", 388, 64);
//    public static final  Material                ITEM_FRAME           = new Material("ITEM_FRAME", 389);
//    public static final  Material                FLOWER_POT_ITEM      = new Material("FLOWER_POT_ITEM", 390);
//    public static final  Material                CARROT_ITEM          = new Material("CARROT_ITEM", 391);
//    public static final  Material                POTATO_ITEM          = new Material("POTATO_ITEM", 392);
//    public static final  Material                BAKED_POTATO         = new Material("BAKED_POTATO", 393);
//    public static final  Material                POISONOUS_POTATO     = new Material("POISONOUS_POTATO", 394);
//    public static final  Material                EMPTY_MAP            = new Material("EMPTY_MAP", 395);
//    public static final  Material                GOLDEN_CARROT        = new Material("GOLDEN_CARROT", 396);
//    public static final  Material                SKULL_ITEM           = new Material("SKULL_ITEM", 397);
//    public static final  Material                CARROT_STICK         = new Material("CARROT_STICK", 398, 1, 25);
//    public static final  Material                NETHER_STAR          = new Material("NETHER_STAR", 399);
//    public static final  Material                PUMPKIN_PIE          = new Material("PUMPKIN_PIE", 400);
//    public static final  Material                FIREWORK             = new Material("FIREWORK", 401);
//    public static final  Material                FIREWORK_CHARGE      = new Material("FIREWORK_CHARGE", 402);
//    public static final  Material                ENCHANTED_BOOK       = new Material("ENCHANTED_BOOK", 403, 1);
//    public static final  Material                REDSTONE_COMPARATOR  = new Material("REDSTONE_COMPARATOR", 404);
//    public static final  Material                NETHER_BRICK_ITEM    = new Material("NETHER_BRICK_ITEM", 405);
//    public static final  Material                QUARTZ               = new Material("QUARTZ", 406);
//    public static final  Material                EXPLOSIVE_MINECART   = new Material("EXPLOSIVE_MINECART", 407, 1);
//    public static final  Material                HOPPER_MINECART      = new Material("HOPPER_MINECART", 408, 1);
//    public static final  Material                PRISMARINE_SHARD     = new Material("PRISMARINE_SHARD", 409);
//    public static final  Material                PRISMARINE_CRYSTALS  = new Material("PRISMARINE_CRYSTALS", 410);
//    public static final  Material                RABBIT               = new Material("RABBIT", 411);
//    public static final  Material                COOKED_RABBIT        = new Material("COOKED_RABBIT", 412);
//    public static final  Material                RABBIT_STEW          = new Material("RABBIT_STEW", 413, 1);
//    public static final  Material                RABBIT_FOOT          = new Material("RABBIT_FOOT", 414);
//    public static final  Material                RABBIT_HIDE          = new Material("RABBIT_HIDE", 415);
//    public static final  Material                ARMOR_STAND          = new Material("ARMOR_STAND", 416, 16);
//    public static final  Material                IRON_BARDING         = new Material("IRON_BARDING", 417, 1);
//    public static final  Material                GOLD_BARDING         = new Material("GOLD_BARDING", 418, 1);
//    public static final  Material                DIAMOND_BARDING      = new Material("DIAMOND_BARDING", 419, 1);
//    public static final  Material                LEASH                = new Material("LEASH", 420);
//    public static final  Material                NAME_TAG             = new Material("NAME_TAG", 421);
//    public static final  Material                COMMAND_MINECART     = new Material("COMMAND_MINECART", 422, 1);
//    public static final  Material                MUTTON               = new Material("MUTTON", 423);
//    public static final  Material                COOKED_MUTTON        = new Material("COOKED_MUTTON", 424);
//    public static final  Material                BANNER               = new Material("BANNER", 425, 16);
//    public static final  Material                SPRUCE_DOOR_ITEM     = new Material("SPRUCE_DOOR_ITEM", 427);
//    public static final  Material                BIRCH_DOOR_ITEM      = new Material("BIRCH_DOOR_ITEM", 428);
//    public static final  Material                JUNGLE_DOOR_ITEM     = new Material("JUNGLE_DOOR_ITEM", 429);
//    public static final  Material                ACACIA_DOOR_ITEM     = new Material("ACACIA_DOOR_ITEM", 430);
//    public static final  Material                DARK_OAK_DOOR_ITEM   = new Material("DARK_OAK_DOOR_ITEM", 431);
//    public static final  Material                GOLD_RECORD          = new Material("GOLD_RECORD", 2256, 1);
//    public static final  Material                GREEN_RECORD         = new Material("GREEN_RECORD", 2257, 1);
//    public static final  Material                RECORD_3             = new Material("RECORD_3", 2258, 1);
//    public static final  Material                RECORD_4             = new Material("RECORD_4", 2259, 1);
//    public static final  Material                RECORD_5             = new Material("RECORD_5", 2260, 1);
//    public static final  Material                RECORD_6             = new Material("RECORD_6", 2261, 1);
//    public static final  Material                RECORD_7             = new Material("RECORD_7", 2262, 1);
//    public static final  Material                RECORD_8             = new Material("RECORD_8", 2263, 1);
//    public static final  Material                RECORD_9             = new Material("RECORD_9", 2264, 1);
//    public static final  Material                RECORD_10            = new Material("RECORD_10", 2265, 1);
//    public static final  Material                RECORD_11            = new Material("RECORD_11", 2266, 1);
//    public static final  Material                RECORD_12            = new Material("RECORD_12", 2267, 1);
    private static final Map<String, Material>   byName      = new SimpleStringHashMap<>(MATERIALS_SIZE, SLOW_GROW);
    private static final TIntObjectMap<Material> byID        = new TIntObjectHashMap<>(MATERIALS_SIZE, SLOW_GROW);
    private final String enumName;
    private final int    id;
    private final int    maxStack;

    public Material(final String enumName, final int id)
    {
        this(enumName, id, MagicNumbers.ITEMS__DEFAULT_STACK_SIZE);
    }

    public Material(final String enumName, final int id, final int maxStack)
    {
        this.enumName = enumName;
        this.id = id;
        this.maxStack = maxStack;
    }

    @Override
    public String name()
    {
        return this.enumName;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public Material byId(final int id)
    {
        return byID.get(id);
    }

    @Override
    public Material byName(final String name)
    {
        return byName.get(name);
    }

    public int getMaxStack()
    {
        return this.maxStack;
    }

    public abstract boolean isBlock();

    public abstract boolean isSolid();

    public abstract boolean isTransparent();

    public abstract boolean isFlammable();

    public abstract boolean isBurnable();

    public abstract boolean isOccluding();

    public abstract boolean hasGravity();

    public abstract boolean isEdible();

    public abstract boolean isReplaceable();

    public abstract boolean isGlowing();

    public abstract int getLuminance();

    public abstract float getBlastResistance();

    public abstract float getHardness();

    public abstract IntRange getExperienceWhenMined();

    // TODO: method to get possible drops

    public boolean isThisSameID(final Material mat)
    {
        return this.enumName.equals(mat.enumName);
    }

    public final boolean simpleEquals(final Object o)
    {
        //noinspection ObjectEquality
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof Material))
        {
            return false;
        }

        final Material material = (Material) o;

        return this.enumName.equals(material.enumName);
    }

    @Override
    public int hashCode()
    {
        return this.enumName.hashCode();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (! (o instanceof Material))
        {
            return false;
        }

        final Material material = (Material) o;

        return this.enumName.equals(material.enumName);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("enumName", this.enumName).append("id", this.id).append("maxStack", this.maxStack).toString();
    }

    public static Material getByID(final int id)
    {
        return byID.get(id);
    }

    public static Material getByID(final int id, final int meta)
    {
        final Material mat = byID.get(id);
        if (mat instanceof BlockMaterialData)
        {
            return ((BlockMaterialData) mat).getType(meta);
        }
        return mat;
    }

    public static Material getByID(final int id, final String meta)
    {
        final Material mat = byID.get(id);
        if (mat instanceof BlockMaterialData)
        {
            return ((BlockMaterialData) mat).getType(meta);
        }
        return mat;
    }

    public static Material getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static Material getByEnumName(final String name, final int meta)
    {
        final Material mat = byName.get(name);
        if (mat instanceof BlockMaterialData)
        {
            return ((BlockMaterialData) mat).getType(meta);
        }
        return mat;
    }

    public static Material getByEnumName(final String name, final String meta)
    {
        final Material mat = byName.get(name);
        if (mat instanceof BlockMaterialData)
        {
            return ((BlockMaterialData) mat).getType(meta);
        }
        return mat;
    }

    public static void register(final Material element)
    {
        byID.put(element.getId(), element);
        byName.put(element.name(), element);
    }

    static
    {
        register(AIR);
        register(STONE);
        register(GRASS);
        register(DIRT);
        register(COBBLESTONE);
        register(PLANKS);
        register(SAPLING);
        register(BEDROCK);
        register(WATER);
        register(LAVA);
//        register(SAND);
//        register(GRAVEL);
//        register(GOLD_ORE);
//        register(IRON_ORE);
//        register(COAL_ORE);
//        register(LOG);
//        register(LEAVES);
//        register(SPONGE);
//        register(GLASS);
//        register(LAPIS_ORE);
//        register(LAPIS_BLOCK);
//        register(DISPENSER);
//        register(SANDSTONE);
//        register(NOTE_BLOCK);
//        register(BED_BLOCK);
//        register(POWERED_RAIL);
//        register(DETECTOR_RAIL);
//        register(PISTON_STICKY_BASE);
//        register(WEB);
//        register(LONG_GRASS);
//        register(DEAD_BUSH);
//        register(PISTON_BASE);
//        register(PISTON_EXTENSION);
//        register(WOOL);
//        register(PISTON_MOVING_PIECE);
//        register(YELLOW_FLOWER);
//        register(RED_ROSE);
//        register(BROWN_MUSHROOM);
//        register(RED_MUSHROOM);
//        register(GOLD_BLOCK);
//        register(IRON_BLOCK);
//        register(DOUBLE_STEP);
//        register(STEP);
//        register(BRICK);
//        register(TNT);
//        register(BOOKSHELF);
//        register(MOSSY_COBBLESTONE);
//        register(OBSIDIAN);
//        register(TORCH);
//        register(FIRE);
//        register(MOB_SPAWNER);
//        register(WOOD_STAIRS);
//        register(CHEST);
//        register(REDSTONE_WIRE);
//        register(DIAMOND_ORE);
//        register(DIAMOND_BLOCK);
//        register(WORKBENCH);
//        register(CROPS);
//        register(SOIL);
//        register(FURNACE);
//        register(BURNING_FURNACE);
//        register(SIGN_POST);
//        register(WOODEN_DOOR);
//        register(LADDER);
//        register(RAILS);
//        register(COBBLESTONE_STAIRS);
//        register(WALL_SIGN);
//        register(LEVER);
//        register(STONE_PLATE);
//        register(IRON_DOOR_BLOCK);
//        register(WOOD_PLATE);
//        register(REDSTONE_ORE);
//        register(GLOWING_REDSTONE_ORE);
//        register(REDSTONE_TORCH_OFF);
//        register(REDSTONE_TORCH_ON);
//        register(STONE_BUTTON);
//        register(SNOW);
//        register(ICE);
//        register(SNOW_BLOCK);
//        register(CACTUS);
//        register(CLAY);
//        register(SUGAR_CANE_BLOCK);
//        register(JUKEBOX);
//        register(FENCE);
//        register(PUMPKIN);
//        register(NETHERRACK);
//        register(SOUL_SAND);
//        register(GLOWSTONE);
//        register(PORTAL);
//        register(JACK_O_LANTERN);
//        register(CAKE_BLOCK);
//        register(DIODE_BLOCK_OFF);
//        register(DIODE_BLOCK_ON);
//        register(STAINED_GLASS);
//        register(TRAP_DOOR);
//        register(MONSTER_EGGS);
//        register(SMOOTH_BRICK);
//        register(HUGE_MUSHROOM_1);
//        register(HUGE_MUSHROOM_2);
//        register(IRON_FENCE);
//        register(THIN_GLASS);
//        register(MELON_BLOCK);
//        register(PUMPKIN_STEM);
//        register(MELON_STEM);
//        register(VINE);
//        register(FENCE_GATE);
//        register(BRICK_STAIRS);
//        register(SMOOTH_STAIRS);
//        register(MYCEL);
//        register(WATER_LILY);
//        register(NETHER_BRICK);
//        register(NETHER_FENCE);
//        register(NETHER_BRICK_STAIRS);
//        register(NETHER_WARTS);
//        register(ENCHANTMENT_TABLE);
//        register(BREWING_STAND);
//        register(CAULDRON);
//        register(ENDER_PORTAL);
//        register(ENDER_PORTAL_FRAME);
//        register(ENDER_STONE);
//        register(DRAGON_EGG);
//        register(REDSTONE_LAMP_OFF);
//        register(REDSTONE_LAMP_ON);
//        register(WOOD_DOUBLE_STEP);
//        register(WOOD_STEP);
//        register(COCOA);
//        register(SANDSTONE_STAIRS);
//        register(EMERALD_ORE);
//        register(ENDER_CHEST);
//        register(TRIPWIRE_HOOK);
//        register(TRIPWIRE);
//        register(EMERALD_BLOCK);
//        register(SPRUCE_WOOD_STAIRS);
//        register(BIRCH_WOOD_STAIRS);
//        register(JUNGLE_WOOD_STAIRS);
//        register(COMMAND);
//        register(BEACON);
//        register(COBBLE_WALL);
//        register(FLOWER_POT);
//        register(CARROT);
//        register(POTATO);
//        register(WOOD_BUTTON);
//        register(SKULL);
//        register(ANVIL);
//        register(TRAPPED_CHEST);
//        register(GOLD_PLATE);
//        register(IRON_PLATE);
//        register(REDSTONE_COMPARATOR_OFF);
//        register(REDSTONE_COMPARATOR_ON);
//        register(DAYLIGHT_DETECTOR);
//        register(REDSTONE_BLOCK);
//        register(QUARTZ_ORE);
//        register(HOPPER);
//        register(QUARTZ_BLOCK);
//        register(QUARTZ_STAIRS);
//        register(ACTIVATOR_RAIL);
//        register(DROPPER);
//        register(STAINED_CLAY);
//        register(STAINED_GLASS_PANE);
//        register(LEAVES_2);
//        register(LOG_2);
//        register(ACACIA_STAIRS);
//        register(DARK_OAK_STAIRS);
//        register(SLIME_BLOCK);
//        register(BARRIER);
//        register(IRON_TRAPDOOR);
//        register(PRISMARINE);
//        register(SEA_LANTERN);
//        register(HAY_BLOCK);
//        register(CARPET);
//        register(HARD_CLAY);
//        register(COAL_BLOCK);
//        register(PACKED_ICE);
//        register(DOUBLE_PLANT);
//        register(STANDING_BANNER);
//        register(WALL_BANNER);
//        register(DAYLIGHT_DETECTOR_INVERTED);
//        register(RED_SANDSTONE);
//        register(RED_SANDSTONE_STAIRS);
//        register(DOUBLE_STONE_SLAB2);
//        register(STONE_SLAB2);
//        register(SPRUCE_FENCE_GATE);
//        register(BIRCH_FENCE_GATE);
//        register(JUNGLE_FENCE_GATE);
//        register(DARK_OAK_FENCE_GATE);
//        register(ACACIA_FENCE_GATE);
//        register(SPRUCE_FENCE);
//        register(BIRCH_FENCE);
//        register(JUNGLE_FENCE);
//        register(DARK_OAK_FENCE);
//        register(ACACIA_FENCE);
//        register(SPRUCE_DOOR);
//        register(BIRCH_DOOR);
//        register(JUNGLE_DOOR);
//        register(ACACIA_DOOR);
//        register(DARK_OAK_DOOR);
//        register(IRON_SPADE);
//        register(IRON_PICKAXE);
//        register(IRON_AXE);
//        register(FLINT_AND_STEEL);
//        register(APPLE);
//        register(BOW);
//        register(ARROW);
//        register(COAL);
//        register(DIAMOND);
//        register(IRON_INGOT);
//        register(GOLD_INGOT);
//        register(IRON_SWORD);
//        register(WOOD_SWORD);
//        register(WOOD_SPADE);
//        register(WOOD_PICKAXE);
//        register(WOOD_AXE);
//        register(STONE_SWORD);
//        register(STONE_SPADE);
//        register(STONE_PICKAXE);
//        register(STONE_AXE);
//        register(DIAMOND_SWORD);
//        register(DIAMOND_SPADE);
//        register(DIAMOND_PICKAXE);
//        register(DIAMOND_AXE);
//        register(STICK);
//        register(BOWL);
//        register(MUSHROOM_SOUP);
//        register(GOLD_SWORD);
//        register(GOLD_SPADE);
//        register(GOLD_PICKAXE);
//        register(GOLD_AXE);
//        register(STRING);
//        register(FEATHER);
//        register(SULPHUR);
//        register(WOOD_HOE);
//        register(STONE_HOE);
//        register(IRON_HOE);
//        register(DIAMOND_HOE);
//        register(GOLD_HOE);
//        register(SEEDS);
//        register(WHEAT);
//        register(BREAD);
//        register(LEATHER_HELMET);
//        register(LEATHER_CHESTPLATE);
//        register(LEATHER_LEGGINGS);
//        register(LEATHER_BOOTS);
//        register(CHAINMAIL_HELMET);
//        register(CHAINMAIL_CHESTPLATE);
//        register(CHAINMAIL_LEGGINGS);
//        register(CHAINMAIL_BOOTS);
//        register(IRON_HELMET);
//        register(IRON_CHESTPLATE);
//        register(IRON_LEGGINGS);
//        register(IRON_BOOTS);
//        register(DIAMOND_HELMET);
//        register(DIAMOND_CHESTPLATE);
//        register(DIAMOND_LEGGINGS);
//        register(DIAMOND_BOOTS);
//        register(GOLD_HELMET);
//        register(GOLD_CHESTPLATE);
//        register(GOLD_LEGGINGS);
//        register(GOLD_BOOTS);
//        register(FLINT);
//        register(PORK);
//        register(GRILLED_PORK);
//        register(PAINTING);
//        register(GOLDEN_APPLE);
//        register(SIGN);
//        register(WOOD_DOOR);
//        register(BUCKET);
//        register(WATER_BUCKET);
//        register(LAVA_BUCKET);
//        register(MINECART);
//        register(SADDLE);
//        register(IRON_DOOR);
//        register(REDSTONE);
//        register(SNOW_BALL);
//        register(BOAT);
//        register(LEATHER);
//        register(MILK_BUCKET);
//        register(CLAY_BRICK);
//        register(CLAY_BALL);
//        register(SUGAR_CANE);
//        register(PAPER);
//        register(BOOK);
//        register(SLIME_BALL);
//        register(STORAGE_MINECART);
//        register(POWERED_MINECART);
//        register(EGG);
//        register(COMPASS);
//        register(FISHING_ROD);
//        register(WATCH);
//        register(GLOWSTONE_DUST);
//        register(RAW_FISH);
//        register(COOKED_FISH);
//        register(INK_SACK);
//        register(BONE);
//        register(SUGAR);
//        register(CAKE);
//        register(BED);
//        register(DIODE);
//        register(COOKIE);
//        register(MAP);
//        register(SHEARS);
//        register(MELON);
//        register(PUMPKIN_SEEDS);
//        register(MELON_SEEDS);
//        register(RAW_BEEF);
//        register(COOKED_BEEF);
//        register(RAW_CHICKEN);
//        register(COOKED_CHICKEN);
//        register(ROTTEN_FLESH);
//        register(ENDER_PEARL);
//        register(BLAZE_ROD);
//        register(GHAST_TEAR);
//        register(GOLD_NUGGET);
//        register(NETHER_STALK);
//        register(POTION);
//        register(GLASS_BOTTLE);
//        register(SPIDER_EYE);
//        register(FERMENTED_SPIDER_EYE);
//        register(BLAZE_POWDER);
//        register(MAGMA_CREAM);
//        register(BREWING_STAND_ITEM);
//        register(CAULDRON_ITEM);
//        register(EYE_OF_ENDER);
//        register(SPECKLED_MELON);
//        register(MONSTER_EGG);
//        register(EXP_BOTTLE);
//        register(FIREBALL);
//        register(BOOK_AND_QUILL);
//        register(WRITTEN_BOOK);
//        register(EMERALD);
//        register(ITEM_FRAME);
//        register(FLOWER_POT_ITEM);
//        register(CARROT_ITEM);
//        register(POTATO_ITEM);
//        register(BAKED_POTATO);
//        register(POISONOUS_POTATO);
//        register(EMPTY_MAP);
//        register(GOLDEN_CARROT);
//        register(SKULL_ITEM);
//        register(CARROT_STICK);
//        register(NETHER_STAR);
//        register(PUMPKIN_PIE);
//        register(FIREWORK);
//        register(FIREWORK_CHARGE);
//        register(ENCHANTED_BOOK);
//        register(REDSTONE_COMPARATOR);
//        register(NETHER_BRICK_ITEM);
//        register(QUARTZ);
//        register(EXPLOSIVE_MINECART);
//        register(HOPPER_MINECART);
//        register(PRISMARINE_SHARD);
//        register(PRISMARINE_CRYSTALS);
//        register(RABBIT);
//        register(COOKED_RABBIT);
//        register(RABBIT_STEW);
//        register(RABBIT_FOOT);
//        register(RABBIT_HIDE);
//        register(ARMOR_STAND);
//        register(IRON_BARDING);
//        register(GOLD_BARDING);
//        register(DIAMOND_BARDING);
//        register(LEASH);
//        register(NAME_TAG);
//        register(COMMAND_MINECART);
//        register(MUTTON);
//        register(COOKED_MUTTON);
//        register(BANNER);
//        register(SPRUCE_DOOR_ITEM);
//        register(BIRCH_DOOR_ITEM);
//        register(JUNGLE_DOOR_ITEM);
//        register(ACACIA_DOOR_ITEM);
//        register(DARK_OAK_DOOR_ITEM);
//        register(GOLD_RECORD);
//        register(GREEN_RECORD);
//        register(RECORD_3);
//        register(RECORD_4);
//        register(RECORD_5);
//        register(RECORD_6);
//        register(RECORD_7);
//        register(RECORD_8);
//        register(RECORD_9);
//        register(RECORD_10);
//        register(RECORD_11);
//        register(RECORD_12);
    }
}
