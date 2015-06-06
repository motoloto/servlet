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

class PsgMatrix extends Acme.GenericCloneable
    {
    public double xx, xy, yx, yy, tx, ty;

    public PsgMatrix()
	{
	// Initialize with the identity matrix.
	xx = 1.0;
	xy = 0.0;
	yx = 0.0;
	yy = 1.0;
	tx = 0.0;
	ty = 0.0;
	}
    
    public PsgMatrix multiply( PsgMatrix b )
	{
	PsgMatrix r = new PsgMatrix();
	r.xx = this.xx * b.xx + this.xy * b.yx;
	r.xy = this.xx * b.xy + this.xy * b.yy;
	r.yy = this.yx * b.xy + this.yy * b.yy;
	r.yx = this.yx * b.xx + this.yy * b.yx;
	r.tx = this.tx * b.xx + this.ty * b.yx + b.tx;
	r.ty = this.tx * b.xy + this.ty * b.yy + b.ty;
	return r;
	}
    
    public PsgMatrix invert() throws PsgException
	{
	PsgMatrix r = new PsgMatrix();
        double det = this.xx * this.yy - this.xy * this.yx;
	if ( det == 0.0 )
	  throw new PsgException( "undefined result" );
	r.xx = this.yy / det;
	r.xy = - this.xy / det;
	r.yx = - this.yx / det;
	r.yy = this.xx / det;
	r.tx = - ( this.tx * r.xx + this.ty * r.yx );
	r.ty = - ( this.tx * r.xy + this.ty * r.yy );
	return r;
	}
    }


