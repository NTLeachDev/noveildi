package com.nleachdev.noveildi.framework.model;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class InjectionPoint {
    private final Constructor<?> constructor;
    private final Dependency[] dependencies;

    public InjectionPoint(final Constructor<?> constructor, final Dependency[] dependencies) {
        this.constructor = constructor;
        this.dependencies = dependencies;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    public Dependency[] getDependencies() {
        return dependencies;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InjectionPoint that = (InjectionPoint) o;
        return Objects.equals(constructor, that.constructor) &&
                Arrays.equals(dependencies, that.dependencies);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(constructor);
        result = 31 * result + Arrays.hashCode(dependencies);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InjectionPoint.class.getSimpleName() + "[", "]")
                .add("constructor=" + constructor)
                .add("dependencies=" + Arrays.toString(dependencies))
                .toString();
    }
}
