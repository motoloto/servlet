// Psg - a PostScript-like alternative to the Graphics class
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

package Acme;

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;

// Test class.

class PsgTest extends Applet
    {

        // Called when the applet is first created.
    public void init()
        {
        setBackground( Color.white );
        }

    // Called when the applet should paint itself.
    public void paint( Graphics graphics )
	{
	try
	    {
	    Psg psg = new Psg( this );
	    psg.gsave();
		psg.translate( 50, 50 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.stroke();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 150, 50 );
		psg.rotate( 30 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.stroke();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 250, 50 );
		psg.rotate( 30 );
		psg.scale( 1.5, 1.5 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.stroke();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 50, 150 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.fill();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 150, 150 );
		psg.rotate( 30 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.fill();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 250, 150 );
		psg.rotate( 30 );
		psg.scale( 1.5, 1.5 );
		psg.newpath();
		squarePath( psg, 50 );
		psg.fill();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 50, 250 );
		psg.newpath();
		psg.arc( 25, 25, 25, 0, 360 );
		psg.stroke();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 150, 250 );
		psg.newpath();
		psg.arc( 25, 25, 25, 0, 360 );
		psg.fill();
	    psg.grestore();
	    psg.gsave();
		psg.translate( 250, 250 );
		psg.moveto( 0, 0 );
		psg.curveto( 0, 50, 50, 50, 50, 0 );
		psg.stroke();
	    psg.grestore();
	    }
	catch ( PsgException e )
	    {
	    System.err.println( e );
	    System.exit( 1 );
	    }
	}

    private void squarePath( Psg psg, int size ) throws PsgException
	{
	psg.moveto( 0, 0 );
	psg.rlineto( size, 0 );
	psg.rlineto( 0, size );
	psg.rlineto( -size, 0 );
	psg.closepath();
	}

    }
