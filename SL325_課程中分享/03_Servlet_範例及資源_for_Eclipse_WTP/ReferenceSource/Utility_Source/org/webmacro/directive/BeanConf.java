/*
 * Copyright (C) 1998-2001 Semiotek Inc.  All Rights Reserved.
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

/**
 * NOTE: this class is highly experimental at this point.
 * Use at your own risk!
 */

import java.io.*;
import java.util.*;
import org.webmacro.*;
import org.webmacro.engine.*;
import org.webmacro.resource.*;
import org.webmacro.util.Settings;
import org.webmacro.servlet.WebContext;

class BeanConf {
    static Map globalBeans = new HashMap(20);
    Map appBeans = new HashMap(20);
    List impliedPackages;
    List allowedPackages;

    public BeanConf(Broker b){
        String s = b.getSetting("BeanDirective.ImpliedPackages");
        impliedPackages = Arrays.asList(org.webmacro.servlet.TextTool.split(s, ","));
        s = b.getSetting("BeanDirective.AllowedPackages");
        allowedPackages = Arrays.asList(org.webmacro.servlet.TextTool.split(s, ","));
    }
}
