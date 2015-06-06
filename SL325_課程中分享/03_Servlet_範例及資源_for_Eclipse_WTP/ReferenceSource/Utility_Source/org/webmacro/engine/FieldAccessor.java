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
  * An accessor that knows how to get/set from a field
  */
final class FieldAccessor extends Accessor
{
   private Field _field;

   FieldAccessor(final Field f) {
      super(f.getName());
      _field = f;
   }

   final Object get(final Object instance)
      throws PropertyException
   {
      try {
         return _field.get(instance);
      } catch (Exception e) {
         throw new PropertyException("Unable to read field " + _field +
               " on object " + instance + " of " + instance.getClass(),
               e);
      }
   }

   final boolean set(final Object instance, final Object value)
      throws PropertyException
   {
      try {
         _field.set(instance,value);
      } catch (Exception e) {
         throw new PropertyException("Unable to write field " + _field +
               " on object " + instance + " of " + instance.getClass(),
               e);
      }
      return true;
   }
}


