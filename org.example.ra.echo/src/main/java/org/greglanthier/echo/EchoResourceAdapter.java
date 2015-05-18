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
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.resource.spi.work.WorkManager;
import javax.transaction.xa.XAResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Connector
public class EchoResourceAdapter implements ResourceAdapter {

	private static final transient Logger LOG = LoggerFactory.getLogger( EchoResourceAdapter.class );

	public static final String JNDI_NAME = "eis/echo";

	@SuppressWarnings("unused")
	private WorkManager m_workManager;

	@Override
	public void start( final BootstrapContext ctx )
			throws ResourceAdapterInternalException {
		LOG.info( "start" );
		m_workManager = ctx.getWorkManager();
	}

	@Override
	public void stop() {
		LOG.info( "stop" );
	}

	@Override
	public void endpointActivation( MessageEndpointFactory endpointFactory,
			ActivationSpec spec ) throws ResourceException {
		LOG.info( "endpointActivation" );
	}

	@Override
	public void endpointDeactivation( MessageEndpointFactory endpointFactory,
			ActivationSpec spec ) {
		LOG.info( "endpointDeactivation" );
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] specs)
			throws ResourceException {
		LOG.info( "getXAResources" );
		return null;
	}

}
