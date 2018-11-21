/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.stubbing;

/**
 * Used for declaring optional stubbings with {@link Mockito#lenient()}
 *
 * @since 2.20.0
 */
public interface LenientStubber extends BaseStubber {

    /**
     * Allows declaring the method to stub. See {@link Mockito#when(Object)}.
     * Needed for classic stubbing with when().then()
     *
     * @since 2.20.0
     */
    <T> OngoingStubbing<T> when(T methodCall);
}
