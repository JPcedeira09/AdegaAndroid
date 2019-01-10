package techold.com.adegaandroid.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    private static FirebaseAuth autenticacao;

    //Retorna a instancia do Firebase
    public static FirebaseAuth getFirebaseAutenticacao(){
        if ( autenticacao == null ) {
            autenticacao = FirebaseAuth.getInstance();
        }

        return autenticacao;
    }
}
