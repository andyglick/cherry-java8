package io.magentys.java8;

import io.magentys.Memory;
import io.magentys.Narrator;

import java.util.stream.Stream;

import static io.magentys.CoreMemory.coreMemory;
import static java.util.stream.Collectors.toSet;

/**
 * Agent Provider creates agents as a Builder
 */
public class FunctionalAgentProvider {

    private FunctionalAgentProvider() {
        anAgent = agent();
    }

    private FunctionalAgentProvider(FunctionalAgent agent) {
        anAgent = agent;
    }

    private FunctionalAgent anAgent;

    /**
     * Provides a vanilla agent with CoreMemory
     *
     * @return an empty agent
     */
    public static FunctionalAgent agent() {
        return new FunctionalAgent(coreMemory());
    }

    /**
     * Create a new agent with a type of memory
     *
     * @param memory the provided memory
     * @return a new agent
     */
    public static FunctionalAgent agentWithMemory(Memory memory) {
        return new FunctionalAgent(memory);
    }

    /**
     * The starting point for creating agents
     *
     * @return an AgentProvider
     */
    public static FunctionalAgentProvider provideFunctionalAgent() {
        return new FunctionalAgentProvider();
    }

    /**
     * Create a new agent with the memory provided
     *
     * @param memory the provided memory
     * @return a new agent
     */
    public FunctionalAgentProvider withMemory(Memory memory) {
        anAgent = anAgent.clone();
        anAgent.setMemory(memory);
        return this;
    }

    /**
     * Create a new agent with the tools provided
     *
     * @param tools the provided tools
     * @return a new agent
     */
    public FunctionalAgentProvider withTools(Object... tools) {
        anAgent = (FunctionalAgent) anAgent.clone().obtains(tools);
        return this;
    }

    /**
     * Return the agent
     *
     * @return the built agent
     */
    public FunctionalAgent get() {
        return anAgent;
    }

    public FunctionalAgentProvider withNarrators(Narrator... narrators) {
        anAgent = (FunctionalAgent) anAgent.clone().setNarrators(Stream.of(narrators).collect(toSet()));
        return this;
    }
}