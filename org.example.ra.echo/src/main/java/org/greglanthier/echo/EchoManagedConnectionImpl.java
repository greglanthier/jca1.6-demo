package org.greglanthier.echo;

import java.io.PrintWriter;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public class EchoManagedConnectionImpl implements EchoManagedConnection {

	@Override
	public Object getConnection(Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#getConnection");
		return this;
	}

	@Override
	public void destroy() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#destroy");
	}

	@Override
	public void cleanup() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#cleanup");
	}

	@Override
	public void associateConnection(Object connection) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println( this + "#associateConnection");
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener listener) {
		// TODO Auto-generated method stub
		System.out.println( this + "#addConnectionEventListener");
	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		// TODO Auto-generated method stub
		System.out.println( this + "#removeConnectionEventListener");
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
