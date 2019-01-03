package entity;
import java.sql.Date;

public class Fee implements Entity{

  private long id;
  private double amount;
  private java.sql.Date time;
  private long paied;
  private String description;

  public Fee(long id, double amount, Date time, long paied, String description){
    this.id = id;
    this.amount = amount;
    this.time = time;
    this.paied = paied;
    this.description  = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public long getPaied() {
    return paied;
  }

  public void setPaied(long paied) {
    this.paied = paied;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
