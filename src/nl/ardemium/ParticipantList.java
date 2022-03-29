package nl.ardemium;

import java.util.ArrayList;

public class ParticipantList {

    private ArrayList<Participant> participants;

    public ParticipantList(Participant participant){
        if(participants == null){
            participants = new ArrayList<>();
        }
        participants.add(participant);
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public void rmParticipant(Participant participant){
        if(participant.calculateCosts().equals("0.00") && participants.size() != 1){
            participants.remove(participant);
        }
    }

    public ArrayList<Participant> getParticipants(){
        return participants;
    }

}
