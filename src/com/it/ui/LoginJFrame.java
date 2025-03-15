package com.it.ui;

import com.it.CodeUtil.CodeUtil;
import com.it.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    //表示登录界面
    //以后所有跟登录有关的代码都写在这里
    static ArrayList<User> allUsers = new ArrayList<>();
    static {
        allUsers.add(new User("zhangsan","123"));
        allUsers.add(new User("lisi","1234"));
    }


    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField codeText = new JTextField();
    JButton loginButton = new JButton();
    JButton register = new JButton();
    //正确的验证码
    JLabel rightCode = new JLabel();

    //构造方法，给界面进行一些初始化
    public LoginJFrame()  {
        //初始化界面
        initJFrame ();

        //給界面添加内容
        initView();


    }

    private void initView() {
        //创建JLabel添加  用户名文字
        JLabel userJlabel = new JLabel(new ImageIcon("..\\jigsawgame\\image\\login\\用户名.png"));
        userJlabel.setBounds(116, 135, 47, 17);
        this.getContentPane().add(userJlabel);

        //创建用户名的文本输入框  JTextField
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //创建JLabel添加  密码文字
        JLabel pswdJlabel = new JLabel(new ImageIcon("..\\jigsawgame\\image\\login\\密码.png"));
        pswdJlabel.setBounds(130, 195, 35, 16);
        this.getContentPane().add(pswdJlabel);

        //创建密码的文本输入框  JTextField
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //创建JLabel添加  验证码文字
        JLabel code = new JLabel(new ImageIcon("..\\jigsawgame\\image\\login\\验证码.png"));
        code.setBounds(133,256,50,30);
        this.getContentPane().add(code);

        //创建验证码输入框  JTextField
        codeText.setBounds(195, 256, 100, 30);
        this.getContentPane().add(codeText);
        //创建验证码
        String codeStr = CodeUtil.getCode();
        //设置内容
        rightCode.setText(codeStr);
        //绑定鼠标事件
        rightCode.addMouseListener(this);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //创建登录按钮  JButton
        loginButton.setBounds(123, 310, 128, 47);
        ImageIcon icon = new ImageIcon("..\\jigsawgame\\image\\login\\登录按钮.png");
        loginButton.setIcon(icon);
        //透明设置去除按钮的边框
        loginButton.setBorderPainted(false);
        //去除按钮的背景
        loginButton.setContentAreaFilled(false);
        //给登录绑定事件
        loginButton.addMouseListener(this);
        this.getContentPane().add(loginButton);

        //创建注册按钮  JButton
        register.setBounds(256,310,128,47);
        register.setIcon(new ImageIcon("..\\jigsawgame\\image\\login\\注册按钮.png"));
        //透明设置去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册绑定事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //创建背景图片
        JLabel backImage = new JLabel(new ImageIcon("..\\jigsawgame\\image\\login\\background.png"));
        backImage.setBounds(0,0,470,390);
        this.getContentPane().add(backImage);

        //让界面显示出来
        this.setVisible(true);
    }

    private void initJFrame() {
        //在创建登录界面的时候，同时给这个界面取设置一些信息
        //比如：宽高，直接展示出来
        //设置界面的宽高
        this.setSize(488, 430);
        //设置界面的标题
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中模式，下面添加组件的时候才能按照xy轴的形式添加
        this.setLayout(null);
    }

    //展示弹窗，显示错误
    public void showJDialog(String str){
        //设置弹窗对象
        JDialog jDialog1 = new JDialog(this, "提示", true);
        //设置弹窗的大小
        jDialog1.setSize(200,150);
        //设置弹窗置顶
        jDialog1.setAlwaysOnTop(true);
        //设置弹窗居中
        jDialog1.setLocationRelativeTo(null);
        //设置弹窗取消，不取消就不能操作
        jDialog1.setModal(true);
        //创建JLabel,用来储存要提示文字
        JLabel hintWord = new JLabel(str, SwingConstants.CENTER);
        hintWord.setBounds(0,0,200,150);
        jDialog1.getContentPane().add(hintWord);
        //让弹窗显示出来
        jDialog1.setVisible(true);
        //this.getContentPane().add(jDialog1);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginButton){
            System.out.println("点击了登录按钮");
            //获取两个文本输入框中的内容
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            //获取用户输入的验证码
            String codeInput = codeText.getText();

            //创建一个User对象
            User user = new User(usernameInput,passwordInput);
            System.out.println("用户输入的用户名为" + usernameInput);
            System.out.println("用户输入的密码为" + passwordInput);

            if (codeInput.length() == 0){
                showJDialog("验证码不能为空");

            }else if (usernameInput.length() == 0 || passwordInput.length() == 0){
                //校验用户名和密码是否为空
                System.out.println("用户名或者密码为空");
                //使用showJDialog 展示弹窗
                showJDialog("用户名或者密码为空");

            }else if (!(codeInput.equalsIgnoreCase(rightCode.getText()))){
                System.out.println("验证码输入错误");
                showJDialog("验证码输入错误");

            }else if (contains(user)){
                System.out.println("用户名和密码正确可以开始玩游戏");
                //关闭当前页面
                this.setVisible(false);
                //打开游戏的界面
                new GameJFrame();

            }else {
                System.out.println("用户名或密码错误");
                showJDialog("用户名或密码错误");

            }
        }else if (e.getSource() == register){
            System.out.println("点击了注册界面");

        }else if (e.getSource() == rightCode){
            System.out.println("更换验证码");
            //获取一个新的验证码
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }

    }
    //鼠标按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == loginButton){
            loginButton.setIcon(new ImageIcon("..\\jigsawgame\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\jigsawgame\\image\\login\\注册按下.png"));
        }
    }
    //鼠标按下松开
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == loginButton){
            loginButton.setIcon(new ImageIcon("..\\jigsawgame\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\jigsawgame\\image\\login\\注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //判断用户在集合中是否存在
    public boolean contains(User userInput){
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if(userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())){
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }
}
