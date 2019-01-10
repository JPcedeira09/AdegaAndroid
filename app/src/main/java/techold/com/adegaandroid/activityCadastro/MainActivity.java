package techold.com.adegaandroid.activityCadastro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import techold.com.adegaandroid.R;
import techold.com.adegaandroid.config.ConfiguracaoFirebase;
import techold.com.adegaandroid.model.Usuario;

public class MainActivity extends AppCompatActivity {

    public void btConcordar(){
        startActivity(new Intent(this, SucessoActivity.class));
        finish();
    }
    private EditText campoEmail, campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_cadastro);

        campoEmail = findViewById (R.id.editEmail);
        campoSenha = findViewById (R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                // Validar se os campos foram preenchidos
                if ( !textoEmail.isEmpty()) {
                    if ( !textoSenha.isEmpty()) {

                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                         cadastrarUsuario();

                    }else{
                        Toast.makeText(MainActivity.this,
                                "Preencha o campo Senha",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,
                            "Preencha o campo E-mail",
                            Toast.LENGTH_SHORT).show();


                }
            }



        });



        }

    public void cadastrarUsuario () {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful()){
                    Toast.makeText(MainActivity.this,
                            "Sucesso ao cadastrar o usuário!",
                            Toast.LENGTH_SHORT).show();
                            btConcordar();

            }else{
                    Toast.makeText(MainActivity.this,
                            "Erro ao cadastrar o usuário.",
                            Toast.LENGTH_SHORT).show();
                }
        }
    });


}


}
