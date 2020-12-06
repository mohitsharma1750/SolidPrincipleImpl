package com.loylogic.pointspay.gameoflife;

import java.util.Set;

import com.loylogic.pointspay.gameoflife.rules.Rule;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */
public interface GameStratedy {

	Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);

}
