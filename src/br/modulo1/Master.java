package br.modulo1;

public class Master {

	public static void main(String[] args) {
		ASO aso = new ASO();
		
		aso.setId(01);
		aso.setNamePaciente("Junior");
		aso.setDate("10/11/2024");
		aso.setCpf(01234);
		aso.setMedico("Dr.Joaquim");
		aso.setAptidao(false);
		
		/**
		 * Metodo não utilizado.
		 * @deprecated
		 * System.out.println(aso.getId());
		 * System.out.println(aso.getNamePaciente());
		 * System.out.println(aso.getDate());
		 * System.out.println(aso.getMedico());
		 *
		 * @see  fichaClinica() @link
		*/
		aso.fichaClinica();
		aso.checarAptidao(aso.getAptidao());
		
		aso.setAptidao(true);
		aso.checarAptidao(aso.getAptidao());
	}

}
