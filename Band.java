package performers;

import java.util.Iterator;

public interface Band extends Performer {
	Iterator<String> listBandMembers();
	void addMember(String name);
}
