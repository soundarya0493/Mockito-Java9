module mockito.base {
    requires java.base;
    requires junit;
    requires org.objenesis;
    requires java.instrument;
    requires net.bytebuddy;
    requires net.bytebuddy.agent;
    requires mockito.external;
    exports org.mockito.configuration;
    exports org.mockito.exceptions.base;
    exports org.mockito.exceptions.misusing;
    exports org.mockito.exceptions.stacktrace;
    exports org.mockito.exceptions.verification;
    exports org.mockito.hamcrest;
    exports org.mockito.instance;
    exports org.mockito.invocation;
    exports org.mockito.junit;
    exports org.mockito.listeners;
    exports org.mockito.mock;
    exports org.mockito.plugins;
    exports org.mockito.quality;
    exports org.mockito.runners;
    exports org.mockito.stubbing;
    exports org.mockito.verification;
}
