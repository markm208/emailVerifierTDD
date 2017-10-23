package emailTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailVerifierTest 
{
	@Test
	void testValidEmailAddresses() 
	{
		assertTrue(EmailVerifier.verify("mmahoney@carthage.edu"));
		assertTrue(EmailVerifier.verify("mark.mahoney@carthage.edu"));
		assertTrue(EmailVerifier.verify("mark.robert.mahoney@carthage.edu"));
		assertTrue(EmailVerifier.verify("mmahoney@cs.carthage.edu"));
		assertTrue(EmailVerifier.verify("mark.mahoney@cs.carthage.edu"));
		assertTrue(EmailVerifier.verify("mark.robert.mahoney@cs.carthage.edu"));
		assertTrue(EmailVerifier.verify("!#$%&'*+-/=?^_`{|}~@carthage.edu"));
	}
	
	@Test
	void testInvalidEmailAddresses() 
	{
		assertFalse(EmailVerifier.verify(""));
		assertFalse(EmailVerifier.verify(" "));
		assertFalse(EmailVerifier.verify("   mmahoney@carthage.edu"));
		assertFalse(EmailVerifier.verify("mmahoney@carthage.edu   "));
		assertFalse(EmailVerifier.verify("   mmahoney@carthage.edu   "));
		assertFalse(EmailVerifier.verify("mmahoney @ carthage . edu"));
		assertFalse(EmailVerifier.verify("@"));
		assertFalse(EmailVerifier.verify("."));
		assertFalse(EmailVerifier.verify("mmahoney"));
		assertFalse(EmailVerifier.verify("mmahoney@"));
		assertFalse(EmailVerifier.verify("mmahoney@carthage"));
		assertFalse(EmailVerifier.verify("mmahoney.@carthage.edu"));
		assertFalse(EmailVerifier.verify("mmahoney@.carthage.edu"));
		assertFalse(EmailVerifier.verify("mmahoney@cs@carthage.edu"));		
		assertFalse(EmailVerifier.verify("mmahoney@c"));
		assertFalse(EmailVerifier.verify("mmahoney@carthage."));
		assertFalse(EmailVerifier.verify("mark..mahoney@carthage.edu"));
		assertFalse(EmailVerifier.verify("mark.mahoney@carthage..edu"));
		assertFalse(EmailVerifier.verify("mmahoney@carthage.edu."));
		assertFalse(EmailVerifier.verify("@carthage"));
		assertFalse(EmailVerifier.verify("@carthage.edu"));
		assertFalse(EmailVerifier.verify(".mmahoney@carthage.edu"));
		assertFalse(EmailVerifier.verify("mmahoney@!#$%&'*+-/=?^_`{|}~.edu"));
		assertFalse(EmailVerifier.verify(";@carthage.edu"));
	}
}
