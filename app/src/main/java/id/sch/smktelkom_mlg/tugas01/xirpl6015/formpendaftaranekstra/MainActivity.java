package id.sch.smktelkom_mlg.tugas01.xirpl6015.formpendaftaranekstra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etKelas;
    Button bS;
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKelas = (EditText) findViewById(R.id.editTextKelas);
        bS = (Button) findViewById(R.id.buttonSelesai);
        tvDetail = (TextView) findViewById(R.id.textViewDL);

        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String kelas = etKelas.getText().toString();
            tvDetail.setText(nama + "\nkelas " + kelas);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (kelas.isEmpty()) {
            etKelas.setError("Kelas belum diisi");
            valid = false;
        } else {
            etKelas.setError(null);
        }
        return valid;
    }
}
