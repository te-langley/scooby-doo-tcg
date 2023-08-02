package com.techelevator.dao;

import com.techelevator.model.Instance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcInstanceDaoTest extends BaseDaoTests {
    private static final Instance INSTANCE_TO_CREATE = new Instance() {{
        setSerial("INST01");
        setProductCode(1);
        setProductionRun(1);
        setSequence(999);
        setLocked(true);
    }};
    private JdbcInstanceDao dao;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcInstanceDao(jdbcTemplate);
    }

    @Test
    public void create() {
        // Add the Instance to the database.
        Assert.assertTrue("One row should be added to the database.", dao.createInstance(INSTANCE_TO_CREATE) == 1);

        // Retrieve the Instance from the database.
        Instance dbInstance = dao.getInstanceBySerial(INSTANCE_TO_CREATE.getSerial());
        Assert.assertNotNull("The returned instance should not be null.", dbInstance);
        Assert.assertTrue("Instance not correct.", dbInstance.equals(INSTANCE_TO_CREATE));
    }

    @Test
    public void read() {
        Instance dbInstance = dao.getInstanceBySerial("DDSMUL");
        Assert.assertNotNull("The returned instance should not be null.", dbInstance);
        Assert.assertTrue(dbInstance.getSerial().equals("DDSMUL"));
        Assert.assertTrue(dbInstance.getProductCode() == 1);
        Assert.assertTrue(dbInstance.getProductionRun() == 1);
        Assert.assertTrue(dbInstance.getSequence() == 1);
        Assert.assertTrue(dbInstance.isLocked() == false);
    }

    @Test
    public void contains() {
    }

    @Test
    public void instancesAlreadyCreatedForRun() {
        Assert.assertEquals("Expected 100 instances for run 1.", 100, dao.instancesGeneratedForRun(1));
        Assert.assertEquals("Expected no instances for run 999.", 0, dao.instancesGeneratedForRun(999));
    }

    @Test
    public void unlocked_instance_has_expected_values_when_retrieved() {
        String serial = "22YPPM";

        Instance unlockedInstance = dao.unlock(serial);
        Assert.assertNotNull(unlockedInstance);
        Assert.assertTrue(unlockedInstance.isLocked());

        Instance retrievedInstance = dao.getInstanceBySerial(serial);
        assertInstancesMatch(retrievedInstance, unlockedInstance);
    }

    @Test
    public void deleted_instance_can_no_longer_be_retrieved() {
        String serial = "22YPPM";

        int numDeleted = dao.deleteInstance(serial);
        Instance retrievedInstance = dao.getInstanceBySerial(serial);

        Assert.assertEquals("Only one instance should be deleted.", 1, numDeleted);
        Assert.assertNull("No instance should be retrieved after deletion.", retrievedInstance);
    }

    @Test
    public void instances_deleted_by_run_cannot_be_retrieved() {
        int runToDelete = 1;
        String serial = "DDSMUL";

        Instance retrievedInstance = dao.getInstanceBySerial(serial);
        Assert.assertNotNull("Instance " + serial + " exists prior to deleting instances for run " + runToDelete,
                retrievedInstance);


        int numDeleted = dao.deleteInstancesForRun(runToDelete);
        retrievedInstance = dao.getInstanceBySerial(serial);

        Assert.assertEquals("Number of rows deleted should match the run's volume.", 100, numDeleted);
        Assert.assertNull("Instance " +
                serial +
                " should not be retrieved after deleting instances for run " +
                runToDelete, retrievedInstance);
    }

    private void assertInstancesMatch(Instance expected, Instance actual) {
        Assert.assertEquals(expected.getSerial(), actual.getSerial());
        Assert.assertEquals(expected.getProductCode(), actual.getProductCode());
        Assert.assertEquals(expected.getProductionRun(), actual.getProductionRun());
        Assert.assertEquals(expected.getSequence(), actual.getSequence());
        Assert.assertEquals(expected.isLocked(), actual.isLocked());
    }

}