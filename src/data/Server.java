package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "server")
public class Server implements Comparable<Server> {

    private String type;
    private String limit;
    private int bootupTime;
    private int coreCount;
    private int memory;
    private int disk;

    private int Runtime;
    private int Waittime;
    private String state;
    private int id;

    public Server() {
        // empty default constructor
    }

    public Server(String type, int id, String state, int bootupTime, int coreCount, int memory, int disk,int Waittime, int Runtime) {
        this.type = type;
        this.id = id;
        this.state = state;
        this.bootupTime = bootupTime;
        this.coreCount = coreCount;
        this.memory = memory;
        this.disk = disk;
        this.Waittime = Waittime;
        this.Runtime = Runtime;
    }

  
    /**
     * This method returns the server type,
     * the XML parser uses the annotation to
     * get the TYPE parsed from the XML attribute
     */
    @XmlAttribute(name = "type")
    public String getType() {
        return type;
    }

    /**
     * This method returns the limit of the server,
     * the XML parser uses the annotation to get
     * the limit which is parsed from thee XML attribute
     */
    @XmlAttribute(name = "limit")
    public String getLimit() {
        return limit;
    }
    /**
     * This method is used to get the corecount of the servers,
     * the XML parser uses the annotation to get the coreCount
     * of the server which was parsed from the XML attribute
     */
    @XmlAttribute(name = "coreCount")
    public int getCoreCount() {
        return coreCount;
    }

    /**
     * This method is used to attain the memory of the server,
     * the XML parser uses the annotation to get the memory
     * of the server which was parsed from the XML attribute
     */
    @XmlAttribute(name = "memory")
    public int getMemory() {
        return memory;
    }

    /**
     * This metod is used to get the disk size of the server,
     * the XML parser uses the annotation to get the memory
     * of the server which was parsed from the XML attribute
     */
    @XmlAttribute(name = "disk")
    public int getDisk() {
        return disk;
    }

    public int getRuntime() {
        return Runtime;
    }
    public int getWaittime() {
        return Waittime;
    }

    public String getState() {
        return state;
    }
    
    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Server server) {
        // The order of comparison is : Corecount -> Memory -> Disk space
        int coreComparison = Integer.compare(coreCount, server.coreCount);
        int memoryComparison = Integer.compare(memory, server.memory);
        int diskComparison = Integer.compare(disk, server.disk);
        return coreComparison != 0 ? coreComparison : memoryComparison != 0 ? memoryComparison : diskComparison;
    }

    public void setId(int id) {
        this.id = id;
    }
}
