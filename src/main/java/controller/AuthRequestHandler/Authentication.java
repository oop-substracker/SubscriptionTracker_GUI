package controller.AuthRequestHandler;

import controller.Repositories.AuthenticationRepository;
import model.UserAccount.User;

public class Authentication  {

   AuthenticationRepository authenticationRepository;

   public Authentication(AuthenticationRepository authenticationRepository) {
       this.authenticationRepository = authenticationRepository;
   }

    public void registerUser(User user) {
        authenticationRepository.makeRegistrationRequest(user);
    }

    public void loginUser(User user) {
        authenticationRepository.makeLoginRequest(user);
    }

    public int getResponseCode() {
        return authenticationRepository.getResponseCode();
    }

    public String getError() {
        return authenticationRepository.getError();
    }

    public User getUser() {
       return authenticationRepository.getUser();
    }
}
