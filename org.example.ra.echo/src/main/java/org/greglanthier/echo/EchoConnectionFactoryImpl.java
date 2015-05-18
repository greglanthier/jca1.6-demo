/*
 * Copyright 2015 Greg Lanthier
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.greglanthier.echo;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

import org.greglanthier.echo.spi.EchoConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoConnectionFactoryImpl implements EchoConnectionFactory {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoConnectionFactoryImpl.class );

	private static final long serialVersionUID = 1L;

	ManagedConnectionFactory mcf;
	ConnectionManager cm;

	public EchoConnectionFactoryImpl( final ManagedConnectionFactory _mcf, final ConnectionManager _cm ) {
		LOG.info( this + "( {}, {} )", _mcf, _cm );
		this.mcf = _mcf;
		this.cm = _cm;
	}

	@Override
	public Connection getConnection() throws ResourceException {
		LOG.info( this + "#getConnection()" );
		EchoManagedConnectionImpl c = (EchoManagedConnectionImpl) cm.allocateConnection( mcf, null );
		return new EchoConnection( c );
	}

	@Override
	public Connection getConnection(ConnectionSpec properties)
			throws ResourceException {
		LOG.info( this + "#getConnection( properties )" );
		return getConnection();
	}

	@Override
	public RecordFactory getRecordFactory() throws ResourceException {
		return null;
	}

	@Override
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return null;
	}

	@Override
	public void setReference(Reference reference) {
		System.out.println( "CFImpl#setReference");
	}

	@Override
	public Reference getReference() throws NamingException {
		System.out.println( "CFImpl#getReference");
		return null;
	}

}
