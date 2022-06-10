import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CandidateManager {
    
    private ArrayList<Candidate> candidates;
    
    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }
    
  
    public boolean readData(String textFile) {
        File file = null;
        Scanner fileReader = null;
        try {
            file = new File(textFile);
            fileReader = new Scanner(file);
            
            while (fileReader.hasNextLine()) {
                String[] fields = fileReader.nextLine().trim().split("\\|");
                if (fields.length != 6) {
                    continue;
                }
                
                String id = fields[0].trim();
                String name = fields[1].trim();
                String selection = fields[2].trim();
                String sex = fields[3].trim();
                int year = Integer.parseInt(fields[4].trim());
                int priority = Integer.parseInt(fields[5].trim());
                
                Candidate newCandidate = new Candidate(id, name, selection, sex, year, priority);
                
                this.candidates.add(newCandidate);
            }
            return true;
        } catch(IOException ex) {
            System.out.println("Error reading file '" + textFile + "'");
            return false;
        }  finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
    
    public ArrayList<Candidate> getSelectionCandicates(String selection) { 
        ArrayList<Candidate> selectoCandidates = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.selection().equals(selection)) {
                selectoCandidates.add(candidate);
            }
        }
        return selectoCandidates; 
    }
    
  
    public ArrayList<Candidate> getPriorityCandidates() {
        ArrayList<Candidate> priorityCandidates = new ArrayList<>();
        for (Candidate candidate : this.candidates) {
            if (candidate.priority() == 1) {
                priorityCandidates.add(candidate);
            }
        }
        return priorityCandidates;
    }
    
   
    public ArrayList<Candidate> sortByName() {
        ArrayList<Candidate> sortednameCandidates = new ArrayList<>(candidates);
        for (int j = 1; j <= sortednameCandidates.size(); j++) {
            for (int i = 0; i < sortednameCandidates.size()-1; i++) {
                Candidate candidate1 = sortednameCandidates.get(i);
                String fullName1 = candidate1.name();
            
                Candidate cadidate2 = sortednameCandidates.get(i+1);
                String fullName2 = cadidate2.name();
            
                if (fullName1.compareTo(fullName2) > 0) {
                    sortednameCandidates.set(i, cadidate2);
                    sortednameCandidates.set(i+1, candidate1);
                }
            }
        }
        return sortednameCandidates;
    }
    
    
    public ArrayList<Candidate> getSecondYoungestCandidates() {
        int maxYear = 0;
        for (Candidate candidate : candidates) {
            maxYear = Math.max(maxYear, candidate.year());
        }
        
        int sencondMaxYear = 0;
        for (Candidate candidate : candidates) {
            if (candidate.year() < maxYear) {
                sencondMaxYear = Math.max(candidate.year(), sencondMaxYear);
            }
        }
        
        ArrayList<Candidate> secondYoungestCandidates = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.year() == sencondMaxYear) {
                secondYoungestCandidates.add(candidate);
            }
        }
        return secondYoungestCandidates;
    }
    
    public void printCandidatesFromArray(ArrayList<Candidate> candidates) {
        if (candidates == null) {
            return;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).print();
        }
    }
    
   
    public void printCandidates() {
        printCandidatesFromArray(this.candidates);
    }
    
    public static void main(String[] args) {
        CandidateManager candidateManager = new CandidateManager();
        if (!candidateManager.readData("candidates.txt")) {
            return;
        }
            
        //ArrayList<Candidate> selectionCandidates = candidateManager.getSelectionCandicates("A");
        //candidateManager.printCandidatesFromArray(selectionCandidates);
        //System.out.println();
        
        //ArrayList<Candidate> priorityCandidates = candidateManager.getPriorityCandidates();
        //candidateManager.printCandidatesFromArray(priorityCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> sortedNameCandidates = candidateManager.sortByName();
        //candidateManager.printCandidatesFromArray(sortedNameCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> secondYoungestCandidates = candidateManager.getSecondYoungestCandidates();
        //candidateManager.printCandidatesFromArray(secondYoungestCandidates);
    }
}