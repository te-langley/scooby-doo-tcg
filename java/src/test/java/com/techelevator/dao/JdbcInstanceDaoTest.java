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
        setClaimed(true);
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
        Assert.assertTrue("One row should be added to the database.", dao.create(INSTANCE_TO_CREATE) == 1);

        // Retrieve the Instance from the database.
        Instance dbInstance = dao.read(INSTANCE_TO_CREATE.getSerial());
        Assert.assertNotNull("The returned instance should not be null.", dbInstance);
        Assert.assertTrue("Instance not correct.", dbInstance.equals(INSTANCE_TO_CREATE));
    }

    @Test
    public void read() {
        Instance dbInstance = dao.read("DDSMUL");
        Assert.assertNotNull("The returned instance should not be null.", dbInstance);
        Assert.assertTrue(dbInstance.getSerial().equals("DDSMUL"));
        Assert.assertTrue(dbInstance.getProductCode() == 1);
        Assert.assertTrue(dbInstance.getProductionRun() == 1);
        Assert.assertTrue(dbInstance.getSequence() == 1);
        Assert.assertTrue(dbInstance.isClaimed() == false);
    }

    @Test
    public void contains() {
    }

    @Test
    public void instancesAlreadyCreatedForRun() {
        Assert.assertTrue("Expected instances for run 1.", dao.alreadyGeneratedForRun(1));
        Assert.assertFalse("Did not expect instances for run 999.", dao.alreadyGeneratedForRun(999));
    }

    @Test
    public void unlock() {

    }

    //    @Test
    public void delete() {
    }
}