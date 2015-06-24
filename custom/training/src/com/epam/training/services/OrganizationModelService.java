/**
 * 
 */
package com.epam.training.services;

import org.apache.commons.collections.CollectionUtils;
import com.epam.training.model.OrganizationModel;

/**
 * @author Olha_Horbatiuk
 *
 */
public class OrganizationModelService
{
	
	private static final String NO_CUSTOMERS_FOUND = "This organization has no customers.";
	private static final String SOME_CUSTOMERS_FOUND = "This organization has %d customers.";
	
	public String getValueOfCustomersAmount(final OrganizationModel model)
	{
		if (CollectionUtils.isEmpty(model.getCustomers()))
		{
			return NO_CUSTOMERS_FOUND;
		}

		return String.format(SOME_CUSTOMERS_FOUND, Integer.valueOf(model.getCustomers().size()));
	}
	
}