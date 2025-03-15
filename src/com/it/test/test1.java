package com.it.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(603,680);
        //设置界面的标题
        jFrame.setTitle("事件演示");
        //设置界面的置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置界面的关闭模式
        jFrame.setDefaultCloseOperation(3);
        //取消默认的居中模式，才能按照xy轴的形式添加组件
        jFrame.setLayout(null);

        //创建按钮对象
        JButton jbt = new JButton("点我啊");

        //设置位置和宽高
        jbt.setBounds(0,0,100,50);
        //给按钮添加动作监听
        //jbt:组件对象，表示你要给那个组件的添加事件
        //addActionListener:表示我要给组件添加那个事件监听  (动作监听 包括鼠标左键点击，空格)
        //参数：表示事件被触发之后要执行的代码
        //jbt.addActionListener(new MyActionListener());
        //使用了匿名内部类
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("哒咩 ~不要点我");
            }
        });


        //将按钮放在界面
        jFrame.getContentPane().add(jbt);


        //显示界面
        jFrame.setVisible(true);
    }
}
