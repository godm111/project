package Run;
import Thing.Ball;
import Thing.Force;

public class Space {
    public int N;//球的数量
    public Ball[] balls;
    public Force[] forces;
    public Space(int N){
        this.N = N;
        this.balls = new Ball[N];
        this.forces = new Force[N-1];
        //创建N个Ball实例，属性为具体传参。
        for(int i = 0; i<N ; i++){
           // balls[i] = new Ball();
        }

        for (int i =0; i<N-1; i++){
            forces[i] = new Force(balls[i] , balls[i+1]);
        }
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
    }



