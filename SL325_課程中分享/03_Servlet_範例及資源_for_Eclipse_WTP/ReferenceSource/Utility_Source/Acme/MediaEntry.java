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

abstract class MediaEntry {
    MediaTracker tracker;
    int ID;
    MediaEntry next;

    int status;

    MediaEntry(MediaTracker mt, int id) {
	tracker = mt;
	ID = id;
    }

    abstract Object getMedia();

    static MediaEntry insert(MediaEntry head, MediaEntry me) {
	MediaEntry cur = head;
	MediaEntry prev = null;
	while (cur != null) {
	    if (cur.ID > me.ID) {
		break;
	    }
	    prev = cur;
	    cur = cur.next;
	}
	me.next = cur;
	if (prev == null) {
	    head = me;
	} else {
	    prev.next = me;
	}
	return head;
    }

    int getID() {
	return ID;
    }

    abstract void startLoad();

    static final int LOADING = MediaTracker.LOADING;
    static final int ABORTED = MediaTracker.ABORTED;
    static final int ERRORED = MediaTracker.ERRORED;
    static final int COMPLETE = MediaTracker.COMPLETE;

    static final int LOADSTARTED = (LOADING | ERRORED | COMPLETE);
    static final int DONE = (ABORTED | ERRORED | COMPLETE);

    synchronized int getStatus(boolean doLoad) {
	if (doLoad && ((status & LOADSTARTED) == 0)) {
	    status = (status & ~ABORTED) | LOADING;
	    startLoad();
	}
	return status;
    }

    void setStatus(int flag) {
	synchronized (this) {
	    status = flag;
	}
	tracker.setDone();
    }
}

