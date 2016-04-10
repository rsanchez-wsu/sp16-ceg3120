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

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/**
 * Utilities for xml parsing.
 *
 */
public final class XmlUtil {
	/**
	 * Private constructor for utility class.
	 */
	private XmlUtil() {
	}

	/**
	 * Wraps a NodeList as a List collection. Useful for foreach loops.
	 * 
	 * 
	 * @param nl
	 *            NodeList
	 * @return NodeList as List
	 */
	public static List<Node> asList(NodeList nl) {
		return nl.getLength() == 0 ? Collections.<Node>emptyList() : new NodeListWrapper(nl);
	}

	/**
	 * List wrapper for NodeList.
	 */
	static final class NodeListWrapper extends AbstractList<Node> implements RandomAccess {
		private final NodeList list;

		/**
		 * Wraps a NodeList as a List
		 * 
		 * @param nl
		 *            NodeList.
		 */
		NodeListWrapper(NodeList nl) {
			list = nl;
		}

		@Override
		public Node get(int index) {
			return list.item(index);
		}

		@Override
		public int size() {
			return list.getLength();
		}
	}
}