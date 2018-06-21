package client;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

import client.*;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
 private static ClientConsole ClientFunc = new ClientConsole("localhost", 5555);
 
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
 public static boolean Done = false; 
 public static String Result;
 public static String ParkingID;
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
//  private static ClientConsole console = new ClientConsole("localhost", DEFAULT_PORT);
  private static ChatClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port) 
  {  
    try 
    {
      client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
	
	/*TODO: add fields as needed in class*/
	/*TODO: extend the constructor to receive the needed info (user name, user id)*/
	/*TODO:check out AbstractClient API(NOTE ChatClient extends AbstractClient), to find out how to get the address of the client*/
  }

  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public void sendRequest(String Msg) 
  {
    try
    {
        client.handleMessageFromClientUI(Msg);
      
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }
  public static ClientConsole getInstance() {
		return ClientFunc;
  }
  
  public ChatClient getClient(){
	  return client;
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  public void display(String message) 
  {
   this.Done=true;
   this.Result=message;
  // System.out.println(message);
  }
  
  
//  public static ChatClient getClient() {return client;}

  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
//  public static void main(String[] args) 
//  {
//  }
}
//End of ConsoleChat class
