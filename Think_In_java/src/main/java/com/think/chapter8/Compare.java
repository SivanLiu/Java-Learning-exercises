package com.think.chapter8;

/**
 * interface for sorting callback
 */
public interface Compare {
    boolean lessThan(Object lhs, Object rhs);

    boolean lessThanOrEqual(Object lhs, Object rhs);
}
