import classes.Bug;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.apache.commons.collections.IteratorUtils;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by taraskovtun on 3/29/14.
 */
public class JongoDBTest {

    @Test
    public void testrun() throws UnknownHostException {

        DB db = new MongoClient().getDB("BugTracker");
        Jongo jongo = new Jongo(db);
        MongoCollection bugsColl = jongo.getCollection("Bugs");


        bugsColl.remove();

        bugsColl.insert(new Bug("Open", "High", "TarasK", "Bug 1", "Crash!!!"));
        bugsColl.insert(new Bug("Open", "Medium", "TarasK", "Bug 2", ""));
        bugsColl.insert(new Bug("Closed", "High", "TarasK", "Bug 3", "Crash!!!"));

        long count = bugsColl.count();

        List<String> summaries = bugsColl.distinct("Summary").as(String.class);

        List allBugs = IteratorUtils.toList(bugsColl.find("").as(Bug.class).iterator());


        assertTrue("Must be 3", count == 3);

    }
}
