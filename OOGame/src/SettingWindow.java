import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SettingWindow {

	private Setting curGameSetting;

	private JFrame prevWindow;
	private JFrame settingWinFrame;

	private ArrayList<JLabel> optionLabels;
	private ArrayList<JCheckBox> optionCheckboxes;
	private ArrayList<JButton> optionButtons;
	private Hashtable<String, JTextArea> optionTextboxes;

	private SettingWindowListener swl;

	private class SettingWindowListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getActionCommand()) {
			case ("ok"):
				// Apply changes, return to previous window
				// curGameSetting.updatePlayerAbilities(skip, trap, tun);
				// curGameSetting.updateMonsterAbilities(invis, leap, repro);
				// curGameSetting.updateMonsterAbilities(invis, leap, repro);
				break;

			case ("cancel"):
				// Cancel all changes, return to previous window

				break;

			default:
				break;
			}
		}

	}

	public SettingWindow(Setting gameSetting) {
		curGameSetting = gameSetting;
		settingWinFrame = new JFrame("Setting");
		optionLabels = new ArrayList<JLabel>();
		optionCheckboxes = new ArrayList<JCheckBox>();
		optionButtons = new ArrayList<JButton>();
		optionTextboxes = new Hashtable<String, JTextArea>();

		addLabel("Player's Skill");
		addLabel("Monster's Skill");
		addLabel("Game Duration");
		addLabel("Game Tick Speed");

		addCheckBox("Player able to skip panels", "playerSetting1");
		addCheckBox("Player able to set up trap", "playerSetting2");
		addCheckBox("Player able to create tunnels", "playerSetting3");
		addCheckBox("Monster able to skip panels", "monsterSetting1");
		addCheckBox("Monster able to turn invisible", "monsterSetting2");
		addCheckBox("Monster able to create offspring", "monsterSetting3");

		addButton("OK", "ok");
		addButton("Cancel", "cancel");

		addTextBoxes("", "gameDuration");
		addTextBoxes("", "gameTick");

	}

	public void addLabel(String text) {
		optionLabels.add(new JLabel(text));
	}

	public void addTextBoxes(String initialText, String textboxName) {
		optionTextboxes.put(textboxName, new JTextArea(initialText));
	}

	public void addCheckBox(String text, String commandName) {
		optionCheckboxes.add(new JCheckBox(text));
		optionCheckboxes.get(optionCheckboxes.size()).setActionCommand(commandName);
	}

	public void addButton(String text, String commandName) {
		optionButtons.add(new JButton(text));
		optionButtons.get(optionButtons.size()).addActionListener(swl);
		optionButtons.get(optionButtons.size()).setActionCommand(commandName);
	}

	public void setSettingWinFrame(JFrame settingWinFrame) {
		this.settingWinFrame = settingWinFrame;
	}

	public JFrame getSettingWinFrame() {
		return settingWinFrame;
	}

}