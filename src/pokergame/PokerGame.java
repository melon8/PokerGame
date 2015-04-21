package pokergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Son
* 实现1.创建52张牌（不包含大王小王）有顺序
 * 2.洗牌 
 * 3.发牌，每人轮流发一张，各发两张
 * 4.游戏：取每人手中最大的牌比较，谁的点数大赢，数字一样则比较花色
 */
public class PokerGame {
	public List<Poker> pokers;
	public List<Poker> newPokers;//洗牌后的前四张（发给玩家的）
	//public List<Player> players;
	
	public Table table;
	public Scanner console;
	
	public Player[] player;
	public int[] playerId;
	public String[] playerName;
	public Poker[] eachMaxCard;//第i位玩家手中的最大的牌
	@SuppressWarnings("finally")
	public PokerGame(){
		
		table=new Table();
		playerId=new int[2];
		playerName=new String[2];
		player=new Player[2];
		newPokers=new ArrayList<Poker>();
		
		System.out.println("---游戏开始---");
		//创建拍并打印出来每一张牌号
		System.out.println("---创建扑克牌---");
		pokers=table.createPokers();
		System.out.println("---扑克牌创建成功---");
		
		
		System.out.println("---创建2个玩家---");
		console=new Scanner(System.in);
		
		//提醒用户依次输入玩家id和名字，若输入的id不是整数，提醒玩家重新输入
		for(int i=0;i<2;i++){
			System.out.println("---请输入第"+(i+1)+"个玩家id---");

			boolean inputOK=false;
			while(!inputOK){
				try {
					playerId[i]=console.nextInt();
					inputOK=true;
				} catch (Exception e) {
					// TODO: handle exception
					console.nextLine();
					System.out.println("您输入的不是整数，请重新输入");
					

				}
			}
			
			
			System.out.println("---请输入第"+(i+1)+"个姓名---");
			playerName[i]=console.next();
			

			player[i]=new Player(playerId[i], playerName[i]);
		}
		
		
		System.out.println("---开始洗牌---");
		newPokers=table.shuffledPokers(pokers);
		for(int i=0;i<4;i++){
			System.out.println(newPokers.get(i).getType()+""+newPokers.get(i).getNumber());
		}
		System.out.println("---洗牌结束---");
		
		
		//给两玩家依次发牌 j个玩家，每人i张牌
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.println("给玩家"+player[j].getName()+"发第"+(i+1)+"张牌");
				player[j].playerPockers.add(newPokers.get(0));	
				newPokers.remove(0);
			}	
		}
		for(int i=0;i<2;i++){
			System.out.println("玩家"+player[i].getName()+"的牌为"+player[i].playerPockers.get(0).getType()+""+player[i].playerPockers.get(0).getNumber()
					+"    "+player[i].playerPockers.get(1).getType()+""+player[i].playerPockers.get(1).getNumber());
		}
		
		
		///////比较两玩家手中牌的大小
		//先找出每个玩家手中最大牌  再比较这两张牌 最后返回大的牌的玩家
		if(this.maxCard(player)==null){
			System.out.println("平手");
		}else{
			System.out.println("ID为："+this.maxCard(player).getId()+"的玩家"+this.maxCard(player).getName()+"胜出");
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokerGame pg=new PokerGame();
		
	}
	///////比较两玩家手中牌的大小
	//先找出每个玩家手中最大牌  再比较这两张牌 最后返回大的牌的玩家
	public Player maxCard(Player[] player){
		eachMaxCard=new Poker[2];
		//i代表第i个玩家
		for(int i=0;i<2;i++){	
			Poker p1=player[i].getPlayerPockers().get(0);
			Poker p2=player[i].getPlayerPockers().get(1);
//			System.out.println("玩家"+player[i].getName()+"的牌为"+p1.getType()+""+p1.getNumber()+"  "+p2.getType()+""+p2.getNumber());
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
