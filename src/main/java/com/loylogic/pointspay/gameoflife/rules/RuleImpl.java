package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.State;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */
public class RuleImpl implements Rule{

	@Override
	public State nextState(State currentState, int liveNeighbours) {
		
		if(State.LIVE.equals(currentState))
		{
			if(liveNeighbours==2 || liveNeighbours==3)
			{
				return State.LIVE;
			}
			else return State.DEAD;
		}
		else if(State.DEAD.equals(currentState)) 
		{
			if(liveNeighbours == 3)
			{
				return State.LIVE;
			}
		}
		
		return currentState;
	}

}
