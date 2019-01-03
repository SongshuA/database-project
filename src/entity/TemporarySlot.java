package entity;


public class TemporarySlot implements Entity{

  private long id;

  public TemporarySlot(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
