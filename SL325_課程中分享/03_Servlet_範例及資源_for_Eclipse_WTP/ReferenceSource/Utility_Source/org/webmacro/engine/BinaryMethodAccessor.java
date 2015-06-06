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

final class BinaryMethodAccessor extends MethodAccessor
{
   
   BinaryMethodAccessor(String name, Method m, Class[] params) 
      throws PropertyException
   {      
      super( name,m,params);
   }

   final int numArgsGet() {
      return 1;
   }

   final int numArgsSet() {
      return 2;
   }

   final Object get(final Object instance, String prop)
      throws PropertyException, NoSuchMethodException
   {
      Object[] args = new Object[1];
      args[0] = prop;
      return PropertyOperator.invoke(_getMethod,instance,args);      
   }

   final boolean set(final Object instance, String prop, Object value)
      throws PropertyException, NoSuchMethodException
   {
      Object[] args = new Object[2];
      args[0] = prop;
      args[1] = value;
      return setImpl(instance,args);
   }
}
