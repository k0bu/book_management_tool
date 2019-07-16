package buttonsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

//https://ateraimemo.com/Swing/FastRemoveOfListItems.html
public class ListItemMove {
  public static <E> void move(JList<E> from, JList<E> to) {
    ListSelectionModel sm = from.getSelectionModel();
    int[] selectedIndices = from.getSelectedIndices();
  
    DefaultListModel<E> fromModel = (DefaultListModel<E>) from.getModel();
    DefaultListModel<E> toModel = (DefaultListModel<E>) to.getModel();
    List<E> unselectedValues = new ArrayList<>();
    for (int i = 0; i < fromModel.getSize(); i++) {
      if (!sm.isSelectedIndex(i)) {
        unselectedValues.add(fromModel.getElementAt(i));
      }
    }
    if (selectedIndices.length > 0) {
      for (int i: selectedIndices) {
        toModel.addElement(fromModel.get(i));
      }
      fromModel.clear();
      // unselectedValues.forEach(fromModel::addElement);
      DefaultListModel<E> model = new DefaultListModel<>();
      unselectedValues.forEach(model::addElement);
      from.setModel(model);
    }
  }
}