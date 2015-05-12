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

@Connector
public class EchoResourceAdapter implements ResourceAdapter {

	@SuppressWarnings("unused")
	private WorkManager m_workManager;

	@Override
	public void start(BootstrapContext ctx)
			throws ResourceAdapterInternalException {
		System.out.println( "start: " + ctx );
		m_workManager = ctx.getWorkManager();
	}

	@Override
	public void stop() {
		System.out.println( "stop" );
	}

	@Override
	public void endpointActivation( MessageEndpointFactory endpointFactory,
			ActivationSpec spec ) throws ResourceException {
		System.out.println( "endpointActivation" );
	}

	@Override
	public void endpointDeactivation( MessageEndpointFactory endpointFactory,
			ActivationSpec spec ) {
		System.out.println( "endpointDeactivation" );
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] specs)
			throws ResourceException {
		System.out.println( "getXAResources" );
		return null;
	}

}
