package pokergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Son
* ʵ��1.����52���ƣ�����������С������˳��
 * 2.ϴ�� 
 * 3.���ƣ�ÿ��������һ�ţ���������
 * 4.��Ϸ��ȡÿ�����������ƱȽϣ�˭�ĵ�����Ӯ������һ����Ƚϻ�ɫ
 */
public class PokerGame {
	public List<Poker> pokers;
	public List<Poker> newPokers;//ϴ�ƺ��ǰ���ţ�������ҵģ�
	//public List<Player> players;
	
	public Table table;
	public Scanner console;
	
	public Player[] player;
	public int[] playerId;
	public String[] playerName;
	public Poker[] eachMaxCard;//��iλ������е�������
	@SuppressWarnings("finally")
	public PokerGame(){
		
		table=new Table();
		playerId=new int[2];
		playerName=new String[2];
		player=new Player[2];
		newPokers=new ArrayList<Poker>();
		
		System.out.println("---��Ϸ��ʼ---");
		//�����Ĳ���ӡ����ÿһ���ƺ�
		System.out.println("---�����˿���---");
		pokers=table.createPokers();
		System.out.println("---�˿��ƴ����ɹ�---");
		
		
		System.out.println("---����2�����---");
		console=new Scanner(System.in);
		
		//�����û������������id�����֣��������id�������������������������
		for(int i=0;i<2;i++){
			System.out.println("---�������"+(i+1)+"�����id---");

			boolean inputOK=false;
			while(!inputOK){
				try {
					playerId[i]=console.nextInt();
					inputOK=true;
				} catch (Exception e) {
					// TODO: handle exception
					console.nextLine();
					System.out.println("������Ĳ�������������������");
					

				}
			}
			
			
			System.out.println("---�������"+(i+1)+"������---");
			playerName[i]=console.next();
			

			player[i]=new Player(playerId[i], playerName[i]);
		}
		
		
		System.out.println("---��ʼϴ��---");
		newPokers=table.shuffledPokers(pokers);
		for(int i=0;i<4;i++){
			System.out.println(newPokers.get(i).getType()+""+newPokers.get(i).getNumber());
		}
		System.out.println("---ϴ�ƽ���---");
		
		
		//����������η��� j����ң�ÿ��i����
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.println("�����"+player[j].getName()+"����"+(i+1)+"����");
				player[j].playerPockers.add(newPokers.get(0));	
				newPokers.remove(0);
			}	
		}
		for(int i=0;i<2;i++){
			System.out.println("���"+player[i].getName()+"����Ϊ"+player[i].playerPockers.get(0).getType()+""+player[i].playerPockers.get(0).getNumber()
					+"    "+player[i].playerPockers.get(1).getType()+""+player[i].playerPockers.get(1).getNumber());
		}
		
		
		///////�Ƚ�����������ƵĴ�С
		//���ҳ�ÿ��������������  �ٱȽ��������� ��󷵻ش���Ƶ����
		if(this.maxCard(player)==null){
			System.out.println("ƽ��");
		}else{
			System.out.println("IDΪ��"+this.maxCard(player).getId()+"�����"+this.maxCard(player).getName()+"ʤ��");
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokerGame pg=new PokerGame();
		
	}
	///////�Ƚ�����������ƵĴ�С
	//���ҳ�ÿ��������������  �ٱȽ��������� ��󷵻ش���Ƶ����
	public Player maxCard(Player[] player){
		eachMaxCard=new Poker[2];
		//i�����i�����
		for(int i=0;i<2;i++){	
			Poker p1=player[i].getPlayerPockers().get(0);
			Poker p2=player[i].getPlayerPockers().get(1);
//			System.out.println("���"+player[i].getName()+"����Ϊ"+p1.getType()+""+p1.getNumber()+"  "+p2.getType()+""+p2.getNumber());
			int result1=p1.compareTo(p2);
//			System.out.println(result1);
			
				
			if(result1>=0){
				eachMaxCard[i]=p1;
			}else {
				eachMaxCard[i]=p2;
			}
		}
		//System.out.println(eachMaxCard[0].getType()+""+eachMaxCard[0].getNumber()+"     "+eachMaxCard[1].getType()+""+eachMaxCard[1].getNumber());
		int result2=eachMaxCard[0].compareTo(eachMaxCard[1]);
		if(result2>0)
			return player[0];
		else if(result2<0)
			return player[1];
		else 
			return null;
	}
}
