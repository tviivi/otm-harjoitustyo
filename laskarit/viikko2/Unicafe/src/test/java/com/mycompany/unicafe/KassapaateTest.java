package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti2 = new Maksukortti(200);
    }
    
    @Test
    public void alussaOikeaMaaraRahaa() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void alussaOikeaMaaraEdullisia() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void alussaOikeaMaaraMaukkaita() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoToimiiEdullistenOsaltaJosRahaaOnRiittavasti() {
        kassapaate.syoEdullisesti(300);
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(60, kassapaate.syoEdullisesti(300));
    }
    
    @Test
    public void kateisostoToimiiEdullistenOsaltaJosRahaaEiOleRiittavasti() {
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(200, kassapaate.syoEdullisesti(200));
    }
    
    @Test
    public void kateisostoToimiiMaukkaidenOsaltaJosRahaaOnRiittavasti() {
        kassapaate.syoMaukkaasti(600);
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(200, kassapaate.syoMaukkaasti(600));
    }
    
    @Test
    public void kateisostoToimiiMaukkaidenOsaltaJosRahaaEiOleRiittavasti() {
        kassapaate.syoMaukkaasti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(200, kassapaate.syoMaukkaasti(200));
    }
    
    @Test
    public void korttiostoToimiiEdullistenOsaltaJosTilillaKatetta() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(true, kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiostoToimiiEdullistenOsaltaJosTilillaEiOleKatetta() {
        kassapaate.syoEdullisesti(kortti2);
        assertEquals(200, kortti2.saldo());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(false, kassapaate.syoEdullisesti(kortti2));
    }
    
    @Test
    public void korttiostoToimiiMaukkaidenOsaltaJosTilillaKatetta() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(true, kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiostoToimiiMaukkaidenOsaltaJosTilillaEiOleKatetta() {
        kassapaate.syoMaukkaasti(kortti2);
        assertEquals(200, kortti2.saldo());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(false, kassapaate.syoMaukkaasti(kortti2));
    }
    
    @Test
    public void rahanLatausToimiiOikein() {
        kassapaate.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());
        assertEquals(100100, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void negatiivistaRahaaEiLadata() {
        kassapaate.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
}