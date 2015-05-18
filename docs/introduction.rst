Introduction
============

This site is intended to serve as an introduction to JCA 1.6 (otherwise known as `JSR 322 - JavaTM EE Connector Architecture 1.6 <https://jcp.org/aboutJava/communityprocess/final/jsr322/index.html>`_).

What is JCA?
------------

JCA (Java Connector Architecture) is one of the standard set of features JEE compliant runtime containers must support.

JCA gives a resource adapter developer a way to package a set of classes and native libraries that allows any JEE application container to interact with an Enterprise Information Systems.

In addition to being a convenient way to deliver code required to access remote systems JCA also specifies ways
to accomplish the following tasks.

  * Properly deal with threads in Web applications.
		*Allocating threads in Web applications that use EJBs is not allowed by the spec.  Using Resource Adapters, however,
		developers can make use of resource adapter WorkManager objects to submit work to be executed
		in a background thread.  This is compelling because it*
		
		*a) allows the container to maintain tight control over the number of threads devoted to user code, and*
		
		*b) provides more robust resource adapter & container life cycle event handling (start up & shutdown).*
		
		*More on this later.*
		
  * Participate in container managed transactions.
		*This feature allows developers to gracefully handle error scenarios where one of multiple resource adapters or 
		EJBs participating in transaction fails.  Basically if any RA or EJB throws an exception during a transaction
		the entire transaction will be rolled back by the container.*
		
		*User code must be written in such a way to allow for this to happen cleanly.*
		

  * Support connection pooling.
		*This is also cool.*

  * Reuse container managed user security principals for interacting with remote resources.
		*This is also cool.*

