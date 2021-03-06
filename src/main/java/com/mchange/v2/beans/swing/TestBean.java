/*
 * Distributed as part of mchange-commons-java 0.2.11
 *
 * Copyright (C) 2015 Machinery For Change, Inc.
 *
 * Author: Steve Waldman <swaldman@mchange.com>
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of EITHER:
 *
 *     1) The GNU Lesser General Public License (LGPL), version 2.1, as 
 *        published by the Free Software Foundation
 *
 * OR
 *
 *     2) The Eclipse Public License (EPL), version 1.0
 *
 * You may choose which license to accept if you wish to redistribute
 * or modify this work. You may offer derivatives of this work
 * under the license you have chosen, or you may provide the same
 * choice of license which you have been offered here.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received copies of both LGPL v2.1 and EPL v1.0
 * along with this software; see the files LICENSE-EPL and LICENSE-LGPL.
 * If not, the text of these licenses are currently available at
 *
 * LGPL v2.1: http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 *  EPL v1.0: http://www.eclipse.org/org/documents/epl-v10.php 
 * 
 */

package com.mchange.v2.beans.swing;

import java.beans.*;

public class TestBean
{
    String s;
    int    i;
    float  f;

    PropertyChangeSupport pcs = new PropertyChangeSupport( this );

    public String getTheString()
    { return s; }

    public int getTheInt()
    { return i; }

    public float getTheFloat()
    { return f; }

    public void setTheString( String new_s )
    {
	if (! eqOrBothNull( new_s, s ) )
	    {
		String old_s = s;
		this.s = new_s;
		pcs.firePropertyChange( "theString", old_s, s );
	    }
    }

    public void setTheInt( int new_i )
    {
	if ( new_i != i )
	    {
		int old_i = i;
		i = new_i;
		pcs.firePropertyChange( "theInt", old_i, i );
	    }
    }

    public void setTheFloat( float new_f )
    {
	if ( new_f != f )
	    {
		float old_f = f;
		f = new_f;
		pcs.firePropertyChange( "theFloat", new Float(old_f), new Float(f) );
	    }
    }

    public void addPropertyChangeListener( PropertyChangeListener pcl )
    { pcs.addPropertyChangeListener( pcl ); }
    
    public void removePropertyChangeListener( PropertyChangeListener pcl )
    { pcs.removePropertyChangeListener( pcl ); }

    private boolean eqOrBothNull( Object a, Object b )
    {
	return
	    a == b ||
	    (a != null && a.equals(b));
    }
}

