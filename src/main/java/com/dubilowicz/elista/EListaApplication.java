package com.dubilowicz.elista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EListaApplication {

	private static final Logger log = LoggerFactory.getLogger(EListaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EListaApplication.class, args);
		// punkt wejsciowy do aplikacji, dobre miejsce na import danych wymaganych przy kazdym uruchomieniu,
		// tworzenie cache'ow, uruchamianie globalnych timerow i konfiguratorow, etc...
		log.info("Ponizszy tekst wyswietlany jest z metody main w klasie " + EListaApplication.class.getName());
		log.info("");
		log.info("Niniejszy projekt powinien posluzyc tylko i wylacznie jako przykladowy szablon");
		log.info("Projekt ma wpietego SWAGGERa, dostepnego pod adresem: http://localhost:8080/swagger-ui.html");
		log.info("  - w celu uzycia wejdz w powyzszego linka, wybierz core-controller, wybierz metode, wstaw parametry, kliknij Try it out!");
		log.info("Projekt jest takze pozbawiony jakiejkolwiek obslugi bledow i zwracania poprawnych statusow HTTP, nie bede przeciez robic wszystkiego za was. :D");
		log.info("Przyjete nazewnictwo jest nieprzypadkowe o czym dowiecie sie innym razem.");
		log.info("A teraz do roboty!");
	}
}
