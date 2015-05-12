package com.wombat.ra;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

public class CFImpl implements CF {

	private static final long serialVersionUID = 1L;

	ManagedConnectionFactory mcf;
	ConnectionManager cm;

	public CFImpl( final ManagedConnectionFactory _mcf, final ConnectionManager _cm ) {
		this.mcf = _mcf;
		this.cm = _cm;
	}

	@Override
	public Connection getConnection() throws ResourceException {
		System.out.println( "CFImpl#getConnection()");
		return (Connection) cm.allocateConnection(mcf, null);
	}

	@Override
	public Connection getConnection(ConnectionSpec properties)
			throws ResourceException {
		System.out.println( "CFImpl#getConnection(prop)");
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
