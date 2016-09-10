package id.sch.smktelkom_mlg.tugas01.xirpl6015.formpendaftaranekstra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etKelas;
    Button bS;
    TextView tvDetail;
    CheckBox cb24, cb25;
    Spinner spJR;
    RadioGroup rgEks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKelas = (EditText) findViewById(R.id.editTextKelas);
        bS = (Button) findViewById(R.id.buttonSelesai);
        cb24 = (CheckBox) findViewById(R.id.checkBox24);
        cb25 = (CheckBox) findViewById(R.id.checkBox25);
        spJR = (Spinner) findViewById(R.id.spinnerJurusan);
        rgEks = (RadioGroup) findViewById(R.id.radioGroupEKs);

        tvDetail = (TextView) findViewById(R.id.textViewDL);

        findViewById(R.id.buttonSelesai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        if (kelas.isEmpty()) {
            etKelas.setError("Kelas belum diisi");
        } else {
            etKelas.setError(null);
        }

        String angakatan = "";
        int startlen = angakatan.length();
        if (cb24.isChecked()) angakatan += cb24.getText() + "\n";
        if (cb25.isChecked()) angakatan += cb25.getText() + "\n";

        if (angakatan.length() == startlen) angakatan += "Belum Memilih";

        String ekstra = null;
        if (rgEks.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgEks.getCheckedRadioButtonId());
            ekstra = rb.getText().toString();
        }
        if (ekstra == null) {
            tvDetail.setText("Belum Memilih Ekstra");
        } else {
            tvDetail.setText("Kamu mimiliih ekstra : " + ekstra);
        }

        tvDetail.setText("Nama " + nama + "\n" + "Kelas " + kelas + "\n" + "Angkatan" + angakatan + "Jurusan " + spJR.getSelectedItem().toString() + "\n" + "Ekstra yang dipilih " + ekstra);
    }
}
