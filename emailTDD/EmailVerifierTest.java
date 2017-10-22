package emailTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailVerifierTest 
{
	@Test
	void test() 
	{
		
		assertTrue(EmailVerifier.verify("mmahoney@carthage.edu"));
	}
}
