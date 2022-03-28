package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {
	
	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		
		String path = "D:\\curso-java\\products.txt";
		List<Product> list = new ArrayList<>();
		
		boolean crtDir = new File("D:\\curso-java\\out").mkdir();
		String path2 = "D:\\curso-java\\out\\summary.txt";
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] product = line.split(",");
				String name = product[0];
				double price = Double.parseDouble(product[1]);
				int quantity = Integer.parseInt(product[2]);
				Product pdt = new Product(name, price, quantity);
				list.add(pdt);
				System.out.println(line);
				line = br.readLine();
			}
			System.out.println("------");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
				for(Product pdt : list) {
					bw.write(pdt.toString());
					bw.newLine();
				}
			}
			
	
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
