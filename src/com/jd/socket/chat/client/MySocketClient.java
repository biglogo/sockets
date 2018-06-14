package com.jd.socket.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MySocketClient {
	public void connet()throws Exception{
		Socket socket = new Socket(InetAddress.getByName("www.baidu.com"),10086);
		BufferedReader reader = new BufferedReader(new 
				InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		InputStreamReader input = new InputStreamReader(System.in);
		String info = null;
		try {
			while(true){
				System.out.println("客户端需要输入：");
				char[] ins = new char[1024];
				input.read(ins);
				info = new String(ins);
				info = info+"\r\n";
				writer.write(info);
				writer.flush();
				System.err.println("我："+info);
				String cli = reader.readLine();
				if(cli!=null&&!"".equals(cli)){
					System.out.println("服务端："+cli);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			socket.close();
		}
		reader.close();
		writer.close();
		input.close();
	}
	
	public static void main(String[] args) {
		try {
//			for(int i=0;i<3;i++){
//				MySocketClient client = new MySocketClient();
//				client.connet();
//			}
			MySocketClient client = new MySocketClient();
			client.connet();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
