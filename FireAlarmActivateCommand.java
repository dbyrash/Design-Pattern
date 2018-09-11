package application;

//Activates Fire Alarm acts as Concrete Command
public class FireAlarmActivateCommand implements Command{
	private FireAlarm fireAlarm;
    public FireAlarmActivateCommand ( FireAlarm fa) {
            fireAlarm =  fa;
    }
    public void execute(String line, String value) {
            fireAlarm. activate(line, value);
 
    }
}
