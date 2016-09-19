import java.net.*;
import java.io.*;
import java.util.*;
class CarServer
{
	private ServerSocket serverSocket;

	public CarServer(int port,int backlog)throws Exception
	{
		serverSocket=new ServerSocket(port,backlog);
	}
	public static void main(String[] args) {
		int port=Integer.parseInt(args[0]);
		int backlog=Integer.parseInt(args[1]);

		try
		{
			CarServer cs=new CarServer(port,backlog);
			cs.run(backlog);
		}
		catch(Exception e)
		{}
	}
	public void run(int backlog)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		try
		{
		Socket client[]=new Socket[backlog];
		DataOutputStream out[]=new DataOutputStream[backlog];
		DataInputStream in[] =new DataInputStream[backlog];
			for(int i=0;i<backlog;i++)
			{
				client[i]=serverSocket.accept();
				out[i]=new DataOutputStream(client[i].getOutputStream());
				in[i]=new DataInputStream(client[i].getInputStream());
				System.out.println("connected to "+client[i]);
			}
			int c=0;
			//int id=0;
			do
			{
				System.out.println("1.New Car addition in parking area");
				System.out.println("2.Old Car retrieval from parking area");
				System.out.println("Enter choice no.");
				c=sc.nextInt();
				if(c==1)
				{
					for(int i=0;i<backlog;i++)
					{
						//DataOutputStream out=new DataOutputStream(client[i].getOutputStream());
						out[i].writeUTF("-1");
						//DataInputStream in =
                 // new DataInputStream(client[i].getInputStream());
                  		int s=Integer.parseInt(in[i].readUTF());
                  		if(s>=0)
                  		{
                  			System.out.println("parking space allotted!!your id is"+i+"_"+s);
                  			c=3;
                  			break;
                  		}
					}
					if(c!=3)
					System.out.println("Parking space unavailable!! Please try again later");
				}
				if(c==2)
				{
					System.out.println("Enter parking id");
					String s="";
					while(s.equals(""))
					{
						s=sc.nextLine();
						System.out.println(s);
					}
					StringTokenizer st=new StringTokenizer(s,"_");
					int a=Integer.parseInt(st.nextToken());
					int b=Integer.parseInt(st.nextToken());
					System.out.println(a+" "+b);
					//DataOutputStream out=new DataOutputStream(client[a].getOutputStream());
					//System.out.println("out1");
					out[a].writeUTF(Integer.toString(b));
					out[a].writeUTF(Integer.toString(b));
					//System.out.println("out2");
				//	DataInputStream in =
                //  new DataInputStream(client[a].getInputStream());
						
						System.out.println(in[a].readUTF());
				}
			}
			while(c!=4);
			for(int i=0;i<backlog;i++)
			{
				client[i].close();
				out[i].close();
				in[i].close();
			}
			
		}
		catch(Exception e)
		{}
	}
	
}