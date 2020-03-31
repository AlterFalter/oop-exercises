/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw04.exercise3;

/**
 *
 * @author yannk
 */
public class Line {
    private Point startPoint;
    private Point endPoint;
    
    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    public Point getStartPoint() {
        // watch out: this makes it possible to change the point from this class
        // it is possible to add a clone() method which executes the constructor
        // again, and gives the fields as parameter (notice "clone" not "deepClone"
        return this.startPoint;
    }
    
    public Point getEndPoint() {
        return this.endPoint;
    }
    
    public void setStartPoint(int newX, int newY) {
        this.startPoint.setX(newX);
        this.startPoint.setY(newY);
    }
    
    public void setStartPoint(Point newStartPoint) {
        // call by value
        this.setStartPoint(newStartPoint.getX(), newStartPoint.getY());
        // call by reference
        //this.startPoint = newStartPoint;
    }
    
    public void setEndPoint(int newX, int newY) {
        this.setEndPoint(new Point(newX, newY));
    }
    
    public void setEndPoint(Point newEndPoint) {
        // call by reference
        this.startPoint = newEndPoint;
    }
}
