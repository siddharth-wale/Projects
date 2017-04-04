/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Session;

import Business.Activity.ActivityDirectory;
import java.util.Date;

/**
 *
 * @author admin
 */
public class SessionLog {
    private Date starTime;
    private Date endTime;
    private ActivityDirectory activityDirectory;
    public SessionLog(){
        activityDirectory=new ActivityDirectory();
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ActivityDirectory getActivityDirectory() {
        return activityDirectory;
    }

    public void setActivityDirectory(ActivityDirectory activityDirectory) {
        this.activityDirectory = activityDirectory;
    }
            
    @Override
    public String toString(){
        return String.valueOf(getStarTime());
    }
}
