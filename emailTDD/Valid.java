package emailTDD;

public class Valid extends State
{
	//to make this a singleton
	private static State instance;

	private Valid()
	{
		super("Valid");
	}

	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new Valid();
		}
		
		return instance;
	}

	@Override
	public void letter(EmailVerifier context)
	{
		//do nothing
	}
	
	@Override
	public void dot(EmailVerifier context)
	{
		context.changeState(AfterAtDot.getInstance());
	}
	
	@Override
	public void at(EmailVerifier context)
	{
		context.changeState(Error.getInstance());
	}
}
