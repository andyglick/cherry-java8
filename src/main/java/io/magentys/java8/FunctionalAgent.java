package io.magentys.java8;

import io.magentys.Agent;
import io.magentys.CoreMemory;
import io.magentys.Memory;
import io.magentys.java8.functional.Functions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalAgent extends Agent {

    public FunctionalAgent(Memory memory) {
        super(memory);
    }

    public static FunctionalAgent functionalAgent() {
        return new FunctionalAgent(new CoreMemory());
    }

    public <INPUT, OUTPUT> OUTPUT performs(Function<INPUT, OUTPUT> myFunction, INPUT input) {
        return myFunction.apply(input);
    }

    public <INPUT> Boolean tests(Predicate<INPUT> predicate, INPUT input) {
        return predicate.test(input);
    }

    public <OUTPUT> FunctionalAgent keepsInMindTheResultOf(Supplier<OUTPUT> supplier, String uniqueKey) {
        this.keepsInMind(uniqueKey, supplier.get());
        return this;
    }

    public <OUTPUT> OUTPUT performs(Function<FunctionalAgent, OUTPUT> functionalMission) {
        return functionalMission.apply(this);
    }

    public <One, OUTPUT> OUTPUT performs(Functions.Function2<One, FunctionalAgent, OUTPUT> functionalMission, One one) throws Exception {
        return functionalMission.apply(one, this);
    }

    public <One, Two, OUTPUT> OUTPUT performs(Functions.Function3<One, Two, FunctionalAgent, OUTPUT> functionalMission, One one, Two two)
            throws Exception {
        return functionalMission.apply(one, two, this);
    }

    public <One, Two, Three, OUTPUT> OUTPUT performs(Functions.Function4<One, Two, Three, FunctionalAgent, OUTPUT> functionalMission, One one,
            Two two, Three three) throws Exception {
        return functionalMission.apply(one, two, three, this);
    }

    public <One, Two, Three, Four, OUTPUT> OUTPUT performs(Functions.Function5<One, Two, Three, Four, FunctionalAgent, OUTPUT> functionalMission,
            One one, Two two, Three three, Four four) throws Exception {
        return functionalMission.apply(one, two, three, four, this);
    }

    public <Result> Result performs(Functions.FunctionalMission<Result> mission) throws Exception {
        return mission.apply(this);
    }

    public <One, Result> Result performs(Functions.FunctionalMission1<One, Result> mission, One one) throws Exception {
        return mission.apply(one, this);
    }

    public <One, Two, Result> Result performs(Functions.FunctionalMission2<One, Two, Result> mission, One one, Two two) throws Exception {
        return mission.apply(one, two, this);
    }

    public <One, Two, Three, Result> Result performs(Functions.FunctionalMission3<One, Two, Three, Result> mission, One one, Two two, Three three)
            throws Exception {
        return mission.apply(one, two, three, this);
    }

    public <One, Two, Three, Four, Result> Result performs(Functions.FunctionalMission4<One, Two, Three, Four, Result> mission, One one, Two two,
            Three three, Four four) throws Exception {
        return mission.apply(one, two, three, four, this);
    }

    public <Result> CompletableFuture<Result> performsAsync(FutureMission<Result> mission) {
        return mission.accomplishAsync(mission, this);
    }

    public <Input, Result> Future<Result> performsAsync(Functions.FunctionalMission1<Input, Result> mission, Input input) {
        CompletableFuture<Result> futureResult = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                Result result = mission.apply(input, this);
                futureResult.complete(result);
            } catch (Throwable e) {
                futureResult.completeExceptionally(e);
            }
        };
        new Thread(runnable).start();
        return futureResult;
    }

    public <One, Two, Result> Future<Result> performsAsync(Functions.FunctionalMission2<One, Two, Result> mission, One one, Two two) {
        CompletableFuture<Result> futureResult = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                Result result = mission.apply(one, two, this);
                futureResult.complete(result);
            } catch (Throwable e) {
                futureResult.completeExceptionally(e);
            }
        };
        new Thread(runnable).start();
        return futureResult;
    }

    public <One, Two, Three, Result> Future<Result> performsAsync(Functions.FunctionalMission3<One, Two, Three, Result> mission, One one, Two two,
            Three three) {
        CompletableFuture<Result> futureResult = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                Result result = mission.apply(one, two, three, this);
                futureResult.complete(result);
            } catch (Throwable e) {
                futureResult.completeExceptionally(e);
            }
        };
        new Thread(runnable).start();
        return futureResult;
    }

    public <One, Two, Three, Four, Result> Future<Result> performsAsync(Functions.FunctionalMission4<One, Two, Three, Four, Result> mission, One one,
            Two two, Three three, Four four) {
        CompletableFuture<Result> futureResult = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                Result result = mission.apply(one, two, three, four, this);
                futureResult.complete(result);
            } catch (Throwable e) {
                futureResult.completeExceptionally(e);
            }
        };
        new Thread(runnable).start();
        return futureResult;
    }

    public FunctionalAgent clone() {
        FunctionalAgent functionalAgent = new FunctionalAgent(getMemory());
        functionalAgent.setTools(getTools());
        return functionalAgent;
    }
}
