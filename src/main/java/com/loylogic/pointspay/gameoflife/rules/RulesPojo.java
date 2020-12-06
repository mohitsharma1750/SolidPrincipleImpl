package com.loylogic.pointspay.gameoflife.rules;

public class RulesPojo implements IRules{

	private Rule [] rules; 
	
	@Override
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	@Override
	public Rule[] getRules() {
		return rules;
	}
}
