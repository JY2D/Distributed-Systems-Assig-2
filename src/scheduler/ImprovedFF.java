package scheduler;

import data.Job;
import data.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ImprovedFF implements ServerProvider {

    private ArrayList<Server> dsServerArrayList;
    private Job job;

    public void setJob(Job job) {
        this.job = job;
    }

    public void setDsServerArrayList(ArrayList<Server> dsServerArrayList) {
        this.dsServerArrayList = dsServerArrayList;
    }

    @Override
    public String getServer(String serverType, ArrayList<Server> serverList) {
    	Server min = serverList.get(0);

        for (int i = 0; i < serverList.size(); i++) {
            if (min.getWaittime() > serverList.get(i).getWaittime()) {                           
                min = serverList.get(i); 
            }
        }
        return min.getType()+" "+min.getId(); 
    	
    
  	  
    }
    
    
}
