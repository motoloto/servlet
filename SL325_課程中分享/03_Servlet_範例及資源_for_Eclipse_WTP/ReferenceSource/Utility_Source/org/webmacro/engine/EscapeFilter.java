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
 * Directive that escape non-HTML characters properly in variables.
 * You can use this variable to set up a filter for a variable and
 * its sub-properties to change all non-HTML characters into their
 * correct encoded form (like quotation marks to &amp;quot;).
 * <br>
 * You can use the directive in your templates like this:<br>
 * <code>
 * #htmlescape $a
 * </code>
 * This will escape non-HTML characters in $a and all sub-properties
 * like $a.b, $a.b.c and so on.
 * @author skanthak@muehlheim.de
 **/

/**
 * Filter factory, that defines recursive behaviour
 * and provides filter macro.
 **/
public class EscapeFilter implements Filter {
  /**
   * Return this to indicate that we will recursively
   * filter sub-properties.
   * @param name name of property to filter
   * @return this
   **/
  public Filter getFilter(String name) {
    return this;
  }

  /**
   * Return a macro for filtering.
   * This will return a macro, that filters
   * source through HTMLEscaper.escape() method.
   * @param source macro to html escape
   * @return filter macro for source
   **/
  public Macro getMacro(Macro source) {
    return new EscapeFilterMacro(source);
  }
}

    
