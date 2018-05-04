# Arkkitehtuurikuvaus

## Pakkausrakenne
Sovelluksen koodin pakkausrakenne on seuraava:
![alt text](kuvat/arkkitehtuuri4.png "Description goes here") <br />
Pakkaus *Calculator* sis�lt�� ohjelman sovelluslogiikan ja pakkaus *Graphic* taas graafisen k�ytt�liittym�n. 
Pakkauksessa *Database* on sovelluksen k�ytt�m��n tietokantaan ja sen k�ytt��n liittyv�t luokat.
Pakkauksen *Test* sis�lt� l�ytyy sovelluslogiikan kattavat testit, sek� tietokantaan liittyvi� testej�.

## Sovelluslogiikka
Sovelluksen graafisen liittym�n koostumista kuvaava sekvenssikaavio:
![alt text](kuvat/aloitussekvenssi.png "Description goes here") <br />
Ohjelma l�htee py�rim��n, kun luokka *Main* kutsuu metodia *launch* luokalle *Graphic*. T�ll�in *Graphic* l�htee rakentamaan
k�ytt�liittym�� luomalla erin�isi� k�ytt�liittym��n tarvittavia elementtej�.


Sovelluksen toiminnallisuutta kuvaava sekvenssikaavio:
![alt text](kuvat/klikkaussekvenssi.png "Description goes here") <br />
Kaavion alussa k�ytt�j� klikkaa numeronappulaa 1. T�ll�in *event* aktivoituu ja asettaa *TextField*in *current* tekstiksi kyseess� olevan numeron 1.
Seuraavaksi kaavion mukaan k�ytt�j� klikkaa nappia "+". T�m� saa aikaan uuden *event*in aktivoitumisen. Jo luodulle *Calculator*-oliolle kutsutaan
*Calculator*-luokan metodia *sum* parametrilla *thenumber*, mik� saa aikaan laskutoimituksen toteutumisen.
T�m�n j�lkeen asetetaan *TextField*eille sy�tetty arvo, annettu laskutoimitus sek� sen tulos. Koko lauseke
lis�t��n *history*-listalle, joka tulostetaan omalle *Label*illeen.