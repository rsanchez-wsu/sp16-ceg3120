package edu.wright.cs.sp16.ceg3120;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		return nl.getLength() == 0 ? Collections.<Node> emptyList() : new NodeListWrapper(nl);
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