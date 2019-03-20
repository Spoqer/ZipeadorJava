package com.auebo.utils.zipeador;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipeador {
    public static void generarZip(String ubicacion, ArrayList<String> documentosAComprimir) {
        try {
            FileOutputStream salidaDeDatos = new FileOutputStream(ubicacion);
            ZipOutputStream salidaZip = new ZipOutputStream(salidaDeDatos);
            for (String documento : documentosAComprimir) {
                File archivoAZipear = new File(documento);
                FileInputStream lectorDeArchivo = new FileInputStream(archivoAZipear);
                ZipEntry entradaAlZip = new ZipEntry(archivoAZipear.getName());
                salidaZip.putNextEntry(entradaAlZip);

                byte[] bytes = new byte[1024];
                int tamano;
                while ((tamano = lectorDeArchivo.read(bytes)) >= 0) {
                    salidaZip.write(bytes, 0, tamano);
                }
                lectorDeArchivo.close();
            }
            salidaZip.close();
            salidaDeDatos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
