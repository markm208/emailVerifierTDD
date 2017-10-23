package emailTDD;

public class EmailVerifier
{	
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
	private String validChars;

	//reference to the state machine's current state
	private State currentState;
	
	//to change the state of the state machine- pass in a singleton
	public void changeState(State newState)
	{
		currentState = newState;
	}
	
	//set the acceptable characters before the at
	public void useBeforeAtCharacters()
	{
		//set the valid characters to the group allowed before the at 
		validChars = validCharsBeforeAt;		
	}
	
	//set the acceptable characters after the at
	public void useAfterAtCharacters()
	{
		//set the valid characters to the group allowed after the at
		validChars = validCharsAfterAt;		
	}
	
	/**
	 * Used to verify that an email address is valid.
	 * 
	 * @param emailAddress The email address to test
	 * @return true if this is a valid email, false otherwise
	 */
	public boolean verify(String emailAddress)
	{
		//assume the email address is not valid
		boolean retVal = false;
		
		//set the valid characters for before the at 
		useBeforeAtCharacters();
		
		//start in the first character state
		changeState(FirstCharacter.getInstance());

		try
		{			
			//go through all of the characters in the email address
			for(int i = 0;i < emailAddress.length();i++)
			{
				//get an event from the current character
				Events currentEvent = getEvent(emailAddress.charAt(i));

				//check the event type and send the event to the current state
				if(currentEvent == Events.LETTER)
				{
					currentState.letter(this);
				} 
				else if(currentEvent == Events.DOT)
				{
					currentState.dot(this);
				}
				else if(currentEvent == Events.AT)
				{
					currentState.at(this);
				}

				//if we ever get to the error state stop handling events
				if(currentState == Error.getInstance())
				{
					break;
				}
			}
			
			//after going through all of the characters in the email address
			//verify that the ending state is the valid state
			retVal = currentState == Valid.getInstance();
		}
		catch(Exception ex)
		{
			//do nothing on a bad event, the retVal defaults to false
		}
		
		return retVal;
	}	
	
	private Events getEvent(char character) throws Exception
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
