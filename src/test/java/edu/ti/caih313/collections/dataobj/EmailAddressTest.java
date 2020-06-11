package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EmailAddressTest {

    EmailAddress Chana, drAllen, joe, johnDoe;

    @Before
    public void makeTester()
    {
        Chana = new EmailAddress("chana@gmail.com", EmailAddress.Type.HOME);
        Chana.emailMap.put(EmailAddress.Type.SCHOOL, "chana@ti.htc.edu");
        Chana.emailMap.put(EmailAddress.Type.WORK, "chana@work.com");

        drAllen = new EmailAddress("mallen@htc.edu", EmailAddress.Type.SCHOOL);
        drAllen.emailMap.put(EmailAddress.Type.WORK, "mallen@ccis.com");

        joe = new EmailAddress("joe@gmail.com", EmailAddress.Type.HOME);

        johnDoe = new EmailAddress("johndoe@gmail.com", EmailAddress.Type.HOME);
        johnDoe.emailMap.remove(EmailAddress.Type.HOME);
    }

    @Test
    public void testGetPrimaryEmailAddress()
    {
        String primaryEmailAddress = Chana.getEmailAddress();
        assertEquals("chana@gmail.com", primaryEmailAddress);

        String primaryEmailAddress1 = drAllen.getEmailAddress();
        assertEquals("mallen@ccis.com", primaryEmailAddress1);

        String primaryEmailAddress2 = joe.getEmailAddress();
        assertEquals("joe@gmail.com", primaryEmailAddress2);

        String primaryEmailAddress3 = johnDoe.getEmailAddress();
        assertNull(primaryEmailAddress3);
    }

    @Test
    public void testGetEmailAddress()
    {
        String emailAddress = Chana.getEmailAddress(EmailAddress.Type.HOME);
        assertEquals("chana@gmail.com", emailAddress);

        String emailAddress1 = Chana.getEmailAddress(EmailAddress.Type.WORK);
        assertEquals("chana@work.com", emailAddress1);

        String emailAddress2 = Chana.getEmailAddress(EmailAddress.Type.SCHOOL);
        assertEquals("chana@ti.htc.edu", emailAddress2);

        String emailAddress3 = johnDoe.getEmailAddress(EmailAddress.Type.HOME);
        assertNull(emailAddress3);
    }

    @Test
    public void testEmailToString()
    {
        String toString = Chana.toString();
        assertEquals("Emails: <HOME: chana@gmail.com, WORK: chana@work.com, SCHOOL: chana@ti.htc.edu>", toString);

        String toString1 = drAllen.toString();
        assertEquals("Emails: <WORK: mallen@ccis.com, SCHOOL: mallen@htc.edu>", toString1);

        String toString2 = joe.toString();
        assertEquals("Emails: <HOME: joe@gmail.com, >", toString2);

        String toString3 = johnDoe.toString();
        assertEquals("Emails: <no email address available>", toString3);
    }
}


