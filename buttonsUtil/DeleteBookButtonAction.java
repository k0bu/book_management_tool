package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import bookInterface.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DeleteBookButtonAction implements ActionListener {
  private Map<String, JList<String>> _listMap;
  private Map<String, BookShelf> _aggMap;

  public DeleteBookButtonAction(Map<String, JList<String>> listMap,  Map<String, BookShelf> aggMap) {
    this._listMap = listMap;
    this._aggMap = aggMap;
  }

  public void actionPerformed(ActionEvent e) {
    this._listMap.forEach((string,list) -> {
      DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();
      List<String> selected = new ArrayList<>();
      List<String> unselected = new ArrayList<>();
      for (int i = 0; i < listModel.getSize(); i++) {
        if (!list.isSelectedIndex(i)) {
          unselected.add(listModel.getElementAt(i));
        } else {
          selected.add(listModel.getElementAt(i));
        }
      }

      selected.forEach(s -> {
        Book b = new Book(s);
        this._aggMap.get(string).removeElement(b);
      });

      System.out.println(string);
      System.out.println(this._aggMap.get(string).toString());

      listModel.clear();
      listModel = new ListModelUtil<String>().List2ListModel(unselected);
      list.setModel(listModel);

    });

  }
}