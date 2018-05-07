package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	private static Socket socket;

	public static void main(String[] args) {

		try
		{
			int port = 25000;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server Started and listening to the port 25000");
		/*	
			//Server is running always. This is done using this while(true) loop
			socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				//Reading the message from the client
				
				//System.out.println("Before receving from client");
				String cmd = br.readLine();
				System.out.println("Message received from client is "+cmd);
				
			String returnMessage;
			try{
			//int cmdInIntFormat = Integer.parseInt(cmd);
			//int returnValue = cmdInIntFormat*2;
			returnMessage = "ok " ;//String.valueOf(returnValue) + "\n";
			}catch(Exception e)
			{
			//Input was not a cmd. Sending proper message back to client.
				e.printStackTrace();
				returnMessage = "Please send a proper cmd\n";
			}
			//Sending the response back to the client.
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(returnMessage);
			System.out.println("Message sent to the client is "+returnMessage);
			*/
			bw.flush();
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
			{
			try{
				socket.close();
			}catch(Exception e){}

			}
		}
}