package com.it.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //JFrame 界面 窗体
    //子类 呢 也表示界面 窗体
    //规定: GameJFrame 这个界面表示就是游戏的主界面
    //以后游戏相关的所有逻辑都写在这个类中

    //构造方法，给界面进行一些初始化


    //创建一个二维数组
    //目的: 用来管理数据
    //加载图片的时候，会根据二维数组的数据俩进行加载
    int[][] date = new int[4][4];
    //记录白方块在数组的位置
    int x = 0;
    int y = 0;
    //定义一个变量，记录当前展示图片的路径
    String path = "..\\jigsawgame\\image\\animal\\animal3\\";
    //定义一个变量来统计步数
    int step = 0;
    //定义一个胜利时的二维数组 用于判断胜利
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0},
    };
    //创建JMenuItem
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登陆");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem beautyGirl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem exercise = new JMenuItem("运动");

    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据(打乱)
        initDate();

        //初始化图片(根据打乱之后的结果去加载图片)
        initimage();

        //让界面显示出来，建议写在最后面
        this.setVisible(true);


    }

    //初始化数据
    private void initDate() {
        //1.定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据的顺序
        //遍历数组，得到每个一个元素，拿着每个元素跟随机索引来进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历的每个数据，跟随机的索引上的数据来交换位置
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        /*
         *       11 12 13 4
         *       1  2  6 5
         *       8  7  9  10
         *       15 14 3  0
         *       4 5 6 7 9 8 1 3 0 11 10 12 14 15 13 2
         * */
        //3.给二位数组添加数据
        //遍历一维数组tempArr得到的每个元素。把每个元素依次添加到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            //不给二维数组中的0位置赋值，默认原来的值 ,但是如果重新游戏不赋值就会导致出现空白格消失
            //所以不管是不是0，都要给二维数组赋值
            date[i / 4][i % 4] = tempArr[i];

        }

    }

    //初始化图片
    //添加图片的时候，就要根据二维数组中的数据来添加图片
    private void initimage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();
        //加载计数器
        JLabel countStep = new JLabel("步数: " + step);
        countStep.setBounds(50, 30, 100, 20);
        this.getContentPane().add(countStep);
        //判断是否胜利胜利就结束
        if (victory()) {
            //加载胜利的图片
            ImageIcon winIcon = new ImageIcon("..\\jigsawgame\\image\\win.png");
            JLabel winJlabel = new JLabel(winIcon);
            winJlabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJlabel);
        }
        //路径分两中
        //绝对路径：一定是从盘符开始C:\ D:\
        //相对路径: 相对当前项目而言的  不一定根据实际的jdk来看
        //细节：
        //先加载的图片在上面，后加载的图片在后面
        //外循环 --- 把内循环执行了4次
        for (int j = 0; j < 4; j++) {
            //内循环 --- 表示一行内添加4张图片
            for (int i = 0; i < 4; i++) {
                int num = date[j][i];
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                //指定图片的位置
                jLabel.setBounds(105 * i + 83, 105 * j + 134, 105, 105);

                //给图片添加边框
                //0:表示让图片凸起来
                //1：表示让图片凹下去
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //把管理容器添加到界面当中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("..\\jigsawgame\\image\\background.png");
        //创建一个JLabel的管理容器
        JLabel background = new JLabel(bg);
        //设置背景图片的位置大小
        background.setBounds(40, 40, 508, 560);
        //添加到界面中去
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单的JMenuBar
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //创建更换图片的JMenu
        JMenu changeImage = new JMenu("更换图片");

        //给《功能》添加选项
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        //给《关于我们》添加选项
        aboutJMenu.add(accountItem);
        //美女，动物，运动添加到《更换图片》上
        changeImage.add(beautyGirl);
        changeImage.add(animal);
        changeImage.add(exercise);
        //给条目添加点击事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        beautyGirl.addActionListener(this);
        animal.addActionListener(this);
        exercise.addActionListener(this);

        //将两个选项添加到菜单上
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
        //在创建游戏界面的对象时，同时给界面设置一些信息
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中放置，只有取消才能按照xy 轴的形式添加组件
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时会调用这个代码
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //清空界面中所有图片
            this.getContentPane().removeAll();
            //添加完整的图片
            ImageIcon image1 = new ImageIcon(path + "all.jpg");
            JLabel all = new JLabel(image1);
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            //添加背景图片
            ImageIcon image2 = new ImageIcon("..\\jigsawgame\\image\\background.png");
            JLabel background = new JLabel(image2);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }

    }

    //松开按键的时候调用该方法
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，此方法需要结束，不能再执行下面的代码
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            //x,y 白方块,xy不代表坐标系里面的xy，而是二维数组里面的数的位置
            //画个二维数组就清晰了
            System.out.println("向左移动");
            if (y == 3) {
                return;
            }
            //就是把空白方块右边数字向往左移动
            date[x][y] = date[x][y + 1];
            date[x][y + 1] = 0;
            y++;
            //每移动一次，计数器自增一次。
            step++;
            initimage();
        } else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3) {
                return;
            }
            //就是把空白方块下边数字向往上移动
            date[x][y] = date[x + 1][y];
            date[x + 1][y] = 0;
            x++;
            //每移动一次，计数器自增一次。
            step++;
            initimage();
        } else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0) {
                return;
            }
            //就是把空白方块左边数字向往右移动
            date[x][y] = date[x][y - 1];
            date[x][y - 1] = 0;
            y--;
            //每移动一次，计数器自增一次。
            step++;
            initimage();
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            //就是把空白方块上边数字向往下移动
            date[x][y] = date[x - 1][y];
            date[x - 1][y] = 0;
            x--;
            //每移动一次，计数器自增一次。
            step++;
            initimage();
        } else if (code == 65) {
            initimage();
        } else if (code == 87) {
            //就是数据调整，或者直接创建一个全新的二维数组
            date = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0},
            };
            initimage();
        }

    }

    //判断二维数组中是否与胜利时的二维数组一样
    public boolean victory() {
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date.length; j++) {
                if (date[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");
            //计数器清零
            step = 0;
            //再次打乱二维数组中的数据
            initDate();
            //重新加载图片
            initimage();

        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前的游戏页面
            this.setVisible(false);
            //打开登录页面
            new LoginJFrame();

        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);

        } else if (obj == accountItem) {
            System.out.println("公众号");
            //设一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("..\\jigsawgame\\image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加弹框中去
            jDialog.getContentPane().add(jLabel);
            //设置弹框的大小
            jDialog.setSize(344, 344);
            //弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            //设置弹框显示
            jDialog.setVisible(true);


        } else if (obj == beautyGirl) {
            System.out.println("切换美女图片");
            //第一步应更换图片路径
            Random r = new Random();
            int num = r.nextInt(13) + 1;
            path = "..\\jigsawgame\\image\\girl\\girl"+num+"\\";
            //计数器清零
            step = 0;
            //打乱数据
            initDate();
            //初始化图片
            initimage();

        } else if (obj == animal) {
            System.out.println("切换动物图片");
            //第一步应更换图片路径
            Random r = new Random();
            int num = r.nextInt(8) + 1;
            path = "..\\jigsawgame\\image\\animal\\animal"+num+"\\";
            //计数器清零
            step = 0;
            //打乱数据
            initDate();
            //初始化图片
            initimage();

        } else if (obj == exercise) {
            System.out.println("切换运动图片");
            //第一步应更换图片路径
            Random r = new Random();
            int num = r.nextInt(10) + 1;
            path = "..\\jigsawgame\\image\\sport\\sport"+num+"\\";
            //计数器清零
            step = 0;
            //打乱数据
            initDate();
            //初始化图片
            initimage();
        }
    }
}
