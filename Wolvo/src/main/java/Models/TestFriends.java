package Models;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFriends extends TestCase {

    User users[];

    public void setUp() {
        users = new User[20];
        User usr0 = new User();
        usr0.setId(0);
        PrivacyStatus ps = new PrivacyStatus();
        ps.setStatus("Public");
        usr0.setPrivacyType(ps);
        UserStatus us = new UserStatus();
        us.setStatus("NormalUser");
        usr0.setUserType(us);
        usr0.setAddress("fanjikidzis 22a");
        usr0.setPassword("qwerty");
        usr0.setFirstName("temur");
        usr0.setLastName("arustashvili");
        usr0.setEmail("tarus19@freeuni.edu.ge");
        usr0.setCity("Tbilisi");
        usr0.setPhoneNumber("595055777");
        usr0.setDistrict("saburtalo");
        users[0] = usr0;
        for (int i = 1; i < 10; i++) {
            User usr = new User();
            usr.setId(i);
            PrivacyStatus p = new PrivacyStatus();
            p.setStatus("Public");
            usr.setPrivacyType(p);
            UserStatus u = new UserStatus();
            u.setStatus("NormalUser");
            usr.setUserType(u);
            usr.setAddress("fanjikidzis 22a");
            usr.setPassword("qwerty");
            usr.setFirstName("temur");
            usr.setLastName("arustashvili");
            usr.setEmail("tarus19@freeuni.edu.ge");
            usr.setCity("Tbilisi");
            usr.setPhoneNumber("595055777");
            usr.setDistrict("saburtalo");
            users[i] = usr;
            users[10 + i] = usr;
        }
        User usr10 = new User();
        usr10.setId(0);
        PrivacyStatus ps1 = new PrivacyStatus();
        ps.setStatus("Public");
        usr10.setPrivacyType(ps1);
        UserStatus us1 = new UserStatus();
        us1.setStatus("NormalUser");
        usr10.setUserType(us1);
        usr10.setAddress("fanjikidzis 22a");
        usr10.setPassword("qwerty");
        usr10.setFirstName("temur");
        usr10.setLastName("arustashvili");
        usr10.setEmail("tarus19@freeuni.edu.ge");
        usr10.setCity("Tbilisi");
        usr10.setPhoneNumber("595055777");
        usr10.setDistrict("saburtalo");
        users[10] = usr10;
    }

    @Test
    public void testFriends0() {
        Friends friends0 = new Friends();
        Friends friends1 = new Friends();
        Friends friendsRC = new Friends();
        friendsRC = new Friends();
    }

    @Test
    public void testFriends1() {
        //setup();
        Friends friends0 = new Friends();
        friends0.setUser(users[0]);
        Set<User> friends = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            friends.add(users[i]);
        }
        friends0.setFriends(friends);
        assertEquals(users[0], friends0.getUser());
        assertEquals(friends, friends0.getFriends());

        Friends friends1 = new Friends();
        friends1.setUser(users[0]);
        Set<User> fr = new HashSet<>();
        fr.add(users[1]);
        fr.add(users[2]);
        String s = "0 (first name \"temur\" last name \"arustashvili\") Friends are " +
                "1 (first name \"temur\" last name \"arustashvili\"), " +
                "2 (first name \"temur\" last name \"arustashvili\"), ";
        friends1.setFriends(fr);
        assertEquals(s, friends1.toString());
    }

    @Test
    public void testFriends2() {
        //setup();
        Friends friends0 = new Friends();
        friends0.setUser(users[0]);
        Friends friends1 = new Friends();
        friends1.setUser(users[10]);
        Set<User> friendsOf0 = new HashSet<>();
        Set<User> friendsOf1 = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            friendsOf0.add(users[i]);
            friendsOf1.add(users[10 + i]);
        }
        friends0.setFriends(friendsOf0);
        friends1.setFriends(friendsOf1);
        assertEquals(friends0, friends1);
    }
}
