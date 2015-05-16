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
