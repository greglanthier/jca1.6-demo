package org.greglanthier.echo;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoConnection implements Connection {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoConnection.class );

	private EchoManagedConnection m_mc;

	public EchoConnection( final EchoManagedConnection _mc ) {
		LOG.info( this + "( {} )", _mc );
		this.m_mc = _mc;
	}

	@Override
	public Interaction createInteraction() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		
		return null;
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		return null;
	}

	@Override
	public void close() throws ResourceException {
		LOG.info( this + "#close()" );
		m_mc.cleanup();
	}

}
