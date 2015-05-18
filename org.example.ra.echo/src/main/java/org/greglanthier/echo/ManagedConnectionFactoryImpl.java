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

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.ValidatingManagedConnectionFactory;
import javax.security.auth.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConnectionDefinition(
		connectionFactory=org.greglanthier.echo.spi.EchoConnectionFactory.class,
		connectionFactoryImpl=org.greglanthier.echo.EchoConnectionFactoryImpl.class,
		connection=org.greglanthier.echo.spi.EchoManagedConnection.class,
		connectionImpl=org.greglanthier.echo.EchoManagedConnectionImpl.class
		)
public class ManagedConnectionFactoryImpl implements ManagedConnectionFactory, ResourceAdapterAssociation, ValidatingManagedConnectionFactory {

	private static final transient Logger LOG = LoggerFactory.getLogger( ManagedConnectionFactoryImpl.class );

	private static final long serialVersionUID = 1L;

	ConnectionManager m_connectionManager;

	@Override
	public Object createConnectionFactory(ConnectionManager cxManager)
			throws ResourceException {
		LOG.info( this + "#createConnectionFactory( {} )", cxManager );
		return new EchoConnectionFactoryImpl( this, cxManager );
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {
		LOG.info( this + "#createConnectionFactory( )" );
		return null;
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		LOG.info( this + "#createManagedConnection( {}, {} )", subject, cxRequestInfo );
		return new EchoManagedConnectionImpl();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ManagedConnection matchManagedConnections(Set connectionSet,
			Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		Iterator iterator = connectionSet.iterator();
		if ( ! iterator.hasNext() ) {
			return null;
		}

		ManagedConnection answer = null;
		for ( ; iterator.hasNext(); ) {
			Object next = iterator.next();
			if ( ! ManagedConnection.class.isAssignableFrom( next.getClass() ) ) {
				continue;
			}
			answer = (ManagedConnection) next;
			break;
		}

		LOG.info( this + "#matchManagedConnection( {}, {}, {} ): {}", connectionSet, subject, cxRequestInfo, answer );
		return answer;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {

	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set getInvalidConnections(Set connectionSet)
			throws ResourceException {
		LOG.info( this + "#getInvalidConnections( {} ): {}", connectionSet, connectionSet );
		return connectionSet;
	}

	@Override
	public ResourceAdapter getResourceAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		LOG.info( this + "#setResourceAdapter( {} )", ra );

	}

}
