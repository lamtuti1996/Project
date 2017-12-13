import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		String a = " bc as as";
		String b = URLEncoder.encode(a, "UTF-8");
		String c = URLEncoder.encode(b, "UTF-8");
		// String d=URLDecoder.decode(c, "UTF-8");
	/*	String str_date = "02-09-2017";
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = (Date) formatter.parse(str_date);
		java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
		System.out.println(timeStampDate);
*/
		String startDateString = "2017-08-29";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate;
	
		    startDate = df.parse(startDateString);
		   System.out.println(startDate.getDate());
		  
	
	}
}