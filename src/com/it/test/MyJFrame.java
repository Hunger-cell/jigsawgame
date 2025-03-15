package com.it.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    //创建一个按钮
    JButton jbt1 = new JButton("点我啊");
    //创建一个按钮
    JButton jbt2 = new JButton("再点我啊");
    public MyJFrame(){
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("我的界面");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中模式，才能实现xy轴的形式添加组件
        this.setLayout(null);


        //给按钮设置位置和宽高
        jbt1.setBounds(0,0,100,50);
        //给按钮添加事件
        jbt1.addActionListener(this);


        jbt2.setBounds(100,0,100,50);
        jbt2.addActionListener(this);

        //将按钮添加到界面中去
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        //让界面显示出来
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前按钮进行判断

        //获取当前被操作的那个按钮
        Object source = e.getSource();
        if (source == jbt1){
            jbt1.setSize(200,200);
        } else if (source == jbt2) {
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500),r.nextInt(500));
        }

    }
}
