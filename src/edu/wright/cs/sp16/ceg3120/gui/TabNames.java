package edu.wright.cs.sp16.ceg3120.gui;

/**
 * Created by Sam on 2/13/2016.'
 * Enums for our Tab Names for clarity in code
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
            return "New Connction";
        }
    },
    BackupExport {
        @Override
        public String toString() {
            return "Backup\\Export";
        }
    },
    Start {
        @Override
        public String toString() {
            return "Start Page";
        }
    }
}