package nl.ardemium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getMenuInstance() {
        Menu a = Menu.getMenuInstance();
        Menu b = Menu.getMenuInstance();
        assertEquals(a,b);
    }
}