package br.com.bruno;

public abstract class Note {
	private String processador;
    private String memoria;
    private String marca;
    private int armazenamento;

    public Note(String processador, String memoria, String marca,int armazenamento) {
        this.processador = processador;
        this.memoria = memoria;
        this.marca = marca;
        this.armazenamento = armazenamento;
    }

    public void powerOn(){
        System.out.println(marca);
        System.out.println("Inicializando " + "Processador: " + processador + " Memória: " + memoria + " Armazenmamento "+ armazenamento + " GB" );
        System.out.println("Pronto para uso!");
    }
    public void formatacao(){
        System.out.println("Notebook Limpo e pronto para nova alocação. " + marca + " Processador: " + processador + " Memória: " + memoria + " Armazenmamento "+ armazenamento + " GB");
    }
}
