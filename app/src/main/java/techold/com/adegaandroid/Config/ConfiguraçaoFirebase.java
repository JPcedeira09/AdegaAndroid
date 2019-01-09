package techold.com.adegaandroid.Config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguraçaoFirebase {
    private static FirebaseAuth Autenticaçao;

    //Retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticaçao() {
          if (Autenticaçao == null ) {
              Autenticaçao = FirebaseAuth.getInstance();
          }
          return Autenticaçao;


    }
}
