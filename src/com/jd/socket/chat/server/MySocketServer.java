package com.jd.socket.chat.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.jd.socket.chat.client.MySocketClient;

public class MySocketServer {
	public void serve()throws Exception{
		ServerSocket server = new ServerSocket(10086);
		Socket socket = server.accept();
		BufferedReader reader = new BufferedReader(new 
				InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		InputStreamReader input = new InputStreamReader(System.in);
		String info = null;
		try {
			while(true){
				String cli = reader.readLine();
				if(cli!=null&&!"".equals(cli)){
					System.out.println("¿Í»§¶Ë£º"+cli);
				}
				char[] ins = new char[1024];
				input.read(ins);
				info = new String(ins);
				info = info+"\r\n";
				writer.write(info);
				writer.flush();
				System.err.println("ÎÒ£º"+info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			socket.close();
		}
		reader.close();
		writer.close();
		input.close();
		server.close();
	}
	
	public static void main(String[] args) {
//		MySocketServer server = new MySocketServer();
//		try {
//			server.serve();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		for(int i=0;i<100;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000l);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
