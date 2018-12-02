/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package test.java.org.mockito.internal.verification;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.reporting.SmartPrinter;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartPrinterTest extends TestBase {

    private InvocationMatcher multi;
    private InvocationMatcher shortie;
    @Mock private IMethods mock;

    @Before
    public void setup() throws Exception {
        mock.varargs("first very long argument", "second very long argument", "another very long argument");
        multi = new InvocationMatcher(getLastInvocation());

        mock.varargs("short arg");
        shortie = new InvocationMatcher(getLastInvocation());
    }

    @Test
    public void shouldPrintBothInMultilinesWhenFirstIsMulti() {
        //when
        SmartPrinter printer = new SmartPrinter(multi, shortie.getInvocation());

        //then
        assertThat(printer.getWanted()).contains("\n");
        assertThat(printer.getActual()).contains("\n");
    }

    @Test
    public void shouldPrintBothInMultilinesWhenSecondIsMulti() {
        //when
        SmartPrinter printer = new SmartPrinter(shortie, multi.getInvocation());

        //then
        assertThat(printer.getWanted()).contains("\n");
        assertThat(printer.getActual()).contains("\n");
    }

    @Test
    public void shouldPrintBothInMultilinesWhenBothAreMulti() {
        //when
        SmartPrinter printer = new SmartPrinter(multi, multi.getInvocation());

        //then
        assertThat(printer.getWanted()).contains("\n");
        assertThat(printer.getActual()).contains("\n");
    }

    @Test
    public void shouldPrintBothInSingleLineWhenBothAreShort() {
        //when
        SmartPrinter printer = new SmartPrinter(shortie, shortie.getInvocation());

        //then
        assertThat(printer.getWanted()).doesNotContain("\n");
        assertThat(printer.getActual()).doesNotContain("\n");
    }
}
