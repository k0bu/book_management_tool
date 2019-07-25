package book_manager.buttonsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ListModelUtil<E> {
  public List<E> ListModel2List(ListModel<E> listM){
    List<E> list = new ArrayList<>();
    for(int i = 0; i < listM.getSize(); i++){
      list.add(listM.getElementAt(i));
    }
    return list;
  }

  public DefaultListModel<E> List2ListModel(List<E> list){
    DefaultListModel<E> listM = new DefaultListModel<E>();
    list.forEach(e->{
      listM.addElement(e);
    });
    return listM;
  }
}