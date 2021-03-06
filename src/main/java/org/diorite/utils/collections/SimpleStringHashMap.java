package org.diorite.utils.collections;

import java.util.HashMap;
import java.util.Map;

public class SimpleStringHashMap<T> extends HashMap<String, T>
{

    public SimpleStringHashMap(final int initialCapacity, final float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public SimpleStringHashMap(final Map<? extends String, ? extends T> m)
    {
        super(m);
    }

    public SimpleStringHashMap(final int initialCapacity)
    {
        super(initialCapacity);
    }

    @Override
    public T get(final Object key)
    {
        return super.get((key instanceof String) ? ((String) key).toLowerCase() : key);
    }

    @Override
    public boolean containsKey(final Object key)
    {
        return super.containsKey((key instanceof String) ? ((String) key).toLowerCase() : key);
    }

    @Override
    public T put(final String key, final T value)
    {
        return super.put(key.toLowerCase(), value);
    }

    @Override
    public T remove(final Object key)
    {
        return super.remove((key instanceof String) ? ((String) key).toLowerCase() : key);
    }

    @Override
    public T putIfAbsent(final String key, final T value)
    {
        return super.putIfAbsent(key.toLowerCase(), value);
    }

    @Override
    public boolean remove(final Object key, final Object value)
    {
        return super.remove((key instanceof String) ? ((String) key).toLowerCase() : key, value);
    }

    @Override
    public boolean replace(final String key, final T oldValue, final T newValue)
    {
        return super.replace(key.toLowerCase(), oldValue, newValue);
    }

    @Override
    public T replace(final String key, final T value)
    {
        return super.replace(key.toLowerCase(), value);
    }
}
