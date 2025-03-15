package com.it.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

public class MyJFrame3 extends JFrame implements KeyListener {

    public MyJFrame3() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面标题
        this.setTitle("我的标题界面3");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中模式，才能在添加组件的时候xy轴的形式展示
        this.setLayout(null);

        //给整个窗体添加键盘监听
        this.addKeyListener(this);

        //显示界面
        this.setVisible(true);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //细节1：如果我们按下一个建不送就会重复的调用keyPressed
    //细节2：


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){
            System.out.println("现在按的是A");
        }else if (code == 68){
            System.out.println("现在按的是D");
        }else if (code == 87){
            System.out.println("现在按的是W");
        }else if (code == 83){
            System.out.println("现在按的是S");
        }
        System.out.println(code);

    }

}
