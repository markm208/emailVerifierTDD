package emailTDD;

public class EmailVerifier
{
	//different states from the state machine
	private enum States
	{
		ERROR, FIRST_CHARACTER, BEFORE_AT, BEFORE_AT_DOT, FIRST_CHARACTER_AFTER_AT, AFTER_AT, AFTER_AT_DOT, VALID
	}
	
	//different events that can happen
	private enum Events
	{
		LETTER, AT, DOT
	}
	
	//valid characters before the at
	final static String validCharsBeforeAt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&'*+-/=?^_`{|}~";
	//valid characters after the at
	final static String validCharsAfterAt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";
	
	//used to validate characters before/after the at
	private static String validChars;
	
	/**
	 * Used to verify that an email address is valid.
	 * 
	 * @param emailAddress The email address to test
	 * @return
	 */
	public static boolean verify(String emailAddress)
	{
		//assume the email address is not valid
		boolean retVal = false;
		
		//set the valid characters for 
		validChars = validCharsBeforeAt;
		
		//start in the first character state
		States currentState = States.FIRST_CHARACTER;

		try
		{			
			//go through all of the characters in the email address
			for(int i = 0;i < emailAddress.length();i++)
			{
				
				//get an event from the current character
				Events currentEvent = getEvent(emailAddress.charAt(i));

				//check our current state
				if(currentState == States.FIRST_CHARACTER)
				{
					if(currentEvent == Events.LETTER)
					{
						currentState = States.BEFORE_AT;
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.ERROR;
						break;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else if(currentState == States.BEFORE_AT)
				{
					if(currentEvent == Events.LETTER)
					{
						//do nothing
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.BEFORE_AT_DOT;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.FIRST_CHARACTER_AFTER_AT;
						validChars = validCharsAfterAt;
					}				
				}
				else if(currentState == States.BEFORE_AT_DOT)
				{
					if(currentEvent == Events.LETTER)
					{
						currentState = States.BEFORE_AT;
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.ERROR;
						break;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else if(currentState == States.FIRST_CHARACTER_AFTER_AT)
				{
					if(currentEvent == Events.LETTER)
					{
						currentState = States.AFTER_AT;					
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.ERROR;
						break;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else if(currentState == States.AFTER_AT)
				{
					if(currentEvent == Events.LETTER)
					{
						//do nothing
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.AFTER_AT_DOT;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else if(currentState == States.AFTER_AT_DOT)
				{
					if(currentEvent == Events.LETTER)
					{
						currentState = States.VALID;
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.ERROR;
						break;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else if(currentState == States.VALID)
				{
					if(currentEvent == Events.LETTER)
					{
						//do nothing
					} 
					else if(currentEvent == Events.DOT)
					{
						currentState = States.AFTER_AT_DOT;
					}
					else if(currentEvent == Events.AT)
					{
						currentState = States.ERROR;
						break;
					}
				}
				else 
				{
					currentState = States.ERROR;
					break;
				}
			}
			
			//verify that the ending state is the valid state
			retVal = currentState == States.VALID;
		}
		catch(Exception ex)
		{
			//do nothing, the retVal defaults to false
		}
		
		return retVal;
	}	
	
	private static Events getEvent(char character) throws Exception
	{
		Events retVal;
		
		//if the character is one of the valid letters/digits
		if(validChars.indexOf(character) != -1)
		{
			retVal = Events.LETTER;
		}
		else if(character == '.') //its a dot
		{
			retVal = Events.DOT;
		}
		else if(character == '@') //its the at
		{
			retVal = Events.AT;
		}
		else //bad character
		{
			throw new Exception("Invalid character " + character);
		}
		
		return retVal;
	}
}
