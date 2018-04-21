# OTM-harjoitustyö - Laskin

Referenssisovellus kurssille Ohjelmistotekniikan menetelmät 2018 kevät. Toteutettu laskinsvellus pystyy laskemaan yksinkertaisia laskuja kysymällä käyttäjältä aina yhden luvun ja laskutoimituksen kerrallaan. Sovellukseen on tulossa vielä graafinen käyttöliittymä ja kirjautumismahdollisuus.

## Dokumentaatio
[Yleiskuvaus](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/yleiskuvaus.md) <br />
[Toiminnallisuudet](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/toiminnallisuudet.md) <br />
[Tuntikirjanpito](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md) <br />
[Arkkitehtuuri](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md) <br />

## Release
Viikon 5 deadlinen mukainen release löytyy [täältä](https://github.com/tviivi/otm-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla `mvn test`
ja testien kattavuusraportti komennolla `mvn jacoco:report`

### Checkstyle
Checkstylen määrittelemät tarkistukset ajetaan komennolla `mvn jxr:jxr checkstyle:checkstyle` <br />
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

### Jar
Jar suoritetaan komennolla `mvn package` ja suoritettu generoi hakemistoon target suoritettavan jar-tiedoston Laskin-1.0-SNAPSHOT.jar