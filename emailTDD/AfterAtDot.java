package emailTDD;

public class AfterAtDot extends State
{
	//to make this a singleton
	private static State instance;

	private AfterAtDot()
	{
		super("After At Dot");
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new AfterAtDot();
		}
		
		return instance;
	}

	@Override
	public void letter(EmailVerifier context)
	{
		context.changeState(Valid.getInstance());
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
