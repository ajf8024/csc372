abstract class Shape {
    public abstract double surface_area();
    public abstract double volume();
}

class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surface_area() {
        return 4.0 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "Sphere: Surface Area = " + surface_area() + ", Volume = " + volume();
    }
}

class Cylinder extends Shape {
    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        return 2.0 * Math.PI * radius * (radius + height);
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "Cylinder: Surface Area = " + surface_area() + ", Volume = " + volume();
    }
}

class Cone extends Shape {
    private double radius, height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height / 3.0;
    }

    @Override
    public String toString() {
        return "Cone: Surface Area = " + surface_area() + ", Volume = " + volume();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];

        shapeArray[0] = new Sphere(4.5);
        shapeArray[1] = new Cylinder(3.5, 6.5);
        shapeArray[2] = new Cone(5.0, 7.5);

        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }
    }
}