/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package test.java.org.mockito.internal.configuration;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ClassPathLoaderTest extends TestBase {

    @Test
    public void shouldReadConfigurationClassFromClassPath() {
        ConfigurationAccess.getConfig().overrideDefaultAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) {
                return "foo";
            }});

        IMethods mock = mock(IMethods.class);
        assertEquals("foo", mock.simpleMethod());
    }
}
