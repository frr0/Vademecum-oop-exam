---
<!--title: Cheat sheet-->
<!--author: Francesco Ranellucci-->
<!--date: 2022-01-19-->
---

# OOP Java

## Code

  ```Java
String codice = regione.substring(0, 3)
  .toUpperCase() + (centriXRegione.get(regione).size() + 1);
  ```

## List/Map

  ```Java
  LinkedList<Cittadino> cittadini = new LinkedList<Cittadino>();
  LinkedHashMap<String, LinkedList<Centro>> centriXRegione;
  LinkedHashMap<String, Centro> centriXid;

  public Piano() {
    centriXRegione = new LinkedHashMap<String, LinkedList<Centro>>();
    centriXid = new LinkedHashMap<>();
  }

//list
cittadini.add(c)

  //map
  centriXid.put(codice, c);
  centriXRegione.get(regione).add(c);

  return centriXid.get(codiceCentro);
  ```

## Streams

  ```Java
  // sort
  return cittadini.stream().sorted(Comparator
      .comparing(Cittadino::getNome)).collect(Collectors.toList());
  return cittadini.stream().sorted(Comparator
      .comparing(Cittadino::getDataDiNascita)).collect(Collectors.toList());

  // filter
return cittadini.stream()
  .filter(c -> c.getEta() >= etaMinima).collect(Collectors.toList());
  ```

## files

  ```Java
  File file = new File("10_Random");

  try {

    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
      int i = sc.nextInt();
      System.out.println(i);
    }
    sc.close();
  } 
catch (FileNotFoundException e) {
  e.printStackTrace();
}
```
