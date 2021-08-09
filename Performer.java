package performers;

import java.util.Iterator;

public interface Performer {
	String getName();
	Iterator<String> getRecordsByInsertion();
	void addRecord(String record);
	//boolean hasRecord(String record);?
}
