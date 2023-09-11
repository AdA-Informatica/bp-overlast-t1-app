# Repository for Safe Space App Development

## Code Contract

## Gemaakt door Paul Kros voor de ontwikkeling van project Safe Space

Hierin staan de afspraken over hoe er te werk gegaan zal worden met de code m.b.t de app.

---

## Inhoud

1. Afspraken naamgevingen
2. Styles van naamgevingen
3. GIT en project structuur
4. Ontwerp
5. Mappenstructuur
6. Taal
7. Inspringen
8. Wit regels
9. Maximum regel lengte

---

### Afspraken naamgevingen

> Voor de naamgevingen zal er gebruik worden gemaakt van camelCasing. Voor functies en classes zal gebruik worden gemaakt van PascalCasing.
> Er is voordeze optie gekozen om gemakkelijk onderscheid te kunnen maken tussen variabelen en classes/functies.

---

### Styles van naamgevingen

> - Er zullen geen afkortingen worden gebruikt om zo de leesbaarheid te verhogen en verwarring te voorkomen. **Voorbeeld: employeeId ipv eId**
> - Variabelen horen duidelijke namen te krijgen om zo duidelijk onderscheid te houden. **Voorbeeld: employeeName ipv Name**
> - In loops mag wel gebruik gemaakt worden van eenletterige variabelen zodat deze niet in zoekvelden naar voren komen en verwarring veroorzaken.
> - Er zal geen gebruik gemaakt worden van "\_" in naamgevingen.
> - Voor functies zal er gebruik gemaakt worden van werkwoorden in de naamgevingen zodat er een duidelijk is tussen klasses en functies.
> - Code schoon houden en geen gebruik maken van onzin naamgevingen die grappig bedoeld zijn. **Voorbeeld: GetBalance() ipv ShowMeTheMoney()**

---

### GIT en project structuur

> - Er wordt gebruik gemaakt van GitFlow.
> - Er zal gebruik gemaakt gaan worden van issuesleutels vanuit Jira voor de commits.
> - Er wordt gebruik gemaakt van versiebeheer. Hierbij word de versie verhoogt met 0.1 tot gehele getallen. **Voorbeeld: 0.1 -> 0.2 ... -> 1.1**
> - Bij de branches zullen naamgevingen als volgt gehanteerd worden: initialen + featurenaam. **Voorbeeld: PKMenuOverzicht**
> - Onze commits zullen er als volgt uitzien: featurenaam + versienummer. **Voorbeeld: MenuOverzicht0.1 -> MenuOverzicht0.2**
> - Bij het commentaar zal een korte beschrijving worden toegevoegd met daarin beknopt de wijzigingen beschreven.

---

### Ontwerp

> Er zal gebruik gemaakt gaan worden van Static code.

---

### Mappenstructuur

> Voor het coderen met React is het belangrijk dat de correcte mappenstructuur wordt aangehouden om een juiste werking te garanderen.
> Raadpleeg hiervoor:
> [React Code Standards / File Structure](https://gilshaan.medium.com/react-native-coding-standards-and-best-practices-5b4b5c9f4076).

---

### Taal

> De applicatie zal volledig in het Engels gecodeerd worden.

---

### Inspringen

> Voor het inspringen bij een functie wordt de functie geopend **{** op dezelfde lijn als de functienaam.
> Het sluiten van een functie wordt gedaan op een aparte regel. **}**
> De inhoud van een functie zal door middel van 1 tab geindenteerd worden.

```
function UserGreeting(props) {
  return <h1>Welcome back!</h1>;
}
```

---

### Wit regels

> Er zal 1 witregel tussen elke functie worden gezet
> Binnen een functie zullen witregels gebruikt worden op de manier dat de code overzichtelijk blijft.
> Denk b.v. aan het scheiden van variabelen of statements.

---

### Maximum regel lengte

> In het project zal er een maximum regellengte van 120 tekens gehanteerd worden
