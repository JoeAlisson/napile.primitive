package io.github.joealisson.primitive.function;

import java.util.function.Function;

/**
 * Represents a function that produces a long-valued result.  This is the
 * {@code long}-producing primitive specialization for {@link Function}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #applyAsLong(long)}.
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface LongToLongFunction {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    long applyAsLong(long value);
}
