package io.magentys;

import io.magentys.functional.Functions;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.sun.xml.internal.ws.policy.subject.WsdlBindingSubject.WsdlMessageType.OUTPUT;

public class FunctionalAgent extends Agent {


    public FunctionalAgent(Memory memory) {
        super(memory);
    }

    public <INPUT,OUTPUT> OUTPUT performs(Function<INPUT, OUTPUT> myFunction, INPUT input) {
         return myFunction.apply(input);
    }

    public <INPUT> Boolean tests(INPUT s, Predicate<INPUT> isNotEmpty) {
         return isNotEmpty.test(s);
    }

    public <OUTPUT> FunctionalAgent keepsInMindTheResultOf(Supplier<OUTPUT> sultanOfStrings, String uniqueKey) {
        this.keepsInMind(uniqueKey, sultanOfStrings.get());
        return this;
    }


    public <One,Two, OUTPUT> OUTPUT performs(Functions.Function3<One, Two, FunctionalAgent, OUTPUT> functionalMission, One one, Two two) {
        return functionalMission.apply(one,two, this);
    }

    public <One,Two,Three, OUTPUT> OUTPUT performs(Functions.Function4<One, Two,Three, FunctionalAgent, OUTPUT> functionalMission, One one, Two two, Three three) {
        return functionalMission.apply(one,two, three, this);
    }

    public <One,Two,Three, Four, OUTPUT> OUTPUT performs(Functions.Function5<One, Two,Three, Four, FunctionalAgent, OUTPUT> functionalMission, One one, Two two, Three three, Four four) {
        return functionalMission.apply(one,two, three, four, this);
    }


}
