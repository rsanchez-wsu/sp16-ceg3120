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

package edu.wright.cs.sp16.ceg3120.gui.other;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Comparator;

import javax.swing.AbstractAction;
import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * Created by kenton on 4/4/16.
 */
public class AutoComplete implements DocumentListener {

	/**
	 * enum for the mode.
	 * @author kenton
	 *
	 */
	private enum Mode {
		INSERT, COMPLETION
	}

	private JEditorPane editorPane;
	private ArrayList<String> keywords;
	private Mode mode = Mode.INSERT;

	/**
	 * constructor for the autocomplete functionality.
	 * 
	 * @param editorPane
	 *            jeditiorpane that you want autocomplete for
	 * @param keywords
	 *            list of words to be completed
	 */
	public AutoComplete(JEditorPane editorPane, ArrayList<String> keywords) {
		this.editorPane = editorPane;
		this.keywords = keywords;
		this.keywords.sort(new ArrayListCompare());
	}

	/**
	 * this is the comparator used for sorting the keyword arraylist.
	 */
	private static class ArrayListCompare implements Comparator<String>, Serializable {
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(String string1, String string2) {
			return string1.compareTo(string2);
		}
	}

	/**
	 * default method from document listener.
	 * 
	 * @param ev
	 *            documentevent
	 */
	@Override
	public void changedUpdate(DocumentEvent ev) {
	}

	/**
	 * default method from document listener.
	 * 
	 * @param ev
	 *            documentevent
	 */
	@Override
	public void removeUpdate(DocumentEvent ev) {
	}

	/**
	 * default method from document listener. this is where we find the match to
	 * autocomplete the word
	 * 
	 * @param event
	 *            documentevent
	 */
	@Override
	public void insertUpdate(DocumentEvent event) {
		if (event.getLength() != 1) {
			return;
		}

		// gets the entire string in the jeditorpane
		int pos = event.getOffset();
		String content = null;
		try {
			content = editorPane.getText(0, pos + 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		// makes sure that the char or chars are actually chars
		int word;
		for (word = pos; word >= 0; word--) {
			if (!Character.isLetter(content.charAt(word))) {
				break;
			}
		}

		if (pos - word < 2) {
			return;
		}
		// test for the autocomplete
		String prefix = content.substring(word + 1);
		int index = Collections.binarySearch(keywords, prefix);
		if (index < 0 && -index <= keywords.size()) {
			// completion found
			String match = keywords.get(-index - 1);
			if (match.startsWith(prefix)) {
				String completion = match.substring(pos - word);
				SwingUtilities.invokeLater(new CompletionTask(completion, pos + 1));
			}
		} else {
			mode = Mode.INSERT;
		}
	}

	/**
	 * gets the editor pane ready to be editing.
	 */
	public class CommitAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		/**
		 * the action event for the commit.
		 * 
		 * @param event
		 *            this is an action event
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if (mode == Mode.COMPLETION) {
				int pos = editorPane.getSelectionEnd();
				StringBuffer sb = new StringBuffer(editorPane.getText());
				sb.insert(pos, " ");
				editorPane.setText(sb.toString());
				editorPane.setCaretPosition(pos + 1);
				mode = Mode.INSERT;
			} else {
				editorPane.replaceSelection("\t");
			}
		}
	}

	/**
	 * complete the insert for the autocompletion.
	 */
	private class CompletionTask implements Runnable {
		private String completion;
		private int position;

		/**
		 * constructor for the completion task.
		 * 
		 * @param completion
		 *            string
		 * @param position
		 *            position
		 */
		CompletionTask(String completion, int position) {
			this.completion = completion;
			this.position = position;
		}

		/**
		 * method that completes the autocomplete.
		 */
		public void run() {
			StringBuffer sb = new StringBuffer(editorPane.getText());
			sb.insert(position, completion);
			editorPane.setText(sb.toString());
			editorPane.setCaretPosition(position + completion.length());
			editorPane.moveCaretPosition(position);
			mode = Mode.COMPLETION;
		}
	}
}
