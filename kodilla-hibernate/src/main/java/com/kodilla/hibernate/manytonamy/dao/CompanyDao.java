package com.kodilla.hibernate.manytonamy.dao;

import com.kodilla.hibernate.manytonamy.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDao extends CrudRepository<Company, Integer> {
}
