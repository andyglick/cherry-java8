package io.magentys;

import io.magentys.java8.FluentAgent;
import io.magentys.java8.functional.Functions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FluentAgentTest {

    private FluentAgent agent;

    @Before
    public void setUp() {
        agent = new FluentAgent();
    }

    @Test
    public void shouldReturnResultOnSuccess() throws Throwable {
        final String result = "12345";
        assertThat(agent.performs(missionWithArg, result).andReturns().getResult(), equalTo(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowUncheckedExceptionIfNotIgnored() throws Throwable {
        agent.performs(missionThrowingUncheckedException);
    }

    @Test
    public void shouldSuppressUncheckedExceptionIfIgnored() throws Throwable {
        try {
            assertThat(agent.ignoring(IllegalArgumentException.class).performs(missionThrowingUncheckedException).failed(), is(true));
        } catch (IllegalArgumentException e) {
            fail("Expected exception to be suppressed");
        }
    }

    @Test(expected = IOException.class)
    public void shouldThrowCheckedExceptionIfNotIgnored() throws Throwable {
        agent.performs(missionThrowingCheckedException);
    }

    @Test
    public void shouldSuppressCheckedExceptionIfIgnored() throws Throwable {
        try {
            assertThat(agent.ignoring(IOException.class).performs(missionThrowingCheckedException).failed(), is(true));
        } catch (IOException e) {
            fail("Expected exception to be suppressed");
        }
    }

    @Test
    public void shouldKeepInMindResult() throws Throwable {
        agent.performs(missionWithArg, "67890").andKeepsInMind("theResult");
        Result result = agent.recalls("theResult", Result.class);
        assertThat(result, notNullValue());
    }

    private static final Functions.FunctionalMission<Result> missionThrowingUncheckedException = functionalAgent -> {
        throw new IllegalArgumentException("Unchecked exception");
    };

    private static final Functions.FunctionalMission<Result> missionThrowingCheckedException = functionalAgent -> {
        throw new IOException("Checked exception");
    };

    private static final Functions.FunctionalMission1<String, Result> missionWithArg = (arg, functionalAgent) -> new Result(arg);

    static class Result {
        private final String result;

        Result(final String result) {
            this.result = result;
        }

        String getResult() {
            return result;
        }
    }
}
