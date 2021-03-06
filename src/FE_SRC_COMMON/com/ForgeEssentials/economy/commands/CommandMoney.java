package com.ForgeEssentials.economy.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import com.ForgeEssentials.core.commands.ForgeEssentialsCommandBase;
import com.ForgeEssentials.economy.Wallet;
import com.ForgeEssentials.util.OutputHandler;

public class CommandMoney extends ForgeEssentialsCommandBase
{
	public CommandMoney()
	{
		aliasList.add("wallet");
	}
	
	@Override
	public String getCommandName()
	{
		return "money";
	}

	@Override
	public void processCommandPlayer(EntityPlayer sender, String[] args)
	{
		int money = Wallet.getWallet(sender);
		OutputHandler.chatConfirmation(sender, "You have " + money + " " + Wallet.currency(money));
	}

	@Override
	public void processCommandConsole(ICommandSender sender, String[] args)
	{
	}

	@Override
	public boolean canConsoleUseCommand()
	{
		return false;
	}

	@Override
	public String getCommandPerm()
	{
		return "ForgeEssentials.Economy." + getCommandName();
	}
}
