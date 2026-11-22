package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    @Test
    void shouldAddAndFindTaskByNewEqualIssueIdInstance() {
        IssueRegistry registry = new IssueRegistry();
        IssueId putId = new IssueId("CORE", 42);
        ProjectTask task = new ProjectTask(putId, "Fix HashMap key", "OPEN");

        registry.register(task);

        IssueId lookupId = new IssueId("CORE", 42);
        ProjectTask found = registry.findById(lookupId).orElseThrow();

        assertEquals("Fix HashMap key", found.getTitle());
        assertTrue(registry.contains(lookupId));
    }

    @Test
    void equalsShouldSatisfyReflexiveSymmetricAndTransitiveContracts() {
        IssueId a = new IssueId("API", 10);
        IssueId b = new IssueId("API", 10);
        IssueId c = new IssueId("API", 10);
        IssueId diff = new IssueId("API", 11);

        // Рефлексивность
        assertTrue(a.equals(a));
        // Симметричность
        assertTrue(a.equals(b) && b.equals(a));
        assertFalse(a.equals(diff) || diff.equals(a));
        // Транзитивность
        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    void equalObjectsMustHaveEqualHashCodes() {
        IssueId a = new IssueId("WEB", 7);
        IssueId b = new IssueId("WEB", 7);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void equalsShouldReturnFalseForNullAndDifferentType() {
        IssueId id = new IssueId("WEB", 7);

        assertFalse(id.equals(null));
        assertFalse(id.equals("WEB-7"));
    }
}