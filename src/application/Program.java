package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CadastroAnuncio;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<CadastroAnuncio> list = new ArrayList<>();

		try {
			System.out.println("Digite o nome do anuncio a ser cadastrado: ");
			String nomeDoAnuncio = sc.nextLine();
			System.out.println("Diginte cliente: ");
			String cliente = sc.nextLine();
			System.out.println("Data de início do anúncio (dd/mm/yyyy): ");
			Date dataDeInicio = sdf.parse(sc.next());
			sc.nextLine();
			System.out.println("Data de término do anúncio (dd/mm/yyyy): ");
			Date dataDeTermino = sdf.parse(sc.next());
			sc.nextLine();
			System.out.println("Investimento por dia: ");
			double investimentoPorDia = sc.nextDouble();

			CadastroAnuncio cadastroAnuncio = new CadastroAnuncio(nomeDoAnuncio, cliente, dataDeInicio, dataDeTermino, investimentoPorDia);
			System.out.println(cadastroAnuncio);
		} 
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (InputMismatchException e) {
			System.out.println("Erro nos dados de entrada");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}

}
