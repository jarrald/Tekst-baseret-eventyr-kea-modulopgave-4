public class Equipment {
	private Item weapon;
	public Inventory _;

	public Item getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item equipWeapon(Object item) {
		throw new UnsupportedOperationException();
	}
}