public class Encounter {
	private String text;
	private Enemy optionalEnemy;
	private Item optionalItem;

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Enemy getOptionalEnemy() {
		return this.optionalEnemy;
	}

	public void setOptionalEnemy(Enemy optionalEnemy) {
		this.optionalEnemy = optionalEnemy;
	}

	public Item getOptionalItem() {
		return this.optionalItem;
	}

	public void setOptionalItem(Item optionalItem) {
		this.optionalItem = optionalItem;
	}
}