package com.loylogic.pointspay.gameoflife;

import java.util.Set;

public interface IRuleRunner {
	
	public Set<Cell> applyRules(Set<Cell> liveCells) ;

}
