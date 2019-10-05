package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	//Atributos
	private Integer quarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	//SimpleDateFormat definido como 'static' de modo a ser instanciado s� uma vez, e n�o para cada
	//'objeto' Reservas que a aplica��o tiver.
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Construtores
	public Reservas() {
	}
	
	public Reservas(Integer quarto, Date dataEntrada, Date dataSaida) {
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	
	//GETs e SEts
	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	//SET 'exclu�do'. N�o permitir mudan�a da data via "SET".
	//public void setDataEntrada(Date dataEntrada) {
	//	this.dataEntrada = dataEntrada;
	//}

	public Date getDataSaida() {
		return dataSaida;
	}

	//SET 'exclu�do'. N�o permitir mudan�a da data via "SET".
	//public void setDataSaida(Date dataSaida) {
	//	this.dataSaida = dataSaida;
	//}
	
	//M�todos. CUIDADO: aqui h� muita informa��o �til!
	
	//Artif�cio: m�todo definido do tipo "long" porque a 'data' ser� convertida para MILISEGUNDOS.
	//Este m�todo calcular� a diferen�a entre duas datas, em dias.
	
	public long duracao() {
		//Calculando a diferen�a de datas em milisegundos.
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		//Convertendo esta diferen�a para DIAS.
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	//Este m�todo 'atualizar�' as datas de entrada e de sa�da da reserva.
	
	public void atualDatas (Date dataEntrada, Date dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	//Implementando o 'ToString', tratando-o como uma 'sobreposi��o', o que de fato ele �.
	@Override
	public String toString() {
		return "Quarto: "
				+ quarto
				+ ", Data de entrada: "
				+ sdf.format(dataEntrada)
				+ ", Data de sa�da: "
				+ sdf.format(dataSaida)
				+ ", "
				+ duracao() //Chamada do m�todo 'duracao' aqui!
				+ " noites.";
	}
	
}
