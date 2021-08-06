package Models.Tests;

import Models.PrivacyStatus;
import Models.RequestStatus;
import Models.Status;
import Models.UserStatus;
import junit.framework.TestCase;

public class TestStatus extends TestCase {

  //  @Test
    public void testUserStatus() {
        Status st = new UserStatus();
        st.setStatus("Admin");
        assertEquals("Admin", st.getStatus());
        st.setStatus("Customer");
        assertEquals("Customer", st.getStatus());
        st.setStatus("Courier");
        assertEquals("Courier", st.getStatus());
        st.setStatus("Manager");
        assertEquals("Manager", st.getStatus());
        boolean b = st.setStatus("foo");
        assertFalse(b);
        assertEquals("Manager", st.getStatus());
        Status stEq = new UserStatus();
        stEq.setStatus("Manager");
        assertTrue(st.equals(stEq));
        Status stNE = null;
        assertFalse(st.equals(stNE));
        String str = "Manager";
        assertFalse(st.equals(str));
    }

//    @Test
    public void testPrivacyStatus() {
        Status st = new PrivacyStatus();
        st.setStatus("Private");
        assertEquals("Private", st.getStatus());
        st.setStatus("Public");
        assertEquals("Public", st.getStatus());
        st.setStatus("Friends");
        assertEquals("Friends", st.getStatus());
        boolean b = st.setStatus("foo");
        assertFalse(b);
        assertEquals("Friends", st.getStatus());
        Status stEq = new PrivacyStatus();
        stEq.setStatus("Friends");
        assertTrue(st.equals(stEq));
        Status stNE = null;
        assertFalse(st.equals(stNE));
        String str = "Friends";
        assertFalse(st.equals(str));
    }

    public void testRequestStatus() {
        Status st = new RequestStatus();
        st.setStatus("Accepted");
        assertEquals("Accepted", st.getStatus());
        st.setStatus("Rejected");
        assertEquals("Rejected", st.getStatus());
        st.setStatus("NotResponded");
        assertEquals("NotResponded", st.getStatus());
        st.setStatus("NotSent");
        assertEquals("NotSent", st.getStatus());
        boolean b = st.setStatus("foo");
        assertFalse(b);
        assertEquals("NotSent", st.getStatus());
        Status stEq = new RequestStatus();
        stEq.setStatus("NotSent");
        assertTrue(st.equals(stEq));
        Status stNE = null;
        assertFalse(st.equals(stNE));
        String str = "NotSent";
        assertFalse(st.equals(str));
    }

}
