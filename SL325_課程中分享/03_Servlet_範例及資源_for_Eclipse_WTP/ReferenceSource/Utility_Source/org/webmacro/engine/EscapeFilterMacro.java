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

package org.webmacro.engine;

import org.webmacro.*;
import org.webmacro.util.HTMLEscaper;
import java.io.IOException;

/**
 * Filter macro that html escapes another macro.
 * This macro uses HTMLEscaper's escape method
 * to filter another macro. It will evaluate
 * the source macro, call toString() on the
 * resulting object and return the escaped string.
 **/
class EscapeFilterMacro implements Macro {
  final private Macro _m;

  /**
   * Create a new filter macro filtering m
   * @param m source macro to filter
   **/
  public EscapeFilterMacro(Macro m) {
    _m = m;
  }

  /**
   * Evaluate this macro.
   * This will be done by first evaluating
   * the source macro, calling toString() on
   * the resulting object and return the escaped
   * string.
   * @param c context to evaluate against
   * @return html escaped string
   **/
  public Object evaluate(Context c) throws PropertyException {
    Object o = _m.evaluate(c);
    return (o != null) ? HTMLEscaper.escape(o.toString()) : null;
  }
  
  /**
   * Write evaluated object to out.
   * @param out writer to write to
   * @param c context to evaluate against
   **/
  public void write(FastWriter out,Context c)
    throws IOException,PropertyException {
    out.write(evaluate(c).toString());
  }
}
        
    
