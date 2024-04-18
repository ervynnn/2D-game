package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPress,downPress,leftPress,rightPress;

    // NOT INCLUDED
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //System.out.println(code);

        if(code== KeyEvent.VK_W || code== KeyEvent.VK_UP){
            upPress=true;
        }
        if(code== KeyEvent.VK_S || code== KeyEvent.VK_DOWN){
            downPress=true;
        }
        if(code== KeyEvent.VK_A || code== KeyEvent.VK_LEFT){
            leftPress=true;
        }
        if(code== KeyEvent.VK_D || code== KeyEvent.VK_RIGHT){
            rightPress=true;
        }

    }

    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code== KeyEvent.VK_W || code== KeyEvent.VK_UP){
            upPress=false;
        }
        if(code== KeyEvent.VK_S || code== KeyEvent.VK_DOWN){
            downPress=false;
        }
        if(code== KeyEvent.VK_A || code== KeyEvent.VK_LEFT){
            leftPress=false;
        }
        if(code== KeyEvent.VK_D || code== KeyEvent.VK_RIGHT){
            rightPress=false;
        }

    }

}
