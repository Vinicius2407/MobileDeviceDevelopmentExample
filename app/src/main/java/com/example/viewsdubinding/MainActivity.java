package com.example.viewsdubinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.viewsdubinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnConfirmar.setOnClickListener(this);
        binding.btnLimpar.setOnClickListener(this);

        public void onClick(View v) {
            if (v.getId() == R.id.btnLimpar) {
//            Toast.makeText(this, "Limpar", Toast.LENGTH_SHORT).show();
                binding.edtNome.setText("");
                binding.edtEmail.setText("");
                binding.edtTelefone.setText("");
                binding.swtWhats.setChecked(false);
                binding.rdbPeriodo.clearCheck();
                binding.chkInternet.setChecked(false);
                binding.chkTelefone.setChecked(false);
                binding.chkTvACabo.setChecked(false);
                binding.chkStreaming.setChecked(false);
                binding.lblDados.setVisibility(View.INVISIBLE);
            }

            if (v.getId() == R.id.btnConfirmar) {
//            Toast.makeText(this, "Confirmar", Toast.LENGTH_SHORT).show();
                String nome = binding.edtNome.getText().toString();
                String email = binding.edtEmail.getText().toString();
                String telefone = binding.edtTelefone.getText().toString();
                String whats = binding.swtWhats.isChecked() ? "Sim" : "Não";
                String periodo = "";
                if (binding.rdbManha.isChecked()) {
                    periodo = "Manhã";
                } else if (binding.rdbTarde.isChecked()) {
                    periodo = "Tarde";
                } else if (binding.rdbNoite.isChecked()) {
                    periodo = "Noite";
                }
                String preferencia = "";
                if (binding.chkInternet.isChecked()) {
                    preferencia += "Internet ";
                }
                if (binding.chkTelefone.isChecked()) {
                    preferencia += "Telefone ";
                }
                if (binding.chkTvACabo.isChecked()) {
                    preferencia += "TV a Cabo ";
                }
                if (binding.chkStreaming.isChecked()) {
                    preferencia += "Streaming ";
                }

                binding.txtNome.setText(nome);
                binding.txtEmail.setText(email);
                binding.txtTelefone.setText(telefone);
                binding.txtWhats.setText(whats);
                binding.txtPeriodo.setText(periodo);
                binding.txtPreferencia.setText("As preferencias foram essas:" +preferencia);

                binding.lblDados.setVisibility(View.VISIBLE);
            }
        }
    }
}