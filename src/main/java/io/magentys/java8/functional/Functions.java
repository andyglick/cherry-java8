package io.magentys.java8.functional;

import io.magentys.java8.FunctionalAgent;

public class Functions {

    @FunctionalInterface
    public interface Function2<One, Two, Result> {
        Result apply(One one, Two two) throws Exception;
    }

    @FunctionalInterface
    public interface Function3<One, Two, Three, Result> {
        Result apply(One one, Two two, Three three) throws Exception;
    }

    @FunctionalInterface
    public interface Function4<One, Two, Three, Four, Result> {
        Result apply(One one, Two two, Three three, Four four) throws Exception;
    }

    @FunctionalInterface
    public interface Function5<One, Two, Three, Four, Five, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five) throws Exception;
    }

    @FunctionalInterface
    public interface Function6<One, Two, Three, Four, Five, Six, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five, Six six) throws Exception;
    }

    @FunctionalInterface
    public interface Function7<One, Two, Three, Four, Five, Six, Seven, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five, Six six, Seven seven) throws Exception;
    }

    @FunctionalInterface
    public interface Function8<One, Two, Three, Four, Five, Six, Seven, Eight, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five, Six six, Seven seven, Eight eight) throws Exception;
    }

    @FunctionalInterface
    public interface Function9<One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five, Six six, Seven seven, Eight eight, Nine nine) throws Exception;
    }

    @FunctionalInterface
    public interface Function10<One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Result> {
        Result apply(One one, Two two, Three three, Four four, Five five, Six six, Seven seven, Eight eight, Nine nine, Ten ten) throws Exception;
    }

    @FunctionalInterface
    public interface FunctionalMission<RESULT> {
        RESULT apply(FunctionalAgent functionalAgent) throws Exception;
    }

    @FunctionalInterface
    public interface FunctionalMission1<One, Result> extends Function2<One, FunctionalAgent, Result> {

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

    @FunctionalInterface
    public interface FunctionalMission5<One, Two, Three, Four, Five, Result> extends Function6<One, Two, Three, Four, Five, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission6<One, Two, Three, Four, Five, Six, Result>
            extends Function7<One, Two, Three, Four, Five, Six, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission7<One, Two, Three, Four, Five, Six, Seven, Result>
            extends Function8<One, Two, Three, Four, Five, Six, Seven, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission8<One, Two, Three, Four, Five, Six, Seven, Eight, Result>
            extends Function9<One, Two, Three, Four, Five, Six, Seven, Eight, FunctionalAgent, Result> {

    }

    @FunctionalInterface
    public interface FunctionalMission9<One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Result>
            extends Function10<One, Two, Three, Four, Five, Six, Seven, Eight, Nine, FunctionalAgent, Result> {

    }

}
