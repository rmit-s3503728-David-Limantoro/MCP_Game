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

	private Hashtable<String, JLabel> optionLabels;
	private Hashtable<String, JCheckBox> optionCheckboxes;
	private Hashtable<String, JButton> optionButtons;
	private Hashtable<String, JTextArea> optionTextboxes;

	private SettingWindowListener swl;

	private class SettingWindowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getActionCommand()) {
			case ("ok"):
				// Apply changes, return to previous window
				curGameSetting.updatePlayerAbilities(optionCheckboxes.get("playerSkillPanel").isSelected(),
						optionCheckboxes.get("playerSkillTrap").isSelected(),
						optionCheckboxes.get("playerSkillTunnel").isSelected());
				curGameSetting.updateMonsterAbilities(optionCheckboxes.get("monsterSkillInvis").isSelected(),
						optionCheckboxes.get("monsterSkillLeap").isSelected(),
						optionCheckboxes.get("monsterSkillRepro").isSelected());
				curGameSetting.updateOtherSettings(Integer.parseInt(optionTextboxes.get("gameTick").getText()),
						Integer.parseInt(optionTextboxes.get("gameDuration").getText()),
						optionTextboxes.get("mapType").getText());
				settingWinFrame.dispose();
				prevWindow.setEnabled(true);
				break;

			case ("cancel"):
				// Cancel all changes, return to previous window
				settingWinFrame.dispose();
				prevWindow.setEnabled(true);
				break;

			default:
				break;
			}
		}

	}

	public SettingWindow(Setting gameSetting, JFrame prevWindow) {
		this.prevWindow = prevWindow;
		curGameSetting = gameSetting;
		settingWinFrame = new JFrame("Setting");
		optionLabels = new Hashtable<String, JLabel>();
		optionCheckboxes = new Hashtable<String, JCheckBox>();
		optionButtons = new Hashtable<String, JButton>();
		optionTextboxes = new Hashtable<String, JTextArea>();

		addLabel("Player's Skill", "label1");
		addCheckBox("Player able to skip panels", "playerSkillPanel");
		addCheckBox("Player able to set up trap", "playerSkillTrap");
		addCheckBox("Player able to create tunnels", "playerSkillTunnel");

		addLabel("Monster's Skill", "label2");
		addCheckBox("Monster able to turn invisible", "monsterSkillInvis");
		addCheckBox("Monster able to skip panels", "monsterSkillLeap");
		addCheckBox("Monster able to create offspring", "monsterSkillRepro");

		addLabel("Game Tick Speed", "label3");
		addTextBoxes("", "gameTick");

		addLabel("Game Duration", "label4");
		addTextBoxes("", "gameDuration");

		addLabel("Game Map Type", "label5");
		addTextBoxes("", "mapType");

		addButton("OK", "ok");
		addButton("Cancel", "cancel");
	}

	public void addLabel(String text, String labelName) {
		optionLabels.put(labelName, new JLabel(text));
		settingWinFrame.add(optionLabels.get(labelName));
	}

	public void addTextBoxes(String initialText, String textboxName) {
		optionTextboxes.put(textboxName, new JTextArea(initialText));
		settingWinFrame.add(optionTextboxes.get(textboxName));
	}

	public void addCheckBox(String text, String commandName) {
		optionCheckboxes.put(commandName, new JCheckBox(text));
		optionCheckboxes.get(commandName).setActionCommand(commandName);
		settingWinFrame.add(optionCheckboxes.get(commandName));
	}

	public void addButton(String text, String commandName) {
		optionButtons.put(commandName, new JButton(text));
		optionButtons.get(commandName).addActionListener(swl);
		optionButtons.get(commandName).setActionCommand(commandName);
		settingWinFrame.add(optionButtons.get(commandName));
	}

	public void setSettingWinFrame(JFrame settingWinFrame) {
		this.settingWinFrame = settingWinFrame;
	}

	public JFrame getSettingWinFrame() {
		return settingWinFrame;
	}

}
