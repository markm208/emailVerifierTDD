package emailTDD;

public class FirstCharacterAfterAt extends State
{
	//to make this a singleton
	private static State instance;

	private FirstCharacterAfterAt()
	{
		super("First Character After At");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new FirstCharacterAfterAt();
		}
		
		return instance;
	}

	@Override
	public void letter(EmailVerifier context)
	{
		context.changeState(AfterAt.getInstance());
	}
	
	@Override
	public void dot(EmailVerifier context)
	{
		context.changeState(Error.getInstance());
	}
	
	@Override
	public void at(EmailVerifier context)
	{
		context.changeState(Error.getInstance());
	}
}
