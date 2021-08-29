package test.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.app.dao.CompanyDao;
import test.app.dto.CompanyDto;
import test.app.model.Company;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Transactional
    @Override
    public void save(Company company) {
        companyDao.save(company);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CompanyDto> getAll() {
        return companyDao.getAll();
    }

}