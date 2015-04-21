package pokergame;

public class Poker implements Comparable{
   private int number;
   private Type type;
   
   public enum Type {
		ºìÌÒ,Ã·»¨,·½Æ¬,ºÚÌÒ;
	 }
  
   public Poker(){
		 
  }
     public Poker(Type type,int number){
		  this.type =type;
		  this.number=number;
     }


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Poker anotherPocker=(Poker)o;
		int result=this.getNumber()-anotherPocker.getNumber();
		if(result==0){
			result=this.getType().ordinal()-anotherPocker.getType().ordinal();
		}
		return result;
	}
		 
}
