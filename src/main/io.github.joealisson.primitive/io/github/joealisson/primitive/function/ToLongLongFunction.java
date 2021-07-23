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
public interface ToLongLongFunction {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    int applyAsLong(long value);
}
