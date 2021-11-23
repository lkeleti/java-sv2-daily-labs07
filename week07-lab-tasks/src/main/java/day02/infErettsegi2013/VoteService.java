package day02.infErettsegi2013;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VoteService {
    public static final int  SUM_OF_RIGHT_TO_VOTE = 12_345;
    private List<Vote> votes = new ArrayList<>();

    public VoteService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            linesToVotes(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!",ioe);
        }
    }

    public List<Vote> getVotes() {
        return votes;
    }

    private void linesToVotes(List<String> lines) {
        for (String line: lines) {
            String[] datas = line.split(" ");
            if (datas[4].equals("-")) {
                datas[4] = "FUG";
            }
            votes.add(new Vote(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]),datas[2], datas[3], PartyNameAbbreviation.valueOf(datas[4])));
        }
    }

    public int findByName(String firstName, String lastName) {
        int result = -1;
        for(Vote vote: votes)
        {
            if (vote.getFirstName().equals(firstName) && vote.getLastName().equals(lastName)){
                return vote.getVoteNumber();
            }
        }
        return result;
    }

    public int numberOfVoters() {
        int result = 0;
        for(Vote vote: votes)
        {
            result += vote.getVoteNumber();
        }
        return result;
    }

    public List<Parties> votesByParties(){
        List<Parties> parties = new ArrayList<>();
        for (Vote vote : votes){
            int indexOfParty = findParty(parties, vote.getParty());
            if (indexOfParty == -1){
                parties.add(new Parties(vote.getParty().getFullName(),vote.getVoteNumber()));
            }
            else {
                parties.get(indexOfParty).incVotes(vote.getVoteNumber());
            }
        }
        return parties;
    }

    private int findParty(List<Parties> parties, PartyNameAbbreviation name) {
        int result = -1;
        for (int i = 0; i < parties.size(); i++){
            if (parties.get(i).getName().equals(name.getFullName())) {
                return i;
            }
        }
        return result;
    }

    public List<Delegate> votesByDelegates(){
        List<Delegate> delegates = new ArrayList<>();
        for (Vote vote : votes){
            int indexOfDelegate = findDelegate(delegates, vote.getFirstName(), vote.getLastName());
            if (indexOfDelegate == -1){
                delegates.add(new Delegate(vote.getFirstName(),vote.getLastName(), vote.getVoteNumber(),vote.getParty()));
            }
            else {
                delegates.get(indexOfDelegate).incVotes(vote.getVoteNumber());
            }
        }
        return delegates;
    }

    private int findDelegate(List<Delegate> delegates, String firstName, String lastName) {
        int result = -1;
        for (int i = 0; i < delegates.size(); i++){
            if (delegates.get(i).getFirstName().equals(firstName) && delegates.get(i).getLastName().equals(lastName)) {
                return i;
            }
        }
        return result;
    }

    public List<Delegate> findMaxDelegates(List<Delegate> delegates) {
        List<Delegate> result = new ArrayList<>();
        int maxVote = findMaxVoteByDelegate(delegates);
        for (Delegate delegate: delegates) {
            if (delegate.getVotes() == maxVote) {
                result.add(delegate);
            }
        }
        return result;
    }

    private int findMaxVoteByDelegate(List<Delegate> delegates){
        int maxVotes = 0;
        for (Delegate delegate: delegates) {
            if (delegate.getVotes() > maxVotes) {
                maxVotes = delegate.getVotes();
            }
        }
        return maxVotes;
    }
}
