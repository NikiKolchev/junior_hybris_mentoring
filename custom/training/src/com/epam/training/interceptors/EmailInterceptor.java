package com.epam.training.interceptors;

import com.epam.training.model.OrganizationModel;
import com.epam.training.services.MailService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class EmailInterceptor implements ValidateInterceptor {

    public static final int MAX_CUSTOMERS_AMOUNT = 5;
    public static final String MAX_CUSTOMERS_COUNT_ACHIEVED_MESSAGE = "The Organization %s has %d customers now. If you would like to add new one at first you need to fire one.";

    @Autowired
    private MailService mailService;
    @Autowired
    private ModelService modelService;

    @Override
    public void onValidate(Object model, InterceptorContext interceptorContext) throws InterceptorException {
        OrganizationModel organization = (OrganizationModel) model;

        if (MAX_CUSTOMERS_AMOUNT == organization.getCustomers().size()) {
            List<OrganizationModel> organizations = Collections.singletonList(organization);
            mailService.sendEmail(organizations, String.format(MAX_CUSTOMERS_COUNT_ACHIEVED_MESSAGE, organization.getName(), organization.getCustomers().size()));
        }
    }

}