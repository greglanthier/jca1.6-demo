package org.greglanthier.echo;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

public class EchoConnection implements Connection {

	private EchoManagedConnection m_mc;

	public EchoConnection( final EchoManagedConnection _mc ) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws ResourceException {
		m_mc.cleanup();
	}

}
