package com.nleachdev.derivativedi.framework.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <K, V> void addToMapSet(final Map<K, Set<V>> map, final K key, final V value) {
        if (map == null || key == null || value == null) {
            return;
        }

        map.compute(key, (k, v) -> {
            if (v == null) {
                v = new HashSet<>();
            }
            v.add(value);
            return v;
        });
    }

    public static <T, K> Set<T> setOf(final Collection<K> entries, final Function<K, T> func) {
        return entries.stream()
                .map(func)
                .collect(toSet());
    }
}
