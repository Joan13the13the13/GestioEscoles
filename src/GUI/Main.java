/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Estudiant.Estudiant;
import Estudiant.LlistaEstudiants;
import Asignatures.Assignatura;
import Asignatures.Obligatoria;
import Asignatures.Optativa;
import Cursos.Curs;
import Cursos.FP;
import Cursos.LlistaCursos;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author joanbalaguer
 */
public class Main extends JFrame {

    //declaració del panell que contindrà tots els botons del JFrame
    private JPanel panellBotons;
    private JPanel panellActual;
    //declaració del panell que contindrà l'area de text on es mostraran les dades a l'usuari
    private PanellInit pi;
    //Declaració del PanellInfoCurs
    private PanellInfoCurs pic;

    //declaració dels botos de les diverses opcions de que otorga el programa
    private JButton altaCurs;
    private JButton matriculaEstudiant;
    private JButton baixaCurs;
    private JButton baixaAssignatura;
    private JButton infoCurs;
    private JButton infoAssignatura;
    private JButton infoEstudiant;
    private JButton sortir;

    //Declaram una llista global de Cursos a on anirem emmagatzemant els cursos creats
    LlistaCursos llistaC = new LlistaCursos();
    //Declaram la llista d'alumnes genèrica
    LlistaEstudiants llistaE = new LlistaEstudiants();

    //Mètode que construiex la finestra (COnstructor)
    public Main() {
        setTitle("Pràctica 1 - Jaume Adrover & Joan Balaguer");
        setSize(1000, 700);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

        //inicialitzam el panell que contendrà tots els botosn del JFrame
        panellBotons = new JPanel(new GridLayout(4, 2));
        panellBotons.setSize(300, 700);
        panellBotons.setBackground(Color.RED);
        //afegim el panell inicialitzat a dins el JFrame
        this.getContentPane().add(panellBotons);

        //Inicialitzam el, panell de presentació
        panellActual = new PanellInit();
        panellActual.setBounds(300, 0, 700, 700);
        this.getContentPane().add(panellActual);

        //inicialitzam els botons i els afegim dins el panell
        altaCurs = new JButton("Alta Curs");
        altaCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                altaCurs();
            }
        });
        panellBotons.add(altaCurs);

        baixaCurs = new JButton("Baixa el Curs");
        baixaCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                baixaCurs();
            }
        });
        panellBotons.add(baixaCurs);

        matriculaEstudiant = new JButton("MatriculA Estudiant");
        matriculaEstudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                matriculEstudiant();
            }
        });
        panellBotons.add(matriculaEstudiant);

        baixaAssignatura = new JButton("Baixa Assignatura");
        baixaAssignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                baixaAssignatura();
            }
        });
        panellBotons.add(baixaAssignatura);

        infoCurs = new JButton("Info Curs");
        infoCurs.setBackground(Color.yellow);
        infoCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                infoCurs();
            }
        });
        panellBotons.add(infoCurs);

        infoAssignatura = new JButton("Info Assignatura");
        infoAssignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                infoAssignatura();
            }
        });
        panellBotons.add(infoAssignatura);

        infoEstudiant = new JButton("Info Estudiant");
        infoEstudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                infoEstudiant();
            }
        });
        panellBotons.add(infoEstudiant);

        sortir = new JButton("Sortir");
        sortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        panellBotons.add(sortir);

        llistaC.afegeixElement(new FP("Informática", "122212", 1));
        FP c2 = (FP) llistaC.getElement(0);
        //ficam assignatures al curs
        Obligatoria prova = new Obligatoria("Càlcul", "964445", c2, "6");
        Optativa prova2 = new Optativa("Discreta", "43555", c2, 1);
        Estudiant joan = new Estudiant("Joan", "43078654t");
        prova.afegirEstudiant(joan);
        //Afegim assignatures asssociades als estudiants
        joan.afegirAsignatura(prova);
        joan.afegirAsignatura(prova2);

        Estudiant jaume = new Estudiant("Jaume", "43078654t");
        llistaE.afegeixElement(jaume);
        prova.afegirEstudiant(jaume);
        jaume.afegirAsignatura(prova);
        jaume.afegirAsignatura(prova2);

        Estudiant alba = new Estudiant("Alba", "43078654t");
        llistaE.afegeixElement(alba);
        prova2.afegirEstudiant(alba);
        alba.afegirAsignatura(prova);
        alba.afegirAsignatura(prova2);

        Estudiant sara = new Estudiant("Sara", "43078654t");
        prova2.afegirEstudiant(sara);
        sara.afegirAsignatura(prova);
        sara.afegirAsignatura(prova2);

        c2.getAsignatures().afegeixElement(prova);
        c2.getAsignatures().afegeixElement(prova2);

//        c2.getAsignatures().afegeixElement(new Assignatura("b", "232333", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("s", "677675", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("t", "788665", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("d", "865555", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("o", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("w", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("q", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("v", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("m", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("r", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("l", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("z", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("q", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("p", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("jty", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("hrthe", "964445", c2));
//        c2.getAsignatures().afegeixElement(new Assignatura("p", "964445", c2));
        Assignatura a = (Assignatura) c2.getAsignatures().getElement(0);
        a.getLlistaEstudiants().afegeixElement(new Estudiant("Joan", "43219174N"));

    }

    private void infoCurs() {
        //obtenim el curs que ha triat l'usuari
        Curs c = new lecturaDades(this, llistaC, 1).getCurs();
        if (c != null) {
            removeJPanel(panellActual);
            updateJPanel(new PanellInfoCurs(c));
        }

    }

    private void infoAssignatura() {
        Assignatura assign = new lecturaDades(this, llistaC, 2).getAssignatura();
        if (assign != null) {
            removeJPanel(panellActual);
            updateJPanel(new PanellInfoAssignaura(assign));
        }

    }

    private void infoEstudiant() {
        Estudiant estudiant = new lecturaDades(this, llistaC, 3).getEstudiant();
        estudiant = llistaE.cercaElement(estudiant);
        if (estudiant != null) {
            removeJPanel(panellActual);
            updateJPanel(new PanellInfoEstudiant(estudiant));
        }

    }

    private void altaCurs() {
        Curs c = new escripturaDades(this).getCurs();
        if (c != null) {
            llistaC.afegeixElement(c);
        }
    }

    private void baixaCurs() {
        new eliminaDades(this, 1, llistaC, llistaE);
        System.out.println(llistaC.getSize());
    }

    private void baixaAssignatura() {
        new eliminaDades(this, 2, llistaC, llistaE);
    }

    private void matriculEstudiant() {
        new escripturaDades(this, llistaC, llistaE);
    }

    private void removeJPanel(JPanel jp) {
        jp.setVisible(false);
        this.remove(jp);
    }

    private void updateJPanel(JPanel jp) {
        panellActual = jp;
        panellActual.setBounds(300, 0, 700, 700);
        this.getContentPane().add(panellActual);
        panellActual.setVisible(true);
    }

    /**
     * Programa principal on feim visible la finestra que exten aquesta classe
     *
     * @param args
     */
    public static void main(String[] args) {
        try { //Control de l'aspecte
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("No s'ha establert el look desitjat: " + e);
        }
        Main taller = new Main();
        taller.setVisible(true);
    }
}
