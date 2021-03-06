package ch02;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {

	public static void main(String[] args) {
		/*
		 * get the newwork interface and associate address for this host
		 */
		try {
			Enumeration<NetworkInterface> interfaceList =
					NetworkInterface.getNetworkInterfaces();
			if (null == interfaceList) {
				System.out.println("--No interface found--");
			} else {
				while (interfaceList.hasMoreElements()) {
					NetworkInterface iface = interfaceList.nextElement();
					System.out.println("Interface " + iface.getName() + ":");
					Enumeration<InetAddress> addrList =
							iface.getInetAddresses();
					if (!addrList.hasMoreElements()) {
						System.out
								.println("\t(No addresses forthis interface)");
					}
					while (addrList.hasMoreElements()) {
						InetAddress address = addrList.nextElement();
						/*
						 * check address type
						 */
						String addressType = "(?)";
						if (address instanceof Inet4Address) {
							addressType = "(v4)";
						}
						if (address instanceof Inet6Address) {
							addressType = "(v6)";
						}
						System.out.println("\tAddress " + addressType //
								+ ": " + address.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			System.out.println("Error getting network interface: "
					+ e.getMessage());
		}

		/*
		 * get name(s)/address(s) of hosts given on command line
		 */
		for (String host : args) {
			System.out.println(host + ": ");
			try {
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for (InetAddress address : addressList) {
					System.out.println("\t" + address.getHostName() + "/"
							+ address.getHostAddress());
				}
			} catch (UnknownHostException e) {
				System.out.println("\tUnable to find address for : " + host);
			}
		}

	}

}
