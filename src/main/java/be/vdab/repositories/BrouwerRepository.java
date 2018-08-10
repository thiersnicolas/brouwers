package be.vdab.repositories;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerRepository {
	public void create(Brouwer brouwer);
	public List<Brouwer> findAll();
	public List<Brouwer> findByName(String beginNaam);
	
}
