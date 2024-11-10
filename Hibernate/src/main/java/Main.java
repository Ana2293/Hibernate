import main.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        MethodsImpl mImpl = new MethodsImpl();
        Person person = new Person();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Frame f = new Frame("Lista angajati");
        GridBagLayout gridBagLayout = new GridBagLayout();
        f.setLayout(gridBagLayout);

        new GridBagConstraints();

        GridBagConstraints c;
        c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        Label l = new Label("Baza de date angajati");
        f.add(l, c);

        c.gridx = 0;
        c.gridy = 1;
        Button b = new Button("Add employee");
        f.add(b, c);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        mImpl.addEmployee(session, person);
                }
            });

        c.gridx = 0;
        c.gridy = 2;
        Button b1 = new Button("Update employee");
        f.add(b1, c);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.updateEmployee(session, person);
            }
        });

        c.gridx = 0;
        c.gridy = 3;
        Button b2 = new Button("Delete employee");
        f.add(b2, c);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.deleteEmployee(session, person);
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        Button b3 = new Button("Employee List");
        f.add(b3, c);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.listAll(session, person);
            }
        });
        c.gridx = 1;
        c.gridy = 1;
        Button b4 = new Button("Employee sorted ascending");
        f.add(b4, c);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.sortAscending(session, person);
            }
        });
        c.gridx = 1;
        c.gridy = 2;
        Button b5 = new Button("Employee sorted descending");
        f.add(b5, c);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.sortDescending(session, person);
            }
        });
        c.gridx = 1;
        c.gridy = 3;
        Button b6 = new Button("Age >30");
        f.add(b6, c);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.sortByAge(session, person);
            }
        });
        c.gridx = 1;
        c.gridy = 4;
        Button b7 = new Button("Salary 4000-6000");
        f.add(b7, c);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mImpl.sortBySalary(session, person);
            }
        });


        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setPreferredSize(new Dimension(500, 300));
        f.pack();
        f.setVisible(true);

    }
}
