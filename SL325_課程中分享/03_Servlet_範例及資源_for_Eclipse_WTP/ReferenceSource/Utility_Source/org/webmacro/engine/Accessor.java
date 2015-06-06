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

// helper classes


/**
  * An accessor represents one particular operation that can be 
  * performed on one particular class: getting/setting a field, or 
  * getting/setting via a method.
  */
abstract class Accessor {

   private String _name;

   Accessor(String name) {
      _name = name;
   }

   final String  getName() {
      return _name;
   }

   public final String toString() {
      return "Accessor:" + _name;
   }
 
   /**
     * Unary get
     */
   Object get(Object instance) 
      throws PropertyException, NoSuchMethodException
   {
      throw new PropertyException("BUG in PropertyOperator.java!");
   }

   /**
     * Unary set
     */
   boolean set(Object instance, Object value) 
      throws PropertyException, NoSuchMethodException
   {
      throw new PropertyException("BUG in PropertyOperator.java!");
   }

   /**
     * Binary get
     */
   Object get(Object instance, String subName) 
      throws PropertyException, NoSuchMethodException
   {
      throw new PropertyException("BUG in PropertyOperator.java!");
   }

   /**
     * Binary
     */
   boolean set(Object instance, String subName, Object value)
      throws PropertyException, NoSuchMethodException
   {
      throw new PropertyException("BUG in PropertyOperator.java!");
   }


   /**
     * Direct get
     */
   Object get(Object instance, Object[] args)
      throws PropertyException, NoSuchMethodException
   {
      throw new PropertyException("BUG in PropertyOperator.java!");
   }

}


