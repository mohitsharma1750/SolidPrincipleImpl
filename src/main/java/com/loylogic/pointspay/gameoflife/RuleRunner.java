package com.loylogic.pointspay.gameoflife;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.loylogic.pointspay.gameoflife.rules.IRules;
import com.loylogic.pointspay.gameoflife.rules.Rule;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */

public class RuleRunner implements IRuleRunner{
	
	private GameStratedy gameStratedy;
	
	private IRules rulesList;

	public RuleRunner(GameStratedy gameStratedy, IRules rules)
	{
		this.gameStratedy = gameStratedy;
		this.rulesList = rules;
	}

	@Override
	public Set<Cell> applyRules(Set<Cell> liveCells) {
		HashSet<Cell> nextGeneration=new HashSet<Cell>(); 
		
		Set<Cell> neighbouringCells;
		for(Cell cellFromCurrentGeneration: liveCells)
		{
			processCell(cellFromCurrentGeneration,liveCells,nextGeneration);
			
			neighbouringCells=gameStratedy.findNeighbours(cellFromCurrentGeneration, liveCells);
			
			for(Cell neighbouringCell:neighbouringCells)
			{
				processCell(neighbouringCell,liveCells,nextGeneration);
			}
		}
		
		return filterDead(nextGeneration);
	}
	
	
	private Set<Cell> filterDead(HashSet<Cell> nextGeneration) {
		Iterator<Cell> iterator = nextGeneration.iterator();
		
		while(iterator.hasNext())
		{
			if(State.DEAD.equals(iterator.next().getState()))
			{
				iterator.remove();
			}
		}
		
		return nextGeneration;
	}


	private void processCell(Cell cell,Set<Cell> currentGeneration,Set<Cell> nextGeneration)
	{
		if(nextGeneration.contains(cell)) return; // already processed
		
		cell=cell.createCopy();
		
		State nextState=cell.getState();
		for(Rule rule:rulesList.getRules())
		{
			nextState=rule.nextState(cell.getState(), findLiveNeighbourCount(cell, currentGeneration));
			
			if(!cell.getState().equals(nextState))
			{
				break;
			}
		}
		
		cell.setState(nextState);
		nextGeneration.add(cell);
	}
	
	

	private int findLiveNeighbourCount(Cell cell,Set<Cell> liveCells)
	{
		int count=0;
		for(Cell c:gameStratedy.findNeighbours(cell, liveCells))
		{
			if(State.LIVE.equals(c.getState())) count++;
		}
		return count;
	}

}
