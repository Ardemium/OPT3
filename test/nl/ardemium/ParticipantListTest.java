package nl.ardemium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantListTest {

    @Test
    void getParticipants() {
        // maakt 2 deelnemers aan
        Participant a = new Participant("a");
        Participant b = new Participant("b");
        // maakt een sessie aan waar deelnemer a aan toegevoegd is
        ParticipantList participantList = new ParticipantList(a);
        int size = participantList.getParticipants().size();
        assertEquals(1,size);
        // deelnemer b is toegevoegd
        participantList.addParticipant(b);
        size = participantList.getParticipants().size();
        assertEquals(2,size);
        assertEquals(a,participantList.getParticipants().get(0));
        assertEquals(b,participantList.getParticipants().get(1));
        // deelnemer a heeft een bestelling geplaatst
        a.mkOrder(new Order(new ShareOrder(Menu.getMenuInstance().getDishList().get(0), 2)));
        // deelnemer a word niet verwijderd omdat er nog een rekening open staat
        participantList.rmParticipant(a);
        size = participantList.getParticipants().size();
        assertEquals(2,size);
        assertEquals(a,participantList.getParticipants().get(0));
        assertEquals(b,participantList.getParticipants().get(1));
        // deelnemer a heeft rekening betaald
        a.payInvoice();
        participantList.rmParticipant(a);
        size = participantList.getParticipants().size();
        assertEquals(1,size);
        assertEquals(b,participantList.getParticipants().get(0));

    }
}