package com.webshop.api;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test configuration class extends by all test classes
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebshopApiApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class TestConfig {

}
