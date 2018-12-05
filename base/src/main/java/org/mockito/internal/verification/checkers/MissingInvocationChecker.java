/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockito.internal.verification.checkers;

import org.mockito.internal.reporting.SmartPrinter;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

import java.util.List;

import static org.mockito.internal.exceptions.Reporter.*;
import static org.mockito.internal.invocation.InvocationsFinder.*;
import static org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool.getSuspiciouslyNotMatchingArgsIndexes;

public class MissingInvocationChecker {

    private MissingInvocationChecker() {
    }

    public static void checkMissingInvocation(List<Invocation> invocations, MatchableInvocation wanted) {
        List<Invocation> actualInvocations = findInvocations(invocations, wanted);

        if (!actualInvocations.isEmpty()){
            return;
        }

        Invocation similar = findSimilarInvocation(invocations, wanted);
        if (similar == null) {
            throw wantedButNotInvoked(wanted, invocations);
        }

        Integer[] indexesOfSuspiciousArgs = getSuspiciouslyNotMatchingArgsIndexes(wanted.getMatchers(), similar.getArguments());
        SmartPrinter smartPrinter = new SmartPrinter(wanted, similar, indexesOfSuspiciousArgs);
        throw argumentsAreDifferent(smartPrinter.getWanted(), smartPrinter.getActual(), similar.getLocation());

    }

    public static void checkMissingInvocation(List<Invocation> invocations, MatchableInvocation wanted, InOrderContext context) {
        List<Invocation> chunk = findAllMatchingUnverifiedChunks(invocations, wanted, context);

        if (!chunk.isEmpty()) {
            return;
        }

        Invocation previousInOrder = findPreviousVerifiedInOrder(invocations, context);
        if (previousInOrder != null) {
            throw wantedButNotInvokedInOrder(wanted, previousInOrder);
        }

        checkMissingInvocation(invocations, wanted);
    }
}
