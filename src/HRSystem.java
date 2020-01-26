import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.oops.hrScanner.HRScanner;

public class HRSystem {
	public static void main(String[] args) throws IOException {
		BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
	    HRScanner.readData(bfreader);
	}

}
