package emailTDD;

public class BeforeAt extends State
{
	//to make this a singleton
	private static State instance;

	private BeforeAt()
	{
		super("Before At");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new BeforeAt();
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
		context.changeState(BeforeAtDot.getInstance());
	}
	
	@Override
	public void at(EmailVerifier context)
	{
		context.changeState(FirstCharacterAfterAt.getInstance());
		
		//change the acceptable characters after the @
		context.useAfterAtCharacters();
	}
}
