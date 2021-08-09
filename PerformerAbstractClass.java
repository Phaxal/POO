package performers;

import java.util.Iterator;
import java.util.List;

public class PerformerAbstractClass implements Performer {

	private String name;
	private List<String> records;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Iterator<String> getRecordsByInsertion() {
		return records.iterator();
	}

	@Override
	public void addRecord(String record) {
		records.add(record);
	}
	
	protected void setName(String name){
		this.name = name;
	}

}
