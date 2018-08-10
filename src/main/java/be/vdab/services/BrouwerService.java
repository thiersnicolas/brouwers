package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
void create(Brouwer brouwer);
List<Brouwer> findAll();
List<Brouwer> findByName(String beginNaam);
}
