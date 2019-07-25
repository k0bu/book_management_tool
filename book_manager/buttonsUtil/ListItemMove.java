package book_manager.buttonsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import book_manager.bookInterface.*;

//https://ateraimemo.com/Swing/FastRemoveOfListItems.html
public class ListItemMove {
  public static void move(JList<String> from, JList<String> to, BookShelf fromShelf, BookShelf toShelf) {
    ListSelectionModel sm = from.getSelectionModel();
    int[] selectedIndices = from.getSelectedIndices();
  
    DefaultListModel<String> fromModel = (DefaultListModel<String>) from.getModel();
    DefaultListModel<String> toModel = (DefaultListModel<String>) to.getModel();
    List<String> selectedValues = new ArrayList<>();
    List<String> unselectedValues = new ArrayList<>();
    for (int i = 0; i < fromModel.getSize(); i++) {
      if (!sm.isSelectedIndex(i)) {
        unselectedValues.add(fromModel.getElementAt(i));
      } else {
        selectedValues.add(fromModel.getElementAt(i));
      }
    }
    if (selectedIndices.length > 0) {
      for (int i: selectedIndices) {
        toModel.addElement(fromModel.get(i));
      }
      fromModel.clear();

      selectedValues.forEach(s->{
        Book b = new Book(s);
        fromShelf.removeElement(b);
      });

      selectedValues.forEach(s->{
        Book b = new Book(s);
        toShelf.addElement(b);
      });

      System.out.println("FROMLIST: ");
      System.out.println(fromShelf.toString());
      System.out.println("TOLIST: ");
      System.out.println(toShelf.toString());

      // unselectedValues.forEach(fromModel::addElement);
      DefaultListModel<String> model = new DefaultListModel<>();
      unselectedValues.forEach(model::addElement);
      from.setModel(model);
    }
  }
}