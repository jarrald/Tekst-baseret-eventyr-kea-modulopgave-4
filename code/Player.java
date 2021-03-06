public class Player {
	private String name;
	private int health;
	private int position_x;
	private int position_y;
	private Inventory inventory;
	private String position;
	public String getName() {
		return this.name;
	}
	public String getPosition(){
		return this.position;
	}
	public void setPosition(String position){
		this.position = position;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Inventory getInventory(){
		return this.inventory;
	}
	public void setInventory(Inventory inventory){
		this.inventory = inventory;
	}

	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public Player(String name, int health) {
		throw new UnsupportedOperationException();
	}

	public Player(String name) {
		this.position = "start";
		this.name = name;
		health = 100;
		position_x = 0; position_y = 0;
	}

	public int getPosition_x() {
		return this.position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return this.position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
}
