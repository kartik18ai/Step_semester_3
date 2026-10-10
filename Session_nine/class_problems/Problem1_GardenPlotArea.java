import java.util.Scanner;

public class Problem1_GardenPlotArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Plot[] plots = new Plot[n];
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0];
            String owner = parts[1];

            switch (shape) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, Double.parseDouble(parts[2]));
                    break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(owner, Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]));
                    break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(owner, Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape: " + shape);
            }

            double area = plots[i].calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plots[i].getOwner(), shape, area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}

abstract class Plot {
    private final String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private final double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
