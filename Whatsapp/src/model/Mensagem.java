package model;

import java.util.ArrayList;

public class Mensagem {
	private int id;
	private String user;
	private String chat;
	private String msg;
	
	public Mensagem(int id, String user, String chat, String msg) {
		this.id = id;
		this.user = user;
		this.chat = chat;
		this.msg = msg;
	}
	
	public static boolean newMsg(String nome, String nomeChat, ArrayList<Chat> chats) {
		for(Chat i : chats) {
			if(i.getNomeChat().equals(nomeChat) && i.getNomeUsuarios().equals(nome)) {
				return true;
			}
		}
		return false;		
	}
	
	/*public static boolean lerMsg(String nome, String nomeChat, ArrayList<Mensagem> msgs, ArrayList<Mensagem> msgsLidas) {
		ArrayList<Mensagem> msgNaoLidas = new ArrayList<Mensagem>();
		for(Mensagem i : msgs) {
			if(msgsLidas.get(i.getId())== null && i.getChat().equals(nomeChat) && !(i.getUser().equals(nome))) {
				msgNaoLidas.add(new Mensagem(i.getId(), i.getUser(), i.getChat(), i.getMsg()));
				msgsLidas.add(new Mensagem(i.getId(), i.getUser(), i.getChat(), i.getMsg()));
				Principal.
				return true;
			}
		}
		return false;		
	}*/
	
	public int getId() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
			
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getChat() {
		return chat;
	}
	
	public void setChat(String chat) {
		this.chat = chat;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Mensagem [user=" + user + ", chat=" + chat + ", msg=" + msg + "]";
	}
}
