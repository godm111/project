package Run;
import Thing.*;

import java.awt.*;
import java.util.Random;

public class GameView extends Frame{

    private static final long serialVersionUID = 1L;
    private Random random = new Random();

    public static final int VIEW_WIDTH = 600;
    public static final int VIEW_HEIGHT = 1000;
    //位图
    private Image ImageBuffer = null;
    private Graphics GraImage = null;

    private Boald boaldTop;
    private Boald boaldDown;
    private Ball ball;

    private GameRun gameRun;

    public GameView() {


        ball = new Ball(0, 0, Color.WHITE, boaldTop, boaldDown);

        boaldTop.setBoaldX(random.nextInt((int)(VIEW_WIDTH - boaldTop.getBOALD_WIDTH())));
        boaldTop.setBoaldY(boaldTop.getBOALD_HEIGHT() * 3);

        boaldDown.setBoaldX(boaldTop.getBoaldX());
        boaldDown.setBoaldY((int)(VIEW_HEIGHT-boaldDown.getBOALD_HEIGHT()*3));

        ball.setBallRX((int)(boaldTop.getBoaldX()+boaldTop.getBOALD_WIDTH()/2));
        ball.setBallRY(boaldTop.getBoaldY() + boaldTop.getBOALD_HEIGHT() + ball.getBALL_R() + 5);

        gameRun = new GameRun(this, boaldTop, boaldDown, ball);
        gameRun.start();
    }

    public static void main(String[] args) {

        new GameView().init();
    }

    public void init() {

        this.setTitle("弹球游戏");
        this.setSize(VIEW_WIDTH, VIEW_HEIGHT);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new GameControl());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {

                System.exit(0);
            }
        });
        this.setVisible(true);
    }
    //画图
    public void paint(Graphics g) {
        g.setColor(ball.getBALL_COLOR());
        g.fillOval(ball.getBallRX() - ball.getBALL_R(), ball.getBallRY() - ball.getBALL_R(), ball.getBALL_R() * 2, ball.getBALL_R() * 2);
        g.setColor(boaldTop.getColor());
        g.fillRect(boaldTop.getBoaldX(), boaldTop.getBoaldY(), boaldTop.getBOALD_WIDTH(), boaldTop.getBOALD_HEIGHT());
        g.setColor(boaldDown.getColor());
        g.fillRect(boaldDown.getBoaldX(), boaldDown.getBoaldY(), boaldDown.getBOALD_WIDTH(), boaldDown.getBOALD_HEIGHT());

        if(Ball.ballstate == false) {
            g.setFont(new Font("隶书",Font.BOLD,40));
            g.drawString("游戏结束", 210, 500);
        }

    }
    public void update(Graphics g) {

        //创建图形缓冲区
        ImageBuffer = createImage(this.getWidth(), this.getHeight());
        //获取图形缓冲区的图形上下文
        GraImage = ImageBuffer.getGraphics();
        //用paint方法中编写的绘图过程对图形缓冲区绘图
        paint(GraImage);
        //释放图形上下文资源
        GraImage.dispose();
        //将图形缓冲区绘制到屏幕上
        g.drawImage(ImageBuffer, 0, 0, this);

    }

}
————————————————
        版权声明：本文为CSDN博主「JiaWei3209」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/qq_40962416/article/details/80741523