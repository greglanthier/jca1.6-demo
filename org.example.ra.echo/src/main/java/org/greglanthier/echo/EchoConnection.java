package org.greglanthier.echo;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;
import javax.resource.cci.ResultSetInfo;

import org.greglanthier.echo.spi.EchoManagedConnection;
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
		return new Interaction() {
			
			@Override
			public ResourceWarning getWarnings() throws ResourceException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Connection getConnection() {
				return EchoConnection.this;
			}
			
			@Override
			public boolean execute(InteractionSpec ispec, Record input, Record output)
					throws ResourceException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Record execute(InteractionSpec ispec, Record input)
					throws ResourceException {
				return new Record() {
					
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void setRecordShortDescription(String description) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void setRecordName(String name) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public String getRecordShortDescription() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public String getRecordName() {
						return ":-)";
					}
					
					@Override
					public Object clone() throws CloneNotSupportedException {
						// TODO Auto-generated method stub
						return super.clone();
					}
				};
			}
			
			@Override
			public void close() throws ResourceException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearWarnings() throws ResourceException {
				// TODO Auto-generated method stub
				
			}
		};
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

	@Override
	public boolean equals(Object obj) {
		LOG.info( this + "#equals( {} )", obj );
		return super.equals(obj);
	}
}
