// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

/* Exception For when the player trys to over spend */

@SuppressWarnings("serial")
public class BankAccountBalanceException extends Exception { // extends Exception Class

	public BankAccountBalanceException(String string) 
	{
		super(string);
	}
} // Class
