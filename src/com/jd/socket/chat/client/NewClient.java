package com.jd.socket.chat.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewClient {
	private static final int port=80;
	private static final String host="127.0.0.1";
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(host,port);
			InetAddress inetAddress = socket.getInetAddress();
			System.out.println(inetAddress);
			InputStream  in  = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
