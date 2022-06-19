package Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Employee;
import repository.JDBCEmployeeRepository;

import java.util.Optional;

public class AuthServiceImp implements AuthService{

    JDBCEmployeeRepository userRepository;

    public AuthServiceImp (JDBCEmployeeRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<Employee> employee = userRepository.findByUsername(username);
        if (employee == null)
            return false;
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), employee.get().getPassword());
        if (result.verified)
            return true;
        return false;
    }
}
