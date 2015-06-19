/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 19, 2015 2:50:25 PM                     ---
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

import de.hybris.platform.acceleratorcms.jalo.components.ProductReferencesComponent;
import de.hybris.platform.catalog.jalo.classification.ClassAttributeAssignment;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.telcotrail.core.constants.TelcotrailCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.telcotrail.core.jalo.ProductReferencesAndClassificationsComponent ProductReferencesAndClassificationsComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedProductReferencesAndClassificationsComponent extends ProductReferencesComponent
{
	/** Qualifier of the <code>ProductReferencesAndClassificationsComponent.classAttributeAssignment</code> attribute **/
	public static final String CLASSATTRIBUTEASSIGNMENT = "classAttributeAssignment";
	/** Qualifier of the <code>ProductReferencesAndClassificationsComponent.targetItemType</code> attribute **/
	public static final String TARGETITEMTYPE = "targetItemType";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CLASSATTRIBUTEASSIGNMENT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedProductReferencesAndClassificationsComponent> CLASSATTRIBUTEASSIGNMENTHANDLER = new BidirectionalOneToManyHandler<GeneratedProductReferencesAndClassificationsComponent>(
	TelcotrailCoreConstants.TC.PRODUCTREFERENCESANDCLASSIFICATIONSCOMPONENT,
	false,
	"classAttributeAssignment",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n TARGETITEMTYPE's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedProductReferencesAndClassificationsComponent> TARGETITEMTYPEHANDLER = new BidirectionalOneToManyHandler<GeneratedProductReferencesAndClassificationsComponent>(
	TelcotrailCoreConstants.TC.PRODUCTREFERENCESANDCLASSIFICATIONSCOMPONENT,
	false,
	"targetItemType",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(ProductReferencesComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CLASSATTRIBUTEASSIGNMENT, AttributeMode.INITIAL);
		tmp.put(TARGETITEMTYPE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesAndClassificationsComponent.classAttributeAssignment</code> attribute.
	 * @return the classAttributeAssignment
	 */
	public ClassAttributeAssignment getClassAttributeAssignment(final SessionContext ctx)
	{
		return (ClassAttributeAssignment)getProperty( ctx, CLASSATTRIBUTEASSIGNMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesAndClassificationsComponent.classAttributeAssignment</code> attribute.
	 * @return the classAttributeAssignment
	 */
	public ClassAttributeAssignment getClassAttributeAssignment()
	{
		return getClassAttributeAssignment( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductReferencesAndClassificationsComponent.classAttributeAssignment</code> attribute. 
	 * @param value the classAttributeAssignment
	 */
	public void setClassAttributeAssignment(final SessionContext ctx, final ClassAttributeAssignment value)
	{
		CLASSATTRIBUTEASSIGNMENTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductReferencesAndClassificationsComponent.classAttributeAssignment</code> attribute. 
	 * @param value the classAttributeAssignment
	 */
	public void setClassAttributeAssignment(final ClassAttributeAssignment value)
	{
		setClassAttributeAssignment( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		CLASSATTRIBUTEASSIGNMENTHANDLER.newInstance(ctx, allAttributes);
		TARGETITEMTYPEHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesAndClassificationsComponent.targetItemType</code> attribute.
	 * @return the targetItemType
	 */
	public ComposedType getTargetItemType(final SessionContext ctx)
	{
		return (ComposedType)getProperty( ctx, TARGETITEMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductReferencesAndClassificationsComponent.targetItemType</code> attribute.
	 * @return the targetItemType
	 */
	public ComposedType getTargetItemType()
	{
		return getTargetItemType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductReferencesAndClassificationsComponent.targetItemType</code> attribute. 
	 * @param value the targetItemType
	 */
	public void setTargetItemType(final SessionContext ctx, final ComposedType value)
	{
		TARGETITEMTYPEHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductReferencesAndClassificationsComponent.targetItemType</code> attribute. 
	 * @param value the targetItemType
	 */
	public void setTargetItemType(final ComposedType value)
	{
		setTargetItemType( getSession().getSessionContext(), value );
	}
	
}
