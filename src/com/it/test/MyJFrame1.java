package com.it.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame1 extends JFrame implements ActionListener {
    //创建按钮对象
    JButton jbt1 = new JButton("登录");
    JButton jbt2 = new JButton("注册");

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jbt1) {
            System.out.println("登录被点击了");
        }else if (source == jbt2){
            System.out.println("注册被点击了");
        }

    }

    //初始化界面信息，空参构造
    public MyJFrame1() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenu();

        //初始化按钮
        initJButton();

        //加载图片
        initJLabel();
        //显示界面
        this.setVisible(true);

    }

    private void initJLabel() {



    }

    //初始化界面方法
    public void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("我的框架");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中设置
        this.setLayout(null);
    }

    //初始化菜单方法
    public void initJMenu() {
        //设置菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //设置菜单中的条目
        JMenu factionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //设置条目中的项目
        JMenuItem replayGame = new JMenuItem("重新游戏");
        JMenuItem reLogin = new JMenuItem("重新登录");
        JMenuItem exitGame = new JMenuItem("退出游戏");

        JMenuItem accountJMenu = new JMenuItem("公众号");
        //将其穿起来
        factionJMenu.add(replayGame);
        factionJMenu.add(reLogin);
        factionJMenu.add(exitGame);

        aboutJMenu.add(accountJMenu);

        jMenuBar.add(factionJMenu);
        jMenuBar.add(aboutJMenu);

        //将菜单放入界面中
        this.setJMenuBar(jMenuBar);

    }

    //初始化按钮方法
    public void initJButton() {

        //设置按钮的位置大小
        jbt1.setBounds(0, 0, 150, 50);
        jbt2.setBounds(400, 0, 150, 50);

        //给按钮设置事件ActionListener
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);

        //将按钮添加到界面
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

    }

}
