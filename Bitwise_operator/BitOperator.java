import java.text.SimpleDateFormat;
import java.util.*;

public class BitOperator {

	public static void main(String[] args) {
		
		long num = 5;
		
		System.out.println(Long.toBinaryString(num));

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		long epochTime = 297616116568L;
		
		long timeInMillis =System.currentTimeMillis();
		
		Date timeInDate = new Date(timeInMillis);
		String timeInFormat = sdf.format(timeInDate);
		
		Date timeInDate1 = new Date(epochTime);
		String timeInFormat1 = sdf.format(timeInDate1);
		 
		System.out.println(epochTime);
		System.out.println(timeInMillis);
		
		System.out.println(timeInFormat);
		System.out.println(timeInFormat1);
		
	}

}
