import java.util.Random;

/*Create a method to calculate the price of a pizza and return it as a double. The
method should take at least 3 parameters: Size, toppings, and crust style. Create an
app which makes 3 pizzas and describes them at the console
 */
public class hw4 {
	public static double price(int size, int toppings, int crust) {
		double[] price = new double[3];
		price[0] = 8;
		price[1] = 12;
		price[2] = 16;
		double[] style = new double[3];
		style[0] = 0;
		style[1] = 1;
		style[2] = 2;
		double p = price[size] + toppings + style[crust];
		return p;
	}

	public static void main(String[] args) {
		int numpizza = 3;
		Random r = new Random();
		int size[] = new int[numpizza];
		int toppings[] = new int[numpizza];
		int crust[] = new int[numpizza];
		for (int i = 0; i < numpizza; i++) {
			size[i] = r.nextInt(3);
			crust[i] = r.nextInt(3);
			toppings[i] = r.nextInt(7);
		}
		for (int i = 0; i < numpizza; i++) {
			if(size[i]==0) {
				System.out.print("small");
			} else if(size[i]==0) {
				System.out.print("medium");
			} else {
				System.out.print("large");
			}
			System.out.print(" pizza with "+toppings[i]+" toppings and crust style ");
			if(crust[i]==0) {
				System.out.print("thin");
			} else if(crust[i]==0) {
				System.out.print("thick");
			} else {
				System.out.print("deep dish");
			}
			System.out.println(". total price is "+String.format("$%.2f",price(size[i],toppings[i],crust[i])));
		}
	}

}
