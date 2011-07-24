/*
 * Copyright 2011, Stuart Douglas
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.fakereplace.integration.weld;


import org.fakereplace.api.IntegrationInfo;
import org.fakereplace.transformation.FakereplaceTransformer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WeldIntegrationInfo implements IntegrationInfo {

    public String getClassChangeAwareName() {
        return "org.fakereplace.integration.weld.ClassRedefinitionPlugin";
    }

    public Set<String> getIntegrationTriggerClassNames() {
        return Collections.singleton("org.jboss.weld.bootstrap.WeldBootstrap");
    }

    public Set<String> getTrackedInstanceClassNames() {
        Set<String> ret = new HashSet<String>();
        ret.add("org.jboss.weld.bean.proxy.ClientProxyProvider");
        return ret;
    }

    public FakereplaceTransformer getTransformer() {
        return new WeldClassTransformer();
    }

    public byte[] loadClass(String className) {
        return null;
    }

}
