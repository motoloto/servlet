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

final public class PropertyOperatorCache { 

   private CacheManager _cache; 
   private Log _log;

   public PropertyOperatorCache() { 
   }
   
   final public void init(Broker b, Settings config) throws InitException
   {
      String cacheManager;

      _log = b.getLog("resource", "Object loading and caching");

      cacheManager = b.getSetting("PropertyOperator.CacheManager");
      if (cacheManager == null || cacheManager.equals("")) {
         _log.info("CachingProvider: No cache manager specified for PropertyOperator, using StaticSMapCacheManager");
         _cache = new StaticSMapCacheManager();
      }
      else {
         try {
            _cache = (CacheManager) b.classForName(cacheManager).newInstance();
         }
         catch (Exception e) {
            _log.warning("Unable to load cache manager " + cacheManager 
                         + " for PropertyOperator, using StaticSMapCacheManager.  Reason:\n" + e);
            _cache = new StaticSMapCacheManager();
         }
      }
      _cache.init(b, config, "PropertyOperator");
   }

   final public PropertyOperator getOperator(final Class type)
   throws PropertyException {   
      Object o = _cache.get(type);
      if (o == null) {
         PropertyOperator po = new PropertyOperator(type, this);
         _cache.put(type, po);
         return po;
      }
      else 
        return (PropertyOperator) o;
   }

   final public PropertyOperator getOperator(final Object obj)
   throws PropertyException {
       Class type = obj.getClass();
       // added code to handle static classes.  Static classes must be wrapped
       // in a StaticClassWrapper
       // 1Jun2001 - Keats
       if (type == org.webmacro.engine.StaticClassWrapper.class){
           type = ((org.webmacro.engine.StaticClassWrapper)obj).get();
       }
       return getOperator(type);
   }

   /**
     * Attempt to retrieve a property using the rules of property 
     * introspection described above. Begin reading names at position 
     * start in the array of names.
     * @param context is used to resolve sub-properties in arguments
     * @param instance is the root of introspection
     * @param names property names, one per array entry 
     * @return the property described by the names, inside the instance
     * @exception PropertyException the property we'd like to look at
     * @exception SecurityExeption you are not permitted to try
     */
   final public Object getProperty(final Context context, 
                                   final Object instance, 
                                   final Object[] names, 
                                   int start) 
   throws PropertyException, SecurityException {
      if (instance == null) {
         return null;
      } else {
         return getOperator(instance).getProperty(
            context,instance,names,start,names.length - 1);
      }
   }

   /**
     * Calls getProperty(context, instance, names, 0)
     */
   final public Object getProperty(final Context context, 
                                   final Object instance, 
                                   final Object[] names) 
   throws PropertyException, SecurityException {
      return getProperty(context, instance, names, 0);
   }


   /**
     * Given a property description name, attempt to set the property
     * value to the supplied object.
     * @param context An object containing a property
     * @param names The string names of that property 
     * @param value the new value the property is to be set to
     * @exception PropertyException not possible to set the property
     * @exception SecurityException you are not permitted to try
     */
   final public boolean setProperty(final Context context, 
                                    Object instance, 
                                    final Object[] names, 
                                    int start, 
                                    final Object value) 
   throws PropertyException, SecurityException {
      try {
         if (instance == null) {
            return false;
         }
         return getOperator(instance)
            .setProperty(context,instance,names,value,start);
      }
      catch (PropertyException e) {
         throw e;
      }
      catch (NoSuchMethodException e) {
         throw new PropertyException("No method to access property: " + e, e);
      }
   }
   
   /**
     * Calls setProperty(context, names, 0, value)
     */
   final public boolean setProperty(final Context context, 
                                    final Object instance, 
                                    final Object[] names, 
                                    final Object value) 
   throws PropertyException, SecurityException { 
      return setProperty(context,instance,names,0,value);
   }
 
   /**
     * Evaluate the supplied object and work out a way to return it 
     * as an iterator.
     * @param context an object believed to represent a list
     * @return an Iterator that iterates through that list
     * @exception PropertyException could not extract iterator from instance
     */
   final public Iterator getIterator(Object instance)
   throws PropertyException {
     if (instance instanceof Object[]) 
       return new ArrayIterator((Object[]) instance);
     else if (instance.getClass().isArray()) 
       return new PrimitiveArrayIterator(instance);
     else if (instance instanceof Iterator) 
       return (Iterator) instance;
     else if (instance instanceof Enumeration) 
       return new EnumIterator((Enumeration) instance);
     else 
       return getOperator(instance).findIterator(instance);
   }

}



