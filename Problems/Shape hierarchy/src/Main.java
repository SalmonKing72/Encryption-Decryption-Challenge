abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double base;
    double height;
    double hypotenuse;

    public Triangle(double base, double height, double hypotenuse) {
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }

    @Override
    public double getPerimeter() {
        return base + height + hypotenuse;
    }

    @Override
    public double getArea() {
        double s = getSemiPerimeter();
        return Math.sqrt(s * (s - base) * (s - height) * (s - hypotenuse));
    }

    private double getSemiPerimeter() {
        return (base + height + hypotenuse) / 2;
    }
}

class Rectangle extends Shape {
    double base;
    double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return (2 * base) + (2 * height);
    }

    @Override
    public double getArea() {
        return base * height;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
