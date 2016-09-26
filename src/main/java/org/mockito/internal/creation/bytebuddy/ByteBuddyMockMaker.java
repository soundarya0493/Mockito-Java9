package org.mockito.internal.creation.bytebuddy;

import java.util.Set;
import org.mockito.Incubating;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.SerializableMode;
import org.mockito.plugins.MockMaker;

/**
 * ByteBuddy MockMaker.
 *
 * This class will serve as the programmatic entry point to all mockito internal MockMakers.
 * Currently the default and only mock maker is the subclassing engine, but with enough feedback we can later
 * promote the inlining engine for features like final class/methods mocks.
 *
 * The programmatic API could look like {@code mock(Final.class, withSettings().finalClasses())}.
 */
public class ByteBuddyMockMaker implements MockMaker {
    private MockMaker defaultByteBuddyMockMaker = new SubclassByteBuddyMockMaker();

    @Override
    public <T> T createMock(MockCreationSettings<T> settings, MockHandler handler) {
        return defaultByteBuddyMockMaker.createMock(settings, handler);
    }

    @Override
    public <T> Class<? extends T> createMockType(Class<T> mockedType, Set<Class<?>> interfaces, SerializableMode serializableMode) {
        return defaultByteBuddyMockMaker.createMockType(mockedType, interfaces, serializableMode);
    }

    @Override
    public MockHandler getHandler(Object mock) {
        return defaultByteBuddyMockMaker.getHandler(mock);
    }

    @Override
    @Incubating
    public Class<?> getMockedType(Object mock) {
        return defaultByteBuddyMockMaker.getMockedType(mock);
    }

    @Override
    public void resetMock(Object mock, MockHandler newHandler, MockCreationSettings settings) {
        defaultByteBuddyMockMaker.resetMock(mock, newHandler, settings);
    }

    @Override
    @Incubating
    public TypeMockability isTypeMockable(Class<?> type) {
        return defaultByteBuddyMockMaker.isTypeMockable(type);
    }
}
