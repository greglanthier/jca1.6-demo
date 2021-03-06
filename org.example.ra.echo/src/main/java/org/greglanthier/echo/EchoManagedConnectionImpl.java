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
import java.util.ArrayList;
import java.util.List;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import org.greglanthier.echo.spi.EchoManagedConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoManagedConnectionImpl implements EchoManagedConnection, ManagedConnectionMetaData {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoManagedConnectionImpl.class );
	
	private List<ConnectionEventListener> m_listeners = new ArrayList<ConnectionEventListener>();
	
	@Override
	public Object getConnection(Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		LOG.info( this + "#getConnection" );
		return this;
	}

	@Override
	public void destroy() throws ResourceException {
		LOG.info( this + "#destroy");
	}

	@Override
	public void cleanup() throws ResourceException {
		LOG.info( this + "#cleanup()" );
	}

	protected void sendEvent( final ConnectionEvent event ) {
		synchronized ( m_listeners ) {
			for ( ConnectionEventListener listener : m_listeners ) {
				listener.connectionClosed( event );
			}
		}
	}
	
	@Override
	public void associateConnection( final Object connection ) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#associateConnection");
	}

	@Override
	public void addConnectionEventListener( final ConnectionEventListener listener ) {
		LOG.info( this + "#addConnectionEventListener( {} )", listener );
		synchronized ( m_listeners ) {
			if ( ! m_listeners.contains( listener ) ) {
				m_listeners.add( listener );
			}
		}
	}

	@Override
	public void removeConnectionEventListener( final ConnectionEventListener listener ) {
		LOG.info( this + "#removeConnectionEventListener( {} )", listener );
		synchronized ( m_listeners ) {
			m_listeners.remove( listener );	
		}
	}

	@Override
	public XAResource getXAResource() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#getXAResource");
		return null;
	}

	@Override
	public javax.resource.spi.LocalTransaction getLocalTransaction()
			throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		LOG.info( this + "#getMetaData()" );
		return this;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		LOG.info( this + "#equals( {} )", obj );
		return super.equals(obj);
	}

	@Override
	public String getEISProductName() throws ResourceException {
		return "echo";
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		return "0.0.1";
	}

	@Override
	public int getMaxConnections() throws ResourceException {
		return 0;
	}

	@Override
	public String getUserName() throws ResourceException {
		return "echo_user";
	}
}
