//all the item which can be owned by the hero
public abstract class Item {


	protected String name;

	// the level needed to use this item
	protected int reqLevel;

	protected int price;
	public Item(){}

	// constructor
	public Item(String na, int pri, int reqL){
		name = na;
		price = pri;
		reqLevel = reqL;
	}

	//getter and setter below

	public String getName() {return name;}

	public int getPrice() {return price;}

	public int getLevel() {return reqLevel;}

	public void setName(String name){
		this.name = name;
	}

	public void setPrice(int price){
		this.price = price;
	}

	// set the required level
	public void setLevel(int reqLevel){
		this.reqLevel = reqLevel;
	}

	@Override
	public String toString(){

		return  "s";
	}

}