import java.awt.*;
import java.util.*;

import javax.swing.*;
public class Cer {
	
	

	 Random rd = new Random();
     int p = rd.nextInt(5);
     int z = rd.nextInt(5);
     
     //
     ImageIcon a = new ImageIcon("cerr"+p+".png");
     Image bam = a.getImage();
     ImageIcon b = new ImageIcon("cerr"+z+".png");
     Image tam = b.getImage();
     
	
    public int OffsetY = 0;
    int type = 0;
	
    public Rectangle p1 = new Rectangle(0,0 , 0, 0);
    public Rectangle p2 = new Rectangle(0, 0, 0, 0);
		//g.fillRect(p1.x, p1.y, p1.width, p1.height);
        //g.fillRect(p2.x, p2.y, p2.width, p2.height);
    public  Cer(int t){
        type = t;
    }
 public void RenderCer(Graphics g){
        //g.setColor(Color.YELLOW);
        
       	
        g.drawImage(bam,p1.x,p1.y,55,73,null);
		
     
        g.drawImage(tam,p2.x,p2.y,55,73,null);
    }
    

    public boolean IsPlayerCollides(Car p){
        if(p.bounds.intersects(p1) || p.bounds.intersects(p2)){
        	
        System.out.println(type);

            return true;
        }
        return false;
    }
    
    public boolean FloorCollide(lol fl){
        if(fl.floor.intersects(p1) || fl.floor.intersects(p2)){
            return true;
        }
        return false;
    }

    public void UpdatePipe(){
        if(type == 0){
            p1 = new Rectangle(20, OffsetY, 50,73);
            
            p2 = new Rectangle(105, OffsetY, 50, 73);
            
        } else if(type == 1){
            p1 = new Rectangle(190, OffsetY, 50, 73);
            p2 = new Rectangle(275, OffsetY, 50, 73);
        } else if(type == 2){
            p1 = new Rectangle(105, OffsetY, 50, 73);
            p2 = new Rectangle(275, OffsetY, 50, 73);
        }
        if(type == 3){
        	p1 = new Rectangle(20, OffsetY, 50, 73);
            p2 = new Rectangle(190, OffsetY, 50, 73);
        }
        if(type == 4){
        	p1 = new Rectangle(105, OffsetY, 50, 73);
            p2 = new Rectangle(190, OffsetY, 50, 73);
            
        }
        if(type == 5){
           p1 = new Rectangle(20, OffsetY, 50, 73);
            p2 = new Rectangle(275, OffsetY, 50, 73);
        }
    }
   public void paintComponent(Graphics g){
   	//super.paintComponent(g);
   	
        
   }
}
