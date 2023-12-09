package controller.Repositories;

import model.UserAccount.User;

public interface AuthenticationRepository {
    public  void makeRegistrationRequest(User user);
    public  void makeLoginRequest(User user);
    public int getResponseCode();
    public void setResponseCode(int code);

    public void setError(String error);

    public String getError();

    public User getUser();
}
