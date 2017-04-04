/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Activity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Activity {
    private String jPanelName;
    private Date activityTime;

    public String getjPanelName() {
        return jPanelName;
    }

    public void setjPanelName(String jPanelName) {
        this.jPanelName = jPanelName;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }
    
    @Override
    public String toString(){
        return String.valueOf(getActivityTime());
    }
}
