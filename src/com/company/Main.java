package com.company;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args) {


        //1. Să afișeze la consolă lista secțiilor spitalului cu un număr de locuri strict mai mare decât 10

        //Citire din JSON
        List<Sectie> listaSectii = new ArrayList<>();

        try(var fisier = new FileReader("/Users/claudiapistol/IdeaProjects/subiectSpital/src/sectii.json")) {
            var jsonSectii = new JSONArray(new JSONTokener((fisier)));

            for (int i=0;i<jsonSectii.length();i++) {
                var jsonSectie=jsonSectii.getJSONObject(i);

                Sectie tempSectie = new Sectie(
                        jsonSectie.getInt("cod_sectie"),
                        jsonSectie.getString("denumire"),
                        jsonSectie.getInt("numar_locuri")
                );
                listaSectii.add(tempSectie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listaSectii.forEach(System.out::println);
        System.out.println();

        //Exercitiul 1

        listaSectii
                .stream()
                .filter(x -> x.getNr_locuri() > 10)
                .forEach(System.out::println);






//        2) Să afișeze la consolă lista secțiilor spitalului sortată descrescător după varsta medie a pacientilor
//        internați pe secție.
//        Pentru fiecare secție se va afișa codul, denumirea, numărul de locuri și vârsta medie a pacienților.

        //citire pacienti din fisier text

        List<Pacient> listaPacienti = new ArrayList<>();
        String fisierPacienti = ("/Users/claudiapistol/IdeaProjects/subiectSpital/src/pacienti.txt");
    //nc nume clasa
        try(BufferedReader readerPacienti = new BufferedReader(new FileReader(fisierPacienti))) {

            String linie = readerPacienti.readLine();
            while((linie=readerPacienti.readLine()) != null) {

                String[] elemLinie = linie.split(",");
                long cnp_pacient = Long.parseLong(elemLinie[0]);
                String nume = elemLinie[1];
                int varsta = Integer.parseInt(elemLinie[2]);
                int numar_sectie = Integer.parseInt(elemLinie[3]);

                Pacient tempPacient = new Pacient(cnp_pacient, nume, varsta, numar_sectie);
                listaPacienti.add(tempPacient);
            }

            readerPacienti.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        listaPacienti.forEach(System.out::println);
        System.out.println();

        for(Sectie sectieCurenta:listaSectii) {

            Double varstamediePeSectia = listaPacienti
                    .stream()
                    .filter(s->s.getCod_sectie() == sectieCurenta.getCod_sectie())
                    .collect(Collectors.averagingInt(p->p.getVarsta()));

            sectieCurenta.setVarsta_medie(varstamediePeSectia);
        }


        System.out.println("Exercitiul 2");
        listaSectii
                .stream()
                .sorted(Comparator.comparingDouble(Sectie::getVarsta_medie).reversed())
                .forEach(System.out::println);



        //scrieti in fisierul text jurnal.txt
//        cod_secție_1,nume secție_1,numar_pacienti_1
//        ...
        for(Sectie sectieCurenta: listaSectii) {
            long numarPeSectie = listaPacienti
                    .stream()
                    .filter(s->s.getCod_sectie() == sectieCurenta.getCod_sectie())
                    .collect(Collectors.counting());

            sectieCurenta.setNrPacienti(numarPeSectie);
        }

        System.out.println("Exercitiul 3");


        try {
            PrintWriter writerSectii = new PrintWriter(new File("raport.txt"));
            writerSectii.println("cod_secție_1,nume secție_1,numar_pacienti_1\n");
            for (Sectie s : listaSectii) {
                writerSectii.println(s.getCod_sectie()+","+s.getDenumire()+","+s.getNrPacienti());
            }
            writerSectii.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
