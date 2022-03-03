package com.biscuit.commands.Exceptions;

/**
 * @author ksharm53
 *
 */
public class TaigaProjectNotSavedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaigaProjectNotSavedException(String errorMessage) {
		super(errorMessage);
	}
}
