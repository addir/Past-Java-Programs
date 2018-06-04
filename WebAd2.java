import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.JPanel;
//* include at least the following attributes: unitPrice (random BigDecimal), discountRate (random
//		 * BigDecimal between 0-50%), taxRate (static BigDecimal rate set by app), and adjustedPrice (
//		 * final BigDecimal price w/ discount and tax applied)

//The WebAd constructor should generate a random price for a new object along with a random
//* discount rate. Then, the constructor should calculate the adjusted price by applying the
//* discount and adding tax. Ideally, all calculations will be carried out in BigDecimal. Finally,
//* a description of the new WebAd object should be added to the JTable (using a getRow() )
//* or JList (using toString() ). Create new web ads using: WebAd ad = new WebAd()

public class WebAd2  extends JPanel{
BigDecimal unitPrice;
BigDecimal discountRate;
static BigDecimal taxRate;
BigDecimal adjustedPrice;
public static void settaxRate(BigDecimal tax) {
	taxRate = tax;
	taxRate = taxRate.divide(new BigDecimal(100));
}
public WebAd2() {
	Random ran = new Random();
	double price = (double)ran.nextInt(5000)/100.0 + 50.0;
	unitPrice = new BigDecimal(price);
	double discount = ran.nextInt(50);	
	discountRate = new BigDecimal(discount);
	discountRate = discountRate.divide(new BigDecimal(100));
	System.out.println(discountRate);
	adjustedPrice = new BigDecimal(price);
	BigDecimal discountbb = discountRate;
	discountbb = discountbb.multiply(unitPrice);
	adjustedPrice = adjustedPrice.subtract(discountbb);
	BigDecimal tax = adjustedPrice.multiply(taxRate);
	adjustedPrice = adjustedPrice.add(tax);
}
public BigDecimal getadjustedPrice() {
	return adjustedPrice;
}
@Override
public String toString() {
	final NumberFormat percentscaleformat = NumberFormat.getPercentInstance();
	percentscaleformat.setMaximumFractionDigits(2);
	return String.format( "%30s%60s%60s%60s", NumberFormat.getCurrencyInstance().format(unitPrice),
				NumberFormat.getPercentInstance().format(discountRate),
				percentscaleformat.format(taxRate),
				NumberFormat.getCurrencyInstance().format(adjustedPrice));

}
}
