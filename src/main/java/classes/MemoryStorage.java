package classes;

import dao.BugTrackerDAOMongo;
import dao.IBugTrackerDAO;

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


        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        List<Bug> allbugs = dao.GetBugs();
        return allbugs;

    }


    public static List<Bug> getOpenBugs() {
        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        return  dao.GetOpenBugs();
    }


    public static void updateBug(Bug bug) {
        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        dao.UpdateBug(bug);

    }

    public static String createBug(Bug bug) {

        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        dao.AddBug(bug);
        return  bug.getId();
    }


    public static void SendEmail(String status, String email) {

    }

    public static Bug getBug(String id) {
        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        return  dao.GetBug(id);
    }
}
