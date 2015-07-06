package com.epam.training.dao.impl;

import com.epam.training.dao.OrganizationDao;
import com.epam.training.model.OrganizationModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.user.daos.UserDao;

import java.util.Collections;
import java.util.List;

public class DefaultOrganizationDao extends DefaultGenericDao<OrganizationModel> implements OrganizationDao {

    public DefaultOrganizationDao(){
        super(OrganizationModel._TYPECODE);
    };

    public DefaultOrganizationDao(String typecode) {
        super(OrganizationModel._TYPECODE);
    }

    @Override
    public List<OrganizationModel> findAll() {
        return (List<OrganizationModel>) this.find();
    }

}
