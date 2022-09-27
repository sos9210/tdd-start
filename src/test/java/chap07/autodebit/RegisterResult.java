package chap07.autodebit;

//컴파일에러제거용
public class RegisterResult {
    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult();
    }

    public static RegisterResult success() {
        return new RegisterResult();
    }

    public CardValidity getValidity() {
        return CardValidity.VALID;
    }
}
