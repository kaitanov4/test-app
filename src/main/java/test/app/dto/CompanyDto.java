package test.app.dto;

import java.util.List;
import java.util.Objects;

public class CompanyDto {

    private String name;
    private List<UserDto> userDtos;

    public CompanyDto(){
    }

    public CompanyDto(String name) {
        this.name = name;
    }

    public CompanyDto(String name, List<UserDto> userDtos) {
        this.name = name;
        this.userDtos = userDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDto that = (CompanyDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}