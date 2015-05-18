# jca1.6-demo [![Build Status](https://travis-ci.org/greglanthier/jca1.6-demo.svg?branch=master)](https://travis-ci.org/greglanthier/jca1.6-demo) [![Documentation Status](https://readthedocs.org/projects/jca16-demo/badge/)](http://jca16-demo.readthedocs.org/en/latest/index.html)

A first step towards experimenting with JCA in Liberty Profile using tutorials like
[Introduction to the J2EE Connector Architecture](http://www.ibm.com/developerworks/java/tutorials/j-jca/j-jca.html)
written by Willy Farrell.

To run this build locally you need to set an environment variable called LIBERTY_LICENSE to the value you obtain from [here](http://public.dhe.ibm.com/ibmdl/export/pub/software/websphere/wasdev/downloads/wlp/8.5.5.4/lafiles/runtime/en.html).  This ensures you accept the terms and conditions for the WebSphere Liberty Profile container.

The value for the LIBERTY_LICENSE variable you need is next to the  string **L/N** in the agreement.

For example:

    lappy:jca-parent greg$ pwd
    /Users/lanthieg/Documents/source/git/jca-parent
    lappy:jca-parent greg$ export LIBERTY_LICENSE=L-JTXX-XXXXXX
    lappy:jca-parent greg$ mvn clean verify
    ...
    [INFO] Scanning for projects...
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Build Order:
    [INFO] 
    [INFO] JCA 1.6 Demo Project Parent
    [INFO] JCA 1.6 Demo Echo Resource Adapter
    [INFO] JCA 1.6 Demo Web Project
    [INFO] JCA 1.6 Demo Project Deployed to Liberty Profile
    [INFO]                                                                         
    [INFO] ------------------------------------------------------------------------
    ...
    INFO] Stopping server defaultServer.
    [INFO] Server defaultServer stopped.
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] JCA 1.6 Demo Project Parent ........................ SUCCESS [  1.050 s]
    [INFO] JCA 1.6 Demo Echo Resource Adapter ................. SUCCESS [ 13.486 s]
    [INFO] JCA 1.6 Demo Web Project ........................... SUCCESS [  2.475 s]
    [INFO] JCA 1.6 Demo Project Deployed to Liberty Profile ... SUCCESS [02:24 min]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 02:42 min
    [INFO] Finished at: 2015-05-18T15:46:37-04:00
    [INFO] Final Memory: 22M/53M
    [INFO] ------------------------------------------------------------------------
    lappy:jca-parent greg$ 
