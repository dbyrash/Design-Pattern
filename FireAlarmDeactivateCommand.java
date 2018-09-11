package application;

//Deactivates Fire Alarm acts as Concrete Command
public class FireAlarmDeactivateCommand implements Command{
	private FireAlarm fireAlarm;
    public FireAlarmDeactivateCommand ( FireAlarm fa) {
            fireAlarm=  fa;
    }
    public void execute(String line, String value) {
            fireAlarm. deactivate(line);
      
    }
}
