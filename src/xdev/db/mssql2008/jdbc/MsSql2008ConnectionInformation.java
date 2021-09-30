
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


import xdev.db.ConnectionInformation;


/**
 * The Class MsSql2008ConnectionInformation.
 */
public class MsSql2008ConnectionInformation extends ConnectionInformation<MsSql2008Dbms>
{
	// /////////////////////////////////////////////////////////////////////////
	// constructors //
	// ///////////////////
	
	/**
	 * Instantiates a new ms sql2005 connection information.
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
	 * @param urlExtension
	 *            the extended url properties
	 * @param dbmsAdaptor
	 *            the dbms adaptor
	 */
	public MsSql2008ConnectionInformation(final String host, final int port, final String user,
			final String password, final String database, final String urlExtension,
			final MsSql2008Dbms dbmsAdaptor)
	{
		super(host,port,user,password,database,urlExtension,dbmsAdaptor);
	}
	
	
	// /////////////////////////////////////////////////////////////////////////
	// getters //
	// ///////////////////
	
	/**
	 * Gets the database.
	 * 
	 * @return the database
	 */
	public String getDatabase()
	{
		return this.getCatalog();
	}
	
	
	// /////////////////////////////////////////////////////////////////////////
	// setters //
	// ///////////////////
	
	/**
	 * Sets the database.
	 * 
	 * @param database
	 *            the database to set
	 */
	public void setDatabase(final String database)
	{
		this.setCatalog(database);
	}
	
	
	// /////////////////////////////////////////////////////////////////////////
	// override methods //
	// ///////////////////
	
	/**
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsConnectionInformation#createJdbcConnectionUrl(java.lang.String)
	 */
	@Override
	public String createJdbcConnectionUrl()
	{
		String url = "jdbc:sqlserver://" + getHost() + ":" + getPort() + ";databaseName="
				+ getDatabase();
		return appendUrlExtension(url);
	}
	
	
	/**
	 * @return
	 * @see com.xdev.jadoth.sqlengine.dbms.DbmsConnectionInformation#getJdbcDriverClassName()
	 */
	@Override
	public String getJdbcDriverClassName()
	{
		return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	}
	
}
