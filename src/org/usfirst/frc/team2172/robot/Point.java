package org.usfirst.frc.team2172.robot;

public class Point {
    public final double X;
    public final double Y;
    public final double THETA;

    public Point(double x, double y, double theta) {
        this.X = x;
        this.Y = y;
        
        //This is gonna need some modification to keep theta in range
        if(theta > Math.PI){
          this.THETA = theta - (2 * Math.PI);
        } else if (theta < -Math.PI){
          this.THETA = theta + (2 * Math.PI);
        } else {
          this.THETA = theta;
        }

    }
    
    public double getOppTheta() {
      if(this.THETA > 0){
        return this.THETA - Math.PI;
      } else {
        return this.THETA + Math.PI;
      }
    }

    public double distanceTo(Point point){
        return Math.sqrt(Math.pow(point.X - this.X, 2) + Math.pow(point.Y - this.Y, 2));
    }

    public double angleTo(Point point){  
      return (Math.atan2((point.Y - this.Y), (point.X - this.X)));
    }
    
    public boolean equals(Point point){
    	return(this.X == point.X && this.Y == point.Y && this.THETA == point.THETA);
    }
    
    public boolean equals(Point point, double cartisianTolerance, double angularTolerance){
    	return(Math.abs(this.X - point.X) <= cartisianTolerance && Math.abs(this.X - point.X) <= cartisianTolerance && Math.abs(this.X - point.X) <= angularTolerance);
    }
}
