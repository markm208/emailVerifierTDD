package emailTDD;

public class Error extends State
{
	//to make this a singleton
	private static State instance;

	private Error()
	{
		super("Error");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new Error();
		}
		
		return instance;
	}
	
	//don't handle events in this state
}
