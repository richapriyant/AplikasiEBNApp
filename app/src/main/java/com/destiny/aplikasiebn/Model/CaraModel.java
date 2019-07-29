package com.destiny.aplikasiebn.Model;

import java.util.ArrayList;

public class CaraModel {
    public static String[][] data = new String[][]{
            {"http://www.jnjbatik.com/wp-content/uploads/2016/11/kamu-tahu-apa-itu-batik-tulis.jpg",
                    "Batik Tulis",
                    "Batik tulis adalah batik yang dibuat dengan menggunakan canting. Pembuatan batik tulis ini lebih lama yaitu sekitar 2-3 bulan. Proses pembuatannya yaitu dimulai dengan pembuatan design atau yang disebut dengan molani, menyanting (melukis dengan lilin/malam menggunakan canting), memberi warna, melorot, kemudian penjemuran. Batik tulis tidak memiliki motif pengulangan yang jelas dengan ukuan garis motif yang relatif kecil dibandingkan dengan batik cap."
            },
            {"https://alunalunkamera.files.wordpress.com/2018/03/img_6059-1024x820.jpg?resize=720%2C577",
                    "Batik Cap",
                    "Batik cap adalah teksture atau corak batik yang dibentuk dengan cap. Biasanya proses pembuatan batik cap lebih cepat daripada batik tulis yaitu sekitar 2-3 hari. Batik cap dikerjakan manual dengan menggunakan alat cap yang biasanya terbuat dari tembaga yang dibentuk dengan design tertentu. Alat cap (stempel) tersebut selanjutanya dicelupkan ke dalam lilin panas, kemudian ditekan atau dicapkan pada kain. Gambar batik cap biasanya tidak tembus pada kedua sisi kain."
            },
            {"http://casofaclothing.com/wp-content/uploads/2017/08/service-page01-1.jpg",
                    "Batik Sablon",
                    "Batik sablon atau disebut juga batik printing adalah batik yang proses pembuatannya dicetak melalui proses sablon. Proses batik dapat diselesaikan tanpa menggunakan lilin malam serta canting. Prosesnya sama seperti pembuatan spanduk atau kaos sablon namun dengan bahan warna yang lebih bagus mutunya. Permukaan kain batik sablon jika dilihat hanya satu sisi saja yag bergambar, sedangkan sisi lainnya polos. Hal inilah yang membuat warna batik sablon lebih cepat luntur karena warnanya tidak meresap ke kain.\n" +
                            "\n" +
                            "Itulah 3 jenis batik menurut teknik pembuatannya. Dari segi kualitas, batik tulis memang lebih bagus karena proses pembuatannya yang menggunakan canting membuatnya memiliki seni tersendiri."
            }

    };
    public static ArrayList<Model> getListData(){
        Model models = null;
        ArrayList<Model> list = new ArrayList<>();
        for (String[] aData : data) {
            models = new Model();
            models.setGambar(aData[0]);
            models.setNama(aData[1]);
            models.setDeskripsi(aData[2]);
            list.add(models);
        }
        return list;
    }
}
