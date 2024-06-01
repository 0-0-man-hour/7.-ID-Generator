import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class IdGenerator {
	
	 private static final long TWEPOCH = 1288834974657L;
	

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		StringBuilder sb = new StringBuilder();
		
		//현재 시각 milliSeconds로 얻고 binary로 변환
		long timestamp = getCurrentTimeStamp();
        String binaryTimeStamp = timeStampToBit(timestamp);

        //확인작업 (다시 timeStampe로 바꿨을때 잘 나오는지 확인)
        bitToTimeStamp(binaryTimeStamp);

       
        
//        sb.append(timestamp).append(serverId).append(serverId).append(serialNum);
        
        
        
        
        
        System.out.println(Long.toBinaryString(TWEPOCH));
        
        Date timeInDate = new Date(TWEPOCH);
        String timeInFormat = sdf.format(timeInDate);
        
        System.out.println(timeInFormat);
        
        String last41 = "11111111111111111111111111111111111111111";
        

        int a = 5;
		
		String b = Integer.toBinaryString(a);
		
		System.out.println(b);
		
		String c = "1001";
		
		int d = 1001;
		
		System.out.println(Integer.toString(d));
		
		

		
	}
	
	// Get TimeStampe
	private static long getCurrentTimeStamp () {
		
	    //사용할 zone 아이디 값.
        ZoneId zoneid = ZoneId.of("Asia/Seoul");

        //#1. 현재 시간의 값 밀리세컨드 변환
        long timestamp = LocalDateTime.now().atZone(zoneid).toInstant().toEpochMilli();
        
        return timestamp;
		
	}
	
	// TimeStamp to Bit
	private static String timeStampToBit(long timestamp) {
		
		//변환
		String timeBinary = Long.toBinaryString(timestamp);
		
		//Console 출력
		System.out.println("현재 시각 milliSeconds는 다음과 같습니다: " + timestamp);
		System.out.println("현재 시각(milliseconds)를 Binary로 바꾸면 다음과 같습니다: " + timeBinary);
		System.out.println("Binary의 길이는 다음과 같습니다: " + timeBinary.length());
        
        return timeBinary;
	}
	
	
	// Bit to TimeStamp
	public static long bitToTimeStamp(String binaryTime) {
		
		// Binary로 되어 있던걸 다시 timestamp로 변환
		long timestamp = Long.parseLong(binaryTime, 2); 
        
        System.out.println("Binary를 역변환하면 다음과 같습니다: " + timestamp);
        
        return timestamp;
		
	}
	
	
	// And Operator
	
	
	// Or Operator
	
	
	// XOR Operator
	
	
	// Not Operator
	
	
	// Shift Operator
	
}
