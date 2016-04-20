package io.magentys.functional;

import io.magentys.FunctionalAgent;

public class Functions {

    @FunctionalInterface
    public interface Function2<One,Two, Result> {
        Result apply(One one, Two two);
    }

    @FunctionalInterface
    public interface Function3<One,Two, Three, Result> {
        Result apply(One one, Two two, Three three);
    }

    @FunctionalInterface
    public interface Function4<One,Two, Three, Four, Result> {
        Result apply(One one, Two two, Three three, Four four);
    }
    @FunctionalInterface
    public interface Function5<One,Two, Three, Four, Five, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five);
    }

    @FunctionalInterface
    public interface FunctionalMission<One,Result> extends Function2<One, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission2<One, Two, Result> extends Function3<One, Two, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission3<One, Two, Three, Result> extends Function4<One, Two, Three, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission4<One, Two, Three, Four, Result> extends Function5<One, Two, Three, Four, FunctionalAgent, Result> {

    }

}
