package comp3021.lab6.base;

import java.util.Date;

public class Note implements Comparable<Note>,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String title;
	public Note(String title) {
		this.date = new Date(System.currentTimeMillis());
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public boolean equals(Note other) {
		if(other.title.equals(this.title)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		return date.toString()+"\t"+title;
	}
	@Override
	public int compareTo(Note o) {
		return this.date.compareTo(o.date);
	}
}
