package nl.ardemium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getMenuInstance() {
        // Menu is een Singleton > Elk menu object is het zelfde object (Er kan er maar een bestaan)
        Menu a = Menu.getMenuInstance();
        Menu b = Menu.getMenuInstance();
        assertEquals(a,b);
    }
}