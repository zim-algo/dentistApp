package miu.edu.lab6.dentistapp.service;

import miu.edu.lab6.dentistapp.model.Surgery;

import java.util.List;
import java.util.Optional;

public interface SurgeryService {

  Surgery save(Surgery surgery);
  void saveAll(List<Surgery> surgeryList);
  List<Surgery> getAll();
  Optional<Surgery> getById(Integer surgeryId);
  void delete(Integer surgeryId);
  void update(Surgery newSurgery, Integer surgeryId);

}
