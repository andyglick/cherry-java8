package io.magentys;

import io.magentys.functional.Functions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.magentys.functional.FunctionalSugars.rememberedAs;
import static io.magentys.functional.FunctionalSugars.withInput;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionalAgentTest {

    private FunctionalAgent functionalAgent;

    @Before
    public void setUp() throws Exception {
        functionalAgent = new FunctionalAgent(new CoreMemory());
    }

    @Test
    public void shouldBeAbleToPerformMissionsInTheShapeOfFunctions() throws Exception {
        assertThat(functionalAgent.performs(Integer::parseInt, withInput("2")), is(2));
    }

    @Test
    public void shouldBeAbleToPerformMissionsInTheShapeOfPredicates() throws Exception {
        Predicate<String> notEmpty = s -> !"".equals(s);
        Predicate<String> notNull = s -> s != null;
        assertThat(functionalAgent.tests("my perfect phrase!", notEmpty.and(notNull)),is(true));
    }

    private Supplier<List<String>> sultanOfStrings = () -> new ArrayList<String>() {{
        add("do");
        add("re");
        add("me");
        add("fa");
        add("sol");
        add("la");
        add("ti");
    }};


    @Test
    public void shouldBeAbleToRememberTheResultOfASupplier() throws Exception {
        functionalAgent.keepsInMindTheResultOf(sultanOfStrings, rememberedAs("music.notes"));
        assertThat(functionalAgent.recalls("music.notes", ArrayList.class).get(0), is("do"));
    }


    private class Additioner {
        public Integer add(Integer... integers) {
            return Stream.of(integers).reduce(0,(a,b)-> a+b);
        }
    }


    @Test
    public void shouldImplementFunctionalMissions() throws Exception {


        functionalAgent.obtains(new Additioner());
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one,two,three), 1, 2, 3),is(6));
        assertThat(functionalAgent.performs((one, two, agent) -> agent.usingThe(Additioner.class).add(one,two), 1, 2),is(3));
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one,two,three), 1, 2, 3),is(6));
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one,two,three), 1, 2, 3),is(6));
    }

}