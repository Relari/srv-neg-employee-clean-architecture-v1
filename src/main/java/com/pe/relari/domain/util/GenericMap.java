package com.pe.relari.domain.util;

import java.util.Map;

public interface GenericMap<K, V> extends Map<K, V> {

    default V getValue(K key) {
        return get(key);
    }

}
