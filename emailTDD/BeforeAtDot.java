package emailTDD;

public class BeforeAtDot extends State
{
	//to make this a singleton
	private static State instance;

	private BeforeAtDot()
	{
		super("Before At Dot");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new BeforeAtDot();
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
