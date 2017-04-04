/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Session;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SessionDirectory {
    private ArrayList<SessionLog> sessionList;
    
    public SessionDirectory(){
        sessionList= new ArrayList<>();
    }

    public ArrayList<SessionLog> getSessionList() {
        return sessionList;
    }

    public void setSessionList(ArrayList<SessionLog> sessionList) {
        this.sessionList = sessionList;
    }
    public SessionLog addSession(){
        SessionLog s= new SessionLog();
        sessionList.add(s);
        return s;
    }
}
