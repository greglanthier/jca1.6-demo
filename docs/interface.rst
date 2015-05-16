Interfaces
==========

ResourceAdapter
---------------

.. uml::

	scale 3/3
	set namespaceSeparator .
	interface javax.resource.spi.ResourceAdapter <<Interface>> {
		+void **start**( BootstrapContext ctx ) throws ResourceAdapterInternalException;
		+void **endpointActivation**( MessageEndpointFactory endpointFactory, ActivationSpec spec ) throws ResourceException;
		+void **endpointDeactivation**( MessageEndpointFactory endpointFactory, ActivationSpec spec );
		+XAResource[] **getXAResources**( ActivationSpec[] specs ) throws ResourceException;
	}
    hide <<Interface>> circle
	
ManagedConnectionFactory
------------------------

.. uml::

	scale 3/3
	set namespaceSeparator .
	interface javax.resource.spi.ManagedConnectionFactory <<Interface>> {
		+Object **createConnectionFactory**( ConnectionManager cxManager ) throws ResourceException;
		+Object **createConnectionFactory**() throws ResourceException;
		+ManagedConnection **createManagedConnection**( Subject subject, ConnectionRequestInfo cxRequestInfo ) throws ResourceException;
		+ManagedConnection **matchManagedConnections**( Set connectionSet, Subject subject, ConnectionRequestInfo cxRequestInfo ) throws ResourceException;
		+void **setLogWriter**( PrintWriter out ) throws ResourceException;
		+PrintWriter **getLogWriter**() throws ResourceException;
		+int **hashCode**();
		+boolean **equals**( Object other );
	}
    hide <<Interface>> circle

ManagedConnection
-----------------

.. uml::

	scale 3/3
	set namespaceSeparator .
	interface ManagedConnection <<Interface>> {
		+Object **getConnection**( Subject subject, ConnectionRequestInfo cxRequestInfo ) throws ResourceException;
		+void **destroy**() throws ResourceException;
		+void **cleanup**() throws ResourceException;
		+void **associateConnection**( Object connection ) throws ResourceException;
		+void **addConnectionEventListener**( ConnectionEventListener listener );
		+void **removeConnectionEventListener**( ConnectionEventListener listener );
		+XAResource **getXAResource**() throws ResourceException;
		+LocalTransaction **getLocalTransaction**() throws ResourceException;
		+ManagedConnectionMetaData **getMetaData**() throws ResourceException;
		+void **setLogWriter**( PrintWriter out ) throws ResourceException;
		+PrintWriter **getLogWriter**() throws ResourceException;
	}
    hide <<Interface>> circle