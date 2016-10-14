package io.magentys.java8;

import com.lambdista.util.Try;
import io.magentys.Agent;

public class MissionResult<T> {

    private final Try<T> tryable;
    private final Agent agent;

    public MissionResult(Try<T> tryable, Agent agent) {
        this.tryable = tryable;
        this.agent = agent;
    }

    public T andReturns() throws Throwable {
        if (tryable.isFailure()) {
            throw tryable.failed().get();
        }
        return tryable.get();
    }

    public MissionResult<T> andKeepsInMind(final String key) {
        agent.keepsInMind(key, tryable.get());
        return this;
    }

    public boolean failed() {
        return tryable.isFailure();
    }
}