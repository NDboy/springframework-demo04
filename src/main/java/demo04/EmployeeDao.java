package demo04;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeDao {

    private DataSource dataSource;

    public EmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveEmployee(String name) {
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement("insert into employees(emp_name) values (?)")){
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert record", se);
        }
    }


    public List<String> listEmployees() {
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement("select emp_name from employees")){
            ResultSet rs = ps.executeQuery();
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString(1));
            }
            return names;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not list records", se);
        }
    }

    //    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    public void saveEmployee(Employee employee) {
//        entityManager.persist(employee);
//    }
//
//    public Employee findEmployeeByName(String name) {
//        return entityManager.createQuery("select e from Employee e where e.name = :name", Employee.class)
//                .setParameter("name", name)
//                .getSingleResult();
//    }

}
