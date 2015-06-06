// Nnrpd - multi-threaded proxying NNRP daemon
//
// Copyright (C) 1996 by Jef Poskanzer <jef@acme.com>.  All rights reserved.
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

package Acme.Nnrpd;

import java.io.*;
import java.util.*;
import java.net.*;
import Acme.Utils;
import Acme.Fmt;
import Acme.Syslog;
import Acme.SyslogException;
import Acme.TimeKiller;

/// Multi-threaded proxying NNRP daemon.
// <P>
// This is a replacement for the standard C nnrpd.  Sites with lots
// of readers have found that running a separate nnrpd for each reader
// puts a tremendous load on the system.  All that memory, all those
// context switches.  This solves both problems by having a single
// process service multiple readers simultaneously.
// <P>
// Optionally, you can also use this as an NNRP proxy, connecting to
// a remote nnrpd instead of getting articles from the local disk.
// <P>
// Logging is via syslog, and is compatible with the standard nnrpd logging.
// <P>
// <A HREF="/resources/classes/Acme/Nnrpd/Nnrpd.java">Fetch the software.</A><BR>
// <A HREF="/resources/classes/Acme.tar.Z">Fetch the entire Acme package.</A>

public class Nnrpd
    {

    private static final String progName = "Nnrpd";

    /// Main routine, if you want to run this directly as an application.
    public static void main( String[] args )
	{
	// Parse args.
	int port = NnrpdUtils.DEFAULT_PORT;
	int aCacheSize = NnrpdUtils.DEFAULT_ACACHESIZE;
	int maxArtSize = NnrpdUtils.DEFAULT_MAXARTSIZE;
	int oCacheSize = NnrpdUtils.DEFAULT_OCACHESIZE;
	String proxyHost = null;
	boolean debug = false;
	int argc = args.length;
	int argn;
	for ( argn = 0; argn < argc && args[argn].charAt( 0 ) == '-'; ++argn )
	    {
	    if ( args[argn].equals( "-p" ) && argn + 1 < argc )
		{
		++argn;
		port = Utils.parseInt( args[argn], -1 );
		if ( port == -1 )
		    usage();
		}
	    else if ( args[argn].equals( "-a" ) && argn + 1 < argc )
		{
		++argn;
		aCacheSize = Utils.parseInt( args[argn], -1 );
		if ( aCacheSize == -1 )
		    usage();
		}
	    else if ( args[argn].equals( "-o" ) && argn + 1 < argc )
		{
		++argn;
		oCacheSize = Utils.parseInt( args[argn], -1 );
		if ( oCacheSize == -1 )
		    usage();
		}
	    else if ( args[argn].equals( "-h" ) && argn + 1 < argc )
		{
		++argn;
		proxyHost = args[argn];
		}
	    else if ( args[argn].equals( "-d" ) )
		debug = true;
	    else
		usage();
	    }
	if ( argn != argc )
	    usage();

	try
	    {
	    // Create the server.
	    Nnrpd nnrpd = new Nnrpd(
		port, aCacheSize, maxArtSize, oCacheSize, proxyHost, debug );

	    // And run.
	    nnrpd.serve();
	    }
	catch ( NnrpdException e )
	    {
	    System.err.println( e );
	    System.exit( 1 );
	    }

	System.exit( 0 );
	}

    private static void usage()
	{
	System.err.println(
	    "usage:  " + progName +
	    " [-p port] [-a art-cachesize] [-o ov-cachesize] [-h proxyhost]" );
	System.err.println( "" );
	System.err.println( "  port:" );
	System.err.println(
	    "    Normally netnews servers run on port " + NnrpdUtils.DEFAULT_PORT + ", which is where the" );
	System.err.println(
	    "    readers look for them.  You can run this on a different port if" );
	System.err.println(
	    "    you like, perhaps for debugging." );
	System.err.println( "  art-cachesize:" );
	System.err.println( "    How many bytes of articles to cache.  Default is " + NnrpdUtils.DEFAULT_ACACHESIZE + "." );
	System.err.println( "  ov-cachesize:" );
	System.err.println(
	    "    How many overview entries to cache.  Default is " + NnrpdUtils.DEFAULT_OCACHESIZE + "." );
	System.err.println( "  proxyhost:" );
	System.err.println(
	    "    The remote news server to connect to, for proxy mode.  Syntax" );
	System.err.println(
	    "    is a hostname, or hostname:port for ports other than " + NnrpdUtils.DEFAULT_PORT + "." );
	System.err.println( "" );
	System.err.println( "For more information see the web page," );
	System.err.println( NnrpdUtils.serverUrl );
	System.exit( 1 );
	}


    private int port;
    private int aCacheSize;
    private int maxArtSize;
    private int oCacheSize;
    private String proxyHost;
    private boolean debug;

    private Syslog syslog;
    private NewsDb newsDb;
    private ArticleCache articleCache;
    private boolean newsDbPostingOk;

    /// Constructor.
    // @param port Normally netnews servers run on port 119, which is where the readers look for them.  You can run this on a different port if you like, perhaps for debugging.
    // @param aCacheSize How many bytes of articles to cache.
    // @param maxArtSize Articles larger than this do not get cached at all.
    // @param oCacheSize How many overview entries to cache.
    // @param proxyHost The remote news server to connect to, for proxy mode.  Syntax is a hostname, or hostname:port for ports other than 119.
    // @param debug Whether to emit debugging syslogs or just dump them.
    // @exception NnrpdException if something goes wrong
    public Nnrpd( int port, int aCacheSize, int maxArtSize, int oCacheSize, String proxyHost, boolean debug ) throws NnrpdException
	{
	this.port = port;
	this.aCacheSize = aCacheSize;
	this.maxArtSize = maxArtSize;
	this.oCacheSize = oCacheSize;
	this.proxyHost = proxyHost;
	this.debug = debug;

	try
	    {
	    syslog = new Syslog( progName, 0, Syslog.LOG_NEWS );
	    }
	catch ( SyslogException e )
	    {
	    throw new NnrpdException( "can't initialize syslog: " + e );
	    }

	articleCache = new ArticleCache( aCacheSize, maxArtSize );

	try
	    {
	    if ( proxyHost != null )
		newsDb = new ProxyNewsDb( proxyHost, oCacheSize );
	    else
		newsDb = new LocalNewsDb( oCacheSize );
	    newsDbPostingOk = newsDb.getPostingOk();
	    }
	catch ( NewsDbException e )
	    {
	    throw new NnrpdException( "problem initializing news db: " + e );
	    }
	}


    /// Run the server.  Returns only on errors.
    // @exception NnrpdException if something goes wrong
    public void serve() throws NnrpdException
	{
	ServerSocket serverSocket;
	try
	    {
	    serverSocket = new ServerSocket( port, 1000 );
	    }
	catch ( IOException e )
	    {
	    error( "problem getting server socket: " + e );
	    return;
	    }

	try
	    {
	    while ( true )
		{
		try
		    {
		    Socket socket = serverSocket.accept();
		    new NnrpdSession(
			this, newsDb, newsDbPostingOk, articleCache, socket );
		    }
		catch ( IOException e )
		    {
		    if ( ! e.getMessage().endsWith( "Interrupted system call" ) )
			throw e;
		    }
		}
	    }
	catch ( IOException e )
	    {
	    error( "problem doing accept: " + e );
	    }
	finally
	    {
	    try
		{
		serverSocket.close();
		}
	    catch ( IOException ignore ) {}
	    }
	}


    void debug( String message ) throws NnrpdException
	{
	if ( debug )
	    log( Syslog.LOG_DEBUG, message );
	}

    void info( String message ) throws NnrpdException
	{
	log( Syslog.LOG_INFO, message );
	}

    void notice( String message ) throws NnrpdException
	{
	log( Syslog.LOG_NOTICE, message );
	}

    void warning( String message ) throws NnrpdException
	{
	log( Syslog.LOG_WARNING, message );
	}

    void error( String message ) throws NnrpdException
	{
	log( Syslog.LOG_ERR, message );
	}

    void crit( String message ) throws NnrpdException
	{
	log( Syslog.LOG_CRIT, message );
	}

    void alert( String message ) throws NnrpdException
	{
	log( Syslog.LOG_ALERT, message );
	}

    void emerg( String message ) throws NnrpdException
	{
	log( Syslog.LOG_EMERG, message );
	}

    private void log( int priority, String message ) throws NnrpdException
	{
	try
	    {
	    syslog.syslog( priority, message );
	    }
	catch ( SyslogException e )
	    {
	    throw new NnrpdException( "syslog problem: " + e );
	    }
	}

    }


