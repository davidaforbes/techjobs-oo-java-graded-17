package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.swing.text.Position;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    @Test
    public void testSettingJobId() {
    Job jobOne = new Job();
    Job jobTwo = new Job();
    assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(jobThree.getName(), "Product tester");
        assertEquals(jobThree.getEmployer().getValue(), "ACME");
        assertEquals(jobThree.getLocation().getValue(), "Desert");
        assertEquals(jobThree.getPositionType().getValue(), "Quality control");
        assertEquals(jobThree.getCoreCompetency().getValue(), "Persistence");
        assertTrue(jobThree.getName() != null);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job jobFour = new Job("Plumber", new Employer("Royal Family"), new Location("Mushroom Kingdom"), new PositionType("Security & Extraction"), new CoreCompetency("Vertical Leap"));
        Job jobFive = new Job("Plumber", new Employer("Royal Family"), new Location("Mushroom Kingdom"), new PositionType("Security & Extraction"), new CoreCompetency("Vertical Leap"));
        assertNotEquals(jobFour, jobFive);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobSix = new Job("Theoretical Physicist", new Employer("Black Mesa"), new Location("REDACTED"), new PositionType("High Energy Experimentation"), new CoreCompetency("Firearm Training"));
        assertTrue(jobSix.toString().startsWith(lineSeparator()));
        assertTrue(jobSix.toString().endsWith(lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobSeven = new Job("Plumber", new Employer("Royal Family"), new Location("Mushroom Kingdom"), new PositionType("Security & Extraction"), new CoreCompetency("Vertical Leap"));
        assertEquals( jobSeven.toString(), System.lineSeparator()+
                        "ID: "+jobSeven.getId()+System.lineSeparator()+
                        "Name: Plumber"+System.lineSeparator()+
                        "Employer: Royal Family"+System.lineSeparator()+
                        "Location: Mushroom Kingdom"+System.lineSeparator()+
                        "Position Type: Security & Extraction"+System.lineSeparator()+
                        "Core Competency: Vertical Leap"+System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobEight = new Job("Plumber", new Employer(""), new Location("Mushroom Kingdom"), new PositionType(""), new CoreCompetency("Vertical Leap"));
        assertEquals( jobEight.toString(), System.lineSeparator()+
                "ID: 3"+System.lineSeparator()+
                "Name: Plumber"+System.lineSeparator()+
                "Employer: Data not available"+System.lineSeparator()+
                "Location: Mushroom Kingdom"+System.lineSeparator()+
                "Position Type: Data not available"+System.lineSeparator()+
                "Core Competency: Vertical Leap"+System.lineSeparator());
    }
}
