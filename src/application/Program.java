package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		List<Contribuinte> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers:");
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company(i/c)?");
			char ch = scan.next().charAt(0);
			System.out.print("Name:");
			scan.nextLine();
			String nome = scan.nextLine();
			System.out.print("Anual income: ");
			double rendaAtual = scan.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures:");
				double saude = scan.nextDouble();
				list.add(new PessoaFisica(nome, rendaAtual, saude));
			} else {
				System.out.print("Nuber of employees:");
				int numFunc = scan.nextInt();
				list.add(new PessoaJuridica(nome, rendaAtual, numFunc));
			}

		}

		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID: ");

		for (Contribuinte contribuinte : list) {
			double taxaImp = contribuinte.taxaImp();
			System.out.println(contribuinte.getNome() + ": $ " + String.format("%.2f", taxaImp));
			sum += taxaImp;
		}

		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);

		scan.close();
	}
}
