import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* Use BigDecimal math to calculate the overhead rate using the data in the table above by
averaging the Ex3 over a 3 month period. The overhead rate can be found by dividing
average indirect Ex3 by average direct Ex3. Display your result (either at the console or
in a JLabel) as a percentage with two decimal places. (Note: the correct answer is
26.27%). */

public class Ex3 {

	BigDecimal[] direct = new BigDecimal[3];
	BigDecimal[] indirect = new BigDecimal[3];
	Ex3() {
		direct[0] = new BigDecimal(44900);
		direct[1] = new BigDecimal(43720);
		direct[2] = new BigDecimal(45201);
		indirect[0] = new BigDecimal(11290);
		indirect[1] = new BigDecimal(9206);
		indirect[2] = new BigDecimal(14660);
		BigDecimal directSum = new BigDecimal(0);
		BigDecimal indirectSum = new BigDecimal(0);
		for(int i=0; i<direct.length;i++) {
			directSum = directSum.add(direct[i]);
			indirectSum = indirectSum.add(indirect[i]);
		}
		BigDecimal avgDirect = directSum.divide(new BigDecimal(3),3,RoundingMode.HALF_EVEN);
		BigDecimal avgIndirect = indirectSum.divide(new BigDecimal(3),3,RoundingMode.HALF_EVEN);
		NumberFormat f = new DecimalFormat("$#0.00");
		System.out.println("Direct Avg Equals "+f.format(avgDirect.doubleValue()));
		System.out.println("Indirect Avg Equals "+f.format(avgIndirect.doubleValue()));
		BigDecimal Overhead = avgIndirect;
		Overhead = Overhead.divide(avgDirect,3,RoundingMode.HALF_EVEN);
//		Overhead = Overhead.multiply(new BigDecimal(100));
		NumberFormat p = new DecimalFormat("#0.00%");
		System.out.println("Overhead equals "+p.format(Overhead.doubleValue()));
	}
	public static void main(String[] args) {
		Ex3 Ex3 = new Ex3();
	}
}