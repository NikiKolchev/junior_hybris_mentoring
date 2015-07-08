/**
 *
 */
package com.epam.training.services;

import com.epam.training.dao.OrganizationDao;
import com.epam.training.model.OrganizationModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * @author Olha_Horbatiuk
 */
@RunWith(MockitoJUnitRunner.class)
public class OrganizationModelServiceTest {

    private static final String NO_CUSTOMERS_FOUND = "This organization has no customers.";
    private static final String THREE_CUSTOMERS_FOUND = "This organization has %d customers.";

    @Mock
    private OrganizationModel organization;
    @Mock
    private OrganizationDao organizationDaoMock;

    @InjectMocks
    private OrganizationModelService organizationModelService;

    @Test
    public void requireReturnCorrectlyFormattedStringForNonEmptyCustomersCollection() {
        CustomerModel customer = new CustomerModel();
        List<CustomerModel> threeCustomers = Arrays.asList(customer, customer, customer);
        organization.setCustomers(threeCustomers);
        Mockito.when(organization.getCustomers()).thenReturn(threeCustomers);

        assertEquals("Resulting string is formatted incorrectly",
                String.format(THREE_CUSTOMERS_FOUND, Integer.valueOf(threeCustomers.size())),
                organizationModelService.getValueOfCustomersAmount(organization));
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

    @Test
    public void requireReturnListOfAllOrganizationsWhenOrganizationsExist() throws Exception {
        List<OrganizationModel> expected = Arrays.asList(organization, organization, organization);
        Mockito.when(organizationDaoMock.findAll()).thenReturn(expected);

        List<OrganizationModel> actual = organizationModelService.getAllOrganizations();

        assertEquals(expected, actual);
    }

    @Test
    public void requireReturnEmptyListOfAllOrganizationsWhenOrganizationsListIsEmpty() throws Exception {
        List<OrganizationModel> expected = Collections.EMPTY_LIST;
        Mockito.when(organizationDaoMock.findAll()).thenReturn(expected);

        List<OrganizationModel> actual = organizationModelService.getAllOrganizations();

        assertEquals(expected, actual);
    }

    @Test
    public void requireReturnEmptyListOfAllOrganizationsWhenOrganizationsListIsNull() throws Exception {
        List<OrganizationModel> expected = Collections.EMPTY_LIST;
        Mockito.when(organizationDaoMock.findAll()).thenReturn(null);

        List<OrganizationModel> actual = organizationModelService.getAllOrganizations();

        assertEquals(expected, actual);
    }

}