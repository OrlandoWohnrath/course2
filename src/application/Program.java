package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + i + "data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price:");
			Double price = sc.nextDouble();
			
			if (type == 'c') {
				list.add(new Product(name, price));
			}
			else if (type == 'i') {
				System.out.println("Custom fee:");
				Double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}
			else {
				System.out.println("Manufacture date (DD/MM/YYYY)");
				Date mDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, mDate));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
