import buttonsUtil.*;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class GUITest {

	private DefaultListModel<String> _listModel;
	private JList<String> _list;
	private List<JTextField> _fieldList = new ArrayList<>();


	public Component createComponents() {
		JTextField field = new JTextField("initial text");
		this._fieldList.add(field);

		_listModel = new DefaultListModel<String>();

		_list = new JList<String>(_listModel);
		_list.setVisibleRowCount(10);
		_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(_list);
		scrollPane.createVerticalScrollBar();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	
		JButton regButton = new JButton("Register");
		RegisterButtonAction regButtonListener = new RegisterButtonAction(_list, _fieldList);
		regButton.addActionListener( regButtonListener );

		regButton.setAlignmentX(Component.CENTER_ALIGNMENT);


		JButton delButton = new JButton("Delete");
		DeleteButtonAction<String> delButtonListener = new DeleteButtonAction<>(_list);
		delButton.addActionListener( delButtonListener );

		JButton quitButton = new JButton("Quit");
		QuitButtonAction quitButtonListener = new QuitButtonAction();
		quitButton.addActionListener( quitButtonListener );

		JPanel subPane1 = new JPanel();
		subPane1.setLayout(new GridLayout(1, 0));
		subPane1.add(delButton);
		subPane1.add(Box.createRigidArea(new Dimension(30, 10)));
		subPane1.add(quitButton);

		JPanel mainPane = new JPanel();
		mainPane.setBorder(BorderFactory.createEmptyBorder( 320, 320, 320, 320 ));
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		this._fieldList.forEach(f->{
			mainPane.add(f);
		});

		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(regButton);
		mainPane.add(Box.createRigidArea(new Dimension(10, 30)));
		mainPane.add(scrollPane);
		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(subPane1);

		return mainPane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("TestList");
		GUITest app = new GUITest();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
