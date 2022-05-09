package utils;

public class ServerInfo {
    private String host;
    private int port;
    private String resourceName;

    public ServerInfo(String host, int port,String resourceName){
        this.host=host;
        this.port=port;
        this.resourceName=resourceName;
    }

    public String getHost(){
        return this.host;
    }

    public int getPort(){
        return this.port;
    }
    public String getResourceName(){
        return this.resourceName;
    }

    public void setHost(String host){
        this.host=host;
    }

    public void setPort(int port){
        this.port=port;
    }

    public void setResourceName(String resourceName){
        this.resourceName=resourceName;
    }

    public String getRMIName(){
        return String.format("rmi://%s:%d/%s", this.host,this.port,this.resourceName);
    }
}

