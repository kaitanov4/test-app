package test.app.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import test.app.dto.CompanyDto;
import test.app.model.Company;
import test.app.model.User;
import test.app.service.CompanyService;
import test.app.service.UserService;

import java.util.List;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner{

    private final UserService userService;
    private final CompanyService companyService;

    public ApplicationRunnerImpl(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @Override
    public void run(ApplicationArguments args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        User user5 = new User("user5");
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        Company company1 = new Company("company1");
        Company company2 = new Company("company2");
        companyService.save(company1);
        companyService.save(company2);
        company1.addUser(user1);
        company1.addUser(user2);
        company1.addUser(user3);
        company2.addUser(user4);
        company2.addUser(user5);
        userService.update(user1);
        userService.update(user2);
        userService.update(user3);
        userService.update(user4);
        userService.update(user5);
        List<CompanyDto> companies = companyService.getAll();
        for(CompanyDto companyDto: companies){
            System.out.println(companyDto.toString() + companyDto.getUserDtos());
        }

    }

}