package application;

//Deactivates Break In Alarm, Concrete Command
public class BreakInAlarmDeactivateCommand implements Command {
	private BreakInAlarm breakInAlarm;
    public BreakInAlarmDeactivateCommand (BreakInAlarm ba) {
            breakInAlarm = ba;
    }
  
	public void execute(String line, String value) {
            breakInAlarm.deactivate(line);
           
    }
}
