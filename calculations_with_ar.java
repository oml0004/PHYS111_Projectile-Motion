import java.util.ArrayList;

public class calculations_with_ar {
	// Variables from lines 6-26 are used as temporary variables
	// Kinematics
	private double v0 = 0;
	private double v0x = 0;
	private double v0y = 0;
	private double v = 0;
	private double vy = 0;
	private double t = 0;
	private double dt = 0.01;
	private double theta = 0;
	private double x0 = 0;
	private double y0 = 0; // y0 > 0 so that kinematics can be calculated; set y0 = 0.1 in constructor
	private double x = 0;
	private double y = 0;
        
        //I am adding a variable vyI as you need to multiply by the current velocity to obtain air resistance
	private double vyI = vy;
        
	// Kinematics with air resistance
	
	// Dynamics
	private double m = 0; // Mass
	private double p = 0; // Momentum
	private double kEnergy = 0; // Kinetic energy
	private double uEnergy = 0; // Gravitational potential energy
	private double mEnergy = 0; // Total mechanical energy
	
	// Variables from lines 29-48 are the final variables that will be calculated and returned to Graph.java and ProjectileMotion.java
	// Maxiumum height and range, returned to user
	private double maxHeightNAR = 0;
	private double maxHeightAR = 0;
	private double rangeNAR = 0;
	private double rangeAR = 0;
	
	// ArrayLists of type double used to store coordinates and dynamics information for the particle launched w/o air resistance
	private ArrayList<Double> xCoordsNAR = new ArrayList<Double>();
	private ArrayList<Double> yCoordsNAR = new ArrayList<Double>();
	private ArrayList<Double> momentaNAR = new ArrayList<Double>();
	private ArrayList<Double> kEnergyNAR = new ArrayList<Double>();
	private ArrayList<Double> uEnergyNAR = new ArrayList<Double>();
	private ArrayList<Double> mEnergyNAR = new ArrayList<Double>();
	// ArrayLists of type double used to store coordinates and dynamics information for the particle launched w/ air resistance
	private ArrayList<Double> xCoordsAR = new ArrayList<Double>();
	private ArrayList<Double> yCoordsAR = new ArrayList<Double>();
	private ArrayList<Double> momentaAR = new ArrayList<Double>();
	private ArrayList<Double> kEnergyAR = new ArrayList<Double>();
	private ArrayList<Double> uEnergyAR = new ArrayList<Double>();
	private ArrayList<Double> mEnergyAR = new ArrayList<Double>();
	
	public calculations_with_ar (double v0, double theta, double m) {
		this.v0 = v0;
		this.theta = theta;
		this.m = m;
		y0 = 0.1;
		t = 0;
		
		calcV0Comps();
		
		while (y > 0) {
			kinematicsNAR();
		}
		
		this.v0 = v0;
		this.theta = theta;
		this.m = m;
		y0 = 0.1;
		t = 0;
		
		calcV0Comps();
		
		while (y > 0) {
			kinematicsAR();
		}
	}
	
	// Kinematics
	private void calcV0Comps() {
		v0x = v0 * Math.cos(theta);
		v0y = v0 * Math.sin(theta);
	}
	
	private void kinematicsNAR() {
		x = x0 + (v0x * t);
		y = y0 + (v0y * t) - (9.81 * Math.pow(dt, 2)/2);
		
		xCoordsNAR.add(x);
		yCoordsNAR.add(y);
		
		vy = v0y - (9.81 * t);
		if (vy == 0) {
			maxHeightNAR = y;
		}
		
		dynamicsNAR();
		
		t += dt;
		
		rangeNAR = x;
	}
	
	// Kinematicss with air resistance
	private void kinematicsAR() {
		while (y > 0) {
                    x = x0 + (v0x * t) ;
                    y = y0 + (v0y * t) - (9.81 * Math.pow(dt, 2)/2);
                    
                    xCoordsAR.add(x) ;
                    yCoordsAR.add(y) ;
                    
                    vy = v0y - (9.81 * t) - (0.0007901 * vyI * vyI) ;
                    if (vy == 0) {
                        maxHeightAR = y;
                    }
                    
                    dynamicsAR () ;
                    
                    t += dt ;
                    
                    rangeAR = x ;
		}
		
	}
	
	// Dynamics
	private void dynamicsNAR() {
		p = m * v;
		
		kEnergy = (m * Math.pow(v, 2))/2;
		uEnergy = (m * 9.81 * y);
		mEnergy = kEnergy + uEnergy;
		
		momentaNAR.add(p);
		kEnergyNAR.add(kEnergy);
		uEnergyNAR.add(uEnergy);
		mEnergyNAR.add(mEnergy);
	}
	
	private void dynamicsAR() {
		p = m * v;
		
		kEnergy = (m * Math.pow(v, 2))/2;
		uEnergy = (m * 9.81 * y);
		mEnergy = kEnergy + uEnergy;
		
		momentaAR.add(p);
		kEnergyAR.add(kEnergy);
		uEnergyAR.add(uEnergy);
		mEnergyAR.add(mEnergy);	
	}
	
	// Getter methods which return the ArrayLists calculated above
	public ArrayList<Double> getXCoordsNAR() {
		return xCoordsNAR;
	}
	
	public ArrayList<Double> getYCoordsNAR() {
		return yCoordsNAR;
	}
	
	public ArrayList<Double> getMomentaNAR() {
		return momentaNAR;
	}
	
	public ArrayList<Double> getKEnergyNAR() {
		return kEnergyNAR;
	}
	
	public ArrayList<Double> getUEnergyNAR() {
		return uEnergyNAR;
	}
	
	public ArrayList<Double> getMEnergyNAR() {
		return mEnergyNAR;
	}
	
	public ArrayList<Double> getXCoordsAR() {
		return xCoordsAR;
	}
	
	public ArrayList<Double> getYCoordsAR() {
		return yCoordsAR;
	}
	
	public ArrayList<Double> getMomentaAR() {
		return momentaAR;
	}
	
	public ArrayList<Double> getKEnergyAR() {
		return kEnergyAR;
	}
	
	public ArrayList<Double> getUEnergyAR() {
		return uEnergyAR;
	}
	
	public ArrayList<Double> getMEnergyAR() {
		return mEnergyAR;
	}
}