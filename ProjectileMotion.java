package phsyicsgraph;
import java.util.Scanner;
public class ProjectileMotion {
    public static void main(String[] args) {
        Scanner variable = new Scanner(System.in);
//Variables//
        double m = 10 ;
        double theta = 45 ;
        double vi = 10 ;
        double xi = 0;
        double yi = 0;
        double y = 0 ;
        double x = 0 ;
        double t = 0 ;
        double dt = 0.01 ;
        double vx = 0 ;
        double vy = 0; 
        double vyi = 0;
//asks for inputs//
        System.out.println("Hello. Please input variables: mass (in grams),"
                + "angle (in degrees) and initial velocity (in meters per "
                + "second)");
        System.out.println("Mass:");
            m = variable.nextDouble();
        System.out.println("Angle:");
            t = variable.nextDouble ();
        System.out.println("Initial velocity:");
            vi = variable.nextDouble();
//Inital equations//
        vx = Math.cos(theta)*vi ;
        vy = Math.sin(theta)*vi ;
//Processing//
        do {
            t = t + dt ;
            x = xi + vx*t ;
            y = yi + (vy*t) - (0.5*9.8*(t*t)) ;
            vy = vyi - 9.8*t ;
        } while (y>0);
        System.out.println("x distance = " +x);
    }
    
}
