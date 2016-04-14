package io.magentys;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
}
