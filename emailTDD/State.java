package emailTDD;

public class State
{
	private String stateName;
	
	public State(String sn)
	{
		setStateName(sn);
	}
	
	public void letter(EmailVerifier context)
	{
		System.out.println("Unhandled 'letter' event in the state: " + getStateName());
	}
	
	public void dot(EmailVerifier context)
	{
		System.out.println("Unhandled 'dot' event in the state: " + getStateName());
	}
	
	public void at(EmailVerifier context)
	{
		System.out.println("Unhandled 'at' event in the state: " + getStateName());
	}
	
	public String getStateName()
	{
		return stateName;
	}
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
}
