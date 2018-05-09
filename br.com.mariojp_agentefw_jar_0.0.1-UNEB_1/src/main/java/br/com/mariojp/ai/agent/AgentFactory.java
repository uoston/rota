package br.com.mariojp.ai.agent;

import br.com.mariojp.ai.agent.strategies.BeamSearch;
import br.com.mariojp.ai.agent.strategies.BreadthFirstSearch;
import br.com.mariojp.ai.agent.strategies.BreadthFirstSearchBiDirect;
import br.com.mariojp.ai.agent.strategies.BreadthFirstSearchReverse;
import br.com.mariojp.ai.agent.strategies.DepthFirstSearch;
import br.com.mariojp.ai.agent.strategies.GreedySearch;
import br.com.mariojp.ai.agent.strategies.HillClimbingSearch;
import br.com.mariojp.ai.agent.strategies.MiniMax;
import br.com.mariojp.ai.agent.strategies.MiniMaxAB;
import br.com.mariojp.ai.agent.strategies.SimulatedAnnealingSearch;
import br.com.mariojp.ai.agent.strategies.StarSearch;
import br.com.mariojp.ai.agent.strategies.UniformCostSearch;

public class AgentFactory {

	public static IAgent createAgent(AgentModel agent) {
		IAgent newAgent = null;
		switch (agent.getType()) {
		case IAgent.DEPTH_FIRST_SEARCH:
			newAgent = new DepthFirstSearch(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH:
			newAgent = new BreadthFirstSearch(agent);
			break;
		case IAgent.GREEDY_SEARCH:
			newAgent = new GreedySearch(agent);
			break;
		case IAgent.STAR_SEARCH:
			newAgent = new StarSearch(agent);
			break;
		case IAgent.UNIFORM_COST_SEARCH:
			newAgent = new UniformCostSearch(agent);
			break;
		case IAgent.MINIMAX:
			newAgent = new MiniMax(agent);
			break;
		case IAgent.MINIMAX_ALFA_BETA:
			newAgent = new MiniMaxAB(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH_REVERSE:
			newAgent = new BreadthFirstSearchReverse(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH_BI_DIRECT:
			newAgent = new BreadthFirstSearchBiDirect(agent);
			break;
                case IAgent.HILL_CLIMBING_SEARCH:
			newAgent = new HillClimbingSearch(agent);
			break;
                case IAgent.SIMULATED_ANNEALING_SEARCH:
			newAgent = new SimulatedAnnealingSearch(agent);
			break;
                case IAgent.BEAM_SEARCH:
			newAgent = new BeamSearch(agent);
			break;
		
		}
		return newAgent;

	}

}
