/*
 * SqlEngine Database Adapter MsSQL 2008 - XAPI SqlEngine Database Adapter for MsSQL 2008
 * Copyright © 2003 XDEV Software (https://xdev.software)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package xdev.db.mssql2008.jdbc;

import com.xdev.jadoth.sqlengine.dbms.DbmsSyntax;


public class MsSql2008Syntax extends DbmsSyntax.Implementation<MsSql2008Dbms>
{
	protected MsSql2008Syntax()
	{
		super(wordSet(),wordSet());
	}
	
}
