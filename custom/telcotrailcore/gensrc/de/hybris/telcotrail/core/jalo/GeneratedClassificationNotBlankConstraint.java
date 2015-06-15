/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 12, 2015 6:38:53 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2014 hybris AG
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *  
 */
package de.hybris.telcotrail.core.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.validation.jalo.constraints.TypeConstraint;
import de.hybris.telcotrail.core.constants.TelcotrailCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.telcotrail.core.jalo.ClassificationNotBlankConstraint ClassificationNotBlankConstraint}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedClassificationNotBlankConstraint extends TypeConstraint
{
	/** Qualifier of the <code>ClassificationNotBlankConstraint.category</code> attribute **/
	public static final String CATEGORY = "category";
	/** Qualifier of the <code>ClassificationNotBlankConstraint.classification</code> attribute **/
	public static final String CLASSIFICATION = "classification";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(TypeConstraint.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CATEGORY, AttributeMode.INITIAL);
		tmp.put(CLASSIFICATION, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ClassificationNotBlankConstraint.category</code> attribute.
	 * @return the category - Category code
	 */
	public String getCategory(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CATEGORY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ClassificationNotBlankConstraint.category</code> attribute.
	 * @return the category - Category code
	 */
	public String getCategory()
	{
		return getCategory( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ClassificationNotBlankConstraint.category</code> attribute. 
	 * @param value the category - Category code
	 */
	public void setCategory(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CATEGORY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ClassificationNotBlankConstraint.category</code> attribute. 
	 * @param value the category - Category code
	 */
	public void setCategory(final String value)
	{
		setCategory( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ClassificationNotBlankConstraint.classification</code> attribute.
	 * @return the classification - Classification class code
	 */
	public String getClassification(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CLASSIFICATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ClassificationNotBlankConstraint.classification</code> attribute.
	 * @return the classification - Classification class code
	 */
	public String getClassification()
	{
		return getClassification( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ClassificationNotBlankConstraint.classification</code> attribute. 
	 * @param value the classification - Classification class code
	 */
	public void setClassification(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CLASSIFICATION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ClassificationNotBlankConstraint.classification</code> attribute. 
	 * @param value the classification - Classification class code
	 */
	public void setClassification(final String value)
	{
		setClassification( getSession().getSessionContext(), value );
	}
	
}
