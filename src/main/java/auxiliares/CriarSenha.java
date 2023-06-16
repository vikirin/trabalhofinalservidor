package auxiliares;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriarSenha {
    private String senha1;
    private String senhahex;
    public String criarsenha(String senha)throws NoSuchAlgorithmException,
        UnsupportedEncodingException {

        senha1 =senha;

            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senhahex = hexString.toString();

            return(senhahex);
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenhahex() {
        return senhahex;
    }

    public void setSenhahex(String senhahex) {
        this.senhahex = senhahex;
    }
}
