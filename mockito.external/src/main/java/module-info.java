module mockito.external{
    requires java.base;
    requires mockito.base;
    exports org.mockito.codegen;
    exports org.mockito.creation.instance;
    exports org.mockito.invocation;
    exports org.mockito.listeners;
    exports org.mockito.mock;
    exports org.mockito.session;
    exports org.mockito.stubbing;
}
