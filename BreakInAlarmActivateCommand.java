package application;

//Activates Break In Alarm, Concrete Command
public class BreakInAlarmActivateCommand implements Command{
	private BreakInAlarm breakInAlarm;
    public BreakInAlarmActivateCommand ( BreakInAlarm ba) {
            breakInAlarm=  ba;
    }
    public void execute(String line, String value) {
            breakInAlarm.activate(line, value);
            return;
    }
}
