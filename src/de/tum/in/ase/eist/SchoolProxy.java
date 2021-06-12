package de.tum.in.ase.eist;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface {
    private final Set<String> blacklistedHosts;
    private final URL redirectPage;
    private final Set<Integer> teacherIDs;
    private boolean authorized;
    private final NetworkConnection networkConnection;

    public SchoolProxy(Set<String> blacklistedHosts, URL redirectPage, Set<Integer> teacherIDs) {
        this.blacklistedHosts = blacklistedHosts;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
        networkConnection = new NetworkConnection();
        authorized = false;
    }

    public void login(int teacherID) {
        if (teacherIDs.contains(teacherID)) {
            authorized = true;
        }
    }

    public void logout() {
        authorized = false;
    }


    @Override
    public void connect(URL url) {
        if (!authorized) {
            if (blacklistedHosts.contains(url.getHost())) {
                System.out.println("Connection to " + url + " rejected.");
                networkConnection.connect(redirectPage);
            } else {
                System.out.println("Connecting to url " + url);
                networkConnection.connect(url);
            }
        } else {
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
