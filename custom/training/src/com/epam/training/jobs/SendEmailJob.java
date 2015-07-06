package com.epam.training.jobs;

import com.epam.training.model.OrganizationModel;
import com.epam.training.services.MailService;
import com.epam.training.services.OrganizationModelService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Olha_Horbatiuk on 6/25/2015.
 */
public class SendEmailJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(SendEmailJob.class);

    @Autowired
    private MailService mailService;
    @Autowired
    private OrganizationModelService modelService;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {

        LOG.info("Sending emails");
        List<OrganizationModel> organizationModels = modelService.getAllOrganizations();

        if (organizationModels.isEmpty()) {
            LOG.info("No competitions have changed, skipping send emails");
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        }

        mailService.sendEmail(organizationModels);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

}
