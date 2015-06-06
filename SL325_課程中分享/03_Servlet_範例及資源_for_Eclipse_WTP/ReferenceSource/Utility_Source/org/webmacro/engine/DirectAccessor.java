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
import java.lang.reflect.*;

import org.webmacro.*;
import org.webmacro.util.*;
import org.webmacro.resource.*;

/**
  * accessor for direct method calls, rather than property-style
  */
final class DirectAccessor extends Accessor
{

   Vector _methods = new Vector();

   DirectAccessor(final String name, final Method m, final Class[] params)
   {
      super(name);
      addMethod(m,params);
   }

   final void addMethod(final Method m, Class[] params)
   {
      _methods.addElement(m);
   }


   final boolean matches(Class[] sig, Class[] args)
   {
      if (args.length != sig.length) 
         return false;

      try {
         for (int i = 0; i < sig.length; i++) {
            Class s = sig[i];
            Class a = args[i];
            if (s.isPrimitive()) {
               if ((s == Integer.TYPE && a == Integer.class) ||
                   (s == Boolean.TYPE && a == Boolean.class) || 
                   (s == Character.TYPE && a == Character.class) ||  
                   (s == Long.TYPE && a == Long.class) ||  
                   (s == Short.TYPE && a == Short.class) ||  
                   (s == Double.TYPE && a == Double.class) ||  
                   (s == Float.TYPE && a == Float.class) ||  
                   (s == Void.TYPE && a == Void.class) ||  
                   (s == Byte.TYPE && a == Byte.class)) 
                  continue;
               else
                  return false;
            }
            else if (a == null || s.isAssignableFrom(a)) 
               continue;
            else 
               return false;
         }
      }
      catch (NullPointerException e) {
         return false; // XXX: block nulls, isAssign... throws this
      }
      return true;
   }

   final Object get(Object instance, Object[] args)
      throws PropertyException, NoSuchMethodException
   {
      Class[] types = new Class[ args.length ];
      for (int i = 0; i < args.length; i++) {
         try {
            types[i] = args[i].getClass();
         } catch (NullPointerException e) {
            types[i] = null;
         }
      }

      for (int i = 0; i < _methods.size(); i++) {
         Method m = (Method) _methods.elementAt(i);
         Class[] sig = m.getParameterTypes();
         if (matches(sig,types)) {
            return PropertyOperator.invoke(m,instance,args);
         }
      }

      // not found

      StringBuffer msg = new StringBuffer();
      msg.append("No method ");
      msg.append(getName());
      msg.append("(");
      for (int i = 0; i < args.length; i++) {
         if (i > 0) {
            msg.append(",");
         }
         msg.append((args[i] == null) ? "null" : args[i].getClass().toString());
      }
      msg.append(") on object ");
      msg.append(instance);

      throw new PropertyException(msg.toString());
   }
   
}


