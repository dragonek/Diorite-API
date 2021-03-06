package org.diorite.utils.collections;

import java.util.Collection;
import java.util.HashSet;

public class SimpleStringHashSet extends HashSet<String>
{

    public SimpleStringHashSet(final int initialCapacity)
    {
        super(initialCapacity);
    }

    public SimpleStringHashSet(final int initialCapacity, final float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public SimpleStringHashSet(final Collection<? extends String> c)
    {
        super(c);
    }

    public SimpleStringHashSet()
    {
        super();
    }

    @Override
    public boolean contains(final Object o)
    {
        return super.contains((o instanceof String) ? ((String) o).toLowerCase() : o);
    }

    @Override
    public boolean add(final String s)
    {
        return super.add(s.toLowerCase());
    }

    @Override
    public boolean remove(final Object o)
    {
        return super.remove((o instanceof String) ? ((String) o).toLowerCase() : o);
    }
}
