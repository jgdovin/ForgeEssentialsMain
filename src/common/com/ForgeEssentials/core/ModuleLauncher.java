package com.ForgeEssentials.core;

import com.ForgeEssentials.WorldBorder.ModuleWorldBorder;
import com.ForgeEssentials.WorldControl.ModuleWorldControl;
import com.ForgeEssentials.commands.ModuleCommands;
import com.ForgeEssentials.core.commands.CoreCommands;
import com.ForgeEssentials.permissions.ModulePermissions;
import com.ForgeEssentials.property.ModuleProperty;
import com.ForgeEssentials.skcompat.LibraryDetector;
import com.ForgeEssentials.util.OutputHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Initialize modules here. Yes. HERE. NOT ForgeEssentials.java! This is the springboard...
 * TODO trap NoClassDefFound if a certain module is not found, right now all are required and you use the config.
 */

public class ModuleLauncher
{
	public CoreCommands corecmd;

	public ModuleCommands commands;
	public ModulePermissions permission;
	public ModuleWorldControl worldcontrol;
	public ModuleProperty property;
	public ModuleWorldBorder worldborder;

	public static boolean permsEnabled = true;
	public static boolean cmdEnabled = true;
	public static boolean wcEnabled = true;
	public static boolean propEnabled = true;
	public static boolean borderEnabled = true;

	public void preLoad(FMLPreInitializationEvent e)
	{
		OutputHandler.SOP("Discovering and loading modules...");
		OutputHandler.SOP("If you would like to disable a module, please look in ForgeEssentials/config.cfg.");
		worldcontrol = new ModuleWorldControl();
		commands = new ModuleCommands();
		corecmd = new CoreCommands();
		permission = new ModulePermissions();
		property = new ModuleProperty();
		worldborder = new ModuleWorldBorder();
		
		corecmd.preLoad(e);

		if (wcEnabled && LibraryDetector.wepresent != true)
			worldcontrol.preLoad(e);

		if (cmdEnabled)
			commands.preLoad(e);

		if (permsEnabled)
			permission.preLoad(e);

		if (propEnabled)
			property.preLoad(e);
		
		if (borderEnabled)
			worldborder.preLoad(e);
	}

	public void load(FMLInitializationEvent e)
	{
		corecmd.load(e);

		if (wcEnabled && LibraryDetector.wepresent != true)
			worldcontrol.load(e);

		if (cmdEnabled)
			commands.load(e);

		if (permsEnabled)
			permission.load(e);

		if (propEnabled)
			property.load(e);

		if (borderEnabled)
			worldborder.load(e);
	}

	public void serverStarting(FMLServerStartingEvent e)
	{
		corecmd.serverStarting(e);

		if (wcEnabled) // && LibraryDetector.wepresent != true)
			worldcontrol.serverStarting(e);

		if (cmdEnabled)
			commands.serverStarting(e);

		if (permsEnabled)
			permission.serverStarting(e);

		if (propEnabled)
			property.serverStarting(e);

		if (borderEnabled)
			worldborder.serverStarting(e);
	}
}
