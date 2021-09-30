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


import xdev.db.DBException;
import xdev.db.jdbc.JDBCDataSource;


public class MsSql2008JDBCDataSource extends JDBCDataSource<MsSql2008JDBCDataSource, MsSql2008Dbms>
{
	public MsSql2008JDBCDataSource()
	{
		super(new MsSql2008Dbms());
	}
	
	
	@Override
	public Parameter[] getDefaultParameters()
	{
		return new Parameter[]{HOST.clone(),PORT.clone(1433),USERNAME.clone("SA"),PASSWORD.clone(),
				SCHEMA.clone(),CATALOG.clone(),URL_EXTENSION.clone(),IS_SERVER_DATASOURCE.clone(),
				SERVER_URL.clone(),AUTH_KEY.clone()};
	}
	
	
	@Override
	protected MsSql2008ConnectionInformation getConnectionInformation()
	{
		return new MsSql2008ConnectionInformation(getHost(),getPort(),getUserName(),getPassword()
				.getPlainText(),getCatalog(),getUrlExtension(),getDbmsAdaptor());
	}
	
	
	@Override
	public MsSql2008JDBCConnection openConnectionImpl() throws DBException
	{
		return new MsSql2008JDBCConnection(this);
	}
	
	
	@Override
	public MsSql2008JDBCMetaData getMetaData() throws DBException
	{
		return new MsSql2008JDBCMetaData(this);
	}
	
	
	@Override
	public boolean canExport()
	{
		return false;
	}
}
