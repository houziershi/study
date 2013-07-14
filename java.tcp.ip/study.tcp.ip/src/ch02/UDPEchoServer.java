package ch02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
	// Maximum size of echo datagram
	private static final int ECHOMAX = 255;

	public static void main(String[] args) throws IOException {

		if (args.length != 1) { // Test for correct argument list
			throw new IllegalArgumentException("Parameter(s): <Port>");
		}

		int servPort = Integer.parseInt(args[0]);

		DatagramSocket socket = new DatagramSocket(servPort);
		DatagramPacket packet = new DatagramPacket(//
				new byte[ECHOMAX], ECHOMAX);

		// Run forever, receiving and echoing datagrams
		while (true) {
			// Receive packet from client
			socket.receive(packet);
			System.out.println("Handling client at "
					+ packet.getAddress().getHostAddress() + " on port "
					+ packet.getPort());
			// Send the same packet back to client
			socket.send(packet);
			// Reset length to avoid shrinking buffer
			packet.setLength(ECHOMAX);
		}
	}

}
