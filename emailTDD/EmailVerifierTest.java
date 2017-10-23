package emailTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailVerifierTest 
{
	private EmailVerifier emailVerifier;
	
	@BeforeEach
	void setUp()
	{
		emailVerifier = new EmailVerifier();
	}
	
	@Test
	void testValidEmailAddresses() 
	{
		assertTrue(emailVerifier.verify("mmahoney@carthage.edu"));
		assertTrue(emailVerifier.verify("mark.mahoney@carthage.edu"));
		assertTrue(emailVerifier.verify("mark.robert.mahoney@carthage.edu"));
		assertTrue(emailVerifier.verify("mmahoney@cs.carthage.edu"));
		assertTrue(emailVerifier.verify("mark.mahoney@cs.carthage.edu"));
		assertTrue(emailVerifier.verify("mark.robert.mahoney@cs.carthage.edu"));
		assertTrue(emailVerifier.verify("!#$%&'*+-/=?^_`{|}~@carthage.edu"));
	}
	
	@Test
	void testInvalidEmailAddresses() 
	{
		assertFalse(emailVerifier.verify(""));
		assertFalse(emailVerifier.verify(" "));
		assertFalse(emailVerifier.verify("   mmahoney@carthage.edu"));
		assertFalse(emailVerifier.verify("mmahoney@carthage.edu   "));
		assertFalse(emailVerifier.verify("   mmahoney@carthage.edu   "));
		assertFalse(emailVerifier.verify("mmahoney @ carthage . edu"));
		assertFalse(emailVerifier.verify("@"));
		assertFalse(emailVerifier.verify("."));
		assertFalse(emailVerifier.verify("mmahoney"));
		assertFalse(emailVerifier.verify("mmahoney@"));
		assertFalse(emailVerifier.verify("mmahoney@carthage"));
		assertFalse(emailVerifier.verify("mmahoney.@carthage.edu"));
		assertFalse(emailVerifier.verify("mmahoney@.carthage.edu"));
		assertFalse(emailVerifier.verify("mmahoney@cs@carthage.edu"));		
		assertFalse(emailVerifier.verify("mmahoney@c"));
		assertFalse(emailVerifier.verify("mmahoney@carthage."));
		assertFalse(emailVerifier.verify("mark..mahoney@carthage.edu"));
		assertFalse(emailVerifier.verify("mark.mahoney@carthage..edu"));
		assertFalse(emailVerifier.verify("mmahoney@carthage.edu."));
		assertFalse(emailVerifier.verify("@carthage"));
		assertFalse(emailVerifier.verify("@carthage.edu"));
		assertFalse(emailVerifier.verify(".mmahoney@carthage.edu"));
		assertFalse(emailVerifier.verify("mmahoney@!#$%&'*+-/=?^_`{|}~.edu"));
		assertFalse(emailVerifier.verify(";@carthage.edu"));
	}
}
