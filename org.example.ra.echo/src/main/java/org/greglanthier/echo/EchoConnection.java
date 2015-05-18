/*
 * Copyright 2015 Greg Lanthier
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import javax.resource.spi.ConnectionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoConnection implements Connection {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoConnection.class );

	private EchoManagedConnectionImpl m_mc;

	public EchoConnection( final EchoManagedConnectionImpl _mc ) {
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
		ConnectionEvent event = new ConnectionEvent( m_mc, ConnectionEvent.CONNECTION_CLOSED );
		event.setConnectionHandle( this );
		m_mc.sendEvent( event );
	}

	@Override
	public boolean equals(Object obj) {
		LOG.info( this + "#equals( {} )", obj );
		return super.equals(obj);
	}
}
