package io.magentys.functional;

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


}
