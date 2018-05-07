package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private static Socket socket;

	public static void main(String args[]) {
		try {
			String host = "localhost";
			int port = 25000;
			String cmd;
			InetAddress address = InetAddress.getByName(host);
			socket = new Socket(address, port);
			Scanner sc = new Scanner(System.in);
			
			while (!socket.isClosed()) {
				
				cmd = sc.nextLine();
				
				// Send the message to the server
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);

				String sendMessage = cmd + "\n";

				bw.write(sendMessage);
				bw.flush();
				System.out.println("Message sent to the server : " + sendMessage);

				
				  // Get the return message from the server InputStream is =
				  InputStream is = socket.getInputStream();
				  InputStreamReader isr = new InputStreamReader(is);
				  BufferedReader br = new BufferedReader(isr); 
				 // System.out.println("Before receiveg message from server ");
				 // String message = br.readLine();
				  //System.out.println("Message received from the server : " + message);
				 
			}
		} catch (Exception exception) {

			exception.printStackTrace();

		} finally {
			// Closing the socket
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
