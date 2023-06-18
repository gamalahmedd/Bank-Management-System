package model;

public class User {

    public static String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public static String mobileNumberPattern = "^1[0125][0-9]{8}$"; //-> Valid Number 01153212712
    public static String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"; // at least one digit, at least 8 characters, at least one lowercase, at least uppercase, at least one special character
    public static String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public static String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";

    private int id;
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;
    private String securityQuestion;
    private String answer;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static boolean testUser(User user) {
        if (user.getName().matches(namePattern) && user.getEmail().matches(emailPattern) && user.getMobileNumber().matches(mobileNumberPattern) && user.getAddress().matches(addressPattern) && user.getPassword().matches(passwordPattern) && !user.getSecurityQuestion().equals("") && !user.getAnswer().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testUpdateUser(User user) {
        if (user.getEmail().matches(emailPattern) && user.getPassword().matches(passwordPattern)) {
            return true;
        }
        else
            return false;
    }
    
    public static boolean testEmailUser(User user) {
        if (user.getEmail().matches(emailPattern)) {
            return true;
        }
        else
            return false;
    }

    public User(String name, String email, String mobileNumber, String address, String password, String securityQuestion, String answer, String status) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.status = status;
    }

    public User() {

    }

}
