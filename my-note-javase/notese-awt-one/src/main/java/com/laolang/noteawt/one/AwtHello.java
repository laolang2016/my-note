package com.laolang.noteawt.one;

import java.awt.*;
import java.awt.event.*;

public class AwtHello extends Frame {

    public static void main(String[] args) {
        AwtHello awtHello = new AwtHello("第一个AWT程序");
        awtHello.setSize(300,200);
        awtHello.setVisible(true);
        awtHello.setLocationRelativeTo(null);
    }

    public AwtHello(String title) throws HeadlessException {
        super(title);
        addKeyListener(new MyKeyAdapter(this));
        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(keyMsg,10,40);
        g.drawString(mousemsg,mouseX,mouseY);
    }

    class MyKeyAdapter extends KeyAdapter{
        AwtHello awtHello;

        public MyKeyAdapter(AwtHello awtHello) {
            this.awtHello = awtHello;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            awtHello.setKeyMsg(awtHello.getKeyMsg() + e.getKeyChar());
            awtHello.repaint();
        }
    }

    class MyMouseAdapter extends MouseAdapter{
        AwtHello awtHello;

        public MyMouseAdapter(AwtHello awtHello) {
            this.awtHello = awtHello;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            awtHello.setMouseX(e.getX());
            awtHello.setMouseY(e.getY());
            awtHello.setMousemsg("Mouse Down at " + awtHello.getMouseX() + " , " + awtHello.getMouseY());
            awtHello.repaint();
        }
    }

    class MyWindowAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public String getKeyMsg() {
        return keyMsg;
    }

    public void setKeyMsg(String keyMsg) {
        this.keyMsg = keyMsg;
    }

    public String getMousemsg() {
        return mousemsg;
    }

    public void setMousemsg(String mousemsg) {
        this.mousemsg = mousemsg;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    private String keyMsg = "This is a test.";

    private String mousemsg = "";

    private int mouseX = 30;

    private int mouseY = 30;
}
