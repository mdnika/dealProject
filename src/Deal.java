import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Deal implements Comparable<Deal> {

  static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
  private String name;
  private Date dealDate;

  public Deal(String name, String dealDate) throws ParseException {
    this.name = name;
    this.dealDate = formatter.parse(dealDate);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDealDate() {
    return dealDate;
  }

  public void setDealDate(Date dealDate) {
    this.dealDate = dealDate;
  }

  @Override
  public String toString() {
    return name + " (" + formatter.format(dealDate) + ")";
  }

  @Override
  public int compareTo(Deal obj) {
    Date current = new Date();
    long date = current.getTime() - dealDate.getTime();
    long objDate = current.getTime() - obj.dealDate.getTime();

    return -Long.compare(date, objDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Deal other)) {
      return false;
    }
    return name.equals(other.name) && dealDate.equals(other.dealDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dealDate);
  }
}
