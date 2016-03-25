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

/**
 * Created by Sam on 2/13/2016.' Enums for our Tab Names for clarity in code
 */
public enum TabNames {

	Connection {
		@Override
		public String toString() {
			return "Connection";
		}
	},
	Help {
		@Override
		public String toString() {
			return "Help Page";
		}
	},
	NewConnection {
		@Override
		public String toString() {
			return "New Connection";
		}
	},
	BackupExport {
		@Override
		public String toString() {
			return "Backup/Export";
		}
	},
	Start {
		@Override
		public String toString() {
			return "Start Page";
		}
	}
}