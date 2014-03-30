package dao;

import classes.Bug;

import java.util.List;

/**
 * Created by taraskovtun on 3/30/14.
 */

public interface IBugTrackerDAO {

    public void AddBug(Bug bug);
    public Bug GetBug(String id);
    public void UpdateBug(Bug bug);
    public void DeleteBug(Bug bug);
    public void DeleteBug(String id);
    public List<Bug> GetBugs();
    public List<Bug> GetOpenBugs();

    public void ClearBugs();

}
