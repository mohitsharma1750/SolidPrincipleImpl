package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.rules.IRules;
import com.loylogic.pointspay.gameoflife.rules.Rule;
import com.loylogic.pointspay.gameoflife.rules.RuleImpl;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */
public class DefaultGameStratedgy  {
	
	private IRules rulesList;

	public DefaultGameStratedgy()
	{
		rulesList.setRules(new Rule[]{new RuleImpl()});
	}
	
}
