import classes.Bug;
import dao.BugTrackerDAOMongo;
import dao.IBugTrackerDAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by taraskovtun on 3/30/14.
 */
public class JongoDAOTest {

    @Test
    public void CreateTest(){
        IBugTrackerDAO dao = new BugTrackerDAOMongo();
        dao.ClearBugs();

        dao.AddBug(new Bug("Open", "High", "TarasK", "Bug 1", "Crash!!!"));
        dao.AddBug(new Bug("Open", "Medium", "TarasK", "Bug 2", ""));
        dao.AddBug(new Bug("Closed", "High", "TarasK", "Bug 3", "Crash!!!"));

        List<Bug> allBugs = dao.GetBugs();
        Assert.assertTrue(allBugs.size() == 3);

        List<Bug> openBugs = dao.GetOpenBugs();
        Assert.assertTrue(openBugs.size() == 2);

        Bug bug2 = openBugs.get(1);
        Assert.assertTrue(bug2.Summary.equals("Bug 2"));

        String bug2id = bug2.getId();

        bug2 = dao.GetBug(bug2id);


        bug2.setDescription("some desc");
        dao.UpdateBug(bug2);


        bug2 = dao.GetBug(bug2id);
        Assert.assertTrue(bug2.getDescription().equals("some desc"));

        dao.DeleteBug(bug2);

        allBugs = dao.GetBugs();
        Assert.assertTrue(allBugs.size() == 2);

    }
}
