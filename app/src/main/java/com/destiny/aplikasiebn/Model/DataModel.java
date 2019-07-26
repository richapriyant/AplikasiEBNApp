package com.destiny.aplikasiebn.Model;

import java.util.ArrayList;

public class DataModel {
    public static String[][] data = new String[][]{
            {"https://sahabatnesia.com/wp-content/uploads/2016/09/Batik-Aceh.jpg",
                    "Motif Batik Aceh",
                    "Ciri khas dari batik Aceh adalah menggunakan perpaduan unsur alam dan budaya dari masyarakat Aceh itu sendiri. Untuk masalah warna, batik Aceh lebih dominan menggunakan warna yang cerah.\n" +
                            "\n" +
                            "Keberanian memainkan warna itulah yang menjadikan batik Aceh terkesan unik dan glamor. Selain itu, Aceh merupakan daerah yang memiliki pengaruh Agama Islam yang kuat. Sehingga jarang sekali masyarakat Aceh menggunakan motif binatang yang merupakan larangan dalam Agama Islam."
            },
            {
                "https://sahabatnesia.com/wp-content/uploads/2016/09/batik-barong.jpg",
                    "Motif Batik Bali",
                    "Ciri khas dari kain batik Bali adalah terletak pada motifnya yang memadukan antara motif tradisional dan motif modern. Selain itu, kain batik Bali mempunyai ciri khas adanya lambang-lambang daerah seperti naga, burung bangau, kura-kura, dan rusa.\n" +
                            "\n" +
                            "Dilihat dari motif dan bentuknya dapat dikatakan bahwa motif yang ada pada batik Bali ini tidak mempunyai batasan dalam hal pengeksplorannya. Batik Bali sendiri banyak terinspirasi oleh semua hal yang berada di Bali. "
            },
            {
                "https://sahabatnesia.com/wp-content/uploads/2016/09/ae1face6631e4801be2cac15772d8832.jpg",
                    "Motif Batik Banyuwangi",
                    "Motif batik Banyuwangi merupakan sebuah perwujudan dari berbagai hal yang berkaitan dengan ciri khas daerah Banyuwangi. Batik Banyuwangi mempunyai nilai estetika yang sangat mempesona. Semua nama batik asli yang terdapat di Banyuwangi ini ternyata banyak dipengaruhi oleh keadaan alam.\n" +
                            "\n" +
                            "Beberapa motif kain batik Banyuwangi hanya mengedepankan nilai estetika dan menggambarkan jati diri dari masyarakat Banyuwangi itu sendiri."
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
