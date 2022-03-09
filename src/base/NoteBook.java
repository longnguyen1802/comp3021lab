package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class NoteBook {
	private ArrayList<Folder> folders;
	public NoteBook(){
		folders = new ArrayList<Folder>();
	}
	public boolean createTextNote(String folderName,String title,String content) {
		TextNote note = new TextNote(title,content);
		return insertNote(folderName,note);
	}
	public boolean createImageNote(String folderName,String title){
		ImageNote note = new ImageNote(title);
		return insertNote(folderName,note);
	}
	public boolean insertNote(String folderName,Note note) {
		Folder f = null;
		for(Folder temp:folders) {
			if(temp.getName().equals(folderName)) {
				f = temp;
			}
		}
		if(f!=null) {
			for(Note temp:f.getNotes()) {
				if(temp.equals(note)) {
					System.out.println("Creating note "+note.getTitle()+ " under folder "+folderName+" failed");
					return false;
				}
			}
			f.addNote(note);
		}
		else {
			f = new Folder(folderName);
			f.addNote(note);
			folders.add(f);
		}
		return true;
	}
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	public void sortFolders() {
		for(Folder temp:folders) {
			temp.sortNotes();
		}
		Collections.sort(folders);
	}
	public List<Note> searchNotes(String string) {
		// TODO Auto-generated method stub
		List<Note> results = new ArrayList<Note>();
		for(Folder temp:folders) {
			results.addAll(temp.searchNotes(string));
		}
		return results;
	}
}
