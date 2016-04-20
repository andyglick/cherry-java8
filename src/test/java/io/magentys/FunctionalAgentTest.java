package io.magentys;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
    public void shouldBeAbleToPerformMissionsInTheShapeOfPredicates() throws Exception {
        Predicate<String> notEmpty = s -> !"".equals(s);
        Predicate<String> notNull = s -> s != null;
        assertThat(functionalAgent.tests("my perfect phrase!", notEmpty.and(notNull)), is(true));
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
            return Stream.of(integers).reduce(0, (a, b) -> a + b);
        }

        public String addAndGetAsString(Integer... integers) {
            return add(integers).toString();
        }
    }


    @Test
    public void shouldPerformMissionsAsFunctions() throws Exception {


        functionalAgent.obtains(new Additioner());
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one, two, three), 1, 2, 3), is(6));
        assertThat(functionalAgent.performs((one, two, agent) -> agent.usingThe(Additioner.class).add(one, two), 1, 2), is(3));
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one, two, three), 1, 2, 3), is(6));
        assertThat(functionalAgent.performs((one, two, three, agent) -> agent.usingThe(Additioner.class).add(one, two, three), 1, 2, 3), is(6));
    }

    @Test
    public void shouldPerformMissionsAsFunctionalMissionsWithImplicitSettingOfAgent() throws Exception {
        functionalAgent.obtains(new Additioner());
        String result = functionalAgent.performs((integer, integer2, integer3, agent) -> agent.usingThe(Additioner.class).addAndGetAsString(integer, integer2, integer3), 1, 2, 3);
        assertThat(result, is("6"));
    }
}