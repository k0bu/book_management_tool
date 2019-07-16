package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;


public class DeleteButtonAction<E>  implements ActionListener {
  private JList<E> _list;
  
  public DeleteButtonAction(JList<E> list){
    this._list = list;
  }

  public void actionPerformed(ActionEvent e) {
    DefaultListModel<E> listModel = (DefaultListModel<E>)this._list.getModel();
    int[] selectedIndicies = _list.getSelectedIndices();
    List<E> unselectedValues = new ArrayList<>();
    if(selectedIndicies.length > 0){
      for (int i = 0; i < listModel.getSize(); i++) {
        if (!_list.isSelectedIndex(i)) {
          unselectedValues.add(listModel.getElementAt(i));
        }
      }
      listModel.clear();
      listModel = new ListModelUtil<E>().List2ListModel(unselectedValues);
      this._list.setModel(listModel);
    } else {
      JOptionPane.showMessageDialog(this._list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
    }

  }
}