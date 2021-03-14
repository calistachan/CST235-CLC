package utilities;

public class AppLogger {

	public static void info(String message) {
		System.out.println("[INFO] " + message);
	}
	
	public static void warning(String message) {
		System.out.println("[WARN] " + message);
	}
	
	public static void error(Exception e) {
		e.printStackTrace();
	}
}
