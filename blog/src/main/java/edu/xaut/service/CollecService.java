package edu.xaut.service;

import java.util.List;

import edu.xaut.bean.Collec;

public interface CollecService {

	List<Collec> findCollecByID(int userID);
}
