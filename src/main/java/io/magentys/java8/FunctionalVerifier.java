package io.magentys.java8;

import io.magentys.AgentVerifier;
import io.magentys.java8.functional.Functions;
import org.hamcrest.Matcher;

import static org.junit.Assert.assertThat;

/**
 * Created by kostasmamalis on 29/04/16.
 */
public class FunctionalVerifier extends AgentVerifier {

    public FunctionalVerifier(FunctionalAgent agent) {
        super(agent);
    }

    public static FunctionalVerifier verifyAsFunctional(FunctionalAgent agent) {
        return new FunctionalVerifier(agent);
    }

    public <TYPE> void that(Functions.FunctionalMission<TYPE> obj, Matcher<TYPE> objectMatcher) {
        assertThat(obj.apply((FunctionalAgent) agent), objectMatcher);
    }

    public <Input1,Output> void that(Functions.FunctionalMission1<Input1,Output> func, Input1 input, Matcher<Output> objectMatcher) {
        FunctionalAgent functionalAgent = (FunctionalAgent) agent;
        assertThat(functionalAgent.performs(func,input), objectMatcher);
    }

    public <Input1,Input2, Output> void that(Functions.FunctionalMission2<Input1,Input2,Output> func, Input1 input, Input2 input2, Matcher<Output> objectMatcher) {
        FunctionalAgent functionalAgent = (FunctionalAgent) agent;
        assertThat(functionalAgent.performs(func,input, input2), objectMatcher);
    }

    public <Input1,Input2, Input3, Output> void that(Functions.FunctionalMission3<Input1,Input2,Input3,Output> func, Input1 input, Input2 input2, Input3 input3, Matcher<Output> objectMatcher) {
        FunctionalAgent functionalAgent = (FunctionalAgent) agent;
        assertThat(functionalAgent.performs(func,input, input2, input3), objectMatcher);
    }

    public <Input1,Input2, Input3, Input4, Output> void that(Functions.FunctionalMission4<Input1,Input2,Input3, Input4, Output> func, Input1 input, Input2 input2, Input3 input3, Input4 input4, Matcher<Output> objectMatcher) {
        FunctionalAgent functionalAgent = (FunctionalAgent) agent;
        assertThat(functionalAgent.performs(func,input, input2, input3,input4), objectMatcher);
    }


}
