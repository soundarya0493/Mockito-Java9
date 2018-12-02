/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package test.java.org.mockitousage.plugins;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.creation.instance.Instantiator;
import org.mockito.plugins.*;
import org.mockitoutil.TestBase;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.withSettings;

public class MockitoPluginsTest extends TestBase {

    private final MockitoPlugins plugins = Mockito.framework().getPlugins();

    @Test
    public void provides_built_in_plugins() {
        assertNotNull(plugins.getInlineMockMaker());
        assertNotNull(plugins.getDefaultPlugin(MockMaker.class));
        assertNotNull(plugins.getDefaultPlugin(StackTraceCleanerProvider.class));
        assertNotNull(plugins.getDefaultPlugin(PluginSwitch.class));
        assertNotNull(plugins.getDefaultPlugin(InstantiatorProvider.class));
        assertNotNull(plugins.getDefaultPlugin(InstantiatorProvider2.class));
        assertNotNull(plugins.getDefaultPlugin(AnnotationEngine.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void instantiator_provider_backwards_compatibility() {
        InstantiatorProvider provider = plugins.getDefaultPlugin(InstantiatorProvider.class);
        Instantiator instantiator = provider.getInstantiator(withSettings().build(MockitoPluginsTest.class));

        assertNotNull(instantiator.newInstance(MockitoPluginsTest.class));
    }
}
