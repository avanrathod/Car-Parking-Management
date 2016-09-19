import java.net.*;
import java.io.*;

public class CarClient
{
   public static void main(String [] args)
   {
   	String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      int p=Integer.parseInt(args[2]);
      try
      {
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to " 
		 + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
        boolean a[]=new boolean[p];
        while(true)
        {
        	String s=in.readUTF();
        	//System.out.println("s="+s);
        	if(s.equals("-1"))
        	{
        		boolean f=false;
        		for(int i=0;i<p;i++)
        		{
        			if(a[i]==false)
        			{
        				a[i]=true;
        				out.writeUTF(Integer.toString(i));
        				f=true;
        				break;
        			}
        		}
        		if(f==false)
        			out.writeUTF("-1");
        	}
        	else
        	{
        		//System.out.println("parking here");
        		s=in.readUTF();
        		System.out.println(s);
        		int c=Integer.parseInt(s);//Integer.parseInt(in.readUTF());
        		//System.out.println("parking here2");
        		if(a[c]==true)
        		{
        			a[c]=false;
        			out.writeUTF("Parking space successfully freed");
        		}
        		else
        		{
        			out.writeUTF("Wrong id,please try again.");
        		}
        	}
        }
      }
      catch(IOException e)
      {
         //e.printStackTrace();
      }
  }
}