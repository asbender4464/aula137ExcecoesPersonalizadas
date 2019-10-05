package modelo.excecoes;

public class DominioExcecao extends Exception {
	private static final long serialVersionUID = 1L;

	public DominioExcecao (String mensagem) {
		super(mensagem);
	}
}
