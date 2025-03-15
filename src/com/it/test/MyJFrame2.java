package com.it.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    //创建一个按钮
    JButton jbt = new JButton("登录");



    public MyJFrame2(){

        //设置界面的宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置默认的关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中的模式，才能按照xy轴的形式添加组件
        this.setLayout(null);


        //设置按钮的位置大小
        jbt.setBounds(0,0,100,50);

        //给按钮添加鼠标事件
        jbt.addMouseListener(this);


        //将按钮添加到界面中去
        this.getContentPane().add(jbt);

        //显示界面
        this.setVisible(true);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击了我");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按压了");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("释放了");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("进入按钮区域");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("离开按钮区域");
    }
}
