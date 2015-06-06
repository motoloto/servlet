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

abstract class MethodAccessor extends Accessor
{
   protected Method _getMethod;           // only one get method allowed
   private Method[] _setMethods = null; // may be multiple set methods
   private Class[]  _setParams = null;  // variable arg type for set meth N
   private Class[]  _setPrimitiveType = null;
   private int setCount = 0;            // how many set methods do we have

   abstract int numArgsGet();
   abstract int numArgsSet();

   MethodAccessor(final String name, final Method m, final Class[] params) 
      throws PropertyException
   {
      super(name);
      addMethod(m,params);
   }

   private Class getWrapperClass(Class s) {
      if (s == Integer.TYPE)
         return Integer.class;
      else if (s == Boolean.TYPE)
         return Boolean.class;
      else if (s == Character.TYPE)
         return Character.class;
      else if (s == Long.TYPE)
         return Long.class;
      else if (s == Short.TYPE)
         return Short.class;
      else if (s == Double.TYPE)
         return Double.class;
      else if (s == Float.TYPE)
         return Float.class;
      else if (s == Void.TYPE)
         return Void.class;
      else if (s == Byte.TYPE)
         return Byte.class;
      else 
         return null;
   }

   final void addMethod(final Method m, Class[] params) 
      throws PropertyException
   {

      final int setArgsLength = numArgsSet();
      final int getArgsLength = numArgsGet();

      if (params.length == getArgsLength) {
         _getMethod = m;
      } else if (params.length == setArgsLength) {
         setCount++;
         if (_setMethods == null) {
            _setMethods = new Method[1];
            _setParams = new Class[1];
            _setPrimitiveType = new Class[1];
         } else if (_setMethods.length <= setCount) {
            Method[] tmpMethods  = new Method[ (setCount + 1) * 2 ];
            Class[] tmpParams    = new Class[(setCount + 1) * 2 ];
            Class[] tmpPrimitive = new Class[(setCount + 1) * 2 ];
            System.arraycopy(_setMethods,0,tmpMethods,0,_setMethods.length);
            System.arraycopy(_setParams,0,tmpParams,0,_setParams.length);
            System.arraycopy(_setPrimitiveType,0,tmpPrimitive,0,_setParams.length);
            _setMethods = tmpMethods;
            _setParams = tmpParams;
            _setPrimitiveType = tmpPrimitive;
         }

         // record the method, and the type of the variable parameter
         _setMethods[setCount - 1] = m;
         _setParams[setCount - 1] = params[setArgsLength - 1];
         if (_setParams[setCount-1].isPrimitive())
            _setPrimitiveType[setCount-1] 
               = getWrapperClass(_setParams[setCount-1]);

      } else {
         throw new PropertyException("PropertyOperator FAILED for method " 
               + m + "--please report this bug!");
      }
   }

   final boolean setImpl(final Object inst, final Object[] args) 
      throws PropertyException, NoSuchMethodException
   {
      //which method to use? check params for first match
      for (int i = 0; i < setCount; i++) {
         Object arg = args[args.length - 1];
         // XXX: null values are blocked by the next line
         if (_setParams[i].isPrimitive()) {
            if (arg.getClass() == _setPrimitiveType[i]) {
               try {
                  PropertyOperator.invoke(_setMethods[i],inst,args);
                  return true;
               } catch (Exception e){
                  // ignore exception
               }
            }
         }
         else if (arg == null 
                  || _setParams[i].isInstance(args[args.length - 1])) {
            PropertyOperator.invoke(_setMethods[i],inst,args);
            return true;
         }
      }
      return false;
   }

}

