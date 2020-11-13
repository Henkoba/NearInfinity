// Near Infinity - An Infinity Engine Browser and Editor
// Copyright (C) 2001 - 2019 Jon Olav Hauglid
// See LICENSE.txt for license information

package org.infinity.resource.cre;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.infinity.datatype.EffectType;
import org.infinity.datatype.Flag;
import org.infinity.datatype.IsNumeric;
import org.infinity.datatype.ResourceRef;
import org.infinity.gui.BrowserMenuBar; // ++
import org.infinity.gui.InfinityScrollPane; // ++
import org.infinity.gui.InfinityTextArea; // ++
import org.infinity.gui.ViewerUtil;
import org.infinity.gui.ViewerUtil.ListValueRenderer;
import org.infinity.resource.AbstractStruct;
import org.infinity.resource.Effect;
import org.infinity.resource.Effect2;
import org.infinity.resource.Profile;
import org.infinity.resource.ResourceFactory;
import org.infinity.resource.StructEntry;

public final class Viewer extends JPanel
{
  private static JPanel makeMiscPanel(CreResource cre)
  {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel panel = new JPanel(gbl);

    gbc.insets = new Insets(2, 6, 3, 0);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ALLEGIANCE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ALIGNMENT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_GENERAL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RACE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CLASS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_GENDER), gbl, gbc, true);
    if (Profile.getGame() != Profile.Game.PSTEE &&
        ResourceFactory.resourceExists("KIT.IDS")) {
      ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_KIT), gbl, gbc, true);
    } else {
      ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MAGE_TYPE), gbl, gbc, true);
    }
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RACIAL_ENEMY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ANIMATION), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MORALE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MORALE_BREAK), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MORALE_RECOVERY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_DEATH), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_WAND), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_POLYMORPH), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_BREATH), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_SPELL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_FIRE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_COLD), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_ELECTRICITY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_ACID), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_MAGIC), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_MAGIC_FIRE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_MAGIC_COLD), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_SLASHING), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_CRUSHING), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_PIERCING), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RESISTANCE_MISSILE), gbl, gbc, true);
    return panel;
  }

  private static JPanel makeMiscPanelIWD2(CreResource cre)
  {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel panel = new JPanel(gbl);

    gbc.insets = new Insets(2, 6, 3, 0);

    // 22
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ALLEGIANCE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_GENERAL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_RACE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CLASS), gbl, gbc, true);
//    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute("Specific"), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_GENDER), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ALIGNMENT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_KIT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CHALLENGE_RATING), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_FORTITUDE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_REFLEX), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SAVE_WILL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_NUM_ITEMS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ATTACKS_PER_ROUND), gbl, gbc, true);

    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_NAME), gbl, gbc, true);
//    gbc.insets = new Insets(4, 3, 4, 0);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_OVERRIDE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_SPECIAL_1), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_TEAM), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_SPECIAL_2), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_COMBAT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_SPECIAL_3), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_MOVEMENT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DIALOG), gbl, gbc, true);
    return panel;
  }

  public Viewer(CreResource cre)
  {
    JTabbedPane tabs = new JTabbedPane();
    JScrollPane scroll = new JScrollPane(makeMainPanel(cre));
    scroll.setBorder(BorderFactory.createEmptyBorder());
    scroll.getVerticalScrollBar().setUnitIncrement(32);
    scroll.getHorizontalScrollBar().setUnitIncrement(32);
    tabs.addTab("Stats", scroll);
    StructEntry version = cre.getAttribute(AbstractStruct.COMMON_VERSION);
    if (version.toString().equalsIgnoreCase("V2.2")) {
      tabs.addTab("Feats/Skills", makeFeatsPanel(cre));
      tabs.addTab("Items/Spells", makeItemSpellsPanelIWD2(cre));
    }
    else if (version != null)
      tabs.addTab("Items/Spells", makeItemSpellsPanel(cre));
    // START: HENKO add BG2WikiInfobox
    if (Profile.getGame().toString() == "BG2EE" ) {
    	tabs.addTab("BG Wiki CreatureInfobox", makeBG2WikiPanel(cre));
    }
	// END: HENKO add BG2WikiInfobox
    setLayout(new BorderLayout());
    add(tabs, BorderLayout.CENTER);
  }

  private JPanel makeFeatsPanel(CreResource cre)
  {
    JPanel p = new JPanel(new BorderLayout());
    p.add(ViewerUtil.makeCheckPanel((Flag)cre.getAttribute(CreResource.CRE_FEATS_3), 1), BorderLayout.NORTH);
    p.add(makeSkillPanelIWD2(cre), BorderLayout.CENTER);

    JPanel panel = new JPanel(new GridLayout(1, 6, 6, 0));
    panel.add(ViewerUtil.makeCheckPanel((Flag)cre.getAttribute(CreResource.CRE_FEATS_1), 1));
    panel.add(ViewerUtil.makeCheckPanel((Flag)cre.getAttribute(CreResource.CRE_FEATS_2), 1));
    panel.add(p);
    panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    return panel;
  }

  private JPanel makeItemSpellsPanel(CreResource cre)
  {
    JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0, 6));
    rightPanel.add(
            ViewerUtil.makeListPanel("Known spells", cre, KnownSpells.class, KnownSpells.CRE_KNOWN_RESREF));
    rightPanel.add(new ViewerSpells(cre));
    JPanel panel = new JPanel(new GridLayout(1, 2, 6, 0));
    panel.add(new ViewerItems(cre));
    panel.add(rightPanel);
    panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    return panel;
  }
  // START: HENKO add function to comment out zero-values in BG2WikiInfobox
  private String creInfoboxCommentZeroValue(CreResource cre, String attribute)
  {
    String retval = cre.getAttribute(attribute).toString();
	if (retval.equalsIgnoreCase("0"))
	{
	  return "<!-- " + retval + " -->";
	}
	else if (retval.indexOf(" - ") != -1)
	{
	  return retval.split(" - ")[0].substring(0,1).toUpperCase() + retval.split(" - ")[0].substring(1).toLowerCase();
    }
	else 
	{
		return retval;
	}
  }
  // END 

private JPanel makeBG2WikiPanel(CreResource cre)
  {
	  // BG2 Wiki 'CreatureInfobox' with some values
	  // Henko 2020-11-12

  
	 Integer stats = Integer.valueOf(cre.getAttribute(CreResource.CRE_STRENGTH).toString()) +
			 Integer.valueOf(cre.getAttribute(CreResource.CRE_INTELLIGENCE).toString())  +
			 Integer.valueOf(cre.getAttribute(CreResource.CRE_WISDOM).toString()) +
			 Integer.valueOf(cre.getAttribute(CreResource.CRE_DEXTERITY).toString()) +
			 Integer.valueOf(cre.getAttribute(CreResource.CRE_CONSTITUTION).toString()) +
			 Integer.valueOf(cre.getAttribute(CreResource.CRE_CHARISMA).toString());
	 String infobox = "Layout source  ( 2020-11 ) https://baldursgate.fandom.com/wiki/Template:Infobox_creature \r\n" + 
"{{infobox creature \r\n" +
"		  |name                 = " + cre.getAttribute(CreResource.CRE_NAME) + "\r\n" + 
"		  |bg1ee_tbp1           = \r\n" + 
"		  |bg1_wo_totsc         = \r\n" +
"		  |bg1_w_totsc          = \r\n" +
"		  |bg1_totsc            = \r\n" + 
"		  |bg1ee_wo_sod         = \r\n" +
"		  |bg1ee_w_sod          = \r\n" + 
"		  |bg1ee_sod            = \r\n" +
"		  |bg2_soa_wo_tob       = \r\n" +
"		  |bg2_soa_w_tob        = \r\n" +
"		  |bg2ee_soa            = yes\r\n" +
"		  |bg2_tob              = \r\n" +
"		  |bg2ee_tob            = yes\r\n" +
"		  |bg2ee_tbp2_got       = \r\n" +
"		  |cut_content          = no\r\n" +
"		  |mod_content          = no\r\n" +
"		  |image                = \r\n" +
"		  |caption1             = \r\n" +
"		  |other_names          = \r\n" +
"		  |general              = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_GENERAL) + "\r\n" +
"		  |gender               = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_GENDER) + "\r\n" +
"		  |race                 = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_RACE) + "\r\n" +
"		  |class                = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_CLASS) + "\r\n" +
"		  |kit                  = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_KIT) + "\r\n" +
"		  |movement_speed       = \r\n" + // cre.getAttribute(CreResource.CRE_SCRIPT_MOVEMENT) + "\r\n" +
"		  |alignment            = {{alignment \r\n" +
"		  |lawful_good          = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("lawful_good") ? "yes" : "no" ) + "\r\n" +
"		  |neutral_good         = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("neutral_good") ? "yes" : "no" ) + "\r\n" +
"		  |chaotic_good         = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("chaotic_good") ? "yes" : "no" ) + "\r\n" +
"		  |lawful_neutral       = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("lawful_neutral") ? "yes" : "no" ) + "\r\n" +
"		  |true_neutral         = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("neutral") ? "yes" : "no" ) + "\r\n" +
"		  |chaotic_neutral      = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("chaotic_neutral") ? "yes" : "no" ) + "\r\n" +
"		  |lawful_evil          = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("lawful_evil") ? "yes" : "no" ) + "\r\n" +
"		  |neutral_evil         = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("neutral_evil") ? "yes" : "no" ) + "\r\n" +
"		  |chaotic_evil         = " + (cre.getAttribute(CreResource.CRE_ALIGNMENT).toString().split(" - ")[0].equalsIgnoreCase("chaotic_evil") ? "yes" : "no" ) + "}}\r\n" +  
"		  |allegiance           = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_ALLEGIANCE) + "\r\n" +
"		  |recruitment_bg1      = \r\n" +
"		  |recruitment_bg2      = \r\n" +
"		  |recruitment_bg1ee    = \r\n" +
"		  |recruitment_bg2ee    = \r\n" +
"		  |temporary            = \r\n" +
"		  |missable             = \r\n" +
"		  |required_chapter     = \r\n" +
"		  |required_other       = \r\n" +
"		  |area                 = \r\n" +
"		  |organization         = \r\n" +
"		  |relationships        = \r\n" +
"		  |romance              = \r\n" +
"		  |conflict             = \r\n" +
"		  |pair                 = \r\n" +
"		  |quests               = \r\n" +
"		  |level                = " + cre.getAttribute(CreResource.CRE_LEVEL_FIRST_CLASS) +
((Integer.parseInt(cre.getAttribute(CreResource.CRE_LEVEL_SECOND_CLASS).toString()) > 1) ? "/" + cre.getAttribute(CreResource.CRE_LEVEL_SECOND_CLASS) : "") +
((Integer.parseInt(cre.getAttribute(CreResource.CRE_LEVEL_THIRD_CLASS).toString()) > 1) ? "/" + cre.getAttribute(CreResource.CRE_LEVEL_THIRD_CLASS) : "") +
"\r\n" + 
"		  |hit_points           = " + cre.getAttribute(CreResource.CRE_HP_CURRENT) + "/" + cre.getAttribute(CreResource.CRE_HP_MAX) + "\r\n" +

"		  |xp_value             = " + cre.getAttribute(CreResource.CRE_XP_VALUE) + "\r\n" +
"		  |strength             = " + cre.getAttribute(CreResource.CRE_STRENGTH) + 
((Integer.parseInt(cre.getAttribute(CreResource.CRE_STRENGTH).toString()) > 17) ? "/" + cre.getAttribute(CreResource.CRE_STRENGTH_BONUS) : "" )+
"\r\n" +
"		  |dexterity            = " + cre.getAttribute(CreResource.CRE_DEXTERITY) + "\r\n" +
"		  |constitution         = " + cre.getAttribute(CreResource.CRE_CONSTITUTION) + "\r\n" +
"		  |intelligence         = " + cre.getAttribute(CreResource.CRE_INTELLIGENCE) + "\r\n" +
"		  |wisdom               = " + cre.getAttribute(CreResource.CRE_WISDOM) + "\r\n" +
"		  |charisma             = " + cre.getAttribute(CreResource.CRE_CHARISMA) + "\r\n" +
"		  |total_scores         = " + stats + "\r\n" +
"		  |luck                 = " + cre.getAttribute(CreResource.CRE_LUCK) + "\r\n" +
"		  |weapon_proficiencies = \r\n" +
"		  |no_of_attacks        = " + cre.getAttribute(CreResource.CRE_ATTACKS_PER_ROUND).toString().split(" ")[0] + "\r\n" +
"		  |thac0                = " + cre.getAttribute(CreResource.CRE_THAC0)+ "\r\n" +
"		  |racial_enemy         = " + creInfoboxCommentZeroValue(cre, CreResource.CRE_RACIAL_ENEMY).replace("No_race", "No") + "\r\n" +
"		  |morale               = " + cre.getAttribute(CreResource.CRE_MORALE) + "\r\n" +
"		  |breaking_point       = " + cre.getAttribute(CreResource.CRE_MORALE_BREAK) + "\r\n" +
"		  |recovery_time        = " + cre.getAttribute(CreResource.CRE_MORALE_RECOVERY) + "\r\n" +
"		  |natural_ac           = " + cre.getAttribute(CreResource.CRE_AC_NATURAL) + "\r\n" +
"		  |effective_ac         = " + cre.getAttribute(CreResource.CRE_AC_EFFECTIVE) + "\r\n" +
"		  |s_v_death            = " + cre.getAttribute(CreResource.CRE_SAVE_DEATH) + "\r\n" +
"		  |s_v_wand             = " + cre.getAttribute(CreResource.CRE_SAVE_WAND) + "\r\n" +
"		  |s_v_polymorph        = " + cre.getAttribute(CreResource.CRE_SAVE_POLYMORPH) + "\r\n" +
"		  |s_v_breath           = " + cre.getAttribute(CreResource.CRE_SAVE_BREATH) + "\r\n" +
"		  |s_v_spell            = " + cre.getAttribute(CreResource.CRE_SAVE_SPELL) + "\r\n" +
"		  |fire                 = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_FIRE) + "\r\n" +
"		  |cold                 = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_COLD)+ "\r\n" +
"		  |electricity          = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_ELECTRICITY) + "\r\n" +
"		  |acid                 = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_ACID) + "\r\n" +
"		  |magic                = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_MAGIC) + "\r\n" +
"		  |magic_dmg_resistance = \r\n" + 
"		  |magical_fire         = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_MAGIC_FIRE) + "\r\n" +
"		  |magical_cold         = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_MAGIC_COLD) + "\r\n" +
"		  |slashing             = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_SLASHING) + "\r\n" +
"		  |crushing             = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_CRUSHING) + "\r\n" +
"		  |piercing             = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_PIERCING) + "\r\n" +
"		  |missile              = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_RESISTANCE_MISSILE) + "\r\n" +
"		  |open_locks           = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_OPEN_LOCKS) + "\r\n" +
"		  |pick_pockets         = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_PICK_POCKETS) + "\r\n" +
"		  |stealth              = " + "\r\n" +
"		  |move_silently        = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_MOVE_SILENTLY) + "\r\n" +
"		  |hide_in_shadows      = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_HIDE_IN_SHADOWS) + "\r\n" +
"		  |find_traps           = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_FIND_TRAPS) + "\r\n" +
"		  |set_traps            = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_SET_TRAPS) + "\r\n" +
"		  |detect_illusion      = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_DETECT_ILLUSION) + "\r\n" +
"		  |spells               = \r\n" +
"		  |special_abilities    = \r\n" + // cre.getAttribute(CreResource.CRE_ABILITIES) + "\r\n" +
"		  |extra_abilities      = \r\n" +
"		  |effects              = \r\n" +
"		  |special              = \r\n" +
"		  |script_name          = " + cre.getAttribute(CreResource.CRE_SCRIPT_NAME) + "\r\n" +
"		  |override_script      = " + cre.getAttribute(CreResource.CRE_SCRIPT_OVERRIDE) + "\r\n" +
"		  |class_script         = " + cre.getAttribute(CreResource.CRE_SCRIPT_CLASS) + "\r\n" +
"		  |race_script          = " + cre.getAttribute(CreResource.CRE_SCRIPT_RACE) + "\r\n" +
"		  |general_script       = " + cre.getAttribute(CreResource.CRE_SCRIPT_GENERAL) + "\r\n" +
"		  |default_script       = " + cre.getAttribute(CreResource.CRE_SCRIPT_DEFAULT) + "\r\n" +
"		  |gold                 = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_GOLD) + "\r\n" +
"		  |items                = "  + "\r\n" + 
"		  |exclusive_equipment  = \r\n" +
"		  |reputation_kill      = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_REPUTATION_MOD_KILLED) + "\r\n" +
"		  |reputation_join      = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_REPUTATION_MOD_JOIN) + "\r\n" +
"		  |reputation_leave     = " + creInfoboxCommentZeroValue(cre,CreResource.CRE_REPUTATION_MOD_LEAVE) + "\r\n" +
"		  |voice_actor          = \r\n" +
"		  |creature_code        = " + cre.getName().replace(".CRE", ".cre")  + "\r\n" + 
"		  |store_code           = \r\n" +
"}}";
	  
	  InfinityTextArea ta = new InfinityTextArea(infobox, true);
	  ta.setCaretPosition(0);
	  ta.setHighlightCurrentLine(false);
	  ta.setEditable(false);
	  ta.setLineWrap(true);
	  ta.setWrapStyleWord(true);
	  InfinityScrollPane scroll = new InfinityScrollPane(ta, true);
	  scroll.setLineNumbersEnabled(false);
	  ta.setMargin(new Insets(3, 3, 3, 3));
	  JPanel panel = new JPanel(new BorderLayout());
	  panel.add(new JLabel("BG-Wiki CreatureInfobox"), BorderLayout.NORTH);
	  panel.add(scroll, BorderLayout.CENTER);
	  panel.setPreferredSize(new Dimension(5, 5));
	  return panel;
  }
  // END: HENKO edit 2019-07-04
  private JPanel makeItemSpellsPanelIWD2(CreResource cre)
  {
    JPanel panel = new JPanel(new GridLayout(1, 2, 6, 0));
    panel.add(new ViewerItems(cre));
    panel.add(ViewerUtil.makeListPanel("Spells/abilities (# known)", cre, Iwd2Struct.class, null,
                                       new SpellListRendererIWD2()));
    panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    return panel;
  }

  private JPanel makeMainPanel(CreResource cre)
  {
    JPanel effectPanel;
    IsNumeric effectVersion = (IsNumeric)cre.getAttribute(CreResource.CRE_EFFECT_VERSION);
    if (effectVersion == null) {
      return new JPanel();
    } else {
      effectPanel = ViewerUtil.makeListPanel("Effects", cre,
                                            (effectVersion.getValue() == 1) ? Effect2.class : Effect.class,
                                            EffectType.EFFECT_TYPE);
    }
    ResourceRef imageRef = (ResourceRef)cre.getAttribute(CreResource.CRE_PORTRAIT_LARGE);
    JComponent imagePanel;
    if (ResourceFactory.resourceExists(imageRef.getResourceName(), true)) {
      imagePanel = ViewerUtil.makeImagePanel(imageRef, true);
    } else {
      imagePanel = ViewerUtil.makeImagePanel((ResourceRef)cre.getAttribute(CreResource.CRE_PORTRAIT_SMALL), true);
    }

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel leftPanel = new JPanel(gbl);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(3, 0, 3, 0);
    gbc.weightx = 1.0;
    gbc.weighty = 0.0;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbl.setConstraints(imagePanel, gbc);
    leftPanel.add(imagePanel);
    gbc.weighty = 1.0;
    gbl.setConstraints(effectPanel, gbc);
    leftPanel.add(effectPanel);

    JPanel panel = new JPanel(new GridLayout(1, 3));
    panel.add(leftPanel);
    String version = cre.getAttribute(AbstractStruct.COMMON_VERSION).toString();
    if (version.equalsIgnoreCase("V2.2")) {
      panel.add(makeStatsPanelIWD2(cre));
      panel.add(makeMiscPanelIWD2(cre));
    }
    else {
      panel.add(makeStatsPanel(cre));
      panel.add(makeMiscPanel(cre));
    }
    panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    return panel;
  }

  private JPanel makeSkillPanelIWD2(CreResource cre)
  {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel panel = new JPanel(gbl);

    gbc.insets = new Insets(1, 6, 2, 0);
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ALCHEMY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ANIMAL_EMPATHY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_BLUFF), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CONCENTRATION), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DIPLOMACY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DISABLE_DEVICE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_HIDE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_INTIMIDATE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_KNOWLEDGE_ARCANA), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MOVE_SILENTLY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_OPEN_LOCKS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_PICK_POCKETS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SEARCH), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SPELLCRAFT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_USE_MAGIC_DEVICE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_WILDERNESS_LORE), gbl, gbc, true);
    panel.setBorder(BorderFactory.createTitledBorder("Skills"));
    return panel;
  }

  private JPanel makeStatsPanel(CreResource cre)
  {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel panel = new JPanel(gbl);

    gbc.insets = new Insets(2, 6, 3, 0);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_NAME), gbl, gbc, true, 100);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_XP), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_XP_VALUE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_GOLD), gbl, gbc, true);

    StructEntry s1 = cre.getAttribute(CreResource.CRE_LEVEL_FIRST_CLASS);
    StructEntry s2 = cre.getAttribute(CreResource.CRE_LEVEL_SECOND_CLASS);
    StructEntry s3 = cre.getAttribute(CreResource.CRE_LEVEL_THIRD_CLASS);
    gbc.weightx = 0.0;
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridwidth = 1;
    JLabel dlabel = new JLabel("Level");
    gbl.setConstraints(dlabel, gbc);
    panel.add(dlabel);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    JLabel tf1 = new JLabel(s1.toString() + '/' + s2.toString() + '/' + s3.toString());
    tf1.setFont(tf1.getFont().deriveFont(Font.PLAIN));
    gbl.setConstraints(tf1, gbc);
    panel.add(tf1);

    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_AC_EFFECTIVE), gbl, gbc, true);

    s1 = cre.getAttribute(CreResource.CRE_HP_CURRENT);
    s2 = cre.getAttribute(CreResource.CRE_HP_MAX);
    gbc.weightx = 0.0;
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridwidth = 1;
    JLabel dlabel1 = new JLabel("Hit points");
    gbl.setConstraints(dlabel1, gbc);
    panel.add(dlabel1);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    JLabel tf2 = new JLabel(s1.toString() + '/' + s2.toString());
    tf2.setFont(tf1.getFont());
    gbl.setConstraints(tf2, gbc);
    panel.add(tf2);

    s1 = cre.getAttribute(CreResource.CRE_STRENGTH);
    s2 = cre.getAttribute(CreResource.CRE_STRENGTH_BONUS);
    gbc.weightx = 0.0;
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridwidth = 1;
    JLabel dlabel2 = new JLabel("Strength");
    gbl.setConstraints(dlabel2, gbc);
    panel.add(dlabel2);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    JLabel tf3 = new JLabel(s1.toString() + '/' + s2.toString());
    tf3.setFont(tf2.getFont());
    gbl.setConstraints(tf3, gbc);
    panel.add(tf3);

    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DEXTERITY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CONSTITUTION), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_INTELLIGENCE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_WISDOM), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CHARISMA), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_THAC0), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ATTACKS_PER_ROUND), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_HIDE_IN_SHADOWS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DETECT_ILLUSION), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SET_TRAPS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LORE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_OPEN_LOCKS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_MOVE_SILENTLY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_FIND_TRAPS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_PICK_POCKETS), gbl, gbc, true);
//    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute("Tracking"), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_NAME), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_OVERRIDE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_CLASS), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_RACE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_GENERAL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_SCRIPT_DEFAULT), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DIALOG), gbl, gbc, true);

    return panel;
  }

  private JPanel makeStatsPanelIWD2(CreResource cre)
  {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel panel = new JPanel(gbl);

    gbc.insets = new Insets(2, 6, 3, 0);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_NAME), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_XP), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_XP_VALUE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVELS_TOTAL), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_ARMOR_CLASS), gbl, gbc, true);

    StructEntry s1 = cre.getAttribute(CreResource.CRE_HP_CURRENT);
    StructEntry s2 = cre.getAttribute(CreResource.CRE_HP_MAX);
    gbc.weightx = 0.0;
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridwidth = 1;
    JLabel dlabel = new JLabel("Hit points");
    gbl.setConstraints(dlabel, gbc);
    panel.add(dlabel);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    JLabel tf1 = new JLabel(s1.toString() + '/' + s2.toString());
    tf1.setFont(tf1.getFont().deriveFont(Font.PLAIN));
    gbl.setConstraints(tf1, gbc);
    panel.add(tf1);

    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_STRENGTH), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_DEXTERITY), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CONSTITUTION), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_INTELLIGENCE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_WISDOM), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_CHARISMA), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_BARBARIAN), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_BARD), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_CLERIC), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_DRUID), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_FIGHTER), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_MONK), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_PALADIN), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_RANGER), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_ROGUE), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_SORCERER), gbl, gbc, true);
    ViewerUtil.addLabelFieldPair(panel, cre.getAttribute(CreResource.CRE_LEVEL_WIZARD), gbl, gbc, true);

    return panel;
  }

// -------------------------- INNER CLASSES --------------------------

  private static final class SpellListRendererIWD2 extends DefaultListCellRenderer
      implements ListValueRenderer
  {
    private SpellListRendererIWD2()
    {
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus)
    {
      JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      label.setText(getListValue(value));
      return label;
    }

    @Override
    public String getListValue(Object value)
    {
      if (value instanceof AbstractStruct) {
        AbstractStruct struct = (AbstractStruct)value;
        return struct.getName() + " (" + (struct.getFields().size() - 2) + ')';
      }
      if (value != null) {
        return value.toString();
      }
      return "";
    }
  }
}
