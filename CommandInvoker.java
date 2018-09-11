package application;

import java.io.File;


//invoker for command pattern
public class CommandInvoker {
	
	private Command activateCommand, deactivateCommand;
        public CommandInvoker( Command act, Command deact) {
                activateCommand= act; 
                deactivateCommand= deact;
        }
        //executes active command
        public void setActive(String value, String line) { 
                        activateCommand.execute (value, line) ;                           
        }
        
        //executes deactive command
        public void setDeactivate(String value, String line) {
                        deactivateCommand.execute (value, line);
        }
}
