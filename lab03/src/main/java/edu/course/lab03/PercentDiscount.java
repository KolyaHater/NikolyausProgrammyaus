package edu.course.lab03;

public class PercentDiscount implements DiscountPolicy {

    private final double percentage;

    public PercentDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be a value between 0 and 100");
        }
        this.percentage = percentage;
    }

    @Override
    public double apply(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        return price * (1 - percentage / 100);
    }

}
