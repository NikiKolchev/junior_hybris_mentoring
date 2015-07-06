/**
 *
 */
package com.epam.training.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.epam.training.dao.OrganizationDao;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

import com.epam.training.model.OrganizationModel;
import org.mockito.Mockito;


/**
 * @author Olha_Horbatiuk
 */
public class OrganizationModelServiceTest {

    private static final String NO_CUSTOMERS_FOUND = "This organization has no customers.";
    private static final String THREE_CUSTOMERS_FOUND = "This organization has %d customers.";

    private OrganizationModel organization;
    private OrganizationModelService organizationModelService;
    private OrganizationDao organizationDaoMock = Mockito.mock(OrganizationDao.class);

    @Before
    public void setUp() {
        organizationModelService = new OrganizationModelService();
        organization = new OrganizationModel();
    }

    @Test
    public void requireReturnCorrectlyFormattedStringForNonEmptyCustomersCollection() {
        CustomerModel customer = new CustomerModel();
        List<CustomerModel> threeCustomers = Arrays.asList(customer, customer, customer);
        organization.setCustomers(threeCustomers);

        assertEquals("Resulting string is formatted incorrectly", String.format(THREE_CUSTOMERS_FOUND, Integer.valueOf(threeCustomers.size())), organizationModelService.getValueOfCustomersAmount(organization));
    }

    @Test
    public void requireReturnNoCustomersFoundMessageWhenCustomersCollectionIsEmpty() {
        organization.setCustomers(Collections.EMPTY_LIST);

        assertEquals("No customers message is formatted incorrectly", NO_CUSTOMERS_FOUND, organizationModelService.getValueOfCustomersAmount(organization));
    }

    @Test
    public void requireReturnNoCustomersFoundMessageWhenCustomersCollectionIsNull() {
        organization.setCustomers(null);

        assertEquals("No customers message is formatted incorrectly", NO_CUSTOMERS_FOUND, organizationModelService.getValueOfCustomersAmount(organization));
    }

    @Ignore
    @Test
    public void testGetOrganizationsEmail() throws Exception {
        String email = "tratata@example.com";
        organization.setEmail(email);
        List<OrganizationModel> expected = Arrays.asList(organization, organization, organization);
        Mockito.when(organizationDaoMock.findAll()).thenReturn(expected);

        List<String> emails = Arrays.asList(email, email, email);

//        List<String> actual = organizationModelService.getOrganizationsEmail();

//        assertEquals(emails, actual);

    }

    @Test
    public void testGetAll() throws Exception {
        List<OrganizationModel> expected = Arrays.asList(organization, organization, organization);
        Mockito.when(organizationDaoMock.findAll()).thenReturn(expected);

//        List<OrganizationModel> actual = organizationModelService.getAll();

//        assertEquals(expected, actual);
    }
}