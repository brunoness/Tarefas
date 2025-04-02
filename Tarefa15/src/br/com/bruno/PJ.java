package br.com.bruno;

public class PJ extends Factory {
    @Override
    Note retrieveNote(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Note3("Core i5 8400", "8GB 2666mhz", "Sony Vaio", 512);
        } else {
        	return new Note4("Core i9 185H", "32GB 3600mhz", "iMac", 1000);
        }
    }
}
