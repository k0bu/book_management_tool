package bookInterface;
import java.util.List;

public interface Aggregation{
  //Generating instance in aggregation makes the connection too strong.
  //In that case, When changees is needed in constructor, 
  //there is necessary for changes in Aggreagation as well.
  public void addElement(Element e);
  public void setAggregation(List<Element> elements);
  public void removeElement(Element e);
  public void removeAggregation();
  public boolean existElement(Element e);
}