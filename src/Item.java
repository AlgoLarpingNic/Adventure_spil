import java.util.ArrayList;

public class Item {
  private final String shortname;
  private final String longname;


  public Item(String shortname, String longname) {
    this.shortname = shortname;
    this.longname = longname;
  }

  public String getShortname() {
    return shortname;
  }

  public String getLongname() {
    return longname;
  }

  @Override
  public String toString() {
    return getShortname();
  }
}
