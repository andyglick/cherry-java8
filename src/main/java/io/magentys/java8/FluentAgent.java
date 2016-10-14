package io.magentys.java8;

import com.lambdista.util.Try;
import io.magentys.Agent;
import io.magentys.CoreMemory;
import io.magentys.Memory;
import io.magentys.java8.functional.Functions;

import java.util.Arrays;
import java.util.List;

public class FluentAgent {

    private final FunctionalAgent agent;
    private final List<Class<? extends Throwable>> ignoredExceptions;

    public FluentAgent() {
        this(new CoreMemory());
    }

    FluentAgent(Class<? extends Throwable>... ignoredExceptions) {
        this(new CoreMemory(), ignoredExceptions);
    }

    public FluentAgent(Memory memory, Class<? extends Throwable>... ignoredExceptions) {
        this.agent = new FunctionalAgent(memory);
        this.ignoredExceptions = Arrays.asList(ignoredExceptions);
    }

    public FluentAgent ignoring(final Class<? extends Throwable>... ignoredExceptions) throws Throwable {
        return new FluentAgent(ignoredExceptions);
    }

    public <Result> MissionResult<Result> performs(Functions.FunctionalMission<Result> mission) throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(agent)));
    }

    public <One, Result> MissionResult<Result> performs(Functions.FunctionalMission1<One, Result> mission, One one) throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(one, agent)));
    }

    public <One, Two, Result> MissionResult<Result> performs(Functions.FunctionalMission2<One, Two, Result> mission, One one, Two two)
            throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(one, two, agent)));
    }

    public <One, Two, Three, Result> MissionResult<Result> performs(Functions.FunctionalMission3<One, Two, Three, Result> mission, One one, Two two,
            Three three) throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(one, two, three, agent)));
    }

    public <One, Two, Three, Four, Result> MissionResult<Result> performs(Functions.FunctionalMission4<One, Two, Three, Four, Result> mission,
            One one, Two two, Three three, Four four) throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(one, two, three, four, agent)));
    }

    public <One, Two, Three, Four, Five, Result> MissionResult<Result> performs(
            Functions.FunctionalMission5<One, Two, Three, Four, Five, Result> mission, One one, Two two, Three three, Four four, Five five)
            throws Throwable {
        return wrapOrThrow(Try.apply(() -> mission.apply(one, two, three, four, five, agent)));
    }

    private <Result> MissionResult<Result> wrapOrThrow(Try<Result> result) throws Throwable {
        if (result.isFailure() && !ignoredExceptions.contains(result.failed().get().getClass())) {
            throw result.failed().get();
        }
        return new MissionResult<>(result, agent);
    }

    public Agent obtains(Object... tools) {
        return agent.obtains(tools);
    }

    public <VALUE> void keepsInMind(String key, VALUE value) {
        agent.keepsInMind(key, value);
    }

    public <VALUE> VALUE recalls(String key, Class<VALUE> clazz) {
        return agent.recalls(key, clazz);
    }
}