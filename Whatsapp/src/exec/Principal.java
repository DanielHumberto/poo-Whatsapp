package exec;
import java.util.ArrayList;
import java.util.Scanner;

import model.Chat;
import model.Mensagem;
import model.Usuario;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String help = "-------Comandos-------\n"+
					  "addUser nome: Adiciona um usuário\n"+
					  "allUsers: mostra todos os usuários cadastrados\n"+
					  "newChat nomeUsuario nomeChat: cria um novo chat\n"+
					  "chats nomeUser: mostra os chats de um usuário\n"+
					  "invite userDoGrupo userNovo nomeChat: adiciona um usuario em um grupo\n"+
					  "users nomeChat: ver quem esta em um grupo\n"+
					  "leave nomeUser nomeChat: sair de um grupo\n"+
					  "zap nomeUser nomeChat mensagem: manda mensagem para um grupo\n"+
					  "ler nomeUser nomeChat: ler mensagens enviadas para um usuário ou grupo que ele está\n"+
					  "sair :sair do programa";
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Chat> chats = new ArrayList<Chat>();
		ArrayList<Mensagem> msg = new ArrayList<Mensagem>();
		ArrayList<Mensagem> msgLidas = new ArrayList<Mensagem>();
		int id = 0;
		while (true){
			System.out.println("Digite um comando(help para ver os comandos): ");
			String comando = sc.nextLine();
			if(comando.equals("help")){
				System.out.println(help);
			}else if(comando.equals("sair")) {
				System.out.println("Até a próxima!!!");
				break;
			}else {
				String c[] = comando.split(" ");
				switch(c[0]){
				case "addUser":
					usuarios.add(new Usuario (c[1]));
					System.out.println("Usuário cadastrado!");
					break;
				case "allUsers":
					System.out.println("==========Usuários==========");
					System.out.println(usuarios);					
					break;
				case "newChat":
					boolean res = Chat.newChat(c[2], chats);
					if(res == true) {
						chats.add(new Chat(c[2], c[1]));	
						System.out.println("Chat criado!");
					}else {
						System.out.println("chat " + c[2] + " já existe");
					}					
					break;
				case "chats":
					ArrayList<String> nomes = new ArrayList<String>();
					for(Chat i : chats) {
						if(i.getNomeUsuarios().equals(c[1])) {
							nomes.add(i.getNomeChat());
						}
					}
					System.out.println(nomes);
					break;
				case "invite":
					for(Chat i : chats) {
						if(i.getNomeUsuarios().equals(c[1]) && i.getNomeChat().equals(c[3])){
							chats.add(new Chat(c[3],c[2]));
							System.out.println("Pessoa adicionada!");
							break;	
						}
					}
					for(int i = 0; i<chats.size() ; i++) {
						if(!(chats.get(i).getNomeUsuarios().equals(c[2])) && chats.get(i).getNomeChat().equals(c[3]) && (i+1) >= chats.size()) {
							System.out.println("user "+ c[1]+ " nao esta em chat "+ c[3]);
						}
					}
					break;
				case "users":
					ArrayList<String> nomesPessoas = new ArrayList<String>();
					for(Chat i : chats) {
						if(i.getNomeChat().equals(c[1])) {
							nomesPessoas.add(i.getNomeUsuarios());
						}
					}
					System.out.println(nomesPessoas);					
					break;
				case "leave":		
					for(int i = 0; i<chats.size() ; i++) {
						if(chats.get(i).getNomeUsuarios().equals(c[1]) && chats.get(i).getNomeChat().equals(c[2])) {
							chats.remove(i);
							System.out.println("Pesssoa Removida");
						}
					}			
					break;
				case "zap":
					boolean res1 = Mensagem.newMsg(c[1], c[2], chats);
					String msgCompleta = "";
					for(int i = 3; i<c.length; i++) {
						msgCompleta += c[i]+" ";
					}
					if(res1 == true) {
						id += 1;
						msg.add(new Mensagem(id, c[1], c[2], msgCompleta));	
						System.out.println("Mensagem enviada!");
					}else {
						System.out.println("Usuário"+ c[1] +"não está no grupo!");
					}
					break;
				case "ler":
					boolean res2 = Mensagem.newMsg(c[1], c[2], chats);
					if(res2 == true) {
						ArrayList<Mensagem> msgNaoLidas = new ArrayList<Mensagem>();
						try {
							for(Mensagem i : msg) {
								if(!(msgLidas.get(i.getId()).equals(i.getId())) && i.getChat().equals(c[2]) && !(i.getUser().equals(c[1]))) {
									msgNaoLidas.add(new Mensagem(i.getId(), i.getUser(), i.getChat(), i.getMsg()));
									msgLidas.add(new Mensagem(i.getId(), i.getUser(), i.getChat(), i.getMsg()));
									System.out.println(msgNaoLidas);
								}
							}
						}catch (Exception e) {
							System.out.println("Não foi possivel mostrar suas mensagens!");
						}
					}	
				default:
					System.out.println("Comando inválido!");					
				}	
			}
		}
	}
}
