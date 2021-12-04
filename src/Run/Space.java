package Run;

import Thing.Ball;
import Thing.Force;
import edu.princeton.cs.algs4.StdDraw;

public class Space {
    public Ball[] balls;
    public Force[][] forces;
    public int height;
    public int width;
    public int rate = 10; // 10ms
    public Space(Ball[] balls, Force[][] forces , int height , int width){
        this.balls = balls;
        this.forces = forces;
        this.height = height;
        this.width = width;

    }

    public double getDistance(Ball ball1 , Ball ball2){
        double distance = Math.sqrt((ball2.getBallRX() - ball1.getBallRX()) * (ball2.getBallRX() - ball1.getBallRX()) + (ball2.getBallRY() - ball1.getBallRY()) * (ball2.getBallRY() - ball1.getBallRY()));
        return distance;
    }//返回两个球的距离
    public boolean checkCrash(Ball ball1 , Ball ball2) {
        double distance = getDistance(ball1, ball2);
        double r = 0.1; //r为允许误差，用于后期调试
        return (distance <= ball1.getBALL_R() + ball2.getBall_R() + r);
    }
    public void repaint(Ball[] balls){
        StdDraw.clear();
        int n =balls.length;
        for(int i=0;i< n ;i++) {
            Ball ball = balls[i];
            ball.draw();
        }
        //显示缓存  在界面上 将所有缓存上用bufferGraphics画完的图形只用一次用之前界面上的画笔g展现处理啊
        StdDraw.show();//0,65为图形左上角坐标     65为了不遮挡鼠标
        for(int i =0 ; i<balls.length; i++){
            balls[i].ballMove();
        }
        //每过10ms利用缓存将数组中全部的小球移动+画出+清屏
        try{
            Thread.sleep(rate);
        }catch(Exception ef) {};
    }

    public void run(Ball[] balls) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.enableDoubleBuffering();
        while(true) {
            repaint(balls);
        }
    }


    public static void main(String[] args) {
     Ball ball1 = new Ball(0.1,0.5,0,0.1,0.03,1,50,50,50);
     Ball ball2 = new Ball(0.8,0.5,0,0.1,0.01,0.1,50,50,50);
     Ball[] balls = {ball1 , ball2};
     Force[][] forces = null;
     Space space = new Space(balls ,forces , 800 , 800);
     space.run(balls);

    }
}
