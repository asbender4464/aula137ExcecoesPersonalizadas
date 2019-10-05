package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;
import modelo.excecoes.DominioExcecao;

//Esta � a vers�o FINAL.

public class ProgramaDeReservas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("N�mero do quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data da entrada (dd/mm/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data da sa�da (dd/mm/yyyy): ");
			Date dataSaida = sdf.parse(sc.next());
			
			Reservas reservas = new Reservas(quarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reservas);
		
			System.out.println();
			System.out.println("Informe os dados da atualiza��o da reserva: ");
			System.out.print("Data da entrada (dd/mm/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data da sa�da (dd/mm/yyyy): ");
			dataSaida = sdf.parse(sc.next());
	
			reservas.atualDatas(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reservas);
		}
		catch (ParseException e1) { //Trata o problema do "sdf.parse", o qual o compilador reclamaria.
			System.out.println("Formato da data � inv�lido!");
		}
		catch (DominioExcecao e1) {
			//Note que "e1.getMessage()" abaixo captura � mensagem que digitada como alerta no caso da exce��o.
			System.out.println("Erro na reserva: " + e1.getMessage()); 
		}
		/*
		 * O 'catch' abaixo captura "QUALQUER ERRO INESPERADO", e por conseguinte n�o tratado,
		 * imprime a mensagem definida no c�digo e encerra o programa, n�o deixando o mesmo "quebrar".
		 * Isso tamb�m � um caso/exemplo de UPCASTING.
		 */
		catch (RuntimeException e1) {
			System.out.println("Ooops! Ocorreu um erro inesperado!");
		}
		sc.close();
	}
}
