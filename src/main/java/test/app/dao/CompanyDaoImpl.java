package test.app.dao;

import org.hibernate.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import test.app.dto.CompanyDto;
import test.app.dto.UserDto;
import test.app.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CompanyDaoImpl implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<CompanyDto> getAll() {
        List<CompanyDto> companyDtos = entityManager.createQuery(
                        "SELECT c.name AS name, u.username AS username " +
                                "FROM Company c LEFT JOIN FETCH User u on c.id = u.company.id"
                )
                .unwrap(Query.class)
                .setResultTransformer(new CompanyDtoWithUserDtosTransformerForJPQLQuery())
                .list();
        return companyDtos;
    }

    private static class CompanyDtoWithUserDtosTransformerForJPQLQuery implements ResultTransformer {

        private Map<String, List<UserDto>> userMap = new HashMap<>();

        private List<CompanyDto> roots = new ArrayList<>();

        @Override
        public Object transformTuple(Object[] tuple, String[] aliaces) {
            String name = (String)tuple[0];
            String username = (String) tuple[1];

            CompanyDto taskDtoWithAnswer = new CompanyDto(name);

            if (!userMap.containsKey(name)) {
                roots.add(taskDtoWithAnswer);
                userMap.put(name, new ArrayList<>());
            }

            userMap.get(name).add(new UserDto(username));
            return taskDtoWithAnswer;
        }

        @Override
        public List<CompanyDto> transformList(List list) {
            for (CompanyDto companyDto : roots) {
                companyDto.setUserDtos(userMap.get(companyDto.getName()));
            }
            return roots;
        }
    }

}
