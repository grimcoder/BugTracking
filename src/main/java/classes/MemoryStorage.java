package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class MemoryStorage {


    static List<Bug> Bugs = new ArrayList<Bug>();
    static int maxId = 0;

    public MemoryStorage()
    {

    }


    public static List<String> getUsers() {
        return Arrays.asList("Illah", "Ke$ha");
    }


    public static List<Bug> getAllBugs() {
        return Bugs;
    }


    public static List<Bug> getOpenBugs() {
        List<Bug> openBugs = new ArrayList<Bug>();
        for(Bug bug: Bugs){
            if (bug.Status == "Open") {
                openBugs.add(bug);
            }
        }
        return openBugs;
    }


    public static void updateBug(Bug bug) {
        Bug selectedBug = null;
        for(Bug _bug: Bugs){
            if (_bug.Id == bug.Id){
                selectedBug = _bug;
                break;
            }
        }

        selectedBug.Status = bug.Status;
        selectedBug.Assignee = bug.Assignee;
        selectedBug.Description = bug.Description;
        selectedBug.Priority = bug.Priority;
        selectedBug.Status = bug.Status;
        selectedBug.Summary = bug.Summary;

    }

    public static int createBug(Bug bug) {

        //increment id
        maxId++;
        bug.Id=maxId;
        Bugs.add(bug);
        return maxId;
    }


    public static void SendEmail(String status, String email) {

    }

    public static Bug getBug(int id) {
        for(Bug _bug: Bugs){
            if (_bug.Id == id){
                return  _bug;
            }
        }
        return null;
    }
}
