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
import java.util.*;
import java.io.*;
import org.webmacro.util.*;
import org.webmacro.*;


public final class QuotedStringBuilder extends Vector implements Builder
{

   final public Object build(BuildContext bc) throws BuildException 
   {
      StringBuffer str = new StringBuffer(100);
      QuotedString qs = new QuotedString();

      Enumeration enum = elements();

      while (enum.hasMoreElements()) {
         Object txt = enum.nextElement();
     
         if (txt instanceof Builder) {
            txt = ((Builder) txt).build(bc);
         }

         if (txt instanceof String) {
            str.append(txt);
         } else {
            qs.addElement(str.toString());
            qs.addElement(txt);
            str.setLength(0);
         }
      }
      if (str.length() > 0) {
         qs.addElement(str.toString());
      }

      if (qs.size() == 1) {
         return qs.elementAt(0);
      } else {
         return qs;
      }
   }
}


