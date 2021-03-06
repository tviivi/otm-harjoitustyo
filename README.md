﻿# OTM-harjoitustyö - Laskin

Referenssisovellus kurssille Ohjelmistotekniikan menetelmät 2018 kevät. Toteutettu laskinsvellus pystyy laskemaan yksinkertaisia laskuja kysymällä käyttäjältä aina yhden luvun ja laskutoimituksen kerrallaan. Laskutoimitukset tallennetaan tietokantaan, ja laskuhistoria tulostuu sovelluksen alareunaan.

## Dokumentaatio
[Yleiskuvaus](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/yleiskuvaus.md) <br />
[Käyttöohje](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/k%C3%A4ytt%C3%B6ohje.md) <br />
[Toiminnallisuudet](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/toiminnallisuudet.md) <br />
[Arkkitehtuuri](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md) <br />
[Testausdokumentti](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md) <br />
[Tuntikirjanpito](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md) <br />

## Release
Viikon 5 deadlinen mukainen release löytyy [täältä](https://github.com/tviivi/otm-harjoitustyo/releases/tag/viikko5) <br />
Viikon 6 deadlinen mukainen release löytyy [täältä](https://github.com/tviivi/otm-harjoitustyo/releases/tag/viikko6) <br />
Sovelluksen lopullinen release löytyy [täältä](https://github.com/tviivi/otm-harjoitustyo/releases/tag/Loppupalautus)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla `mvn test`
ja testien kattavuusraportti komennolla `mvn jacoco:report`, mikä löytyy avaamalla selaimella tiedosto *target/site/jacoco/index.html*.
Testausdokumentti löytyy myös [täältä](https://github.com/tviivi/otm-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md)

### Checkstyle
Checkstylen määrittelemät tarkistukset ajetaan komennolla `mvn jxr:jxr checkstyle:checkstyle`. <br />
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*

### Jar
Jar suoritetaan komennolla `mvn package` ja suoritettu generoi hakemistoon *target* suoritettavan jar-tiedoston *Laskin-1.0-SNAPSHOT.jar*

### Javadoc
Javadoc generoidaan komennolla `mvn javadoc:javadoc` ja sitä voi tarkastella selaimella avatusta tiedostosta *target/site/apidocs/index.html*