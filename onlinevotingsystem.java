import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Voter {
    private String name;
    private boolean hasVoted;

    public Voter(String name) {
        this.name = name;
        this.hasVoted = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote() {
        this.hasVoted = true;
    }
}

class Candidate {
    private String name;
    private int voteCount;

    public Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void incrementVoteCount() {
        this.voteCount++;
    }
}

public class OnlineVotingSystem {
    private Map<String, Candidate> candidates;
    private Map<String, Voter> voters;

    public OnlineVotingSystem() {
        this.candidates = new HashMap<>();
        this.voters = new HashMap<>();
    }

    public void addCandidate(String candidateName) {
        candidates.put(candidateName, new Candidate(candidateName));
    }

    public void registerVoter(String voterName) {
        voters.put(voterName, new Voter(voterName));
    }

    public void vote(String voterName, String candidateName) {
        if (voters.containsKey(voterName) && candidates.containsKey(candidateName)) {
            Voter voter = voters.get(voterName);
            if (!voter.hasVoted()) {
                Candidate candidate = candidates.get(candidateName);
                candidate.incrementVoteCount();
                voter.vote();
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("Error: Voter has already voted.");
            }
        } else {
            System.out.println("Error: Invalid voter or candidate.");
        }
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName() + ": " + candidate.getVoteCount() + " votes");
        }
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();

        votingSystem.addCandidate("Candidate 1");
        votingSystem.addCandidate("Candidate 2");

        votingSystem.registerVoter("Voter 1");
        votingSystem.registerVoter("Voter 2");

        //voting
        votingSystem.vote("Voter 1", "Candidate 1");
        votingSystem.vote("Voter 2", "Candidate 2");

        //results
        votingSystem.displayResults();
    }
}
