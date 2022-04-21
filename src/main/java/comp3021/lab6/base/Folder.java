package comp3021.lab6.base;
import java.security.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Folder implements Comparable<Folder>,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Note> notes;
	private String name;
	public Folder(String name) {
		this.name = name;
		notes = new ArrayList<Note>();
	}
	public void addNote(Note other) {
		notes.add(other);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Note> getNotes(){
		return this.notes;
	}
	@Override 
	public String toString() {
		int nText=0;
		int nImage=0;
		for(Note temp:notes) {
			if(temp instanceof TextNote) {
				nText++;
			}
			if(temp instanceof ImageNote) {
				nImage++;
			}
		}
		return name + ":" + nText + ":" + nImage;
	}
	public List<Note> searchNotes(String keywords){
		String[] listWord = keywords.toLowerCase().split(" ");
		boolean isOr = false;
		int numOfCondition = -1;
		ArrayList< ArrayList<String> > listOfCondition = new ArrayList< ArrayList<String> >();
		
		for(String a:listWord){
			if(a.equals("or")){
				isOr = true;
			}else{
				if(!isOr){
				    numOfCondition++;
					listOfCondition.add(new ArrayList<String>() );
					listOfCondition.get(numOfCondition).add(a);
				}else{
					listOfCondition.get(numOfCondition).add(a);
					isOr = false;
				}
			}
		}
		ArrayList<Note> results = new ArrayList<Note>() ;
		for(Note note:notes){
			if(note instanceof ImageNote){
				if(statisfy(note.getTitle(), listOfCondition)){
					results.add(note);
				}
			}
			else{
				TextNote temp = (TextNote)note;
				if(statisfy(temp.getTitle(), listOfCondition) || statisfy(temp.content, listOfCondition)){
					results.add(temp);
				}
			}
		}
		return results;
	}
	private boolean statisfy(String target,ArrayList< ArrayList<String> > listOfCondition){
		for(ArrayList<String> listWord:listOfCondition){
			if(!containOne(target, listWord)){
				return false;
			}
		}
		return true;
	}
	private boolean containOne(String target,ArrayList<String> listWord){
		for(String a:listWord){
			if(target.toLowerCase().contains(a) ){
				return true;
			}
		}
		return false;
	}


	
	@Override
	public int compareTo(Folder o) {
		return this.name.compareTo(o.name);
	}
	public void sortNotes() {
		// TODO Auto-generated method stub
		Collections.sort(notes);
		
	}
}