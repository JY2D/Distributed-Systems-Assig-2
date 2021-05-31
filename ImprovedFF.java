package scheduler;

import data.Job;
import data.Server;

import java.util.ArrayList;

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
        for ( int i=0; i< serverList.size(); i++) {
	Server server = serverList.get(i);
            if (server.getCoreCount() >= job.getCore() && server.getDisk()>= job.getDisk() && server.getMemory()>= job.getMemory()) {
                return server.getType() + " " + server.getId();
            }
        }
        for (int i=0; i< dsServerArrayList.size();i++) {
        Server server = dsServerArrayList.get(i);
            if (server.getCoreCount() >= job.getCore() && server.getDisk() >= job.getDisk() && server.getMemory() >= job.getMemory()) {
                server.setId(0);
                return server.getType() + " " + server.getId();
            }
        }
        return null;
    }
}
