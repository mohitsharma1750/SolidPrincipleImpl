package com.loylogic.pointspay.gameoflife.rules;

import com.loylogic.pointspay.gameoflife.State;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */
public interface Rule {
	State nextState(State currentState,int liveNeighbours);
}
