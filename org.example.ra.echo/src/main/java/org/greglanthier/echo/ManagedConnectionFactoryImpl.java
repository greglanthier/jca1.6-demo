package org.greglanthier.echo;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
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
public class ManagedConnectionFactoryImpl implements ManagedConnectionFactory, ValidatingManagedConnectionFactory {

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
		ManagedConnection answer = null;//(ManagedConnection) connectionSet.iterator().next();
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

	@Override
	public Set getInvalidConnections(Set connectionSet)
			throws ResourceException {
		LOG.info( this + "#getInvalidConnections( {} ): {}", connectionSet, connectionSet );
		return connectionSet;
	}

}
