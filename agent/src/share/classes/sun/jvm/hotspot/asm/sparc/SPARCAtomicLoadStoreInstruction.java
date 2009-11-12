/*
 * Copyright 2002 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 */

package sun.jvm.hotspot.asm.sparc;

import sun.jvm.hotspot.asm.*;

public abstract class SPARCAtomicLoadStoreInstruction extends SPARCInstruction
                        implements LoadInstruction, StoreInstruction {
    final protected SPARCRegisterIndirectAddress addr;
    final protected SPARCRegister rd;
    final protected Register[] regs = new Register[1];
    final protected String description;

    public SPARCAtomicLoadStoreInstruction(String name, SPARCRegisterIndirectAddress addr, SPARCRegister rd) {
        super(name);
        this.addr = addr;
        this.rd = rd;
        regs[0] = rd;
        description = initDescription();
    }

    private String initDescription() {
        StringBuffer buf = new StringBuffer();
        buf.append(getName());
        buf.append(spaces);
        buf.append(addr.toString());
        buf.append(comma);
        buf.append(rd.toString());
        return buf.toString();
    }

    public Address getLoadSource() {
        return addr;
    }

    public Address getStoreDestination() {
        return addr;
    }

    public Register[] getLoadDestinations() {
        return regs;
    }

    public Register[] getStoreSources() {
        return regs;
    }

    public boolean isLoad() {
        return true;
    }

    public boolean isStore() {
        return true;
    }

    public String asString(long currentPc, SymbolFinder symFinder) {
        return description;
    }
}
