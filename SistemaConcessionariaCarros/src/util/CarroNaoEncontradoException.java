package util;

public class CarroNaoEncontradoException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public CarroNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
