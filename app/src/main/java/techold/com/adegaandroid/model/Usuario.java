package techold.com.adegaandroid.model;

public class Usuario {
    private String  email;

    public String getEmail() {
        return email;
    }

    public Usuario() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;
}
