package classes;

import org.jongo.marshall.jackson.oid.ObjectId;

/**
 * Created by taraskovtun on 3/25/14.
 */
public class Bug  {
    public Bug(){
    }

    //region constructor getters and setters

    public Bug(String status, String priority, String assignee, String summary, String description) {

        Status = status;
        Priority = priority;
        Assignee = assignee;
        Summary = summary;
        Description = description;
    }

    public String getId() {
        return _id;
    }

    public String getStatus() {
        return Status;
    }

    public String getPriority() {
        return Priority;
    }

    public String getAssignee() {
        return Assignee;
    }

    public String getSummary() {
        return Summary;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(String id) {
        _id = id;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public void setAssignee(String assignee) {
        Assignee = assignee;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setDescription(String description) {
        Description = description;
    }
    //endregion

    @ObjectId
    private String _id;

    public String Status; // Open = true, Closed = false
    public String Priority;
    public String Assignee;
    public String Summary;
    public String Description;

}