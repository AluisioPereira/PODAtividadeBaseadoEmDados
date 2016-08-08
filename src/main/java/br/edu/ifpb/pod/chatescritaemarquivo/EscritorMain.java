/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chatescritaemarquivo;

import java.io.IOException;

/**
 *
 * @author Aluísio
 */
public class EscritorMain {

    public static void main(String[] args) throws IOException {
            String path = "C:/Users/CLIENTE/Documents/pastapod/arquivo.txt";
        while (true) {
            ManipulaArquivo.escritor(path);
//            ManipulaArquivo.leitor(path);
        }

    }

}
