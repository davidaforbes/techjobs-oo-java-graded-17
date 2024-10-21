package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;


public class JobTest {
    @Test
    public void testSettingJobId() {
    Job JobOne = new Job();
    Job JobTwo = new Job();
    assertNotEquals(JobOne.getId(), JobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job JobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(JobThree.getName(), "Product tester");
        assertEquals(JobThree.getEmployer().getValue(), "ACME");
        assertEquals(JobThree.getLocation().getValue(), "Desert");
        assertEquals(JobThree.getPositionType().getValue(), "Quality control");
        assertEquals(JobThree.getCoreCompetency().getValue(), "Persistence");
        assertTrue(JobThree.getName() != null);
        assertTrue(JobThree.getEmployer() instanceof Employer);
        assertTrue(JobThree.getLocation() instanceof Location);
        assertTrue(JobThree.getPositionType() instanceof PositionType);
        assertTrue(JobThree.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job JobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job JobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(JobFour, JobFive);
    }
}
