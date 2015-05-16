package org.greglanthier.echo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.resource.ResourceException;
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
