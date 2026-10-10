import java.time.LocalDate;
import java.util.Scanner;

public class Problem5_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    plans[i] = new PremiumPlan(name, startDate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown plan type: " + type);
            }

            System.out.println(plans[i].getName() + ": " + plans[i].getRenewalDate());
        }

        sc.close();
    }
}

abstract class SubscriptionPlan {
    private final String name;
    protected final LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}
