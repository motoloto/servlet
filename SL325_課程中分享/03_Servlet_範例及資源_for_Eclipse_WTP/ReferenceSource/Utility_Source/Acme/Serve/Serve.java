// Serve - minimal Java HTTP server class
//
// Copyright (C)1996,1998 by Jef Poskanzer <jef@acme.com>. All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
//    notice, this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
// OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
// OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE.
//
// Visit the ACME Labs Java page for up-to-date versions of this and other
// fine Java utilities: http://www.acme.com/java/

package Acme.Serve;

import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;
import Acme.Serve.servlet.*;
import Acme.Serve.servlet.http.*;

/// Minimal Java HTTP server class.
// <P>
// This class implements a very small embeddable HTTP server.
// It runs Servlets compatible with the API used by JavaSoft's
// <A HREF="http://java.sun.com/products/java-server/">JavaServer</A> server.
// It comes with default Servlets which provide the usual
// httpd services, returning files and directory listings.
// <P>
// This is not in any sense a competitor for JavaServer.
// JavaServer is a full-fledged HTTP server and more.
// Acme.Serve is tiny, about 1500 lines, and provides only the
// functionality necessary to deliver an Applet's .class files
// and then start up a Servlet talking to the Applet.
// They are both written in Java, they are both web servers, and
// they both implement the Servlet API; other than that they couldn't
// be more different.
// <P>
// This is actually the second HTTP server I've written.
// The other one is called
// <A HREF="http://www.acme.com/software/thttpd/">thttpd</A>,
// it's written in C, and is also pretty small although much more
// featureful than this.
// <P>
// Other Java HTTP servers:
// <UL>
// <LI> The above-mentioned <A HREF="http://java.sun.com/products/java-server/">JavaServer</A>.
// <LI> W3C's <A HREF="http://www.w3.org/pub/WWW/Jigsaw/">Jigsaw</A>.
// <LI> David Wilkinson's <A HREF="http://www.netlink.co.uk/users/cascade/http/">Cascade</A>.
// <LI> Yahoo's <A HREF="http://www.yahoo.com/Computers_and_Internet/Software/Internet/World_Wide_Web/Servers/Java/">list of Java web servers</A>.
// </UL>
// <P>
// A <A HREF="http://www.byte.com/art/9706/sec8/art1.htm">June 1997 BYTE magazine article</A> mentioning this server.<BR>
// A <A HREF="http://www.byte.com/art/9712/sec6/art7.htm">December 1997 BYTE magazine article</A> giving it an Editor's Choice Award of Distinction.<BR>
// <A HREF="/resources/classes/Acme/Serve/Serve.java">Fetch the software.</A><BR>
// <A HREF="/resources/classes/Acme.tar.Z">Fetch the entire Acme package.</A>
// <P>
// @see Acme.Serve.servlet.http.HttpServlet
// @see FileServlet
// @see CgiServlet

public class Serve implements ServletContext
    {

    private static final String progName = "Serve";

    /// Main routine, if you want to run this directly as an application.
    public static void main( String[] args )
	{
	// Parse args.
	int port = 9090;
	String throttles = null;
	int argc = args.length;
	int argn;
	for ( argn = 0; argn < argc && args[argn].charAt( 0 ) == '-'; ++argn )
	    {
	    if ( args[argn].equals( "-p" ) && argn + 1 < argc )
		{
		++argn;
		port = Integer.parseInt( args[argn] );
		}
	    else if ( args[argn].equals( "-t" ) && argn + 1 < argc )
		{
		++argn;
		throttles = args[argn];
		}
	    else
		usage();
	    }
	if ( argn != argc )
	    usage();

	// Create the server.
	Serve serve = new Serve( port );

	// Any custom Servlets should be added here.
	serve.addServlet( "/SampleServlet", new Acme.Serve.SampleServlet() );
	Servlet ts = new Acme.Serve.TestServlet();
	serve.addServlet( "/TestServlet", ts );
	serve.addServlet( "/TestServlet/*", ts );

	// And add the standard Servlets.
	if ( throttles == null )
	    serve.addDefaultServlets( true );
	else
	    try
		{
		serve.addDefaultServlets( true, throttles );
		}
	    catch ( IOException e )
		{
		System.err.println( "Problem reading throttles file: " + e );
		System.exit( 1 );
		}

	// And run.
	serve.serve();

	System.exit( 0 );
	}

    private static void usage()
	{
	System.err.println( "usage:  " + progName + " [-p port]" );
	System.exit( 1 );
	}


    private int port;
    private PrintStream logStream;
    Acme.WildcardDictionary registry;

    /// Constructor.
    public Serve( int port, PrintStream logStream )
	{
	this.port = port;
	this.logStream = logStream;
	registry = new Acme.WildcardDictionary();
	}

    /// Constructor, default log stream.
    public Serve( int port )
	{
	this( port, System.err );
	}

    /// Constructor, default port and log stream.
    // We don't use 80 as the default port because we don't want to
    // encourage people to run a Java web server as root because Java
    // currently has no way of giving up root privs!  Instead, the
    // current default port is 9090.
    public Serve()
	{
	this( 9090, System.err );
	}


    /// Register a Servlet by class name.  Registration consists of a URL
    // pattern, which can contain wildcards, and the class name of the Servlet
    // to launch when a matching URL comes in.  Patterns are checked for
    // matches in the order they were added, and only the first match is run.
    public void addServlet( String urlPat, String className )
	{
	// See if we have already instantiated this one.
	Servlet servlet = (Servlet) servlets.get( className );
	if ( servlet != null )
	    {
	    addServlet( urlPat, servlet );
	    return;
	    }

	// Check if we're allowed to make one of these.
	SecurityManager security = System.getSecurityManager();
	if ( security != null )
	    {
	    int i = className.lastIndexOf( '.' );
	    if ( i != -1 )
		{
		security.checkPackageAccess(
		    className.substring( 0, i ) );
		security.checkPackageDefinition(
		    className.substring( 0, i ) );
		}
	    }

	// Make a new one.
	try
	    {
	    servlet = (Servlet) Class.forName( className ).newInstance();
	    addServlet( urlPat, servlet );
	    return;
	    }
	catch ( ClassNotFoundException e )
	    {
	    log( "Class not found: " + className );
	    }
	catch ( ClassCastException e )
	    {
	    log( "Class cast problem: " + e.getMessage() );
	    }
	catch ( InstantiationException e )
	    {
	    log( "Instantiation problem: " + e.getMessage() );
	    }
	catch ( IllegalAccessException e )
	    {
	    log( "Illegal class access: " + e.getMessage() );
	    }
	catch ( Exception e )
	    {
	    log( "Unexpected problem creating servlet: " + e );
	    }
	}

    /// Register a Servlet.  Registration consists of a URL pattern,
    // which can contain wildcards, and the Servlet to
    // launch when a matching URL comes in.  Patterns are checked for
    // matches in the order they were added, and only the first match is run.
    public void addServlet( String urlPat, Servlet servlet )
	{
	try
	    {
	    servlet.init( new ServeConfig( (ServletContext) this ) );
	    registry.put( urlPat, servlet );
	    servlets.put( servlet.getClass().getName(), servlet );
	    }
	catch ( ServletException e )
	    {
	    log( "Problem initializing servlet: " + e );
	    }
	}

    /// Register a standard set of Servlets.  These will return
    // files or directory listings, and run CGI programs, much like a
    // standard HTTP server.
    // <P>
    // Because of the pattern checking order, this should be called
    // <B>after</B> you've added any custom Servlets.
    // <P>
    // The current set of default servlet mappings:
    // <UL>
    // <LI> If enabled, *.cgi goes to CgiServlet, and gets run as a CGI program.
    // <LI> * goes to FileServlet, and gets served up as a file or directory.
    // </UL>
    // @param cgi whether to run CGI programs
    public void addDefaultServlets( boolean cgi )
	{
	if ( cgi )
	    addServlet( "*.cgi", new Acme.Serve.CgiServlet() );
	addServlet( "*", new Acme.Serve.FileServlet() );
	}

    /// Register a standard set of Servlets, with throttles.
    // @param cgi whether to run CGI programs
    // @param throttles filename to read FileServlet throttle settings from
    public void addDefaultServlets( boolean cgi, String throttles ) throws IOException
	{
	if ( cgi )
	    addServlet( "*.cgi", new Acme.Serve.CgiServlet() );
	addServlet( "*", new Acme.Serve.FileServlet( throttles ) );
	}


    /// Run the server.  Returns only on errors.
    public void serve()
	{
	ServerSocket serverSocket;
	try
	    {
	    serverSocket = new ServerSocket( port, 1000 );
	    }
	catch ( IOException e )
	    {
	    log( "Server socket: " + e );
	    return;
	    }

	try
	    {
	    while ( true )
		{
		Socket socket = serverSocket.accept();
		new ServeConnection( socket, this );
		}
	    }
	catch ( IOException e )
	    {
	    log( "Accept: " + e );
	    }
	finally
	    {
	    try
		{
		serverSocket.close();
		destroyAllServlets();
		}
	    catch ( IOException e ) {}
	    }
	}


    // Methods from ServletContext.

    protected Hashtable servlets = new Hashtable();

    /// Gets a servlet by name.
    // @param name the servlet name
    // @return null if the servlet does not exist
    public Servlet getServlet( String name )
	{
	return (Servlet) servlets.get( name );
	}

    /// Enumerates the servlets in this context (server). Only servlets that
    // are accesible will be returned.  This enumeration always includes the
    // servlet itself.
    public Enumeration getServlets()
	{
	return servlets.elements();
	}

    /// Enumerates the names of the servlets in this context (server). Only
    // servlets that are accesible will be returned.  This enumeration always
    // includes the servlet itself.
    public Enumeration getServletNames()
	{
	return servlets.keys();
	}

    /// Destroys all currently-loaded servlets.
    public void destroyAllServlets()
	{
	Enumeration en = servlets.elements();
	while ( en.hasMoreElements() )
	    {
	    Servlet servlet = (Servlet) en.nextElement();
	    servlet.destroy();
	    }
	servlets.clear();
	}

    /// Write information to the servlet log.
    // @param message the message to log
    public void log( String message )
	{
	Date date = new Date( System.currentTimeMillis() );
	logStream.println( "[" + date.toString() + "] " + message );
	}

    /// Write a stack trace to the servlet log.
    // @param exception where to get the stack trace
    // @param message the message to log
    public void log( Exception exception, String message )
	{
	// !!!
	log( message );
	}

    /// Applies alias rules to the specified virtual path and returns the
    // corresponding real path.  It returns null if the translation
    // cannot be performed.
    // @param path the path to be translated
    public String getRealPath( String path )
	{
	// No mapping.
	return path;
	}

    /// Returns the MIME type of the specified file.
    // @param file file name whose MIME type is required
    public String getMimeType( String file )
	{
	int lastDot = file.lastIndexOf( '.' );
	int lastSep = file.lastIndexOf( File.separatorChar );
	if ( lastDot == -1 ||
	     ( lastSep != -1 && lastDot < lastSep ) )
	    return "text/plain";
	String extension = file.substring( lastDot + 1 );
	if ( extension.equals( "html" ) || extension.equals( "htm" ) )
	    return "text/html";
	if ( extension.equals( "gif" ) )
	    return "image/gif";
	if ( extension.equals( "jpg" ) || extension.equals( "jpeg" ) )
	    return "image/jpeg";
	if ( extension.equals( "au" ) )
	    return "audio/basic";
	if ( extension.equals( "ra" ) || extension.equals( "ram" ) )
	    return "audio/x-pn-realaudio";
	if ( extension.equals( "wav" ) )
	    return "audio/wav";
	if ( extension.equals( "mpg" ) || extension.equals( "mpeg" ) )
	    return "video/mpeg";
	if ( extension.equals( "qt" ) || extension.equals( "mov" ) )
	    return "video/quicktime";
	if ( extension.equals( "class" ) )
	    return "application/octet-stream";
	if ( extension.equals( "ps" ) )
	    return "application/postscript";
	if ( extension.equals( "wrl" ) )
	    return "x-world/x-vrml";
	if ( extension.equals( "pac" ) )
	    return "application/x-ns-proxy-autoconfig";
	return "text/plain";
	}

    /// Returns the name and version of the web server under which the servlet
    // is running.
    // Same as the CGI variable SERVER_SOFTWARE.
    public String getServerInfo()
	{
	return ServeUtils.serverName + " " + ServeUtils.serverVersion +
	       " (" + ServeUtils.serverUrl + ")";
	}

    /// Returns the value of the named attribute of the network service, or
    // null if the attribute does not exist.  This method allows access to
    // additional information about the service, not already provided by
    // the other methods in this interface.
    public Object getAttribute( String name )
	{
	// This server does not support attributes.
	return null;
	}

    }


