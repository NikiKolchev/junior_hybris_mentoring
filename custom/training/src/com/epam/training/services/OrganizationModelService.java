/**
 *
 */
package com.epam.training.services;

import com.epam.training.dao.OrganizationDao;
import org.apache.commons.collections.CollectionUtils;
import com.epam.training.model.OrganizationModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Olha_Horbatiuk
 */
public class OrganizationModelService {

    @Autowired
    private OrganizationDao organizationDao;

    private static final String NO_CUSTOMERS_FOUND = "This organization has no customers.";
    private static final String SOME_CUSTOMERS_FOUND = "This organization has %d customers.";

    public String getValueOfCustomersAmount(final OrganizationModel organizationModel) {
        if (CollectionUtils.isEmpty(organizationModel.getCustomers())) {
            return NO_CUSTOMERS_FOUND;
        }

        return String.format(SOME_CUSTOMERS_FOUND, Integer.valueOf(organizationModel.getCustomers().size()));
    }

    public List<OrganizationModel> getAllOrganizations() {
        List<OrganizationModel> organizationModels = organizationDao.findAll();
        if (CollectionUtils.isEmpty(organizationModels)) {
            return Collections.EMPTY_LIST;
        }
        return organizationModels;
    }

}