import java.util.ArrayList;
import java.util.Vector;

public class Inventory {
	private int slots;
	private ArrayList<Item> allItems;
	private Equipment equipped;

	public int getSlots() {
		return this.slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public ArrayList<Item> getAllItems() {
		return this.allItems;
	}

	public void setAllItems(ArrayList<Item> allItems) {
		this.allItems = allItems;
	}

	public Equipment getEquipped() {
		return this.equipped;
	}

	public void setEquipped(Equipment equipped) {
		this.equipped = equipped;
	}

	public boolean useItem(Object item) {
		throw new UnsupportedOperationException();
	}

	public boolean addItem(Item item) {
		this.allItems.add(item);
		return true;
	}

	public boolean dropItem(Object item) {
		throw new UnsupportedOperationException();
	}
}