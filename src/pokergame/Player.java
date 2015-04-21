package pokergame;
/**
 * ����������� ���ԣ�ID�����������ƣ��˿��Ƶļ��ϣ�
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private String name;
	public List<Poker> playerPockers;
	
	public List<Poker> getPlayerPockers() {
		return playerPockers;
	}

	public void setPlayerPockers(List<Poker> playerPockers) {
		this.playerPockers = playerPockers;
	}

	public Player(int id,String name){
		this.id=id;
		this.name=name;
		playerPockers=new ArrayList<Poker>();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
