package io.magentys;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static io.magentys.functional.FunctionalSugars.withInput;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionalAgentTest {

    private FunctionalAgent functionalAgent;

    @Before
    public void setUp() throws Exception {
        functionalAgent = new FunctionalAgent(new CoreMemory());
    }

    @org.junit.Test
    public void shouldBeAbleToPerformMissionsInTheShapeOfFunctions() throws Exception {
        Function<String,Integer> aStringToIntegerTransformation = s -> Integer.parseInt(s);
        assertThat(functionalAgent.performs(aStringToIntegerTransformation, withInput("2")), is(2));
    }

    @org.junit.Test
    public void shouldBeAbleToPerformMissionsInTheShapeOfPredicates() throws Exception {
        Predicate<String> notEmpty = s -> !"".equals(s);
        Predicate<String> notNull = s -> s != null;
        assertThat(functionalAgent.tests("my perfect phrase!", notEmpty.and(notNull)),is(true));
    }

    private Supplier<List<String>> sultanOfStrings = () -> new ArrayList<String>() {{
        add("do");
        add("re");
        add("me");
    }};


    @org.junit.Test
    public void shouldBeAbleToRememberTheResultOfASupplier() throws Exception {
        functionalAgent.keepsInMindTheResultOf(sultanOfStrings, "unique.key");
        assertThat(functionalAgent.recalls("unique.key", ArrayList.class).size(), is(3));
    }


}