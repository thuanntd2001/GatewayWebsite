package spring.bean.itf;

public interface EmailSender {
    void sendNM(String to, String email, String subject);
    
    public void sendWCC(String to, String email, String sj, String[] cc);
    	
    void sendRegiter(String to, String email);

}
