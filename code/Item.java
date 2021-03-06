public class Item {
	private String name;
	private String description;
	private int damage;
	private String type;
	private int health;
	public Item(String name, String description, int damage, String type, int health){
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.type = type;
		this.health = health;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}