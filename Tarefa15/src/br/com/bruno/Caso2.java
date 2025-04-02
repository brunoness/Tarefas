package br.com.bruno;

public class Caso2 {
	public static void main(String[] args) {
        Atendente cliente = new Atendente("A", false);
        Factory factory = getFactory(cliente);
        Note note = factory.create(cliente.getGradeRequest());
        note.powerOn();
    }

    private static Factory getFactory(Atendente cliente) {
        if (cliente.tipoDeContrato()) {
            return new PJ();
        } else {
            return new PF();
        }
    }
}
