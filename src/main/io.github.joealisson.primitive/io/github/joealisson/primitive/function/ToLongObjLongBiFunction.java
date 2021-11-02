package io.github.joealisson.primitive.function;

import java.util.function.Function;

/**
 * Represents a function that accepts an long-valued argument and produces a
 * int-valued result.  This is the {@code long}-to-{@code long} primitive
 * specialization for {@link Function}.
 *
 *
 * @see Function
 */
@FunctionalInterface
public interface ToLongObjLongBiFunction<K> {

    /**
     * Applies this function to the given arguments.
     *
     * @param k the first function argument
     * @param t the second function argument
     * @return the function result
     */
    long applyAsLong(K k, long t);
}
