package lv.localhost.MyDay.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

@Component("registrationValidator")
public class RegistrationValidation {
  public boolean supports(Class<?> klass) {
    return Account.class.isAssignableFrom(klass);
  }

  public void validate(Object target, Errors errors) {
	  Account registration = (Account) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
        "NotEmpty.registration.login",
        "User Name must not be Empty.");
    String login = registration.getLogin();
    if ((login.length()) > 50) {
      errors.rejectValue("login",
          "lengthOfUser.registration.login",
          "User Name must not more than 50 characters.");
    }
  }
}