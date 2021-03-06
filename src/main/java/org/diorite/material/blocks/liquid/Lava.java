package org.diorite.material.blocks.liquid;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Lava extends Liquid
{
    public static final byte USED_DATA_VALUES = 16;

    public static final Lava LAVA_SOURCE  = new Lava();
    public static final Lava LAVA_STAGE_1 = new Lava(LiquidStage.STAGE_1, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_2 = new Lava(LiquidStage.STAGE_2, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_3 = new Lava(LiquidStage.STAGE_3, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_4 = new Lava(LiquidStage.STAGE_4, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_5 = new Lava(LiquidStage.STAGE_5, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_6 = new Lava(LiquidStage.STAGE_6, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_7 = new Lava(LiquidStage.STAGE_7, LiquidType.NORMAL);

    public static final Lava LAVA_SOURCE_FALLING  = new Lava(LiquidStage.SOURCE_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_1_FALLING = new Lava(LiquidStage.STAGE_1_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_2_FALLING = new Lava(LiquidStage.STAGE_2_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_3_FALLING = new Lava(LiquidStage.STAGE_3_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_4_FALLING = new Lava(LiquidStage.STAGE_4_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_5_FALLING = new Lava(LiquidStage.STAGE_5_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_6_FALLING = new Lava(LiquidStage.STAGE_6_FALLING, LiquidType.NORMAL);
    public static final Lava LAVA_STAGE_7_FALLING = new Lava(LiquidStage.STAGE_7_FALLING, LiquidType.NORMAL);


    public static final Lava LAVA_SOURCE_STILL  = new Lava();
    public static final Lava LAVA_STAGE_1_STILL = new Lava(LiquidStage.STAGE_1, LiquidType.STILL);
    public static final Lava LAVA_STAGE_2_STILL = new Lava(LiquidStage.STAGE_2, LiquidType.STILL);
    public static final Lava LAVA_STAGE_3_STILL = new Lava(LiquidStage.STAGE_3, LiquidType.STILL);
    public static final Lava LAVA_STAGE_4_STILL = new Lava(LiquidStage.STAGE_4, LiquidType.STILL);
    public static final Lava LAVA_STAGE_5_STILL = new Lava(LiquidStage.STAGE_5, LiquidType.STILL);
    public static final Lava LAVA_STAGE_6_STILL = new Lava(LiquidStage.STAGE_6, LiquidType.STILL);
    public static final Lava LAVA_STAGE_7_STILL = new Lava(LiquidStage.STAGE_7, LiquidType.STILL);

    public static final Lava LAVA_SOURCE_FALLING_STILL  = new Lava(LiquidStage.SOURCE_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_1_FALLING_STILL = new Lava(LiquidStage.STAGE_1_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_2_FALLING_STILL = new Lava(LiquidStage.STAGE_2_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_3_FALLING_STILL = new Lava(LiquidStage.STAGE_3_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_4_FALLING_STILL = new Lava(LiquidStage.STAGE_4_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_5_FALLING_STILL = new Lava(LiquidStage.STAGE_5_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_6_FALLING_STILL = new Lava(LiquidStage.STAGE_6_FALLING, LiquidType.STILL);
    public static final Lava LAVA_STAGE_7_FALLING_STILL = new Lava(LiquidStage.STAGE_7_FALLING, LiquidType.STILL);

    private static final Map<String, Lava>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES << 1, SLOW_GROW);
    private static final TByteObjectMap<Lava> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES << 1, SLOW_GROW);

    protected Lava()
    {
        super("LAVA", 10, "SOURCE", LiquidStage.SOURCE, LiquidType.NORMAL);
    }

    public Lava(final LiquidStage stage, final LiquidType liquidType)
    {
        super(LAVA_SOURCE.name(), LAVA_SOURCE.getId() + ((liquidType == LiquidType.STILL) ? 1 : 0), LAVA_SOURCE.getMaxStack(), stage.name() + (liquidType == LiquidType.STILL ? "_STILL" : ""), stage, liquidType);
    }

    @Override
    public Lava getStage(final LiquidStage stage)
    {
        for (final Lava lava : byName.values())
        {
            if ((lava.getLiquidType() == this.liquidType) && (lava.stage == stage))
            {
                return lava;
            }
        }
        return null;
    }

    @Override
    public Lava getLiquidType(final LiquidType type)
    {
        for (final Lava lava : byName.values())
        {
            if ((lava.getStage() == this.stage) && (lava.liquidType == type))
            {
                return lava;
            }
        }
        return null;
    }

    @Override
    public Lava getNormalType()
    {
        return (Lava) super.getNormalType();
    }

    @Override
    public Lava getStillType()
    {
        return (Lava) super.getStillType();
    }

    @Override
    public Lava getOtherType()
    {
        return (Lava) super.getOtherType();
    }

    @Override
    public Lava nextStage()
    {
        return (Lava) super.nextStage();
    }

    @Override
    public Lava previousStage()
    {
        return (Lava) super.previousStage();
    }

    @Override
    public Lava falling()
    {
        return (Lava) super.falling();
    }

    @Override
    public Lava normal()
    {
        return (Lava) super.normal();
    }

    @Override
    public Lava switchFalling()
    {
        return (Lava) super.switchFalling();
    }

    @Override
    public Lava source()
    {
        return (Lava) super.source();
    }

    @Override
    public float getBlastResistance()
    {
        return this.isStill() ? MagicNumbers.MATERIAL__LAVA_STILL__BLAST_RESISTANCE : MagicNumbers.MATERIAL__LAVA__BLAST_RESISTANCE;
    }

    @Override
    public float getHardness()
    {
        return this.isStill() ? MagicNumbers.MATERIAL__LAVA_STILL__HARDNESS : MagicNumbers.MATERIAL__LAVA__HARDNESS;
    }

    @Override
    public Lava getType(final String name)
    {
        return byName.get(name);
    }

    @SuppressWarnings("MagicNumber")
    @Override
    public Lava getType(final int id)
    {
        return this.isStill() ? byID.get((byte) (id + 16)) : byID.get((byte) id);
    }

    @SuppressWarnings("MagicNumber")
    protected byte getFixedDataValue()
    {
        return (byte) (this.getType() + ((this.liquidType == LiquidType.STILL) ? 16 : 0));
    }

    @SuppressWarnings("MagicNumber")
    public static Lava get(final LiquidType type, final LiquidStage stage)
    {
        return getByID(stage.getDataValue() + ((type == LiquidType.STILL) ? 16 : 0));
    }

    public static Lava getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Lava getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Lava element)
    {
        byID.put(element.getFixedDataValue(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Lava.register(LAVA_SOURCE);
        Lava.register(LAVA_STAGE_1);
        Lava.register(LAVA_STAGE_2);
        Lava.register(LAVA_STAGE_3);
        Lava.register(LAVA_STAGE_4);
        Lava.register(LAVA_STAGE_5);
        Lava.register(LAVA_STAGE_6);
        Lava.register(LAVA_STAGE_7);
        Lava.register(LAVA_SOURCE_FALLING);
        Lava.register(LAVA_STAGE_1_FALLING);
        Lava.register(LAVA_STAGE_2_FALLING);
        Lava.register(LAVA_STAGE_3_FALLING);
        Lava.register(LAVA_STAGE_4_FALLING);
        Lava.register(LAVA_STAGE_5_FALLING);
        Lava.register(LAVA_STAGE_6_FALLING);
        Lava.register(LAVA_STAGE_7_FALLING);
        Lava.register(LAVA_SOURCE_STILL);
        Lava.register(LAVA_STAGE_1_STILL);
        Lava.register(LAVA_STAGE_2_STILL);
        Lava.register(LAVA_STAGE_3_STILL);
        Lava.register(LAVA_STAGE_4_STILL);
        Lava.register(LAVA_STAGE_5_STILL);
        Lava.register(LAVA_STAGE_6_STILL);
        Lava.register(LAVA_STAGE_7_STILL);
        Lava.register(LAVA_SOURCE_FALLING_STILL);
        Lava.register(LAVA_STAGE_1_FALLING_STILL);
        Lava.register(LAVA_STAGE_2_FALLING_STILL);
        Lava.register(LAVA_STAGE_3_FALLING_STILL);
        Lava.register(LAVA_STAGE_4_FALLING_STILL);
        Lava.register(LAVA_STAGE_5_FALLING_STILL);
        Lava.register(LAVA_STAGE_6_FALLING_STILL);
        Lava.register(LAVA_STAGE_7_FALLING_STILL);
    }
}
