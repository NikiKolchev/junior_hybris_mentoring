/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package de.hybris.telcotrail.storefront.controllers.pages;

import com.epam.training.dao.TrainingCustomerModelDao;
import com.epam.training.enums.Status;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.telcotrail.storefront.controllers.ControllerConstants;
import de.hybris.telcotrail.storefront.controllers.util.GlobalMessages;
import de.hybris.telcotrail.storefront.forms.RegisterForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * Login Controller. Handles login and register for the account flow.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginPageController extends AbstractLoginPageController {

    public static final String LOGIN_ERROR_ACCOUNT_IS_BLOCKED_TITLE = "login.error.account.is.blocked.title";
    public static final int BLOCK_USER_ATTEMPTS = 3;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelService modelService;

//    @Autowired
//    TrainingCustomerModelDao customerModelDao;

    @Override
    protected String getView() {
        return ControllerConstants.Views.Pages.Account.AccountLoginPage;
    }

    @Override
    protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response) {
        if (httpSessionRequestCache.getRequest(request, response) != null) {
            return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
        }
        return "/my-account";
    }

    @Override
    protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException {
        return getContentPageForLabelOrId("login");
    }

    private HttpSessionRequestCache httpSessionRequestCache;

    @Autowired
    @Qualifier("httpSessionRequestCache")
    public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache) {
        this.httpSessionRequestCache = accHttpSessionRequestCache;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doLogin(@RequestHeader(value = "referer", required = false) final String referer,
                          @RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model,
                          final HttpServletRequest request, final HttpServletResponse response, final HttpSession session)
            throws CMSItemNotFoundException {

        if (loginError) {
            final CustomerModel customerModel = (CustomerModel) userService.getUserForUID(getUsernameTryingToLogin(session));
            int attemptCount = customerModel.getAttemptCount();

            if (attemptCount == BLOCK_USER_ATTEMPTS) {
                if (Status.BLOCKED != customerModel.getStatus()) {
                    customerModel.setStatus(Status.BLOCKED);
                    modelService.save(customerModel);
                }
                GlobalMessages.addErrorMessage(model, LOGIN_ERROR_ACCOUNT_IS_BLOCKED_TITLE);
            } else {
                customerModel.setAttemptCount(++attemptCount);
                modelService.save(customerModel);
            }
        } else {
            storeReferer(referer, request, response);
        }
        return getDefaultLoginPage(loginError, session, model);
    }

    protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse response) {
        if (StringUtils.isNotBlank(referer)) {
            httpSessionRequestCache.saveRequest(request, response);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@RequestHeader(value = "referer", required = false) final String referer,
                             @Valid final RegisterForm form, final BindingResult bindingResult, final Model model, final HttpServletRequest request,
                             final HttpServletResponse response) throws CMSItemNotFoundException {
        return processRegisterUserRequest(referer, form, bindingResult, model, request, response);
    }

}