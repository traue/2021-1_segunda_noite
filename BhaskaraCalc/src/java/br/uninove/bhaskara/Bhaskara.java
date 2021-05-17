package br.uninove.bhaskara;

public class Bhaskara {

    private double a;
    private double b;
    private double c;
    private double delta;
    private double rP;
    private double rN;
    
    public Bhaskara() {
    }

    public Bhaskara(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }


    public double getrP() {
        return rP;
    }

    public double getrN() {
        return rN;
    }

    public double calculaDelta() {
        delta = (b * b) - 4 * a * c;
        if(delta >= 0){
            calculaRaizes();
        }
        return delta;
    }
    
    private void calculaRaizes() {
        rP = ((-b) + Math.sqrt(delta)) / (2 * a);
        rN = ((-b) - Math.sqrt(delta)) / (2 * a);
    }
    
}
