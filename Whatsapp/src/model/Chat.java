package model;

import java.util.ArrayList;

public class Chat {
	private String nomeChat;
	private String nomeUsuarios;
	
	public Chat(String nomeChat, String usuariosChat) {
		this.nomeChat = nomeChat;
		this.nomeUsuarios = usuariosChat;
	}

	public static boolean newChat(String nome, ArrayList<Chat> chats) {
		for(Chat i : chats) {
			if(i.getNomeChat().equals(nome)) {
				return false;
			}
		}
		return true;		
	}

	public String getNomeChat() {
		return nomeChat;
	}

	public void setNomeChat(String nomeChat) {
		this.nomeChat = nomeChat;
	}

	public String getNomeUsuarios() {
		return nomeUsuarios;
	}

	public void setNomeUsuarios(String nomeUsuarios) {
		this.nomeUsuarios = nomeUsuarios;
	}

	@Override
	public String toString() {
		return "Chat [nomeChat=" + nomeChat + ", nomeUsuarios=" + nomeUsuarios + "]";
	}
}