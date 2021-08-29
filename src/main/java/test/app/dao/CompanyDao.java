package test.app.dao;

import test.app.dto.CompanyDto;
import test.app.model.Company;

import java.util.List;

public interface CompanyDao {

    void save(Company company);

    List<CompanyDto> getAll();

}
