import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends JPanel implements KeyListener{

    Car player = new Car();
    public int score=0;
   

	 Random mad = new Random();
     int p = mad.nextInt(6);

    
    public int state = 0;
	ArrayList<Cer> prot = new ArrayList<Cer>();
	int Step = 0;
	int interval = 34;
	Rectangle Bel,Sd,Ds,Abo;
    Cer sample = new Cer(0);    
    lol laps = new lol();
      boolean[] keys = new boolean[256];

    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
       // System.out.println(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
    

    public Game(){
        addKeyListener(this);
        setFocusable(true);
        Thread td = new Thread(new Runnable(){
           public void run(){
               setup();
               while(true){
                   try {
                       update();
                       render();
                       Thread.sleep(16);
                   } catch(Exception ex){

                   }
               }
           }
        });
        td.start();	
        }
        
        /*up 38
         *left 37
         *right 39 
         *down 40*/
         
        void setup(){
        	player.bounds.x=113;
        	player.bounds.y=420;
        	
        	
        Bel = new Rectangle(0, 575, 350, 50);
        Sd = new Rectangle(-25, 0, 20, 560);
        Ds = new Rectangle(365, 0, 20, 560);
        }
        
        void update(){ 
       		hammer();
       		
        	if(state==1){
        	//System.out.print("AA");
        		for(Cer x : prot){
           	x.OffsetY += 8;
            x.UpdatePipe(); 
            	if(score >20)
                {
                	x.OffsetY ++;
                }
            	if(score >30)
                {
                	x.OffsetY ++;
                }
                if(score >40)
                {
                	x.OffsetY ++;
                }
                if(score >50)
                {
                	x.OffsetY ++;
                }
                if(score >70)
                {
                	x.OffsetY ++;
                }
                if(score >80)
                {
                	x.OffsetY ++;
                }
                if(score >85)
                {
                	x.OffsetY ++;
                }
                if(score >95)
                {
                	x.OffsetY ++;
                }
            
       

            }		
        	if(keys[38]){
        	player.bounds.y-=7;
        	}
     		if(keys[37]){
        	player.bounds.x-=7;
     		}
     		if(keys[39]){
        	player.bounds.x+=7;
     		}
     		if(keys[40]){
        	player.bounds.y+=7;
     		}
     		if(Step >= interval){
            AddPipe();
            Step = 0;
        }
        Step++;
        for(Cer x : prot) {
            if (x.IsPlayerCollides(player)) {
                
                die();
                }
            if (x.FloorCollide(laps)) {
            	
        int toRemove = -1;
            	score+=2;
            	toRemove = prot.indexOf(x);
                
            	if(toRemove >-1) prot.remove(toRemove);

            	
            }
        }
        if(player.bounds.intersects(Bel)){
            
        
        	die();}
         if(player.bounds.intersects(Sd)){
             die();
        }
         if(player.bounds.intersects(Ds)){
            die();
        }

        } } 
        
        void hammer(){
        	if (state == 0){
       		if(keys[32]){
       			state=1;
       		}
       		}
        	
        	if (state == 2){
        		player.bounds.x = getWidth() / 2 - 25;
        		player.bounds.y = getHeight()-80;
				die();
				
        	}
        }
        
        void die(){
        	prot.clear();
        	state = 2;
        }
        
        void AddPipe(){
        Random rd = new Random();
        int r = rd.nextInt(6);
        Cer p = new Cer(r);
        //set pipe to rightmost corner
        p.OffsetY = 0;
        prot.add(p);
    }

        void render(){
        	repaint();    }
        	
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));

        //Render player
        //
        
        if(state ==0){

           	g.fillRect(0,0,getWidth(),getHeight());
           	ImageIcon b = new ImageIcon("bb.gif");
       		Image bamz = b.getImage();
       		g.drawImage(bamz,40,300,250,150,null);
           	ImageIcon a = new ImageIcon("logo.png");
       		Image bam = a.getImage();
       		g.drawImage(bam,50,50,250,150,null);
            Font fnt = new Font("Arial", Font.BOLD, 20);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Click Space to RACE!", getWidth() / 2 - 95, getHeight() / 2);
            Font fant = new Font("Arial", Font.BOLD, 15);
            g.setFont(fant);
            g.drawString("Use arrow keys to control VPB", getWidth() / 2 - 110, getHeight()-30);
            
        }
        if(state == 1){
        		g.setColor(Color.BLACK);
                g.fillRect(0,0,getWidth(),getHeight());
                g.setColor(Color.YELLOW);
        		g2.drawLine(85,0,85,550);
        		g2.drawLine(170,0,170,550);
        		g2.drawLine(255,0,255,550);
        		//g.fillRect(player.bounds.x, player.bounds.y, player.bounds.width, player.bounds.height);ImageIcon a = new ImageIcon(imaje[r]);
        		
				
        		ImageIcon ba = new ImageIcon("CARR.png");
        		Image img = ba.getImage();
        		g.drawImage(img,player.bounds.x,player.bounds.y,player.bounds.width,player.bounds.height,null);
        		g.setColor(Color.WHITE);
        		g.drawString("SCORE",270,30);
        		g.drawString(""+score,286,40);


        		for(Cer x : prot){
            	x.RenderCer(g);
        }

        }
         if(state == 2) {
            //Dim screen
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            Font fnt = new Font("Arial", Font.BOLD, 20);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", getWidth() / 2 - 60, getHeight() / 2);
            g.drawString("Your Score Is: "+score, getWidth() / 2 - 75, getHeight() / 2+60);
            g.drawString("Hit space to race AGAIN!!", getWidth() / 2 - 118, getHeight() / 2+80);
            ImageIcon a = new ImageIcon("smile.gif");
     		Image bam = a.getImage();
     		g.drawImage(bam,40,50,250,150,null);
			if(keys[32]){
				
				score =0;

				state=0;
				
			}
        }

    }
public static void main(String[] args){
        JFrame gm =  new JFrame("Hayai Race!");
        gm.setSize(350, 550);
        gm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gm.setContentPane(new Game());
        gm.setVisible(true);
    }





}
