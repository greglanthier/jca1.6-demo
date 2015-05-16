package org.greglanthier.echo;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;

@ConnectionDefinition(
		connectionFactory=org.greglanthier.echo.EchoConnectionFactory.class,
		connectionFactoryImpl=org.greglanthier.echo.EchoConnectionFactoryImpl.class,
		connection=org.greglanthier.echo.EchoManagedConnection.class,
		connectionImpl=org.greglanthier.echo.EchoManagedConnectionImpl.class
		)
public class ManagedConnectionFactoryImpl implements ManagedConnectionFactory {

	private static final long serialVersionUID = 1L;

	@Override
	public Object createConnectionFactory(ConnectionManager cxManager)
			throws ResourceException {
		return new EchoConnectionFactoryImpl( this, cxManager );
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {
		System.out.println("createConnectionFactory");
		return null;
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		System.out.println("createManagedConnection 1");
		
		// Create a managed connection instance (not the ConnectionImpl )
		return new EchoManagedConnectionImpl();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ManagedConnection matchManagedConnections(Set connectionSet,
			Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		System.out.println("matchManagedConnection");
		System.out.println( Arrays.toString( connectionSet.toArray() ) );
		System.out.println( "Subject: " + subject );
		System.out.println( "ConnectionRequestInfo: " + cxRequestInfo );
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {

	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		return null;
	}

}
