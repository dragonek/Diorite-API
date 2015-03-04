package diorite.material.blocks;

import java.util.Map;

import diorite.material.BlockMaterialData;
import diorite.utils.collections.SimpleStringHashMap;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Air extends BlockMaterialData
{
    public static final Air AIR = new Air();

    private static final Map<String, Air>    byName = new SimpleStringHashMap<>(1, .1f);
    private static final TByteObjectMap<Air> byID   = new TByteObjectHashMap<>(1, .1f);

    protected Air()
    {
        super("AIR", 0, 0, "AIR", (byte) 0x00);
    }

    public Air(final String enumName, final int type)
    {
        super(AIR.name(), AIR.getId(), AIR.getMaxStack(), enumName, (byte) type);
    }

    public Air(final int maxStack, final int durability, final String typeName, final byte type)
    {
        super(AIR.name(), AIR.getId(), maxStack, durability, typeName, type);
    }

    @Override
    public BlockMaterialData getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BlockMaterialData getType(final int id)
    {
        return getByID(id);
    }

    public static Air getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Air getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Air element)
    {
        byID.put((byte) element.getId(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Air.register(AIR);
    }
}