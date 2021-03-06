package org.diorite.entity;

import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.utils.SimpleEnum;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

public class EntityAction implements SimpleEnum
{
    public static final  EntityAction                CROUCH          = new EntityAction("CROUCH", 0, (p, args) -> p.setCrouching(true));
    public static final  EntityAction                UNCROUCH        = new EntityAction("UNCROUCH", 1, (p, args) -> p.setCrouching(false));
    public static final  EntityAction                LEAVE_BED       = new EntityAction("LEAVE_BED", 2, null);
    public static final  EntityAction                START_SPRINTING = new EntityAction("START_SPRINTING", 3, (p, args) -> p.setSprinting(true));
    public static final  EntityAction                STOP_SPRINTING  = new EntityAction("STOP_SPRINTING", 4, (p, args) -> p.setSprinting(false));
    public static final  EntityAction                JUMP_WITH_HORSE = new EntityAction("JUMP_WITH_HORSE", 5, null);
    public static final  EntityAction                OPEN_INVENTORY  = new EntityAction("OPEN_INVENTORY", 6, null);
    private static final Map<String, EntityAction>   byName          = new SimpleStringHashMap<>(6, .1f);
    private static final TIntObjectMap<EntityAction> byID            = new TIntObjectHashMap<>(6, .1f);
    private final String                       enumName;
    private final int                          id;
    private final BiConsumer<Player, Object[]> onAction; // idk if this is good idea...

    public EntityAction(final String enumName, final int id, final BiConsumer<Player, Object[]> onAction)
    {
        this.enumName = enumName;
        this.id = id;
        this.onAction = onAction;
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
    public EntityAction byId(final int id)
    {
        return byID.get(id);
    }

    @Override
    public EntityAction byName(final String name)
    {
        return byName.get(name);
    }

    public BiConsumer<Player, Object[]> getOnAction()
    {
        return this.onAction;
    }

    public void doAction(final Player player, final Object... args)
    {
        if (this.onAction != null)
        {
            this.onAction.accept(player, args);
        }
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("enumName", this.enumName).append("id", this.id).toString();
    }

    public static EntityAction getByID(final int id)
    {
        return byID.get(id);
    }

    public static EntityAction getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final EntityAction element)
    {
        byID.put(element.getId(), element);
        byName.put(element.name(), element);
    }

    static
    {
        register(CROUCH);
        register(UNCROUCH);
        register(LEAVE_BED);
        register(START_SPRINTING);
        register(STOP_SPRINTING);
        register(JUMP_WITH_HORSE);
        register(OPEN_INVENTORY);
    }
}
