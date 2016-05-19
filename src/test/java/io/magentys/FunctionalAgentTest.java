package io.magentys;

import io.magentys.java8.FunctionalAgent;
import io.magentys.java8.functional.Functions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.magentys.java8.FunctionalAgentProvider.provideFunctionalAgent;
import static io.magentys.java8.FunctionalVerifier.verifyAsFunctional;
import static io.magentys.java8.functional.FunctionalSugars.rememberedAs;
import static io.magentys.narrators.SysoutNarrator.sysout;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionalAgentTest {

    private FunctionalAgent functionalAgent;

    @Before
    public void setUp() throws Exception {
        functionalAgent = provideFunctionalAgent().get();
    }

    @Test
    public void shouldBeAbleToPerformMissionsInTheShapeOfPredicates() throws Exception {
        Predicate<String> notEmpty = s -> !"".equals(s);
        Predicate<String> notNull = s -> s != null;
        assertThat(functionalAgent.tests(notEmpty.and(notNull), "my perfect phrase!"), is(true));
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

    @Test
    public void shouldPerformAsynchronousOperations() throws Exception {
        assertThat(functionalAgent.performsAsync(asAgent -> "desserts").thenApply(s -> new StringBuffer(s).reverse().toString()).get(),is("stressed"));
    }

    @Test
    public void shouldPerformVerificationsAsMissionsAndVerifyWithHamcrestMatchers() throws Exception {
        functionalAgent.obtains(new Additioner());
        final Functions.FunctionalMission2<Integer, Integer, String> func = (integer1, integer2, agent) -> agent.usingThe(Additioner.class).addAndGetAsString(integer1, integer2);
        verifyAsFunctional(functionalAgent).that(func, 1, 2, is("3"));

    }

    @Test
    public void shouldBeAbleToObtainNarrators() throws Exception {
        functionalAgent.setNarrators(Stream.of(sysout()).collect(toSet()));
        assertThat(functionalAgent.getNarrators().size(), is(1));
        functionalAgent.narrateThat("test");
    }
}