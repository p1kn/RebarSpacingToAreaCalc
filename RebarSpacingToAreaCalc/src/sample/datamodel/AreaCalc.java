package sample.datamodel;

public class AreaCalc {

    private double rebarDiameter;
    private double rebarSpacing;



    public AreaCalc(double rebarDiameter, double rebarSpacing) {
        this.rebarDiameter = rebarDiameter;
        this.rebarSpacing = rebarSpacing;
    }

/*    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }*/

    public double getArea () {
        double radius = rebarDiameter/20;
        double pi = Math.PI;
        double area = pi * Math.pow(radius, 2) * (100/rebarSpacing);
/*        return round(area,2);*/
        return Math.round((area) * 10.0)/10.0;


    }

}
