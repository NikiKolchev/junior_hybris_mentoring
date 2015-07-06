package com.epam.training.services;


import com.epam.training.model.OrganizationModel;
import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.email.impl.DefaultEmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Olha_Horbatiuk on 6/25/2015.
 */
public class MailService {
    private static final Logger LOG = Logger.getLogger(MailService.class);

    @Autowired
    private EmailService emailService;

    public void sendEmail(List<OrganizationModel> organizationModels) {
        LOG.info("In method sendEmail com.epam.training.services.MailService");
        EmailAddressModel fromAddress = emailService.getOrCreateEmailAddressForEmail("darwinepam@gmail.com", "darwinepam");

        for (OrganizationModel organizationModel : organizationModels) {
            List<CustomerModel> customers = (List<CustomerModel>) organizationModel.getCustomers();
            StringBuilder bodyMessage = new StringBuilder("In our organization working:");

            LOG.info("Creating bodyMessage...");
            customers = (List<CustomerModel>) organizationModel.getCustomers();
            for (CustomerModel customer : customers) {
                bodyMessage.append(" " + customer.getName());
            }
            LOG.info("BodyMessage created. " + bodyMessage.toString());

            LOG.info("Creating EmailMessageModel...");
            EmailMessageModel emailMessageModel = emailService.createEmailMessage(
                    Collections.singletonList(getEmailAddressModelsFromOrganiztion(organizationModel)),
                    Collections.EMPTY_LIST,
                    Collections.EMPTY_LIST, fromAddress, "", "Daily mail", bodyMessage.toString(), Collections.EMPTY_LIST);
            LOG.info("EmailMessageModel created.");

            LOG.info("Sending email...");
            emailService.send(emailMessageModel);
            LOG.info("Email sended.");
        }
    }

    private EmailAddressModel getEmailAddressModelsFromOrganiztion(OrganizationModel model) {
        LOG.info("Organization's name is: "+ model.getName());
        EmailAddressModel emailAddressModel = emailService.getOrCreateEmailAddressForEmail(model.getEmail(), model.getName());
        LOG.info("DisplayName is: " + emailAddressModel.getDisplayName());
        return emailAddressModel;
    }

    public void setDefaultEmailService(final DefaultEmailService emailService) {
        this.emailService = emailService;
    }
}
