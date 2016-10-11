/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Book;
import include.Message;

/**
 *
 * @author shsun
 */
public class BookManager extends JFrame implements ActionListener {

    JTable jt = new JTable();
    JTextField Id, Name, Author, Price, Classify, Publishdate;
    
    private List<Book> list = new ArrayList<>();
    Object[] row = new Object[6];
    
    //Table
    Object[] columns = {"Id","Name","Author","Price", "Classify", "Publish Date"};
    DefaultTableModel model = new DefaultTableModel();
         
        
    public BookManager() {

        //Table
        model.setColumnIdentifiers(columns);   
        jt.setModel(model);   
        jt.setBackground(Color.orange);
        jt.setForeground(Color.white);
        Font font = new Font("",1,22);
        jt.setFont(font);
        jt.setRowHeight(35);
        
        //create label
        JLabel jId = new JLabel(" ID：");
        JLabel jName = new JLabel(" Name：");
        JLabel jAuthor = new JLabel(" Author：");
        JLabel jPrice = new JLabel(" Price：");
        JLabel jClassify = new JLabel(" Classify：");
        JLabel jPublishdate = new JLabel(" Publishdate：");

        //create textfield
        Id = new JTextField();
        Name = new JTextField();
        Author = new JTextField();
        Price = new JTextField();
        Classify = new JTextField();
        Publishdate = new JTextField("MM/dd/yyyy");

        // create buttons and actionlisten
        JButton Add = new JButton("Add");
        Add.addActionListener(this);
        JButton Delete = new JButton("Delete");
        Delete.addActionListener(this);
        JButton Update = new JButton("Update");   
        Update.addActionListener(this);
        
        //positions
        jId.setBounds(620, 420, 100, 25);
        jName.setBounds(620, 450, 100, 25);
        jAuthor.setBounds(620, 480, 100, 25);
        jPrice.setBounds(620, 510, 100, 25);
        jClassify.setBounds(620, 540, 100, 25);
        jPublishdate.setBounds(620, 570, 100, 25);
        
        Id.setBounds(750, 420, 200, 25);
        Name.setBounds(750, 450, 200, 25);
        Author.setBounds(750, 480, 200, 25);
        Price.setBounds(750, 510, 200, 25);
        Classify.setBounds(750, 540, 200, 25);
        Publishdate.setBounds(750, 570, 200, 25);
        
        Add.setBounds(600, 610, 100, 25);
        Update.setBounds(750, 610, 100, 25);
        Delete.setBounds(900, 610, 100, 25);
                
        JScrollPane pane = new JScrollPane(jt);
        pane.setBounds(0, 0, 1500, 400);
        setLayout(null);
        add(pane);

        add(jId);
        add(jName);
        add(jAuthor);
        add(jPrice);
        add(jClassify);
        add(jPublishdate);
        
        add(Id);
        add(Name);
        add(Author);
        add(Price);
        add(Classify);
        add(Publishdate);
        
        add(Add);
        add(Update);
        add(Delete);
        
        setResizable(true);
        setSize(1500,800);
        setLocationRelativeTo(null);

        //set textfile values
        jt.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
        
            int i = jt.getSelectedRow();
            Id.setText(model.getValueAt(i, 0).toString());
            Name.setText(model.getValueAt(i, 1).toString());
            Author.setText(model.getValueAt(i, 2).toString());
            Price.setText(model.getValueAt(i, 3).toString());  
            Classify.setText(model.getValueAt(i, 4).toString());
            Publishdate.setText(model.getValueAt(i, 5).toString());
        }     
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        String act = e.getActionCommand();
        
        if (act.equals("Add")){
       
            String id = Id.getText();
            String name = Name.getText();
            String author = Author.getText().trim();
            Double price = Double.parseDouble(Price.getText());
            String classify = Classify.getText().trim();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
            Date publishdate ;
            boolean isVaild = true; 
            
            if ("".equals(id) || "".equals(name) || "".equals(author) || "".equals(price) || "".equals(classify)) {
              Message.showMessage(this, "ID, Name, Author, Price, and Classify cannot be empty","");
              isVaild = false;
            }
            for (Book bk : list) {
               if (bk.getId() != null && bk.getId().equals(id)){
                 Message.showMessage(this, "Id must be unique!","Error");
                 isVaild = false;
               }
            }
            
            if (isVaild){
              Book book = new Book();
              try {
                 publishdate = df.parse(Publishdate.getText());
                 book.setPublishdate(publishdate);
              } catch (ParseException ex) {
                 Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
              }
              //set values for book object
              book.setId(id);
              book.setName(name);
              book.setPrice(price);
              book.setAuthor(author);
              book.setClassify(classify);
              
              //add book objects to arrary
              list.add(book);
              //for (Book bk : list) {
              //   System.out.println(bk.getAuthor());
              //}
              //add values to table rows
              row[0] = book.getId();
              row[1] = book.getName();
              row[2] = book.getAuthor();
              row[3] = book.getPrice();
              row[4] = book.getClassify();
              row[5] = df.format(book.getPublishdate());
              model.addRow(row);     
            }   
        }else if (act.equals("Update")){
            int i = jt.getSelectedRow();   
            
            //update table
            if (i>=0){
              model.setValueAt(Id.getText(), i, 0);
              model.setValueAt(Name.getText(), i, 1);
              model.setValueAt(Author.getText(), i, 2);
              model.setValueAt(Price.getText(), i, 3);  
              model.setValueAt(Classify.getText(), i, 4);
              model.setValueAt(Publishdate.getText(), i, 5);
              
              //update ArrayList
              String bId = model.getValueAt(i, 0).toString();
              Iterator<Book> lt = list.iterator();
              while (lt.hasNext()) {
                  Book bk1 = lt.next();
                  if (bk1.getId().equals(bId)) {
                      //System.out.println(bk1.getAuthor());
                      bk1.setId(Id.getText());
                      bk1.setName(Name.getText());
                      bk1.setAuthor(Author.getText());
                      bk1.setPrice(Double.parseDouble(Price.getText()));
                      bk1.setClassify(Classify.getText());
                      try {
                          bk1.setPublishdate(new SimpleDateFormat("MM/dd/yyyy").parse(Publishdate.getText()));
                      } catch (ParseException ex) {
                          Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }     
            }else{
               Message.showMessage(this, "Update Error", "Error");
            }        
        }else{
            int i = jt.getSelectedRow();
            
            if(i >= 0){
                //delete from ArraryList
                String bId = model.getValueAt(i, 0).toString();
                Iterator<Book> lt = list.iterator();
                while (lt.hasNext()) {
                  Book bk1 = lt.next();
                  if (bk1.getId().equals(bId)) {
                     lt.remove();
                  }
                }
                //delete from table
                model.removeRow(i);
            }else{
                Message.showMessage(this, "Delete Error", "Error");
            }   
           
        }
        
        for (Book bks : list) {
          //System.out.println("-------");
            System.out.println(bks.getId()+" "+bks.getName()+" "+bks.getAuthor()+"\n");
        }    
        
    }
}
