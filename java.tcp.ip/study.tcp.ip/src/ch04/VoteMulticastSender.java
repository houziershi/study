package ch04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import ch03.VoteMsg;
import ch03.VoteMsgCoder;
import ch03.VoteMsgTextCoder;

public class VoteMulticastSender {

	public static final int CANDIDATEID = 475;

	public static void main(String args[]) throws IOException {

		if ((args.length < 2) || (args.length > 3)) { // Test # of args
			throw new IllegalArgumentException(
					"Parameter(s): <Multicast Addr> <Port> [<TTL>]");
		}

		// Destination
		InetAddress destAddr = InetAddress.getByName(args[0]); 
		if (!destAddr.isMulticastAddress()) { // Test if multicast address
			throw new IllegalArgumentException("Not a multicast address");
		}

		int destPort = Integer.parseInt(args[1]); // Destination port
		// Set TTL
		int TTL = (args.length == 3) ? Integer.parseInt(args[2]) : 1; 

		MulticastSocket sock = new MulticastSocket();
		sock.setTimeToLive(TTL); // Set TTL for all datagrams

		VoteMsgCoder coder = new VoteMsgTextCoder();

		VoteMsg vote = new VoteMsg(true, true, CANDIDATEID, 1000001L);

		// Create and send a datagram
		byte[] msg = coder.toWire(vote);
		DatagramPacket message = new DatagramPacket(//
				msg, msg.length, destAddr, destPort);
		System.out.println("Sending Text-Encoded Request (" + msg.length
				+ " bytes): ");
		System.out.println(vote);
		sock.send(message);

		sock.close();
	}
}