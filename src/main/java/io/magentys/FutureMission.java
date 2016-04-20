package io.magentys;

import java.util.concurrent.CompletableFuture;

public interface FutureMission<Result> extends Mission<Result>{

    default public CompletableFuture<Result> accomplishAsync(Mission<Result> mission, FunctionalAgent agent) {
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
