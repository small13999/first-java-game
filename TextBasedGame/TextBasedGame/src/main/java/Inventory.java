
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ármin
 */
public class Inventory {
    
    private int leather;
    private int bone;
    private int fangs;
    private int bearskin;
    private int trunk;
    private int crown;
    
    public Inventory() {  
        leather = 0;
        bone = 0;
        fangs = 0;
        bearskin = 0;
        trunk = 0;
        crown = 0;
        
    }
    
    public void addItem(String item) {
        if (item.equals("Leather")) {
            leather++;
        } else if (item.equals("Bone")) {
            bone++;
        } else if (item.equals("Fangs")) {
            fangs++;
        } else if (item.equals("Bear Skin")) {
            bearskin++;
        } else if (item.equals("Elephant Trunk")) {
            trunk++;
        } else if (item.equals("Golden Crown")) {
            crown++;
        }
    }
    
    public void takeItem(String item, int amount) {
        if (item.equals("Leather")) {
            leather-=amount;
        } else if (item.equals("Bone")) {
            bone-=amount;
        } else if (item.equals("Fangs")) {
            fangs-=amount;
        } else if (item.equals("Bear Skin")) {
            bearskin-=amount;
        } else if (item.equals("Elephant Trunk")) {
            trunk-=amount;
        } else if (item.equals("Golden Crown")) {
            crown-=amount;
        }
    }
    
    public int getItemCount(String item) {
        if (item.equals("Leather")) {
            return leather;
        } else if (item.equals("Bone")) {
            return bone;
        } else if (item.equals("Fangs")) {
            return fangs;
        } else if (item.equals("Bear Skin")) {
            return bearskin;
        } else if (item.equals("Elephant Trunk")) {
            return trunk;
        } else if (item.equals("Golden Crown")) {
            return crown;
        }
        return 0;
    } 
    
}
