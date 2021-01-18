package com.mycompany.findwords;

/**
*Instantiable class ValidWords
*Contains an array of validWords that can be used, a setter to set valid words if the words needed to be changed for future use and a getter to return the values in the validWords array
*@author David Tynan
*/

public class ValidWords{

	//create String array with all the valid words for the game
	private String[] validWords = new String[]{"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus", "cache", "command",
									"computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress",
									"development", "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon",
									"inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor",
									"multimedia", "network", "node", "offline", "online", "path", "process", "protocol", "password", "phishing", "platform", "program", "portal", "privacy",
									"programmer", "queue", "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot",
									"server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus", "web",
									"website", "window", "wireless"};

	//constructor
	//default constructor
	public ValidWords(){}

	//overload constructor if game wants to be played with different words
	public ValidWords(String[] validWords){
		this.validWords = validWords;
	}

	//setter for setting the valid words
	public void setValidWords(String[] validWords){
		this.validWords = validWords;
	}

	//getter for getting the valid words
	public String[] getValidWords(){
		return validWords;
	}
}