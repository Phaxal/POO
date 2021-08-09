package performers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BandClass extends PerformerAbstractClass implements Band {

	private List<String> bandMembers;
	
	public BandClass(int numberOfMembers){
		bandMembers = new ArrayList<String>(numberOfMembers);
	}

	public Iterator<String> listBandMembers() {
		return bandMembers.iterator();
	}

	public void addMember(String name) {
		bandMembers.add(name);
	}

}
