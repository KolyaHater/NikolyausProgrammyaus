package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab03Test {

    @Test
    void noDiscountReturnsSamePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0), 0.001);
    }

    @Test
    void percentDiscountWorks() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertEquals(80.0, policy.apply(100.0), 0.001);
    }

    @Test
    void priceCalculatorUsesPolicy() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(10));
        assertEquals(90.0, calculator.calculate(100.0), 0.001);
    }

    @Test
    void effortPriorityPolicyWorks() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        ProjectTask task = new ProjectTask("1", "Test", TaskStatus.NEW, 8);
        assertEquals(8, policy.calculatePriority(task));
    }

    @Test
    void statusPriorityPolicyWorks() {
        PriorityPolicy policy = new StatusPriorityPolicy();
        ProjectTask task = new ProjectTask("1", "Test", TaskStatus.NEW, 5);
        assertEquals(3, policy.calculatePriority(task));
    }

    @Test
    void taskPrioritizerChoosesCorrectly() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());

        ProjectTask low = new ProjectTask("1", "Low", TaskStatus.NEW, 2);
        ProjectTask high = new ProjectTask("2", "High", TaskStatus.NEW, 10);

        assertEquals(high, prioritizer.chooseHigherPriority(low, high));
    }

    @Test
    void canReplacePolicy() {
        ProjectTask task1 = new ProjectTask("1", "A", TaskStatus.DONE, 10);
        ProjectTask task2 = new ProjectTask("2", "B", TaskStatus.NEW, 3);

        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());

        assertEquals(task1, byEffort.chooseHigherPriority(task1, task2));
        assertEquals(task2, byStatus.chooseHigherPriority(task1, task2));
    }
}