package emailTDD;

public class FirstCharacter extends State
{
	//to make this a singleton
	private static State instance;
	
	private FirstCharacter()
	{
		super("First Character");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new FirstCharacter();
		}
		
		return instance;
	}
	
	@Override
	public void letter(EmailVerifier context)
	{
		context.changeState(BeforeAt.getInstance());
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
