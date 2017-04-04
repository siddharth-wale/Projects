/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Activity;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ActivityDirectory {
    
    private ArrayList<Activity> activityList;
    
    public ActivityDirectory(){
        activityList=new ArrayList<>();
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(ArrayList<Activity> activityList) {
        this.activityList = activityList;
    }
    public Activity addActivity(){
        Activity a= new Activity();
        activityList.add(a);
        return a;
    }
}
