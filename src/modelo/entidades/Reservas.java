package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	//Atributos
	private Integer quarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	//SimpleDateFormat definido como 'static' de modo a ser instanciado só uma vez, e não para cada
	//'objeto' Reservas que a aplicação tiver.
	
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

	//SET 'excluído'. Não permitir mudança da data via "SET".
	//public void setDataEntrada(Date dataEntrada) {
	//	this.dataEntrada = dataEntrada;
	//}

	public Date getDataSaida() {
		return dataSaida;
	}

	//SET 'excluído'. Não permitir mudança da data via "SET".
	//public void setDataSaida(Date dataSaida) {
	//	this.dataSaida = dataSaida;
	//}
	
	//Métodos. CUIDADO: aqui há muita informação útil!
	
	//Artifício: método definido do tipo "long" porque a 'data' será convertida para MILISEGUNDOS.
	//Este método calculará a diferença entre duas datas, em dias.
	
	public long duracao() {
		//Calculando a diferença de datas em milisegundos.
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		//Convertendo esta diferença para DIAS.
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	//Este método 'atualizará' as datas de entrada e de saída da reserva.
	
	public void atualDatas (Date dataEntrada, Date dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	//Implementando o 'ToString', tratando-o como uma 'sobreposição', o que de fato ele é.
	@Override
	public String toString() {
		return "Quarto: "
				+ quarto
				+ ", Data de entrada: "
				+ sdf.format(dataEntrada)
				+ ", Data de saída: "
				+ sdf.format(dataSaida)
				+ ", "
				+ duracao() //Chamada do método 'duracao' aqui!
				+ " noites.";
	}
	
}
