/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 19, 2015 2:50:25 PM                     ---
 * ----------------------------------------------------------------
 */
package com.epam.training.jalo;

import com.epam.training.constants.TrainingConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Organization}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedOrganization extends GenericItem
{
	/** Qualifier of the <code>Organization.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>Organization.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Organization.phone</code> attribute **/
	public static final String PHONE = "phone";
	/** Qualifier of the <code>Organization.email</code> attribute **/
	public static final String EMAIL = "email";
	/** Qualifier of the <code>Organization.customers</code> attribute **/
	public static final String CUSTOMERS = "customers";
	/** Relation ordering override parameter constants for Customer2Organization from ((training))*/
	protected static String CUSTOMER2ORGANIZATION_SRC_ORDERED = "relation.Customer2Organization.source.ordered";
	protected static String CUSTOMER2ORGANIZATION_TGT_ORDERED = "relation.Customer2Organization.target.ordered";
	/** Relation disable markmodifed parameter constants for Customer2Organization from ((training))*/
	protected static String CUSTOMER2ORGANIZATION_MARKMODIFIED = "relation.Customer2Organization.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(PHONE, AttributeMode.INITIAL);
		tmp.put(EMAIL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.customers</code> attribute.
	 * @return the customers
	 */
	public Collection<Customer> getCustomers(final SessionContext ctx)
	{
		final List<Customer> items = getLinkedItems( 
			ctx,
			false,
			TrainingConstants.Relations.CUSTOMER2ORGANIZATION,
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.customers</code> attribute.
	 * @return the customers
	 */
	public Collection<Customer> getCustomers()
	{
		return getCustomers( getSession().getSessionContext() );
	}
	
	public long getCustomersCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			TrainingConstants.Relations.CUSTOMER2ORGANIZATION,
			null
		);
	}
	
	public long getCustomersCount()
	{
		return getCustomersCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.customers</code> attribute. 
	 * @param value the customers
	 */
	public void setCustomers(final SessionContext ctx, final Collection<Customer> value)
	{
		setLinkedItems( 
			ctx,
			false,
			TrainingConstants.Relations.CUSTOMER2ORGANIZATION,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMER2ORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.customers</code> attribute. 
	 * @param value the customers
	 */
	public void setCustomers(final Collection<Customer> value)
	{
		setCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customers. 
	 * @param value the item to add to customers
	 */
	public void addToCustomers(final SessionContext ctx, final Customer value)
	{
		addLinkedItems( 
			ctx,
			false,
			TrainingConstants.Relations.CUSTOMER2ORGANIZATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMER2ORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customers. 
	 * @param value the item to add to customers
	 */
	public void addToCustomers(final Customer value)
	{
		addToCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customers. 
	 * @param value the item to remove from customers
	 */
	public void removeFromCustomers(final SessionContext ctx, final Customer value)
	{
		removeLinkedItems( 
			ctx,
			false,
			TrainingConstants.Relations.CUSTOMER2ORGANIZATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMER2ORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customers. 
	 * @param value the item to remove from customers
	 */
	public void removeFromCustomers(final Customer value)
	{
		removeFromCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.email</code> attribute.
	 * @return the email - Organisation's email.
	 */
	public String getEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.email</code> attribute.
	 * @return the email - Organisation's email.
	 */
	public String getEmail()
	{
		return getEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.email</code> attribute. 
	 * @param value the email - Organisation's email.
	 */
	public void setEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.email</code> attribute. 
	 * @param value the email - Organisation's email.
	 */
	public void setEmail(final String value)
	{
		setEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute.
	 * @return the id - Id(not a PK)
	 */
	public Integer getId(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute.
	 * @return the id - Id(not a PK)
	 */
	public Integer getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute. 
	 * @return the id - Id(not a PK)
	 */
	public int getIdAsPrimitive(final SessionContext ctx)
	{
		Integer value = getId( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute. 
	 * @return the id - Id(not a PK)
	 */
	public int getIdAsPrimitive()
	{
		return getIdAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - Id(not a PK)
	 */
	public void setId(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - Id(not a PK)
	 */
	public void setId(final Integer value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - Id(not a PK)
	 */
	public void setId(final SessionContext ctx, final int value)
	{
		setId( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - Id(not a PK)
	 */
	public void setId(final int value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute.
	 * @return the name - Organisation's name.
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute.
	 * @return the name - Organisation's name.
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - Organisation's name.
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - Organisation's name.
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.phone</code> attribute.
	 * @return the phone - Organisation's phone.
	 */
	public String getPhone(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.phone</code> attribute.
	 * @return the phone - Organisation's phone.
	 */
	public String getPhone()
	{
		return getPhone( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.phone</code> attribute. 
	 * @param value the phone - Organisation's phone.
	 */
	public void setPhone(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.phone</code> attribute. 
	 * @param value the phone - Organisation's phone.
	 */
	public void setPhone(final String value)
	{
		setPhone( getSession().getSessionContext(), value );
	}
	
}
