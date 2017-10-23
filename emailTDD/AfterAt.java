package emailTDD;

public class AfterAt extends State
{
	//to make this a singleton
	private static State instance;

	private AfterAt()
	{
		super("After At");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new AfterAt();
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
