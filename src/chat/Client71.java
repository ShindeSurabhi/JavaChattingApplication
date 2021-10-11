
package chat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Client71 implements ActionListener{
	
	/**
	 * 
	 */
	static JFrame f1= new JFrame();
	JPanel p1;
	JTextField t1;
	JButton b1;
	//static JTextArea a1;
	static JPanel a1;
	
	static Box vertical = Box.createVerticalBox();//vertical box helped to vertically aligned messages
	//classes of java.net package
		
		static Socket s; //declaration
		static DataInputStream din;
		static DataOutputStream dout;
		
		Boolean typing;



	Client71(){
		
   //Panel or Header
        p1 = new JPanel();  //create object of panel
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);  //setting (x,y,width,height) of panel
        f1.add(p1); //add panel on frame
        
  //backButton
    // Create object i1 of ImageIcon class & take image from disc using getSystemResource()  method of ClassLoader class.
        ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("chat/icons7/3.png"));
       
        
        Image i2;  //changing size of an image
        i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        
        ImageIcon i3;
        i3 = new ImageIcon(i2);
     
     //you cannot put image directly on frame so you need to put it in label
        JLabel l1;
        l1 = new JLabel(i3);
        f1.setLayout(null);  //swing has so many layouts and here we will create our own layout using setBounds(x,y,width,height)
        l1.setBounds(5, 17, 30, 30); //setting (x,y,width,height) of an image
        p1.add(l1);  //to add label or image  on panel p1
        
        
      //Adding mouseEvents(over,in,out,click) on Label 1 to make l1 clickable 
        //All following methods are in ActionListener interface of java.awt.event package
        l1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });     
        
        
 //dp 
        ImageIcon i4;
        i4 = new ImageIcon(ClassLoader.getSystemResource("chat/icons7/flow-modified.png"));
        Image i5;  
        i5 = i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i6;
        i6 = new ImageIcon(i5);
        JLabel l2;
        l2 = new JLabel(i6);
        f1.setLayout(null);    
        l2.setBounds(40, 5, 60, 60);
        p1.add(l2); 
        
 //name
        JLabel l3;
        l3 = new JLabel("Client");
        l3.setFont(new Font("SANS_SERIF",Font.BOLD,18 ));
        l3.setForeground(Color.WHITE);
        f1.setLayout(null);    
        l3.setBounds(110, 15, 100, 18);
        p1.add(l3); 
        
        
 //Activity status
        JLabel l4;
        l4 = new JLabel("Active now");
        l4.setFont(new Font("SANS_SERIF",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        f1.setLayout(null);    
        l4.setBounds(110, 35, 100, 20);
        p1.add(l4); 
        
        
//Typing......
        
        
        Timer t = new Timer(1,new ActionListener() {
        	//whenever you are implementing any Interface ,you should override abstract methods of that interface in your class. 
        	public void actionPerformed(ActionEvent ae) {
        		if(!typing) {
        			l4.setText("Active now");   //if i am not typing then set text to active now
        		
        		}
        		
        	}
        	
        });
        
        
        t.setInitialDelay(2000);  //delay of 2000 ms
       
        
        
        
 //video
        ImageIcon i7;
        i7 = new ImageIcon(ClassLoader.getSystemResource("chat/icons7/video.png"));
        Image i8;  
        i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9;
        i9 = new ImageIcon(i8);
        JLabel l5;
        l5 = new JLabel(i9);
        f1.setLayout(null);    
        l5.setBounds(290, 20, 30, 30);
        p1.add(l5); 
        
        
 //phone
        ImageIcon i10;
        i10 = new ImageIcon(ClassLoader.getSystemResource("chat/icons7/phone.png"));
        Image i11;  
        i11 = i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);
        ImageIcon i12;
        i12 = new ImageIcon(i11);
        JLabel l6;
        l6 = new JLabel(i12);
        f1.setLayout(null);    
        l6.setBounds(350, 20, 35, 30);
        p1.add(l6); 
        
        
 //threeDots
        ImageIcon i13;
        i13 = new ImageIcon(ClassLoader.getSystemResource("chat/icons7/3icon.png"));
        Image i14;  
        i14 = i13.getImage().getScaledInstance(15,25,Image.SCALE_DEFAULT);
        ImageIcon i15;
        i15 = new ImageIcon(i14);
        JLabel l7;
        l7 = new JLabel(i15);
        f1.setLayout(null);    
        l7.setBounds(410,20, 15, 25);
        p1.add(l7); 
        
        
 
 //TextArea
        //  a1 = new JTextArea();
          a1 = new JPanel();
          a1.setBounds(5,75,440,570);
      //    a1.setBackground(Color.PINK);
          a1.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
//          a1.setEditable(false); 
//          a1.setLineWrap(true);  //lines will be wrapped if they are too long to fit within the allocated width.
//          a1.setWrapStyleWord(true); //lines will be wrapped at word boundaries , if false then at character boundaries
          f1.add(a1);
        
 //TextField
        t1=new JTextField();
        t1.setBounds(5, 655, 310, 40);
        t1.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
        f1.add(t1);
        
        t1.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent ke) { //overriding keyPressed function of KeyListener Interface
        		l4.setText("Typing...");
        		
        		t.stop();
        		
        		typing = true;
        	}
        	
        	public void keyReleased(KeyEvent ke) { //overriding keyReleased function of KeyListener Interface
        		
        		typing = false;
        		
        		if(!t.isRunning()) {
        			t.restart();
        		}
        		
        		
        	}
        });
        
 //SendButton
        b1=new JButton("Send");
        b1.setBounds(320, 655, 123, 40);
        b1.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);  //when button get clicked actionPerformed()called
        f1.add(b1);

        
 
        

		
     // following  methods are of JFrame Class of swing package
    //getContentPane() will take whole frame
    //getContentPane().setBackground(new Color(4, 52, 107)); //set bg color of whole frame to yellow
		    f1.setSize(450,700);    //Sets size of frame  
	        f1.setLocation(50,5);   //Sets location of frame 
	        f1.setUndecorated(true); //To remove upper bar
	        f1.setVisible(true);  //byDefault frame is not visible so set it to true and write it at last
	}
	
	
	
	//Overriding actionPerformed interface of ActionListener
	public void actionPerformed(ActionEvent ae) {
		//io exception throw
		try {
		
		String out=t1.getText(); //storing text of TextField in out
		//a1.setText(a1.getText()+"\n\t\t\t"+ out); //setting dynamically text(old text of TextArea + text of TextField) on TextArea 
		
		sendTextToFile(out);
		
		JPanel p2 = formatLabel(out); //this function returns panel
		
		//sending messages on right 
		a1.setLayout(new BorderLayout());
		JPanel right = new JPanel(new BorderLayout());
		right.add(p2,BorderLayout.LINE_END);//p2 should add at line end  
		vertical.add(right); //message right append
		vertical.add(Box.createVerticalStrut(15)); // space between two messages
		a1.add(vertical,BorderLayout.PAGE_START);
		//a1.add(p2);
		
		
		dout.writeUTF(out); //sending data after clicking send button
		t1.setText(""); //making textField empty after sending text
		
		} catch ( Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
	public void sendTextToFile(String message) throws FileNotFoundException{
		try (FileWriter f = new FileWriter("chat.txt");
				PrintWriter p = new PrintWriter(new BufferedWriter(f))
						;) {
					p.println("Client:  " + message);
					
		}	
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	
	//returning panel 
		public static JPanel formatLabel(String out) {
			JPanel p3 = new JPanel();
			p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS)); //grow along Y-axis(below one another)
			
			JLabel l1 = new JLabel("<html><p style= \"width : 150px\" >" + out + "</p></html>"); //message of textfield is in label
			//formatting of message
			l1.setBackground(new Color(37,211,102));
			l1.setOpaque(true);
			l1.setBorder(new EmptyBorder(15,15,15,50));//(top,left,bottom,right)
			l1.setFont(new Font("TAHOMA",Font.PLAIN,16));
			p3.add(l1); //adding label(message) on panel
			
			//current date and time below message
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat  sdf= new SimpleDateFormat("hh:mm");
			
			JLabel l2 = new JLabel();
			l2.setText(sdf.format(cal.getTime()));
			p3.add(l2);
			
			return p3;
			
		}


public static void main(String[] args){
    new Client71();
    Client71.f1.setVisible(true);
    
    String msginput = "";
    try {
    	
    	//Defining objects
    	s = new Socket("127.0.0.1",6001); // (IP address of Server, Port no)
    	
    	while(true) {
    	//tracking input and output stream
    	din = new DataInputStream(s.getInputStream());  //din storing incomingdata
    	dout = new DataOutputStream(s.getOutputStream());  //dout storing outgoing data
    	
    	
    	while(true) {
    	msginput = din.readUTF();    //reading data of din & storing into msginput
    	//a1.setText(a1.getText()+"\n"+msginput); //Printing on TextArea
        
    	JPanel p2 = formatLabel(msginput);
    	JPanel left = new JPanel(new BorderLayout());
    	left.add(p2,BorderLayout.LINE_START);
    	vertical.add(left);
    	f1.validate();
    	
    	
    	}
    	}
    	 
    	//connection close
    	// s.close(); 
    	
    }catch (Exception e) {
    	
    }
} 
}
    	
    	
    
