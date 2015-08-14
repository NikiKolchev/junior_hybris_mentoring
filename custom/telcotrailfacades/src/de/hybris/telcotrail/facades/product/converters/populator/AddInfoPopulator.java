package de.hybris.telcotrail.facades.product.converters.populator;

import com.epam.training.model.AdditionalInfoModel;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.telcotrail.facades.data.AdditionalInfoData;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

public class AddInfoPopulator implements Populator<AdditionalInfoModel, AdditionalInfoData> {

    private Converter<PrincipalModel, PrincipalData> principalConverter;

    protected Converter<PrincipalModel, PrincipalData> getPrincipalConverter() {
        return principalConverter;
    }

    @Required
    public void setPrincipalConverter(final Converter<PrincipalModel, PrincipalData> principalConverter) {
        this.principalConverter = principalConverter;
    }


    @Override
    public void populate(AdditionalInfoModel source, AdditionalInfoData target) throws ConversionException {
        Assert.notNull(source, "Parameter source cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");

        target.setId(source.getId());
        target.setDescription("Description from AddInfoPopulator");
    }
}
