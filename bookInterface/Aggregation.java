package bookInterface;
import java.util.List;

public interface Aggregation{
  public void addElement(Element e);
  public void setAggregation(List<Element> elements);
  public void removeElement(Element e);
  public void removeAggregation();
  public boolean existElement(Element e);
}