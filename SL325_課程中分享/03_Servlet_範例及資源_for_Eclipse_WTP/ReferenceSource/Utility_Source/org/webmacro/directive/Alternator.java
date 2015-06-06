/*
 * Copyright (C) 1998-2000 Semiotek Inc.  All Rights Reserved.  
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted under the terms of either of the following
 * Open Source licenses:
 *
 * The GNU General Public License, version 2, or any later version, as
 * published by the Free Software Foundation
 * (http://www.fsf.org/copyleft/gpl.html);
 *
 *  or 
 *
 * The Semiotek Public License (http://webmacro.org/LICENSE.)  
 *
 * This software is provided "as is", with NO WARRANTY, not even the 
 * implied warranties of fitness to purpose, or merchantability. You
 * assume all risks and liabilities associated with its use.
 *
 * See www.webmacro.org for more information on the WebMacro project.  
 */

package org.webmacro.directive;

import java.io.*;
import org.webmacro.*;
import org.webmacro.engine.*;

class Alternator implements Macro { 
  private Object[] list;
  private int index = 0;

  public Alternator(Object[] list) {
    this.list = list;
  }

  public void write(FastWriter out, Context context) 
    throws PropertyException, IOException {
    Object o = evaluate(context);
    if (o != null) 
      out.write(o.toString());
  }

  public Object evaluate(Context context) {
    Object o = list[index++];
    if (index == list.length)
      index = 0;
    return o;
  }
}

