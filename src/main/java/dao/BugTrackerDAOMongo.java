package dao;

import classes.Bug;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import org.apache.commons.collections.IteratorUtils;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by taraskovtun on 3/30/14.
 */
public class BugTrackerDAOMongo implements IBugTrackerDAO {


    private final String dbName = "BugTracker";

    private Jongo getConnection(){
        DB db = null;
        try {
            db = new MongoClient().getDB(dbName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Jongo jongo = new Jongo(db);
        return jongo;

    }


    @Override
    public void AddBug(Bug bug) {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");
        WriteResult res = bugsColl.insert(bug);

    }


    @Override
    public Bug GetBug(String id) {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");

        return bugsColl.findOne(new ObjectId(id)).as(Bug.class);

    }


    @Override
    public void UpdateBug(Bug bug) {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");

        bugsColl.update(new ObjectId(bug.getId())).with(bug);

    }


    @Override
    public void DeleteBug(Bug bug) {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");
        bugsColl.remove(new ObjectId(bug.getId()));
    }

    @Override
    public void DeleteBug(String id) {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");
        bugsColl.remove(new ObjectId(id));
    }


    @Override
    public List<Bug> GetBugs() {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");

        return IteratorUtils.toList(bugsColl.find("").as(Bug.class).iterator());

    }

    @Override
    public List<Bug> GetOpenBugs() {

        MongoCollection bugsColl = getConnection().getCollection("Bugs");

        return IteratorUtils.toList(bugsColl.find("{Status: 'Open'}").as(Bug.class).iterator());

    }

    @Override
    public void ClearBugs() {
        MongoCollection bugsColl = getConnection().getCollection("Bugs");
        bugsColl.remove();

    }


}
