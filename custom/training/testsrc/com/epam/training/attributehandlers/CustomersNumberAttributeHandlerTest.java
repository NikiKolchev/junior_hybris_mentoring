/**
 * 
 */
package com.epam.training.attributehandlers;

import static org.junit.Assert.assertEquals;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.training.model.OrganizationModel;
import com.epam.training.services.OrganizationModelService;


/**
 * @author Olha_Horbatiuk
 *
 */
public class CustomersNumberAttributeHandlerTest
{

	private static final String NO_CUSTOMERS_IN_ORGANIZATION = "This organization has no customers.";
	private static final String THREE_CUSTOMERS_IN_ORGANIZATION = "This organization has %d customers.";

	private OrganizationModel organization;
	private CustomersNumberAttributeHandler handler;
	private OrganizationModelService organizationServiceMock = Mockito.mock(OrganizationModelService.class);

	@Before
	public void setUp()
	{
		handler = new CustomersNumberAttributeHandler();
		handler.setOrganizationModelService(organizationServiceMock);

		organization = new OrganizationModel();
	}

	@Test
	public void requireReturnCorrectlyFormattedStringWhenOrganizationsCollectionIsNotEmpty()
	{
		CustomerModel customer = new CustomerModel();
		List<CustomerModel> threeCustomers = Arrays.asList(customer, customer, customer);
		organization.setCustomers(threeCustomers);
		Mockito.when(organizationServiceMock.getValueOfCustomersAmount(organization)).thenReturn("This organization has 3 customers.");

		assertEquals(String.format(THREE_CUSTOMERS_IN_ORGANIZATION, Integer.valueOf(threeCustomers.size())), handler.get(organization));
	}

	@Test
	public void requireReturnCorrectlyFormattedStringWhenOrganizationsCollectionIsEmpty()
	{
		organization.setCustomers(Collections.EMPTY_LIST);
		Mockito.when(organizationServiceMock.getValueOfCustomersAmount(organization)).thenReturn(NO_CUSTOMERS_IN_ORGANIZATION);

		assertEquals(NO_CUSTOMERS_IN_ORGANIZATION, handler.get(organization));
	}

}
