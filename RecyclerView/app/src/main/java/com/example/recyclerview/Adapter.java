package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mobile_4.R;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MahasiswaViewHolder> {
    private ArrayList<Mahasiswa> dataList;

    // Konstruktor Adapter, menerima ArrayList dataMahasiswa sebagai parameter
    public Adapter(ArrayList<Mahasiswa> dataList) {
        this.dataList = dataList;
    }

    // Metode ini mengembalikan ViewHolder baru ketika RecyclerView memerlukannya
    @Override
    public Adapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate (memuat) tampilan list_item.xml sebagai tampilan item dalam RecyclerView
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);

        // Membuat dan mengembalikan objek MahasiswaViewHolder
        return new MahasiswaViewHolder(view);
    }

    // Metode untuk mengikat data dari objek Mahasiswa ke ViewHolder
    @Override
    public void onBindViewHolder(Adapter.MahasiswaViewHolder holder, int position) {
        // Mengatur nilai TextView dalam ViewHolder dengan data dari ArrayList
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNpm());
        holder.txtnohp.setText(dataList.get(position).getNohp());
    }

    // Metode ini mengembalikan jumlah item dalam RecyclerView
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    // Kelas MahasiswaViewHolder adalah inner class yang mengimplementasikan ViewHolder
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNama, txtNpm, txtnohp;

        // Konstruktor MahasiswaViewHolder
        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            // Menghubungkan TextView dalam tampilan item dengan variabel ViewHolder
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtnohp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
        }
    }
}
