package br.com.bruno;

public abstract class Factory {
	
	public Note create(String requestedGrade) {
		Note note = retrieveNote(requestedGrade);
		note = preparandoNote(note);
        return note;
    }
    private Note preparandoNote(Note note){
    	note.formatacao();
    	note.powerOn();
        return note;
    }
    abstract Note retrieveNote(String requestedGrade);

}
