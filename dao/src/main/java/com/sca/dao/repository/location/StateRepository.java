package com.sca.dao.repository.location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.location.Country;
import com.sca.dao.domain.location.State;


@Repository
public interface StateRepository extends JpaRepository<State, Integer>, JpaSpecificationExecutor<State> {

	State findByName(String stateName);
	
	List<State> findByCountry(Country country);

}
