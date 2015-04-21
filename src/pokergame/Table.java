package pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import pokergame.Poker.Type;

/**
 * 实现1.创建52张牌（不包含大王小王）有顺序
 * 2.洗牌 
 * 3.发牌，每人轮流发一张，各发两张
 * @author Song
 *
 */
public class Table {
	public List<Poker> pokers;
	public Player player;
	

	
	public Table(){	
	pokers=new ArrayList<Poker>();
		
	}
	/**
	 * 创建一副扑克牌
	 */
	public  List<Poker> createPokers(){
		System.out.println("您的牌为：");
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				Poker poker=new Poker();
				poker.setType(Type.values()[i]);
				poker.setNumber(j);
				pokers.add(poker);
				if(j<10){
				System.out.print(poker.getType()+""+poker.getNumber()+"   ");
				}else if(j==10){
					System.out.print(poker.getType()+"J"+"   ");
				}else if(j==11){
					System.out.print(poker.getType()+"Q"+"   ");
				}else {
					System.out.print(poker.getType()+"K"+"   ");
				}
			}
		}
		return pokers;
	}
	
    /**
     * 返回洗过的牌 调用collection的shuffle方法
     */
	public List<Poker> shuffledPokers(List<Poker> pokers){
		Collections.shuffle(pokers);
        
		return pokers;
	}
	
}
