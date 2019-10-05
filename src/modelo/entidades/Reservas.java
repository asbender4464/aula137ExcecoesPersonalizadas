package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	//Atributos
	private Integer quarto;
	private Date dataEntrada;
	private Date dataSaida;
	
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
	
	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualDatas (Date dataEntrada, Date dataSaida) {
		Date hoje = new Date();
		if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {
			/*
			 * A exceção lançada abaixo, 'IllegalArgumentException' é nativa do Java e testa
			 * a validade dos argumentos do Método. Se a sequencialidade das datas estiver incorreta,
			 * naturalmente os argumentos serão inválidos!
			 */
			throw new IllegalArgumentException("a(s) data(s) informada(s) é(são) anterior(es) ao dia de hoje!");
		}
		if (!dataSaida.after(dataEntrada)) {
			throw new IllegalArgumentException ("a data de saída precisa ser APÓS a data de entrada!");
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
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
