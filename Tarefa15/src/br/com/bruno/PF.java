package br.com.bruno;

public class PF extends Factory {
	@Override
    Note retrieveNote(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Note1("Celeron D", "2GB 800mhz", "Positivo", 320);
        } else {
        	return new Note2("Core i3 540", "4GB 1333mhz", "Acer", 120);
        }
    }
}
