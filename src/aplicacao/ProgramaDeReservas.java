package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;

//IMPORTANTE: esta solu��o � considerada MUITO RUIM porque a 'valida��o das datas' est� DENTRO da Classe Principal,
//enquanto deveria estar na "Classe Reservas". Lembra-te: POO! E o objeto � a 'reserva'!
//Trata-se de um problema grave de DELEGA��O. Quem deve saber sobre a RESERVA � a pr�pria RESERVA.

public class ProgramaDeReservas {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("N�mero do quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data da entrada (dd/mm/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data da sa�da (dd/mm/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
		
			//Testando se a 'data de entrada' n�o � posterior � 'data de sa�da'.
			//NOTA: observe a fun��o "booleana" que testa se uma data � posterior a outra ou n�o ("v" ou "f")
			if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro na reserva: a data de sa�da precisa ser AP�S a data de entrada!");
			}
			else { //Somenta ap�s a valida��o das datas a Classe 'Reservas' � instanciada.
				Reservas reservas = new Reservas(quarto, dataEntrada, dataSaida);
				System.out.println("Reserva: " + reservas); //Sobreposto por String toString
			
		System.out.println();
		System.out.println("Informe os dados da atualiza��o da reserva: ");
		System.out.print("Data da entrada (dd/mm/yyyy): ");
		dataEntrada = sdf.parse(sc.next());
		System.out.print("Data da sa�da (dd/mm/yyyy): ");
		dataSaida = sdf.parse(sc.next());
		
		//Chamando o m�todo para atualiza��o de datas "atualDatas", definido na Classe Reservas.
		String erro = reservas.atualDatas(dataEntrada, dataSaida);
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {
			System.out.println("Reserva: " + reservas); //Sobreposto por String toString
			}
		}
		sc.close();
	}
}
