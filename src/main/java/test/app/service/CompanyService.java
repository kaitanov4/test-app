package test.app.service;

import test.app.dto.CompanyDto;
import test.app.model.Company;

import java.util.List;

public interface CompanyService {

    void save(Company company);

    List<CompanyDto> getAll();

}
