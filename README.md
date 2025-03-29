# CGI-Lennuk

# Projekti kirjeldus 

Tegemist on lennureisijale lennu planeerimise ja lennukis istekohtade soovitamise veebirakendusega. 
<br>
Lahendus on loodud Vue.js front-end ning Spring Boot back-end raamistiku abil.  

# Kuidas käivitada?

## Projekti ülesehitus 

```
npm install
```

## Navigeeri frontend kausta

```
cd src/frontend
```

## Jooksuta backend ja frontend korraga

```
npm run dev
```

## Ava projekt aadressil 

```
localhost:3000
```

# Töö protsess

Lahenduse loomiseks kulus ligikaudu ~24 tundi. 
<br>
# Murekohad
1. Esimest korda Spring Booti kasutamine ning sellega algne tutuvumine/ülesseadistamine võttis oma jagu aega, kuid õnneks sain takistuse ületada tänu YouTube'is leiduvatele õpetusvideotele.
2. Alguses oli probleem andmete edastamisega ühelt lehelt teisele, kasutades router-link komponenti. Andmed ei tulnud õigesti üle, kuna need olid vales vormingus. Probleemile leidsin lahenduse pärast mitmete foorumite uurimist, kust leidsin lahenduse, mis seisnes järgmises sammus: lisasin params parameetrile JSON.stringify().
   *  ```
      <router-link :to="{ name: 'SeatPurchase', params: {kohad : JSON.stringify(lend.istekohad), hind: (lend.hind)} }">
      ```
3. Istekohtade visualiseerimine osutus keeruliseks mitmel põhjusel. Esmalt takistas andmete vale edastamine lehelt lehele  (eelmine punkt), kuid ka pärast selle lahendamist tuli leida parim viis istekohtade korrektseks paigutamiseks. Soovisin, et istekohtade paigutus jäljendaks lennuki tegelikku istmeskeemi, kus oleks kolm istet ühel pool, vahekäik keskel ning kolm istet teisel pool. Lõpuks lahendasin selle, jagades istekohtade massiivi alamosadeks kasutades funktsiooni paarisIstmed().
   *  ```
            paarisIstmed() {
            const istmed =  this.parsedIstekohad;
            const paarisKohad =  [];
            for (let i = 0; i < istmed.length; i += 6) {
        paarisKohad.push([istmed[i] || 'X', istmed[i + 1] || 'X',
                            istmed[i + 2] || 'X', istmed[i + 3] || 'X',
                              istmed[i + 4] || 'X', istmed[i + 5] || 'X']);
      }
            console.log(paarisKohad)
            return paarisKohad;
        },
      
      ```

# Lahendused
1. Back-end'is lõin klassi Lend, et mugavas formaadis lendusid front-end'ile edastada.
* Lend klassi ülesehitus oli järgmine:
```
Lend(String start, String sihtkoht, LocalDateTime väljumisAeg, float lennuKestvus, float hind, ArrayList<String> istekohad)
```
* Samuti kirjutasin funktsiooni genereeriKohad(), mis genereerib lennu istekohti juhuslikult. Kui koht oli broneeritud, siis märgiti see "X"-iga. Istekohtade arvu piirasin 60-ga, vältides, et leht liiga kirjuks ei muutuks.
  
        ArrayList<String> kohad = new ArrayList<>();
  
        for (int i = 1; i <= 60; i++) {
            double random = Math.random();
            if (random >= 0.75) {
                kohad.add("X");
            }else{
                kohad.add(String.valueOf(i));
            }
            
        }
        return kohad;
2.Front-end'is kasutasin for-loop abil FlightsView.vue lehe jaoks loodud lende ja kuvasin need tabelis. Lisasin iga lennu kõrvale nupu, mis vastavalt lennule võttis kaasa parameetritena istekohad ja hinna ning suunas kasutaja uuele lehele SeatPurchase.vue.
3. Uuel lehel visualiseerisin samuti for-loopi abil parameetrina kaasa saadud istekohad ning lisasin valiku kasutajal muuta mitut istet ta soovib broneerida.
  * Lõin mitmeid funtsioone, et mugavalt vastavalt kasutaja sisestatud istmete arvule soovitada sobilike istmeid.
    1. aknaäärsedKohad()
    2. väljapääsuKohad()
    3. soovitaKohti()
  * Lisasin ka ülevaate valitud kohtadest ning lõppsummast, mis kasutaja kohtade eest maksma peaks.
4. Lõpuks eksperimenteerisin CSS'iga, et muuta lehe disain esinduslikuks ja kasutajasõbralikuks.
