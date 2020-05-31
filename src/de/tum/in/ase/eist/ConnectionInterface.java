package de.tum.in.ase.eist;

import java.net.URL;

public interface ConnectionInterface {

	void connect(URL url);

	void disconnect();

	boolean isConnected();

}
