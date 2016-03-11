/*
 * Copyright (C) 2016
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.sp16.ceg3120;

import java.util.EnumSet;
import java.util.HashMap;

/**
 * Enums to keep track of input variables more easily.
 * @author Nick Madden
 *
 */
public enum Inputs {
	alias(0) {
		@Override
		public String toString() {
			return "Alias Name";
		}
	},
	dbName(1) {
		@Override
		public String toString() {
			return "Database Name";
		}
	},
	dbUrl(2) {
		@Override
		public String toString() {
			return "Database URL";
		}
	},
	username(3) {
		@Override
		public String toString() {
			return "Username";
		}
	},
	password(4) {
		@Override
		public String toString() {
			return "Password";
		}
	},
	save(5) {
		@Override
		public String toString() {
			return "Save Password?";
		}
	},
	driver(6) {
		@Override
		public String toString() {
			return "Driver";
		}
	},
	autoCon(7) {
		@Override
		public String toString() {
			return "Connect on Startup?";
		}
	},;
	
	private int id;
	private static final HashMap<Integer, Inputs> lookup = new HashMap<Integer, Inputs>();
	
	/** Constructor for enum.
	 * 
	 * @param nid // ID of enum.
	 */
	private Inputs(int nid) {
		this.id = nid;
	}

	static {
		for (Inputs s : EnumSet.allOf(Inputs.class)) {
			lookup.put(s.getId(), s);
		}
	}

	/** Gets the id of an enum.
	 * 
	 * @return // Id of enum.
	 */
	public int getId() {
		return id;
	}

	/** Looks for value of enum by id.
	 * 
	 * @param id // Id to lookup.
	 * @return // Value of enum.
	 */
	public static Inputs get(int id) {
		return lookup.get(id);
	}
}
