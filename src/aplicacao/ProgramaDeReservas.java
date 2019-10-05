package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;

//IMPORTANTE: esta solução é considerada MUITO RUIM porque a 'validação das datas' está DENTRO da Classe Principal,
//enquanto deveria estar na "Classe Reservas". Lembra-te: POO! E o objeto é a 'reserva'!
//Trata-se de um problema grave de DELEGAÇÃO. Quem deve saber sobre a RESERVA é a própria RESERVA.

public class ProgramaDeReservas {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data da entrada (dd/mm/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data da saída (dd/mm/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
		
			//Testando se a 'data de entrada' não é posterior à 'data de saída'.
			//NOTA: observe a função "booleana" que testa se uma data é posterior a outra ou não ("v" ou "f")
			if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro na reserva: a data de saída precisa ser APÓS a data de entrada!");
			}
			else { //Somenta após a validação das datas a Classe 'Reservas' é instanciada.
				Reservas reservas = new Reservas(quarto, dataEntrada, dataSaida);
				System.out.println("Reserva: " + reservas); //Sobreposto por String toString
			
		System.out.println();
		System.out.println("Informe os dados da atualização da reserva: ");
		System.out.print("Data da entrada (dd/mm/yyyy): ");
		dataEntrada = sdf.parse(sc.next());
		System.out.print("Data da saída (dd/mm/yyyy): ");
		dataSaida = sdf.parse(sc.next());
		
		//Chamando o método para atualização de datas "atualDatas", definido na Classe Reservas.
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
