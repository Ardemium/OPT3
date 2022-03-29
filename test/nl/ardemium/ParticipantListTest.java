package nl.ardemium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantListTest {

    @Test
    void getParticipants() {
        Participant a = new Participant("a");
        Participant b = new Participant("b");
        ParticipantList participantList = new ParticipantList(a);
        int size = participantList.getParticipants().size();
        assertEquals(1,size);
        participantList.addParticipant(b);
        size = participantList.getParticipants().size();
        assertEquals(2,size);
        assertEquals(a,participantList.getParticipants().get(0));
        assertEquals(b,participantList.getParticipants().get(1));

    }
}