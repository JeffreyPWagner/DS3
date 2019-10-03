package Server;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateProviderImpl implements DateProvider {

	@Override
	public String getDateOrCaps(String command) {
		if (command.equalsIgnoreCase("time")) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            return dateFormatter.format(Calendar.getInstance().getTime());
        } else if (command.equals("")) {
            return "closing connection";
        } else {
            return command.toUpperCase();
        }
	}
}
