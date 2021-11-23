package day02.infErettsegi2013;

import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Valasztas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VoteService voteService = new VoteService(Paths.get("src/main/resources/szavazatok.txt"));

        System.out.printf("A helyhatósági választáson %d képviselőjelölt indult.%n", voteService.getVotes().size());
        System.out.print("Kérem a képviselő vezetéknevét: ");
        String firstName = scanner.nextLine();
        System.out.print("Kérem a képviselő keresztnevét: ");
        String lastName = scanner.nextLine();

        int voteNumber = voteService.findByName(firstName, lastName);
        if (voteNumber != -1) {
            System.out.printf("%s %s képviselő jelölt %d szavazatot kapott.", firstName, lastName, voteNumber);
        }
        else {
            System.out.println("Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!");
        }
        int numberOfVoters = voteService.numberOfVoters();
        System.out.printf("A választáson %d állampolgár, a jogosultak %.2f %%-a vett részt.%n", numberOfVoters, ((double)numberOfVoters/VoteService.SUM_OF_RIGHT_TO_VOTE)*100);

        for (Parties parties: voteService.votesByParties()){
            System.out.printf("%s= %.2f%% %n", parties.getName(), ((double)parties.getVotes()/numberOfVoters *100));
        }

        List<Delegate> maxDelegates = voteService.findMaxDelegates(voteService.votesByDelegates());
        for (Delegate delegate: maxDelegates){
            System.out.printf("%s %s %s%n", delegate.getFirstName(), delegate.getLastName(), delegate.getParty() == PartyNameAbbreviation.FUG? "Független": delegate.getParty());
        }
    }
}
