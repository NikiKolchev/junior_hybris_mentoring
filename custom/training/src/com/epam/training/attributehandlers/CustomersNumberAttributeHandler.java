/**
 * 
 */
package com.epam.training.attributehandlers;

import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.training.model.OrganizationModel;
import com.epam.training.services.OrganizationModelService;


/**
 * @author Olha_Horbatiuk
 *
 */
@Component
public class CustomersNumberAttributeHandler extends AbstractDynamicAttributeHandler<String, OrganizationModel>
{

	@Autowired
	private OrganizationModelService organizationModelService;

	@Override
	public String get(final OrganizationModel model)
	{
		return organizationModelService.getValueOfCustomersAmount(model);
	}

	public void setOrganizationModelService(final OrganizationModelService organizationModelService)
	{
		this.organizationModelService = organizationModelService;
	}

}