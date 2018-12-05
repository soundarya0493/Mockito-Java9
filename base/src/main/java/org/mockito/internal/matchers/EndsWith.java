/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockito.internal.matchers;

import org.mockito.ArgumentMatcher;

import java.io.Serializable;

public class EndsWith implements ArgumentMatcher<String>, Serializable {

    private final String suffix;

    public EndsWith(String suffix) {
        this.suffix = suffix;
    }

    public boolean matches(String actual) {
        return actual != null && actual.endsWith(suffix);
    }

    public String toString() {
        return "endsWith(\"" + suffix + "\")";
    }
}
