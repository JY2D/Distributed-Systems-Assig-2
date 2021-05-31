package scheduler;

import data.Server;

public class TinyWaitingTimeFit implements ServerProvider {

    @Override
    public String getServer(String serverType, Server[] serverList) {
    	Server min = serverList[0];

        for (int i = 0; i < serverList.length; i++) {
            if (min.getWaittime() > serverList[i].getWaittime()) {
                min = serverList[i];
            }
        }
        return min.getType()+" "+min.getId();
    }
}
