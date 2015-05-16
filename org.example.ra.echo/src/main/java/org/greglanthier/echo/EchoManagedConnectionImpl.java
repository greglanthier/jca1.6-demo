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

public class EchoManagedConnectionImpl implements EchoManagedConnection {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoManagedConnectionImpl.class );
	
	private List<ConnectionEventListener> m_connectionEventListeners = new ArrayList<ConnectionEventListener>();
	
	@Override
	public Object getConnection(Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		LOG.info( this + "#getConnection" );
		return this;
	}

	@Override
	public void destroy() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#destroy");
	}

	@Override
	public void cleanup() throws ResourceException {
		LOG.info( this + "#cleanup()" );
		for ( ConnectionEventListener l : m_connectionEventListeners ) {
			l.connectionClosed( new ConnectionEvent( this, ConnectionEvent.CONNECTION_CLOSED ) );
		}
	}

	@Override
	public void associateConnection(Object connection) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#associateConnection");
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener listener) {
		LOG.info( this + "#addConnectionEventListener( {} )", listener );
		m_connectionEventListeners.add( listener );
	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		LOG.info( this + "#removeConnectionEventListener( {} )", listener );
		m_connectionEventListeners.remove( listener );
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
		// TODO Auto-generated method stub
		return null;
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
}
