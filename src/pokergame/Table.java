package pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import pokergame.Poker.Type;

/**
 * ʵ��1.����52���ƣ�����������С������˳��
 * 2.ϴ�� 
 * 3.���ƣ�ÿ��������һ�ţ���������
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
	 * ����һ���˿���
	 */
	public  List<Poker> createPokers(){
		System.out.println("������Ϊ��");
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
     * ����ϴ������ ����collection��shuffle����
     */
	public List<Poker> shuffledPokers(List<Poker> pokers){
		Collections.shuffle(pokers);
        
		return pokers;
	}
	
}
