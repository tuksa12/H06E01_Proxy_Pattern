package de.tum.in.ase.eist;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface{
    private Set<String> blacklistedHosts;
    private URL redirectPage;
    private Set<Integer> teacherIDs;
    private boolean authorized;
    private NetworkConnection networkConnection;

    public SchoolProxy(Set<String> blacklistedHosts, URL redirectPage, Set<Integer> teacherIDs) {
        this.blacklistedHosts = blacklistedHosts;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
        networkConnection = new NetworkConnection();
        authorized = false;
    }

    public void login(int teacherID) {
        if (teacherIDs.contains(teacherID)){
            authorized = true;
        } else{

        }
    }

    public void logout() {

    }


    @Override
    public void connect(URL url) {
        if (blacklistedHosts.contains(url)){
            System.out.println("Connection to " + url + " rejected.");
            networkConnection.connect(redirectPage);
        } else if (authorized) {
            networkConnection.connect(url);
        }
    }

    @Override
    public void disconnect() {
        networkConnection.disconnect();
    }

    @Override
    public boolean isConnected() {
        return networkConnection.isConnected();
    }

    // TODO: Implement the SchoolProxy

}
