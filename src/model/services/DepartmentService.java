package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
  public List<Department> findAll(){
	  List<Department> list = new ArrayList<Department>();
	  list.add(new Department(1, "Computer"));
	  list.add(new Department(5, "Chaves"));
	  list.add(new Department(4, "Colchoes"));
	  list.add(new Department(3, "Services"));
	  return list;
  }
}
