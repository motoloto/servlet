/*
 * @(#)MediaTracker.java	1.14 95/12/14 Jim Graham
 *
 * Copyright (c) 1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package Acme;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

class ImageMediaEntry extends MediaEntry implements ImageObserver {
    Image image;
    int width;
    int height;

    ImageMediaEntry(MediaTracker mt, Image img, int c, int w, int h) {
	super(mt, c);
	image = img;
	width = w;
	height = h;
    }

    Object getMedia() {
	return image;
    }

    void startLoad() {
	if ( tracker.compTarget != null )
	    if (tracker.compTarget.prepareImage(image, width, height, this)) {
		setStatus(COMPLETE);
	    }
	else
	    if (tracker.tkTarget.prepareImage(image, width, height, this)) {
		setStatus(COMPLETE);
	    }
    }

    public boolean imageUpdate(Image img, int infoflags,
			       int x, int y, int w, int h) {
	if ((infoflags & ERROR) != 0) {
	    setStatus(ERRORED);
	} else if ((infoflags & ABORT) != 0) {
	    setStatus(ABORTED);
	} else if ((infoflags & (ALLBITS | FRAMEBITS)) != 0) {
	    setStatus(COMPLETE);
	}
	return true;
    }
}
