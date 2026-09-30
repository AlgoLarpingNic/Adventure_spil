public class Item {
  private final String shortName;
  private final String longName;

  public Item(String shortName, String longName){
    this.shortName = shortName;
    this.longName = longName;
  }

  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }

  //grammatik til at fixe en/et/flertal
  public String dopeGrammatics() {
    String name = longName.trim();
    if (name.toLowerCase().startsWith("a "))
      return name.substring(2);
    if (name.toLowerCase().startsWith("an "))
      return name.substring(3);
    if (name.toLowerCase().startsWith("some "))
      return name.substring(5);
    return name;
  }
  //override for at give longname tilbage når given kontekst
  @Override
  public String toString() {
    return longName;
  }
}
