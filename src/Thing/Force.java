package Thing;

public class Force {
    public static final double G = 6.67E-11;
    private Ball ball1;
    private Ball ball2;
    private double force_x;
    private double force_y;
    private double dx;
    private double dy;

    public double getForce_x() {
        return force_x;
    }

    public double getForce_y() {
        return force_y;
    }

    public double R;

    public Force(Ball ball1, Ball ball2){
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.dx = ball1.getBallRX() - ball2.getBallRX();
        this.dy = ball1.getBallRY() - ball2.getBallRY();
        this.R = Math.sqrt(this.dx*this.dx + this.dy*this.dy);
        if (this.R < ball1.getBALL_R() + ball2.getBall_R())
            return;

        this.force_x = ForceX();
        this.force_y = ForceY();
    }

    private double ForceX(){
        return G*this.ball1.getMass()*this.ball2.getMass()*this.dx/(this.R*this.R*this.R);
    }

    private double ForceY(){
        return G*this.ball1.getMass()*this.ball2.getMass()*this.dy/(this.R*this.R*this.R);
    }


    public static void main(String[] args) {
    }

}
