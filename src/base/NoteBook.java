package base;

import java.util.ArrayList;
public class NoteBook {
	private ArrayList<Folder> folders;
	public NoteBook(){
		folders = new ArrayList<Folder>();
	}
	public boolean createTextNote(String folderName,String title) {
		TextNote note = new TextNote(title);
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
}
