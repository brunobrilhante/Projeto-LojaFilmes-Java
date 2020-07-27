package interface_film;

import entities.Film;

public interface Interface {

	public void add(Film f);
	public void update(int codigo);
	public void remove(int codigo);
	public String listAll();
	public String list();
}
