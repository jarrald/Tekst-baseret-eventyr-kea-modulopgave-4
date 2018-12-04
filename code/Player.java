public class Player {
	private String name;
	private int health;
	private int position_x;
	private int position_y;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		throw new UnsupportedOperationException();
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