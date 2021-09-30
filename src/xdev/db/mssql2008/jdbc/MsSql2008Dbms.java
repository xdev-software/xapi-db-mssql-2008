package xdev.db.mssql2008.jdbc;

/*-
 * #%L
 * SqlEngine Database Adapter MsSQL 2008
 * %%
 * Copyright (C) 2003 - 2021 XDEV Software
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */


import com.xdev.jadoth.sqlengine.dbms.DbmsAdaptor;
import com.xdev.jadoth.sqlengine.dbms.SQLExceptionParser;
import com.xdev.jadoth.sqlengine.interfaces.ConnectionProvider;
import com.xdev.jadoth.sqlengine.internal.DatabaseGateway;
import com.xdev.jadoth.sqlengine.internal.tables.SqlTableIdentity;


/**
 * The Class MsSql2008Dbms.
 */
public class MsSql2008Dbms
		extends
		DbmsAdaptor.Implementation<MsSql2008Dbms, MsSql2008DMLAssembler, MsSql2008DDLMapper, MsSql2008RetrospectionAccessor, MsSql2008Syntax>
{
	// /////////////////////////////////////////////////////////////////////////
	// constants //
	// ///////////////////
	
	/** The Constant MAX_VARCHAR_LENGTH. */
	protected static final int	MAX_VARCHAR_LENGTH		= 8000;
	
	protected static final char	IDENTIFIER_DELIMITER	= '"';
	
	
	// /////////////////////////////////////////////////////////////////////////
	// static methods //
	// /////////////////
	
	/**
	 * Single connection.
	 * 
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @param user
	 *            the user
	 * @param password
	 *            the password
	 * @param database
	 *            the database
	 * @param properties
	 *            the extended url properties
	 * @return the connection provider
	 */
	public static ConnectionProvider<MsSql2008Dbms> singleConnection(final String host,
			final int port, final String user, final String password, final String database,
			final String properties)
	{
		return new ConnectionProvider.Body<>(new MsSql2008ConnectionInformation(host,
				port,user,password,database,properties,new MsSql2008Dbms()));
	}
	
	
	// /////////////////////////////////////////////////////////////////////////
	// constructors //
	// ///////////////
	
	/**
	 * Instantiates a new ms sql2005 dbms.
	 */
	public MsSql2008Dbms()
	{
		this(new MsSql2008ExceptionParser());
	}
	
	
	/**
	 * Instantiates a new ms sql2005 dbms.
	 * 
	 * @param sqlExceptionParser
	 *            the sql exception parser
	 */
	public MsSql2008Dbms(final SQLExceptionParser sqlExceptionParser)
	{
		super(sqlExceptionParser,false);
		this.setRetrospectionAccessor(new MsSql2008RetrospectionAccessor(this));
		this.setDMLAssembler(new MsSql2008DMLAssembler(this));
		this.setDdlMapper(new MsSql2008DDLMapper(this));
		this.setSyntax(new MsSql2008Syntax());
	}
	
	
	/**
	 * @param host
	 * @param port
	 * @param user
	 * @param password
	 * @param catalog
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#createConnectionInformation(java.lang.String,
	 *      int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public MsSql2008ConnectionInformation createConnectionInformation(final String host,
			final int port, final String user, final String password, final String catalog,
			final String properties)
	{
		return new MsSql2008ConnectionInformation(host,port,user,password,catalog,properties,this);
	}
	
	
	/**
	 * @param table
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#updateSelectivity(com.xdev.jadoth.sqlengine.internal.tables.SqlTableIdentity)
	 */
	@Override
	public Object updateSelectivity(final SqlTableIdentity table)
	{
		return null;
	}
	
	
	/**
	 * @param bytes
	 * @param sb
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#assembleTransformBytes(byte[],
	 *      java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder assembleTransformBytes(final byte[] bytes, final StringBuilder sb)
	{
		return sb;
	}
	
	
	/**
	 * @param dbc
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#initialize(com.xdev.jadoth.sqlengine.internal.DatabaseGateway)
	 */
	@Override
	public void initialize(final DatabaseGateway<MsSql2008Dbms> dbc)
	{
		// No initialization needed
	}
	
	
	/**
	 * @param fullQualifiedTableName
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#rebuildAllIndices(java.lang.String)
	 */
	@Override
	public Object rebuildAllIndices(final String fullQualifiedTableName)
	{
		return null;
	}
	
	
	/**
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsAdapter#getMaxVARCHARlength()
	 */
	@Override
	public int getMaxVARCHARlength()
	{
		return MAX_VARCHAR_LENGTH;
	}
	
	
	@Override
	public boolean supportsOFFSET_ROWS()
	{
		return false;
	}
	
	
	@Override
	public char getIdentifierDelimiter()
	{
		return IDENTIFIER_DELIMITER;
	}
	
}
