module mockito.base{
    requires java.base;
  //  requires hamcrest.core;
  //  requires junit;
    requires net.bytebuddy.agent;
    requires net.bytebuddy;
    requires java.instrument;
    exports org.mockito.configuration;
    exports org.mockito.exceptions.verification;
    exports org.mockito.exceptions.base;
    exports org.mockito.exceptions.misusing;
    exports org.mockito.exceptions.stacktrace;
    exports org.mockito.hamcrest;
    exports org.mockito.junit;
    exports org.mockito.plugins;
    exports org.mockito.quality;
    exports org.mockito.runners;
    exports org.mockito.verification;
    exports org.mockito.invocation;
    exports org.mockito.listeners;
    exports org.mockito.mock;
    }
