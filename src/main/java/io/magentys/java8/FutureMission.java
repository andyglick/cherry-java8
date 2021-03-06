package io.magentys.java8;

import io.magentys.Mission;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface FutureMission<Result> extends Mission<Result> {

    default CompletableFuture<Result> accomplishAsync(Mission<Result> mission, FunctionalAgent agent) {
            CompletableFuture<Result> futureResult = new CompletableFuture<>();
            Runnable runnable = () -> {
                try {
                    Result result = mission.accomplishAs(agent);
                    futureResult.complete(result);
                } catch (Throwable e) {
                    futureResult.completeExceptionally(e);
                }
            };
            new Thread(runnable).start();

            return futureResult;
    }
}
