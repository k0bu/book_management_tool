package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import bookInterface.*;

import java.util.List;
import java.util.ArrayList;


public class DeleteBookButtonAction  implements ActionListener {
  private JList<String> _list;
  private BookShelf _agg; //aggregation
  
  public DeleteBookButtonAction(JList<String> list, BookShelf agg){
    this._list = list;
    this._agg = agg;
  }

  public void actionPerformed(ActionEvent e) {
    DefaultListModel<String> listModel = (DefaultListModel<String>)this._list.getModel();
    int[] selectedIndicies = _list.getSelectedIndices();
    List<String> selected = new ArrayList<>();
    List<String> unselected = new ArrayList<>();
    if(selectedIndicies.length > 0){
      for (int i = 0; i < listModel.getSize(); i++) {
        if (!_list.isSelectedIndex(i)) {
          unselected.add(listModel.getElementAt(i));
        } else {
          selected.add(listModel.getElementAt(i));
        }
      }

      selected.forEach(s->{
        Book b = new Book(s);
        this._agg.removeElement(b);
      });

      System.out.println(this._agg.toString());

      listModel.clear();
      listModel = new ListModelUtil<String>().List2ListModel(unselected);
      this._list.setModel(listModel);
    } else {
      JOptionPane.showMessageDialog(this._list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
    }

  }
}