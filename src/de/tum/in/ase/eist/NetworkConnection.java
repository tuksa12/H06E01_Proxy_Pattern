package de.tum.in.ase.eist;

import java.net.URL;

public class NetworkConnection implements ConnectionInterface {
	
	private URL currentUrl;
	private boolean connected;

	@Override
	public void connect(URL requestedUrl) {
		if (!this.isConnected()) {
			this.currentUrl = requestedUrl;
			connected = true;
			System.out.println("You connected to " + requestedUrl);
		} else {
			System.out.println("Already connected!");
		}
	}

	@Override
	public void disconnect() {
		if (!isConnected()) {
			System.out.println("You are not connected yet!");
		} else {
			connected = false;
			System.out.println("You disconnected from " + currentUrl + "\n");
		}
	}

	public boolean isConnected() {
		return this.connected;
	}
}
