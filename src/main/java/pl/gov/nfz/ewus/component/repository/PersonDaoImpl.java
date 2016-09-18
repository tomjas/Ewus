package pl.gov.nfz.ewus.component.repository;

import org.springframework.stereotype.Repository;

import pl.gov.nfz.ewus.model.Person;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {
}
