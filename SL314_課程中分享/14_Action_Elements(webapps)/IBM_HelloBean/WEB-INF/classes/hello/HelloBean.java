package hello;

public class HelloBean implements java.io.Serializable{
  private String name = "World";

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
