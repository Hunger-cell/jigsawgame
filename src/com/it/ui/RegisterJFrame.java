package com.it.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //以后跟注册界面的代码写在这里

    //构造方法，给界面进行一些初始化
    public RegisterJFrame(){
        //设置界面的宽高
        this.setSize(488,500);
        //设置界面的标题
        this.setTitle("游戏 注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面的关闭模式
        this.setDefaultCloseOperation(3);
        //让界面显示出来
        this.setVisible(true);
    }


}
