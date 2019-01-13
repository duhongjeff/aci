package commontools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import commontools.CommonEnums.DateFormat;

public class CPDateUtils {

	public static Long convertDateToInt(Date target, DateFormat dateFormat)
	{
		
		 String DATE_FORMAT = dateFormat.name();
		 SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
		return  Long.valueOf(sdf.format(target));
		
	}
	
	public static Date ConvertStringToDate(String target,String dateFormat) 
	{
		 SimpleDateFormat sdf =new SimpleDateFormat(dateFormat);
		 try {
			return sdf.parse(target);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}
}
