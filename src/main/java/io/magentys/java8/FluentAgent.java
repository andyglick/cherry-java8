package io.magentys.java8;

import com.lambdista.util.Try;
import io.magentys.Agent;
import io.magentys.CoreMemory;
import io.magentys.Memory;
import io.magentys.java8.functional.Functions;

public class FluentAgent {

    private final FunctionalAgent agent;

    public FluentAgent() {
        this(new CoreMemory());
    }

    public FluentAgent(Memory memory) {
        this.agent = new FunctionalAgent(memory);
    }

    public <Result> MissionResult<Result> performs(Functions.FunctionalMission<Result> mission) throws Exception {
        return wrapAndReturn(Try.apply(() -> mission.apply(agent)));
    }

    public <One, Result> MissionResult<Result> performs(Functions.FunctionalMission1<One, Result> mission, One one) throws Exception {
        return wrapAndReturn(Try.apply(() -> mission.apply(one, agent)));
    }

    public <One, Two, Result> MissionResult<Result> performs(Functions.FunctionalMission2<One, Two, Result> mission, One one, Two two) {
        return wrapAndReturn(Try.apply(() -> mission.apply(one, two, agent)));
    }

    public <One, Two, Three, Result> MissionResult<Result> performs(Functions.FunctionalMission3<One, Two, Three, Result> mission, One one, Two two,
            Three three) {
        return wrapAndReturn(Try.apply(() -> mission.apply(one, two, three, agent)));
    }

    public <One, Two, Three, Four, Result> MissionResult<Result> performs(Functions.FunctionalMission4<One, Two, Three, Four, Result> mission,
            One one, Two two, Three three, Four four) {
        return wrapAndReturn(Try.apply(() -> mission.apply(one, two, three, four, agent)));
    }

    public <One, Two, Three, Four, Five, Result> MissionResult<Result> performs(
            Functions.FunctionalMission5<One, Two, Three, Four, Five, Result> mission, One one, Two two, Three three, Four four, Five five) {
        return wrapAndReturn(Try.apply(() -> mission.apply(one, two, three, four, five, agent)));
    }

    private <Result> MissionResult<Result> wrapAndReturn(Try<Result> result) {
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